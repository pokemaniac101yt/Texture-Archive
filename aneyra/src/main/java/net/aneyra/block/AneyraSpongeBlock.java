package net.aneyra.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

import java.util.function.Supplier;

public class AneyraSpongeBlock extends Block {
    protected final Supplier<Block> wetSponge;
    protected final int maxDepth;
    protected final int maxCount;
    protected final SoundEvent absorbSound;
    protected final SoundSource absorbSoundSource;
    protected final float absorbVolume;
    protected final float absorbPitch;
    protected final TagKey<Fluid> fluid;
    private static final Direction[] ALL_DIRECTIONS = Direction.values();

    public AneyraSpongeBlock(Properties properties, AneyraBlockProperties.SpongeProperties spongeProperties) {
        super(properties);
        this.wetSponge = spongeProperties.wetSponge();
        this.maxDepth = spongeProperties.maxDepth();
        this.maxCount = spongeProperties.maxCount();
        this.absorbSound = spongeProperties.absorbSound();
        this.absorbSoundSource = spongeProperties.absorbSoundSource();
        this.absorbVolume = spongeProperties.absorbVolume();
        this.absorbPitch = spongeProperties.absorbPitch();
        this.fluid = spongeProperties.fluid();
    }

    @Override
    protected void onPlace(final BlockState state, final Level level, final BlockPos pos, final BlockState oldState, final boolean movedByPiston) {
        if (!oldState.is(state.getBlock())) {
            this.tryAbsorbWater(level, pos);
        }
    }

    @Override
    protected void neighborChanged(
            final BlockState state, final Level level, final BlockPos pos, final Block block, @Nullable final Orientation orientation, final boolean movedByPiston
    ) {
        this.tryAbsorbWater(level, pos);
        super.neighborChanged(state, level, pos, block, orientation, movedByPiston);
    }

    protected void tryAbsorbWater(final Level level, final BlockPos pos) {
        if (this.removeWaterBreadthFirstSearch(level, pos)) {
            level.setBlock(pos, wetSponge.get().defaultBlockState(), 2);
            level.playSound(null, pos, absorbSound, absorbSoundSource, absorbVolume, absorbPitch);
        }
    }

    protected boolean removeWaterBreadthFirstSearch(final Level level, final BlockPos startPos) {
        return BlockPos.breadthFirstTraversal(startPos, maxDepth, maxCount + 1, (pos, consumer) -> {
            for (Direction direction : ALL_DIRECTIONS) {
                consumer.accept(pos.relative(direction));
            }
        }, pos -> {
            if (pos.equals(startPos)) {
                return BlockPos.TraversalNodeStatus.ACCEPT;
            } else {
                BlockState state = level.getBlockState(pos);
                FluidState fluidState = level.getFluidState(pos);
                if (!fluidState.is(fluid)) {
                    return BlockPos.TraversalNodeStatus.SKIP;
                } else if (state.getBlock() instanceof BucketPickup bucketPickup && !bucketPickup.pickupBlock(null, level, pos, state).isEmpty()) {
                    return BlockPos.TraversalNodeStatus.ACCEPT;
                } else {
                    if (state.getBlock() instanceof LiquidBlock) {
                        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                    } else {
                        if (!state.is(Blocks.KELP) && !state.is(Blocks.KELP_PLANT) && !state.is(Blocks.SEAGRASS) && !state.is(Blocks.TALL_SEAGRASS)) {
                            return BlockPos.TraversalNodeStatus.SKIP;
                        }

                        BlockEntity blockEntity = state.hasBlockEntity() ? level.getBlockEntity(pos) : null;
                        dropResources(state, level, pos, blockEntity);
                        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                    }

                    return BlockPos.TraversalNodeStatus.ACCEPT;
                }
            }
        }) > 1;
    }
}
