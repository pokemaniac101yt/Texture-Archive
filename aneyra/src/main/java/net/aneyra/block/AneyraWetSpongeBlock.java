package net.aneyra.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class AneyraWetSpongeBlock extends Block{
    protected final Supplier<Block> sponge;
    protected final SoundEvent drySound;
    protected final SoundSource drySoundSource;
    protected final float dryVolume;
    protected final float dryPitch;

    public AneyraWetSpongeBlock(final BlockBehaviour.Properties properties, AneyraBlockProperties.WetSpongeProperties wetSpongeProperties) {
        super(properties);
        this.sponge = wetSpongeProperties.sponge();
        this.drySound = wetSpongeProperties.drySound();
        this.drySoundSource = wetSpongeProperties.drySoundSource();
        this.dryVolume = wetSpongeProperties.dryVolume();
        this.dryPitch = wetSpongeProperties.dryPitch();
    }

    @Override
    protected void onPlace(final BlockState state, final Level level, final BlockPos pos, final BlockState oldState, final boolean movedByPiston) {
        if (level.environmentAttributes().getValue(EnvironmentAttributes.WATER_EVAPORATES, pos)) {
            level.setBlock(pos, sponge.get().defaultBlockState(), 3);
            level.levelEvent(2009, pos, 0);
            level.playSound(null, pos, drySound, drySoundSource, dryVolume, (dryPitch + level.getRandom().nextFloat() * 0.2F) * 0.7F);
        }
    }

    @Override
    public void animateTick(final BlockState state, final Level level, final BlockPos pos, final RandomSource random) {
        Direction direction = Direction.getRandom(random);
        if (direction != Direction.UP) {
            BlockPos relativePos = pos.relative(direction);
            BlockState blockState = level.getBlockState(relativePos);
            if (!state.canOcclude() || !blockState.isFaceSturdy(level, relativePos, direction.getOpposite())) {
                double xx = pos.getX();
                double yy = pos.getY();
                double zz = pos.getZ();
                if (direction == Direction.DOWN) {
                    yy -= 0.05;
                    xx += random.nextDouble();
                    zz += random.nextDouble();
                } else {
                    yy += random.nextDouble() * 0.8;
                    if (direction.getAxis() == Direction.Axis.X) {
                        zz += random.nextDouble();
                        if (direction == Direction.EAST) {
                            xx++;
                        } else {
                            xx += 0.05;
                        }
                    } else {
                        xx += random.nextDouble();
                        if (direction == Direction.SOUTH) {
                            zz++;
                        } else {
                            zz += 0.05;
                        }
                    }
                }

                level.addParticle(ParticleTypes.DRIPPING_WATER, xx, yy, zz, 0.0, 0.0, 0.0);
            }
        }
    }
}

