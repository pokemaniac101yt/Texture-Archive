package net.pokemaniac.texturemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.entity.ModEntities;

public class TextureModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getCutout(),
                ModBlocks.OAK_SAPLING_PRE_CLASSIC_RD_161348,
                ModBlocks.POTTED_OAK_SAPLING_PRE_CLASSIC_RD_161348,
                ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a,
                ModBlocks.POTTED_OAK_SAPLING_CLASSIC_0_0_13a,
                ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a,
                ModBlocks.POPPY_CLASSIC_0_0_20a,
                ModBlocks.POTTED_POPPY_CLASSIC_0_0_20a,
                ModBlocks.DANDELION_CLASSIC_0_0_20a,
                ModBlocks.POTTED_DANDELION_CLASSIC_0_0_20a,
                ModBlocks.RED_MUSHROOM_CLASSIC_0_0_20a,
                ModBlocks.POTTED_RED_MUSHROOM_CLASSIC_0_0_20a,
                ModBlocks.BROWN_MUSHROOM_CLASSIC_0_0_20a,
                ModBlocks.POTTED_BROWN_MUSHROOM_CLASSIC_0_0_20a,
                ModBlocks.TORCH_INDEV_0_31_20091223_1457,
                ModBlocks.WALL_TORCH_INDEV_0_31_20091223_1457,
                ModBlocks.TORCH_INDEV_0_31_20091231_1856,
                ModBlocks.WALL_TORCH_INDEV_0_31_20091231_1856
        );



        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderLayer.getTranslucent(),
                ModBlocks.GLASS_CLASSIC_0_0_19a,
                ModBlocks.GLASS_PANE_CLASSIC_0_0_19a,
                ModBlocks.GLASS_CLASSIC_0_0_19a_01,
                ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_01,
                ModBlocks.GLASS_CLASSIC_0_0_19a_02,
                ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_02
        );


    }
}