package net.pokemaniac.texturemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.fluid.ModFluids;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TextureArchive.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(FluidTags.WATER)
                .add(ModFluids.WATER_CLASSIC_0_0_12a.get())
                .add(ModFluids.FLOWING_WATER_CLASSIC_0_0_12a.get());

        tag(FluidTags.LAVA)
                .add(ModFluids.LAVA_CLASSIC_0_0_12a.get())
                .add(ModFluids.FLOWING_LAVA_CLASSIC_0_0_12a.get())
                .add(ModFluids.LAVA_CLASSIC_0_0_13a.get())
                .add(ModFluids.FLOWING_LAVA_CLASSIC_0_0_13a.get());
    }
}
