package net.aneyra.fluid;

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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.InsideBlockEffectType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.material.*;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public abstract class AneyraWaterFluid extends FlowingFluid {
    Item Bucket = Items.WATER_BUCKET;
    Block Block;

    int slopeFindDistance = 4;
    int dropOff = 1;
    int tickDelay = 5;

    public void setBucket(Item Bucket) {
        this.Bucket = Bucket;
    }

    public void setBlock(Block Block){this.Block = Block;}

    @Override
    public Item getBucket() {
        return Bucket;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return Block.defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
    }

    @Override
    public void animateTick(final Level level, final BlockPos pos, final FluidState fluidState, final RandomSource random) {
        if (!fluidState.isSource() && !(Boolean)fluidState.getValue(FALLING)) {
            if (random.nextInt(64) == 0) {
                level.playLocalSound(
                        pos.getX() + 0.5,
                        pos.getY() + 0.5,
                        pos.getZ() + 0.5,
                        SoundEvents.WATER_AMBIENT,
                        SoundSource.AMBIENT,
                        random.nextFloat() * 0.25F + 0.75F,
                        random.nextFloat() + 0.5F,
                        false
                );
            }
        } else if (random.nextInt(10) == 0) {
            level.addParticle(
                    ParticleTypes.UNDERWATER, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(), pos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0
            );
        }
    }

    @Nullable
    @Override
    public ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_WATER;
    }

    @Override
    protected boolean canConvertToSource(final ServerLevel level) {
        return level.getGameRules().get(GameRules.WATER_SOURCE_CONVERSION);
    }

    @Override
    protected void beforeDestroyingBlock(final LevelAccessor level, final BlockPos pos, final BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? level.getBlockEntity(pos) : null;
        Block.dropResources(state, level, pos, blockEntity);
    }

    @Override
    protected void entityInside(final Level level, final BlockPos pos, final Entity entity, final InsideBlockEffectApplier effectApplier) {
        effectApplier.apply(InsideBlockEffectType.EXTINGUISH);
    }

    public void setSlopeFindDistance(int slopeFindDistance) {
        this.slopeFindDistance = slopeFindDistance;
    }

    @Override
    public int getSlopeFindDistance(final LevelReader level) {
        return 4;
    }

    public void setDropOff(int dropOff) {
        this.dropOff = dropOff;
    }

    @Override
    public int getDropOff(final LevelReader level) {

//        if (dropOff == 1) {
//            dropOff = 0;
//            return 1;
//        }
//        if (dropOff == 0) {
//            dropOff = 1;
//            return 0;
//        }
        return 1;
    }

    public void setTickDelay(int tickDelay){
        this.tickDelay = tickDelay;
    }

    @Override
    public int getTickDelay(final LevelReader level) {
        return 5;
    }

    @Override
    public boolean canBeReplacedWith(final FluidState state, final BlockGetter level, final BlockPos pos, final Fluid other, final Direction direction) {
        return direction == Direction.DOWN && !other.is(FluidTags.WATER);
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL);
    }

    public abstract Fluid getFlowing();

    public static class Flowing extends AneyraWaterFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        Fluid Source;

        public void setSource(Fluid Source) {
            this.Source = Source;
        }


        @Override
        public Fluid getFlowing() {
            return this;
        }

        @Override
        public Fluid getSource() {
            return Source;
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }


        @Override
        public boolean isSame(Fluid fluid) {
            return fluid == Source || fluid == this;
        }

    }

    public static class Source extends AneyraWaterFluid {
        Fluid Flowing;

        public void setFlowing(Fluid Flowing) {
            this.Flowing = Flowing;
        }

        @Override
        public Fluid getFlowing() {
            return Flowing;
        }

        @Override
        public Fluid getSource() {
            return this;
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }


        @Override
        public boolean isSource(FluidState state) {
            return true;
        }

        @Override
        public boolean isSame(Fluid fluid) {
            return fluid == this || fluid == Flowing;
        }

    }
    }
