package net.pokemaniac.texturemod.datagen;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

import java.util.Map;

import static net.pokemaniac.texturemod.aneyra.AneyraBlockModelGenerators.generateCustomFamily;

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

        generateCustomFamily(
                blockModelGenerators,
                0,
                1,
                ModBlocks.STONE_PRE_CLASSIC_RD_20090515,
                null,
                ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515,
                ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515,
                null,
                ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515,
                ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);

        blockModelGenerators.family(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515)
                .stairs(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515)
                .slab(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515)
                .fence(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515)
                .fenceGate(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515)
                .pressurePlate(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515)
                .button(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515);

        blockModelGenerators.createTrivialCube(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

        generateCustomFamily(
                blockModelGenerators,
                2,
                0,
                ModBlocks.SANDSTONE_BETA_1_2,
                null,
                ModBlocks.SANDSTONE_STAIRS_BETA_1_2,
                ModBlocks.SANDSTONE_SLAB_BETA_1_2,
                ModBlocks.SANDSTONE_WALL_BETA_1_2,
                null,
                null
        );
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
