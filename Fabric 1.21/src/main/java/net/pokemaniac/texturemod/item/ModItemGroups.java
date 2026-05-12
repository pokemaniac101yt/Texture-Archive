package net.pokemaniac.texturemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pokemaniac.texturemod.TextureMod;
import net.pokemaniac.texturemod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup PRE_CLASSIC_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TextureMod.MOD_ID, "pre_classic_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                    .displayName(Text.translatable("itemgroup.texturemod.pre_classic_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655);
                        entries.add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
                        entries.add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655);
                        entries.add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655);
                        entries.add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655);


                        entries.add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.STONE_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515);
                        entries.add(ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);

                        entries.add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348);
                        entries.add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348);
                        entries.add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348);
                        entries.add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348);
                        entries.add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348);
                        entries.add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348);
                        entries.add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348);
                        entries.add(ModBlocks.OAK_SAPLING_PRE_CLASSIC_RD_161348);
                    }).build());

    public static final ItemGroup CLASSIC_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TextureMod.MOD_ID, "classic_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BEDROCK_CLASSIC_0_0_12a))
                    .displayName(Text.translatable("itemgroup.texturemod.classic_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

                        entries.add(ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a);

                        entries.add(ModBlocks.COAL_ORE_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.IRON_ORE_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.GOLD_ORE_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.GRAVEL_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.SAND_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.COBBLESTONE_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.COBBLESTONE_STAIRS_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.COBBLESTONE_SLAB_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.COBBLESTONE_WALL_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_FENCE_GATE_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_BUTTON_CLASSIC_0_0_14a);
                        entries.add(ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a);

                        entries.add(ModBlocks.SAND_CLASSIC_0_0_15a);
                        entries.add(ModBlocks.GRAVEL_CLASSIC_0_0_15a);
                        entries.add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a);
                        entries.add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a);

                        entries.add(ModBlocks.SPONGE_CLASSIC_0_0_19a);
                        entries.add(ModBlocks.WET_SPONGE_CLASSIC_0_0_19a);
                        entries.add(ModBlocks.GLASS_CLASSIC_0_0_19a);
                        entries.add(ModBlocks.GLASS_PANE_CLASSIC_0_0_19a);

                        entries.add(ModBlocks.GLASS_CLASSIC_0_0_19a_01);
                        entries.add(ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_01);

                        entries.add(ModBlocks.GLASS_CLASSIC_0_0_19a_02);
                        entries.add(ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_02);

                        entries.add(ModBlocks.POPPY_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.DANDELION_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.RED_MUSHROOM_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.BROWN_MUSHROOM_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.CAPRI_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.CHARTREUSE_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.CYAN_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.DARK_GRAY_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.GREEN_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.LIGHT_GRAY_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.MAGENTA_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.ORANGE_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.PURPLE_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.RED_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.ROSE_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.SPRING_GREEN_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.ULTRAMARINE_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.VIOLET_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.WHITE_WOOL_CLASSIC_0_0_20a);
                        entries.add(ModBlocks.YELLOW_WOOL_CLASSIC_0_0_20a);

                        entries.add(ModBlocks.BOOKSHELF_CLASSIC_0_26);
                        entries.add(ModBlocks.BRICKS_CLASSIC_0_26);
                        entries.add(ModBlocks.GOLD_ORE_CLASSIC_0_26);
                        entries.add(ModBlocks.GOLD_BLOCK_CLASSIC_0_26);
                        entries.add(ModBlocks.IRON_BLOCK_CLASSIC_0_26);
                        entries.add(ModBlocks.MOSSY_COBBLESTONE_CLASSIC_0_26);
                        entries.add(ModBlocks.TNT_CLASSIC_0_26);

                        entries.add(ModBlocks.OBSIDIAN_CLASSIC_0_28);
                        entries.add(ModBlocks.TNT_CLASSIC_0_28);
                    }).build());

    public static final ItemGroup INDEV_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TextureMod.MOD_ID, "indev_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CRAFTING_TABLE_INDEV_0_31_20100129_2332))
                    .displayName(Text.translatable("itemgroup.texturemod.indev_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CRAFTING_TABLE_INDEV_0_31_20100129_2332);
                        entries.add(ModItems.TORCH_INDEV_0_31_20091223_1457);
                        entries.add(ModItems.TORCH_INDEV_0_31_20091231_1856);
                    }).build());



    public static void registerItemGroups() {
        TextureMod.LOGGER.info("Registering Item Groups for " + TextureMod.MOD_ID);
    }
}
