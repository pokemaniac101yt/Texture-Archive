package net.pokemaniac.texturemod.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TextureArchive.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.WOODEN_CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);




        blockModels.createTrivialCube(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get());

        blockModels.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get())
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.get())
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.get())
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655.get());

        blockModels.createTrivialCube(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get());

        blockModels.createTrivialBlock(
                ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get(),
                TexturedModel.createDefault(block -> new TextureMapping()
                                .put(TextureSlot.SIDE,
                                        TextureMapping.getBlockTexture(block, "_side"))
                                .put(TextureSlot.TOP,
                                        TextureMapping.getBlockTexture(block, "_top"))
                                .put(TextureSlot.BOTTOM,
                                        TextureMapping.getBlockTexture(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get())),
                        ModelTemplates.CUBE_BOTTOM_TOP));

        blockModels.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get())
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.get())
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.get())
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515.get());

        blockModels.createRotatedMirroredVariantBlock(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get());

    }
}
