package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655);

        blockModelGenerators.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655)
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655)
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655)
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655);

        blockModelGenerators.createTrivialCube(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        blockModelGenerators.createTrivialBlock(
                ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515,
                TexturedModel.createDefault(block -> new TextureMapping()
                                .put(TextureSlot.SIDE,
                                        TextureMapping.getBlockTexture(block, "_side"))
                                .put(TextureSlot.TOP,
                                        TextureMapping.getBlockTexture(block, "_top"))
                                .put(TextureSlot.BOTTOM,
                                        TextureMapping.getBlockTexture(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)),
                        ModelTemplates.CUBE_BOTTOM_TOP));

        blockModelGenerators.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515)
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515)
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515);

        blockModelGenerators.createRotatedMirroredVariantBlock(ModBlocks.STONE_PRE_CLASSIC_RD_20090515);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.WOODEN_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLDEN_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COPPER_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STONE_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DIAMOND_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHERITE_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
