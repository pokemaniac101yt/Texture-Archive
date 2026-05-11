package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagBuilder;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.datagen.tags.ModBlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        MOD TAGS
        getOrCreateTagBuilder(ModBlockTags.FLAMMABLE_FLOWERS)
                .add(ModBlocks.POPPY_CLASSIC_0_0_20a);

        getOrCreateTagBuilder(ModBlockTags.FLAMMABLE_LEAVES)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(ModBlockTags.FLAMMABLE_LOGS)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(ModBlockTags.FLAMMABLE_PLANKS)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_FENCE_GATE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(ModBlockTags.LAVA_FLAMMABLE)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_FENCE_GATE_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a);

//        VANILLA TAGS
        getOrCreateTagBuilder(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a)
                .add(ModBlocks.BOOKSHELF_CLASSIC_0_26);

        getOrCreateTagBuilder(BlockTags.BAMBOO_PLANTABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.SAND_CLASSIC_0_0_14a)
                .add(ModBlocks.GRAVEL_CLASSIC_0_0_14a)
                .add(ModBlocks.SAND_CLASSIC_0_0_15a)
                .add(ModBlocks.GRAVEL_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(BlockTags.BASE_STONE_OVERWORLD)
                .add(ModBlocks.STONE_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_26)
                .add(ModBlocks.IRON_BLOCK_CLASSIC_0_26);

        getOrCreateTagBuilder(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS)
                .add(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_BUTTON_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.COAL_ORES)
                .add(ModBlocks.COAL_ORE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.DAMPENS_VIBRATIONS)
                .add(ModBlocks.CAPRI_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.CHARTREUSE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.CYAN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.DARK_GRAY_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.GREEN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.LIGHT_GRAY_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.MAGENTA_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ORANGE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.PURPLE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.RED_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ROSE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.SPRING_GREEN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ULTRAMARINE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.VIOLET_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.WHITE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.YELLOW_WOOL_CLASSIC_0_0_20a);

        getOrCreateTagBuilder(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.DIRT)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.BEDROCK_CLASSIC_0_0_12a)
                .add(ModBlocks.OBSIDIAN_CLASSIC_0_28);

        getOrCreateTagBuilder(BlockTags.DRIPSTONE_REPLACEABLE_BLOCKS)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.SAND_CLASSIC_0_0_14a)
                .add(ModBlocks.GRAVEL_CLASSIC_0_0_14a)
                .add(ModBlocks.SAND_CLASSIC_0_0_15a)
                .add(ModBlocks.GRAVEL_CLASSIC_0_0_15a)
                .add(ModBlocks.TNT_CLASSIC_0_26)
                .add(ModBlocks.TNT_CLASSIC_0_28);

        getOrCreateTagBuilder(BlockTags.FEATURES_CANNOT_REPLACE)
                .add(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_FENCE_GATE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.POPPY_CLASSIC_0_0_20a)
                .add(ModBlocks.DANDELION_CLASSIC_0_0_20a);

        getOrCreateTagBuilder(BlockTags.GEODE_INVALID_BLOCKS)
                .add(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

        getOrCreateTagBuilder(BlockTags.GOLD_ORES)
                .add(ModBlocks.GOLD_ORE_CLASSIC_0_0_14a)
                .add(ModBlocks.GOLD_ORE_CLASSIC_0_26);

        getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_26);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a)
                .add(ModBlocks.SPONGE_CLASSIC_0_0_19a)
                .add(ModBlocks.WET_SPONGE_CLASSIC_0_0_19a);

        getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
                .add(ModBlocks.GLASS_CLASSIC_0_0_19a)
                .add(ModBlocks.GLASS_CLASSIC_0_0_19a_01)
                .add(ModBlocks.GLASS_CLASSIC_0_0_19a_02);

        getOrCreateTagBuilder(BlockTags.INFINIBURN_END)
                .add(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

        getOrCreateTagBuilder(BlockTags.IRON_ORES)
                .add(ModBlocks.IRON_ORE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE)
                .add(ModBlocks.BEDROCK_CLASSIC_0_0_12a)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.LUSH_GROUND_REPLACEABLE)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.SAND_CLASSIC_0_0_14a)
                .add(ModBlocks.GRAVEL_CLASSIC_0_0_14a)
                .add(ModBlocks.SAND_CLASSIC_0_0_15a)
                .add(ModBlocks.GRAVEL_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(BlockTags.MOSS_REPLACEABLE)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.OBSIDIAN_CLASSIC_0_28);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_26);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.IRON_BLOCK_CLASSIC_0_26);

        getOrCreateTagBuilder(BlockTags.OAK_LOGS)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS)
                .add(ModBlocks.CAPRI_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.CHARTREUSE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.CYAN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.DARK_GRAY_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.GREEN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.LIGHT_GRAY_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.MAGENTA_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ORANGE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.PURPLE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.RED_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ROSE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.SPRING_GREEN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ULTRAMARINE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.VIOLET_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.WHITE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.YELLOW_WOOL_CLASSIC_0_0_20a);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.COAL_ORE_CLASSIC_0_0_14a)
                .add(ModBlocks.IRON_ORE_CLASSIC_0_0_14a)
                .add(ModBlocks.GOLD_ORE_CLASSIC_0_0_14a)
                .add(ModBlocks.COBBLESTONE_STAIRS_CLASSIC_0_0_14a)
                .add(ModBlocks.COBBLESTONE_SLAB_CLASSIC_0_0_14a)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a)
                .add(ModBlocks.GOLD_ORE_CLASSIC_0_26)
                .add(ModBlocks.BRICKS_CLASSIC_0_26)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_26)
                .add(ModBlocks.IRON_BLOCK_CLASSIC_0_26)
                .add(ModBlocks.MOSSY_COBBLESTONE_CLASSIC_0_26)
                .add(ModBlocks.OBSIDIAN_CLASSIC_0_28);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.SAND)
                .add(ModBlocks.SAND_CLASSIC_0_0_14a)
                .add(ModBlocks.SAND_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.OAK_SAPLING_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.SAND_CLASSIC_0_0_14a)
                .add(ModBlocks.GRAVEL_CLASSIC_0_0_14a)
                .add(ModBlocks.SAND_CLASSIC_0_0_15a)
                .add(ModBlocks.GRAVEL_CLASSIC_0_0_15a);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.COBBLESTONE_SLAB_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.POPPY_CLASSIC_0_0_20a)
                .add(ModBlocks.DANDELION_CLASSIC_0_0_20a);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.COBBLESTONE_STAIRS_CLASSIC_0_0_14a)
                .add(ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.STONE_ORE_REPLACEABLES)
                .add(ModBlocks.STONE_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.STONE_PRESSURE_PLATES)
                .add(ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.UNSTABLE_BOTTOM_CENTER)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_FENCE_GATE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.VALID_SPAWN)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.COBBLESTONE_WALL_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a)
                .add(ModBlocks.TORCH_INDEV_0_31_20091223_1457);

        getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE)
                .add(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_BUTTON_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348)
                .add(ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a);

        getOrCreateTagBuilder(BlockTags.WOOL)
                .add(ModBlocks.CAPRI_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.CHARTREUSE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.CYAN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.DARK_GRAY_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.GREEN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.LIGHT_GRAY_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.MAGENTA_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ORANGE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.PURPLE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.RED_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ROSE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.SPRING_GREEN_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.ULTRAMARINE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.VIOLET_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.WHITE_WOOL_CLASSIC_0_0_20a)
                .add(ModBlocks.YELLOW_WOOL_CLASSIC_0_0_20a);

    }
}
