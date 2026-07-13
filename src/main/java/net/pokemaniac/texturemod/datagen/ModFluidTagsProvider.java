package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.FluidTags;
import net.pokemaniac.texturemod.fluid.ModFluids;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FabricTagsProvider.FluidTagsProvider {
    public ModFluidTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(FluidTags.WATER)
                .add(ModFluids.WATER_CLASSIC_0_0_12a)
                .add(ModFluids.FLOWING_WATER_CLASSIC_0_0_12a);

        valueLookupBuilder(FluidTags.LAVA)
                .add(ModFluids.LAVA_CLASSIC_0_0_12a)
                .add(ModFluids.FLOWING_LAVA_CLASSIC_0_0_12a)
                .add(ModFluids.LAVA_CLASSIC_0_0_13a)
                .add(ModFluids.FLOWING_LAVA_CLASSIC_0_0_13a);
    }
}
