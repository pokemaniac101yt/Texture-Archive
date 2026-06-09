package net.pokemaniac.texturemod.fluid;

import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.pokemaniac.texturemod.TextureArchive;

@EventBusSubscriber(
        modid = TextureArchive.MOD_ID,
        value = Dist.CLIENT
)

public class ModFluidModels {

    @SubscribeEvent
    public static void registerFluidModels(RegisterFluidModelsEvent event) {

        Identifier water_classic_0_0_12a_still =
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/water_classic_0_0_12a");

        Identifier water_classic_0_0_12a_flowing =
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/water_classic_0_0_12a");

        FluidModel.Unbaked model = new FluidModel.Unbaked(
                new Material(water_classic_0_0_12a_still),
                new Material(water_classic_0_0_12a_flowing),
                null,
                BlockTintSources.water()
        );

        event.register(
                model,
                ModFluids.WATER_CLASSIC_0_0_12a,
                ModFluids.FLOWING_WATER_CLASSIC_0_0_12a
        );

        System.out.println("Registered NeoForge fluid model");
    }
}
