package net.aneyra.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class AneyraBlockProperties {

    private AneyraBlockProperties() {
    }

    public static class SpongeProperties {
        private Supplier<Block> wetSponge = () -> Blocks.WET_SPONGE;
        private int maxDepth = 6;
        private int maxCount = 64;
        private SoundEvent absorbSound = SoundEvents.SPONGE_ABSORB;
        private SoundSource absorbSoundSource = SoundSource.BLOCKS;
        private float absorbVolume = 1.0F;
        private float absorbPitch = 1.0F;
        private TagKey<Fluid> fluid = FluidTags.WATER;

        private SpongeProperties() {
        }

        public static SpongeProperties of() { return new SpongeProperties(); }

        public SpongeProperties wetSponge(Supplier<Block> wetSponge) {
            this.wetSponge = wetSponge;
            return this;
        }

        public SpongeProperties maxDepth(int maxDepth) {
            this.maxDepth = maxDepth;
            return this;
        }

        public SpongeProperties maxCount(int maxCount) {
            this.maxCount = maxCount;
            return this;
        }

        public SpongeProperties absorbSound(SoundEvent absorbSound) {
            this.absorbSound = absorbSound;
            return this;
        }

        public SpongeProperties absorbSoundSource(SoundSource absorbSoundSource) {
            this.absorbSoundSource = absorbSoundSource;
            return this;
        }

        public SpongeProperties absorbVolume(float absorbVolume) {
            this.absorbVolume = absorbVolume;
            return this;
        }

        public SpongeProperties absorbPitch(float absorbPitch) {
            this.absorbPitch = absorbPitch;
            return this;
        }

        public SpongeProperties fluid(TagKey<Fluid> fluid) {
            this.fluid = fluid;
            return this;
        }

        public Supplier<Block> wetSponge() { return wetSponge; }

        public int maxDepth() { return maxDepth; }

        public int maxCount() { return maxCount; }

        public SoundEvent absorbSound() { return absorbSound; }

        public SoundSource absorbSoundSource() { return absorbSoundSource; }

        public float absorbVolume() { return absorbVolume; }

        public float absorbPitch() { return absorbPitch; }

        public TagKey<Fluid> fluid() { return fluid; }
    }

    public static class WetSpongeProperties {
        private Supplier<Block> sponge = () -> Blocks.SPONGE;
        private SoundEvent drySound = SoundEvents.WET_SPONGE_DRIES;
        private SoundSource drySoundSource = SoundSource.BLOCKS;
        private float dryVolume = 1.0F;
        private float dryPitch = 1.0F;

        private WetSpongeProperties() {}

        public static WetSpongeProperties of() { return new WetSpongeProperties(); }

        public WetSpongeProperties sponge(Supplier<Block> sponge) {
            this.sponge = sponge;
            return this;
        }

        public WetSpongeProperties drySound(SoundEvent drySound) {
            this.drySound = drySound;
            return this;
        }

        public WetSpongeProperties drySoundSource(SoundSource drySoundSource) {
            this.drySoundSource = drySoundSource;
            return this;
        }

        public WetSpongeProperties dryVolume(float dryVolume) {
            this.dryVolume = dryVolume;
            return this;
        }

        public WetSpongeProperties dryPitch(float dryPitch) {
            this.dryPitch = dryPitch;
            return this;
        }

        public Supplier<Block> sponge() { return sponge; }

        public SoundEvent drySound() { return drySound; }

        public SoundSource drySoundSource() { return drySoundSource; }

        public float dryVolume() { return dryVolume; }

        public float dryPitch() { return dryPitch; }
    }
}
