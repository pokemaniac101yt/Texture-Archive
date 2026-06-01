package net.pokemaniac.texturemod.datagen;

import com.google.gson.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static net.minecraft.network.packet.CustomPayload.id;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

//        PRE-CLASSIC RD-131655
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655);
        BlockStateModelGenerator.BlockTexturePool cobblestone_pre_classic_131655_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
        cobblestone_pre_classic_131655_pool.stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655);
        cobblestone_pre_classic_131655_pool.slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655);
        cobblestone_pre_classic_131655_pool.wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655);


//        PRE-CLASSIC RD-20090515
        TextureMap grass_block_pre_classic_rd_20090515 = new TextureMap()
                .put(TextureKey.TOP, Identifier.of("texturemod:block/grass_block_pre_classic_rd_20090515_top"))
                .put(TextureKey.SIDE, Identifier.of("texturemod:block/grass_block_pre_classic_rd_20090515_side"))
                .put(TextureKey.BOTTOM, Identifier.of("texturemod:block/dirt_pre_classic_rd_20090515"));

        blockStateModelGenerator.registerSingleton(
                ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515,
                TexturedModel.makeFactory(b -> grass_block_pre_classic_rd_20090515, Models.CUBE_BOTTOM_TOP)
        );

//        IMPORTANT - MANUALLY MAKE CUSTOM TEXTURED BLOCKS ROTATABLE IN JSON

        blockStateModelGenerator.registerRotatable(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        BlockStateModelGenerator.BlockTexturePool oak_pre_classic_20090515_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);
        oak_pre_classic_20090515_pool.stairs(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515);
        oak_pre_classic_20090515_pool.slab(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515);
        oak_pre_classic_20090515_pool.button(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515);
        oak_pre_classic_20090515_pool.pressurePlate(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);
        oak_pre_classic_20090515_pool.fence(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515);
        oak_pre_classic_20090515_pool.fenceGate(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515);

        BlockStateModelGenerator.BlockTexturePool stone_pre_classic_rd_20090515_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.STONE_PRE_CLASSIC_RD_20090515);
//        *sigh* looks like texture pool blocks also require manual mirroring/rotating
        stone_pre_classic_rd_20090515_pool.stairs(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515);
        stone_pre_classic_rd_20090515_pool.slab(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515);
        stone_pre_classic_rd_20090515_pool.button(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515);
        stone_pre_classic_rd_20090515_pool.pressurePlate(ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);

        BlockStateModelGenerator.BlockTexturePool cobblestone_pre_classic_20090515_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);
        cobblestone_pre_classic_20090515_pool.stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515);
        cobblestone_pre_classic_20090515_pool.slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515);
        cobblestone_pre_classic_20090515_pool.wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515);


//        PRE-CLASSIC RD-161348
        BlockStateModelGenerator.BlockTexturePool oak_pre_classic_161348_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348);
        oak_pre_classic_161348_pool.stairs(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348);
        oak_pre_classic_161348_pool.slab(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348);
        oak_pre_classic_161348_pool.button(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348);
        oak_pre_classic_161348_pool.pressurePlate(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348);
        oak_pre_classic_161348_pool.fence(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348);
        oak_pre_classic_161348_pool.fenceGate(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.OAK_SAPLING_PRE_CLASSIC_RD_161348, ModBlocks.POTTED_OAK_SAPLING_PRE_CLASSIC_RD_161348, BlockStateModelGenerator.TintType.NOT_TINTED);



//        CLASSIC 0.0.12a

        blockStateModelGenerator.registerMirrorable(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

//        CLASSIC 0.0.13a
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a, ModBlocks.POTTED_OAK_SAPLING_CLASSIC_0_0_13a, BlockStateModelGenerator.TintType.NOT_TINTED);



//        CLASSIC 0.0.14a
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COAL_ORE_CLASSIC_0_0_14a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.IRON_ORE_CLASSIC_0_0_14a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_ORE_CLASSIC_0_0_14a);
        blockStateModelGenerator.registerRotatable(ModBlocks.SAND_CLASSIC_0_0_14a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_CLASSIC_0_0_14a);

        TextureMap oak_log_classic_0_0_14a = new TextureMap()
                .put(TextureKey.END, Identifier.of("texturemod:block/oak_log_classic_0_0_14a_top"))
                .put(TextureKey.SIDE, Identifier.of("texturemod:block/oak_log_classic_0_0_14a"));

        blockStateModelGenerator.registerAxisRotated(
                ModBlocks.OAK_LOG_CLASSIC_0_0_14a,
                TexturedModel.makeFactory(b -> oak_log_classic_0_0_14a, Models.CUBE_COLUMN)
        );

        blockStateModelGenerator.registerSingleton(
                ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a,
                TexturedModel.LEAVES
        );

        BlockStateModelGenerator.BlockTexturePool cobblestone_classic_0_0_14a_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COBBLESTONE_CLASSIC_0_0_14a);
        cobblestone_classic_0_0_14a_pool.stairs(ModBlocks.COBBLESTONE_STAIRS_CLASSIC_0_0_14a);
        cobblestone_classic_0_0_14a_pool.slab(ModBlocks.COBBLESTONE_SLAB_CLASSIC_0_0_14a);
        cobblestone_classic_0_0_14a_pool.wall(ModBlocks.COBBLESTONE_WALL_CLASSIC_0_0_14a);

        BlockStateModelGenerator.BlockTexturePool oak_classic_0_0_14a_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);
        oak_classic_0_0_14a_pool.stairs(ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a);
        oak_classic_0_0_14a_pool.slab(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a);
        oak_classic_0_0_14a_pool.button(ModBlocks.OAK_BUTTON_CLASSIC_0_0_14a);
        oak_classic_0_0_14a_pool.pressurePlate(ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a);
        oak_classic_0_0_14a_pool.fence(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a);
        oak_classic_0_0_14a_pool.fenceGate(ModBlocks.OAK_FENCE_GATE_CLASSIC_0_0_14a);

//        Classic 0.0.15a

        blockStateModelGenerator.registerRotatable(ModBlocks.SAND_CLASSIC_0_0_15a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAVEL_CLASSIC_0_0_15a);

        TextureMap oak_log_classic_0_0_15a = new TextureMap()
                .put(TextureKey.END, Identifier.of("texturemod:block/oak_log_classic_0_0_15a_top"))
                .put(TextureKey.SIDE, Identifier.of("texturemod:block/oak_log_classic_0_0_15a"));

        blockStateModelGenerator.registerAxisRotated(
                ModBlocks.OAK_LOG_CLASSIC_0_0_15a,
                TexturedModel.makeFactory(b -> oak_log_classic_0_0_15a, Models.CUBE_COLUMN)
        );

        blockStateModelGenerator.registerSingleton(
                ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a,
                TexturedModel.LEAVES
        );

//        CLASSIC 0.0.19a
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPONGE_CLASSIC_0_0_19a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WET_SPONGE_CLASSIC_0_0_19a);

        blockStateModelGenerator.registerGlassPane(
                ModBlocks.GLASS_CLASSIC_0_0_19a,
                ModBlocks.GLASS_PANE_CLASSIC_0_0_19a
        );

        blockStateModelGenerator.registerGlassPane(
                ModBlocks.GLASS_CLASSIC_0_0_19a_01,
                ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_01
        );

        blockStateModelGenerator.registerGlassPane(
                ModBlocks.GLASS_CLASSIC_0_0_19a_02,
                ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_02
        );

//        CLASSIC 0.0.20a
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.POPPY_CLASSIC_0_0_20a, ModBlocks.POTTED_POPPY_CLASSIC_0_0_20a, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DANDELION_CLASSIC_0_0_20a, ModBlocks.POTTED_DANDELION_CLASSIC_0_0_20a, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.RED_MUSHROOM_CLASSIC_0_0_20a, ModBlocks.POTTED_RED_MUSHROOM_CLASSIC_0_0_20a, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.BROWN_MUSHROOM_CLASSIC_0_0_20a, ModBlocks.POTTED_BROWN_MUSHROOM_CLASSIC_0_0_20a, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CAPRI_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHARTREUSE_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CYAN_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DARK_GRAY_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREEN_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIGHT_GRAY_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGENTA_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPLE_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSE_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPRING_GREEN_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ULTRAMARINE_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIOLET_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WHITE_WOOL_CLASSIC_0_0_20a);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_WOOL_CLASSIC_0_0_20a);

        TextureMap bookshelf_classic_0_26 = new TextureMap()
                .put(TextureKey.TOP, Identifier.of("texturemod:block/oak_planks_classic_0_0_14a"))
                .put(TextureKey.SIDE, Identifier.of("texturemod:block/bookshelf_classic_0_26"))
                .put(TextureKey.BOTTOM, Identifier.of("texturemod:block/oak_planks_classic_0_0_14a"));

        blockStateModelGenerator.registerSingleton(
                ModBlocks.BOOKSHELF_CLASSIC_0_26,
                TexturedModel.makeFactory(b -> bookshelf_classic_0_26, Models.CUBE_BOTTOM_TOP)
        );
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRICKS_CLASSIC_0_26);
        TextureMap gold_block_classic_0_26 = new TextureMap()
                .put(TextureKey.TOP, Identifier.of("texturemod:block/gold_block_classic_0_26_top"))
                .put(TextureKey.SIDE, Identifier.of("texturemod:block/gold_block_classic_0_26_side"))
                .put(TextureKey.BOTTOM, Identifier.of("texturemod:block/gold_block_classic_0_26_bottom"));

        blockStateModelGenerator.registerSingleton(
                ModBlocks.GOLD_BLOCK_CLASSIC_0_26,
                TexturedModel.makeFactory(b -> gold_block_classic_0_26, Models.CUBE_BOTTOM_TOP)
        );
        TextureMap iron_block_classic_0_26 = new TextureMap()
                .put(TextureKey.TOP, Identifier.of("texturemod:block/iron_block_classic_0_26_top"))
                .put(TextureKey.SIDE, Identifier.of("texturemod:block/iron_block_classic_0_26_side"))
                .put(TextureKey.BOTTOM, Identifier.of("texturemod:block/iron_block_classic_0_26_bottom"));

        blockStateModelGenerator.registerSingleton(
                ModBlocks.IRON_BLOCK_CLASSIC_0_26,
                TexturedModel.makeFactory(b -> iron_block_classic_0_26, Models.CUBE_BOTTOM_TOP)
        );
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_ORE_CLASSIC_0_26);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_COBBLESTONE_CLASSIC_0_26);
        TextureMap tnt_classic_0_26 = new TextureMap()
                .put(TextureKey.TOP, Identifier.of("texturemod:block/tnt_classic_0_26_top"))
                .put(TextureKey.SIDE, Identifier.of("texturemod:block/tnt_classic_0_26_side"))
                .put(TextureKey.BOTTOM, Identifier.of("texturemod:block/tnt_classic_0_26_bottom"));

        blockStateModelGenerator.registerSingleton(
                ModBlocks.TNT_CLASSIC_0_26,
                TexturedModel.makeFactory(b -> tnt_classic_0_26, Models.CUBE_BOTTOM_TOP)
        );
        TextureMap tnt_classic_0_28 = new TextureMap()
                .put(TextureKey.TOP, Identifier.of("texturemod:block/tnt_classic_0_26_top"))
                .put(TextureKey.SIDE, Identifier.of("texturemod:block/tnt_classic_0_28_side"))
                .put(TextureKey.BOTTOM, Identifier.of("texturemod:block/tnt_classic_0_26_bottom"));

        blockStateModelGenerator.registerSingleton(
                ModBlocks.TNT_CLASSIC_0_28,
                TexturedModel.makeFactory(b -> tnt_classic_0_28, Models.CUBE_BOTTOM_TOP)
        );

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OBSIDIAN_CLASSIC_0_28);

        TextureMap crafting_table_indev_0_31_20100129_2332 = new TextureMap()
                .put(TextureKey.DOWN, Identifier.of("texturemod:block/classic_0_0_15a/oak_log_classic_0_0_15a_top"))
                .put(TextureKey.EAST, Identifier.of("texturemod:block/crafting_table_indev_0_31_20100129_2332_side"))
                .put(TextureKey.NORTH, Identifier.of("texturemod:block/crafting_table_indev_0_31_20100129_2332_front"))
                .put(TextureKey.PARTICLE, Identifier.of("texturemod:block/crafting_table_indev_0_31_20100129_2332_front"))
                .put(TextureKey.SOUTH, Identifier.of("texturemod:block/crafting_table_indev_0_31_20100129_2332_front"))
                .put(TextureKey.UP, Identifier.of("texturemod:block/crafting_table_indev_0_31_20100129_2332_top"))
                .put(TextureKey.WEST, Identifier.of("texturemod:block/crafting_table_indev_0_31_20100129_2332_side"));

        blockStateModelGenerator.registerSingleton(
                ModBlocks.CRAFTING_TABLE_INDEV_0_31_20100129_2332,
                TexturedModel.makeFactory(b -> crafting_table_indev_0_31_20100129_2332, Models.CUBE)
        );

        blockStateModelGenerator.registerTorch(ModBlocks.TORCH_INDEV_0_31_20091223_1457, ModBlocks.WALL_TORCH_INDEV_0_31_20091223_1457);
        blockStateModelGenerator.registerTorch(ModBlocks.TORCH_INDEV_0_31_20091231_1856, ModBlocks.WALL_TORCH_INDEV_0_31_20091231_1856);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WOODEN_CHISEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_CHISEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_CHISEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_CHISEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_CHISEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_CHISEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_CHISEL, Models.HANDHELD);
    }
}

