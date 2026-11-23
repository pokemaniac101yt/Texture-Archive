package net.aneyra.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
        private SoundEvent sound = SoundEvents.SPONGE_ABSORB;
        private float volume = 1.0F;
        private float pitch = 1.0F;
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

        public SpongeProperties sound(SoundEvent sound) {
            this.sound = sound;
            return this;
        }

        public SpongeProperties volume(float volume) {
            this.volume = volume;
            return this;
        }

        public SpongeProperties pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        public SpongeProperties fluid(TagKey<Fluid> fluid) {
            this.fluid = fluid;
            return this;
        }

        public Supplier<Block> wetSponge() { return wetSponge; }

        public int maxDepth() { return maxDepth; }

        public int maxCount() { return maxCount; }

        public SoundEvent sound() { return sound; }

        public float volume() { return volume; }

        public float pitch() { return pitch; }

        public TagKey<Fluid> fluid() { return fluid; }
    }

    public static class WetSpongeProperties {
        private Supplier<Block> sponge = () -> Blocks.SPONGE;

        private WetSpongeProperties() {}

        public static WetSpongeProperties of() { return new WetSpongeProperties(); }

        public WetSpongeProperties sponge(Supplier<Block> sponge) {
            this.sponge = sponge;
            return this;
        }

        public Supplier<Block> sponge() { return sponge; }
    }
}
