package net.pokemaniac.texturemod.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.InsideBlockEffectType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.material.*;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.pokemaniac.texturemod.block.ModBlocks;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public abstract class ModLavaFluid extends BaseFlowingFluid {

    protected ModLavaFluid(Properties properties) {
        super(properties);
    }

    public void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        BlockPos above = pos.above();
        if (level.getBlockState(above).isAir() && !level.getBlockState(above).isSolidRender()) {
            if (random.nextInt(100) == 0) {
                double xx = (double)pos.getX() + random.nextDouble();
                double yy = (double)pos.getY() + (double)1.0F;
                double zz = (double)pos.getZ() + random.nextDouble();
                level.addParticle(ParticleTypes.LAVA, xx, yy, zz, (double)0.0F, (double)0.0F, (double)0.0F);
                level.playLocalSound(xx, yy, zz, SoundEvents.LAVA_POP, SoundSource.AMBIENT, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }

            if (random.nextInt(200) == 0) {
                level.playLocalSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), SoundEvents.LAVA_AMBIENT, SoundSource.AMBIENT, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
        }

    }

    public void randomTick(ServerLevel level, BlockPos pos, FluidState fluidState, RandomSource random) {
        if (level.canSpreadFireAround(pos)) {
            int passes = random.nextInt(3);
            if (passes > 0) {
                BlockPos testPos = pos;

                for(int pass = 0; pass < passes; ++pass) {
                    testPos = testPos.offset(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                    if (!level.isLoaded(testPos)) {
                        return;
                    }

                    BlockState blockState = level.getBlockState(testPos);
                    if (blockState.isAir()) {
                        if (this.hasFlammableNeighbours(level, testPos)) {
                            level.setBlockAndUpdate(testPos, EventHooks.fireFluidPlaceBlockEvent(level, testPos, pos, BaseFireBlock.getState(level, testPos)));
                            return;
                        }
                    } else if (blockState.blocksMotion()) {
                        return;
                    }
                }
            } else {
                for(int i = 0; i < 3; ++i) {
                    BlockPos testPos = pos.offset(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                    if (!level.isLoaded(testPos)) {
                        return;
                    }

                    if (level.isEmptyBlock(testPos.above()) && this.isFlammable(level, testPos, Direction.UP)) {
                        level.setBlockAndUpdate(testPos.above(), EventHooks.fireFluidPlaceBlockEvent(level, testPos.above(), pos, BaseFireBlock.getState(level, testPos)));
                    }
                }
            }
        }

    }

    protected void entityInside(Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier) {
        effectApplier.apply(InsideBlockEffectType.CLEAR_FREEZE);
        effectApplier.apply(InsideBlockEffectType.LAVA_IGNITE);
        effectApplier.runAfter(InsideBlockEffectType.LAVA_IGNITE, Entity::lavaHurt);
    }

    private boolean hasFlammableNeighbours(LevelReader level, BlockPos pos) {
        for(Direction direction : Direction.values()) {
            if (this.isFlammable(level, pos.relative(direction), direction.getOpposite())) {
                return true;
            }
        }

        return false;
    }

    /** @deprecated */
    @Deprecated
    private boolean isFlammable(LevelReader level, BlockPos pos) {
        return level.isInsideBuildHeight(pos.getY()) && !level.hasChunkAt(pos) ? false : level.getBlockState(pos).ignitedByLava();
    }

    private boolean isFlammable(LevelReader level, BlockPos pos, Direction face) {
        if (level.isInsideBuildHeight(pos.getY()) && !level.hasChunkAt(pos)) {
            return false;
        } else {
            BlockState state = level.getBlockState(pos);
            return state.ignitedByLava(level, pos, face);
        }
    }

    public @Nullable ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_LAVA;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {
        this.fizz(level, pos);
    }

    @Override
    public int getSlopeFindDistance(LevelReader level) {
        return isFastLava(level) ? 4 : 2;
    }

    @Override
    public int getDropOff(LevelReader level) {
        return isFastLava(level) ? 1 : 2;
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockGetter level, BlockPos pos, Fluid other, Direction direction) {
        return state.getHeight(level, pos) >= 0.44444445F && other.is(FluidTags.WATER);
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return isFastLava(level) ? 10 : 30;
    }

    public int getSpreadDelay(Level level, BlockPos pos, FluidState oldFluidState, FluidState newFluidState) {
        int result = this.getTickDelay(level);
        if (!oldFluidState.isEmpty() && !newFluidState.isEmpty() && !(Boolean)oldFluidState.getValue(FALLING) && !(Boolean)newFluidState.getValue(FALLING) && newFluidState.getHeight(level, pos) > oldFluidState.getHeight(level, pos) && level.getRandom().nextInt(4) != 0) {
            result *= 4;
        }

        return result;
    }

    private void fizz(LevelAccessor level, BlockPos pos) {
        level.levelEvent(1501, pos, 0);
    }

    @Override
    protected boolean canConvertToSource(ServerLevel level) {
        return (Boolean)level.getGameRules().get(GameRules.LAVA_SOURCE_CONVERSION);
    }

    protected void spreadTo(LevelAccessor level, BlockPos pos, BlockState state, Direction direction, FluidState target) {
        if (direction == Direction.DOWN) {
            FluidState fluidState = level.getFluidState(pos);
            if (this.is(FluidTags.LAVA) && fluidState.is(FluidTags.WATER)) {
                if (state.getBlock() instanceof LiquidBlock) {
                    level.setBlock(pos, EventHooks.fireFluidPlaceBlockEvent(level, pos, pos, Blocks.STONE.defaultBlockState()), 3);
                }

                this.fizz(level, pos);
                return;
            }
        }

        super.spreadTo(level, pos, state, direction, target);
    }

    protected boolean isRandomlyTicking() {
        return true;
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
    }

    private static boolean isFastLava(LevelReader level) {
        return (Boolean)level.environmentAttributes().getDimensionValue(EnvironmentAttributes.FAST_LAVA);
    }

    public static class Flowing extends ModLavaFluid {
        protected Flowing(Properties properties) {
            super(properties);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return fluidState.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return false;
        }
    }

    public static class Source extends ModLavaFluid {
        protected Source(Properties properties) {
            super(properties);
        }

        @Override
        public int getAmount(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }
}