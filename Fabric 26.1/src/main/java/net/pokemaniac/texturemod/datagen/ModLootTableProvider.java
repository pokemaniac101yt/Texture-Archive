package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.pokemaniac.texturemod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.command.argument.RegistryEntryArgumentType.lootTable;


public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        var enchantmentRegistry = this.registryLookup
                .getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

//        PRE-CLASSIC RD-131655
        addDrop(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655);
        addDrop(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
        addDrop(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655);
        addDrop(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655, slabDrops(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655));
        addDrop(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655);


//        PRE-CLASSIC RD-20090515
        addDrop(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515,
                dropsWithSilkTouch(
                        ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515,
                        ItemEntry.builder(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)
                ));
        addDrop(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        addDrop(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515, slabDrops(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515));
        addDrop(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515);

        addDrop(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515, slabDrops(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515));
        addDrop(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515);

        addDrop(ModBlocks.STONE_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515);
        addDrop(ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);


//        PRE-CLASSIC RD-161348
        addDrop(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348);
        addDrop(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348);
        addDrop(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348, slabDrops(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348));
        addDrop(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348);
        addDrop(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348);
        addDrop(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348);
        addDrop(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348);

        addDrop(ModBlocks.OAK_SAPLING_PRE_CLASSIC_RD_161348);
        addDrop(ModBlocks.POTTED_OAK_SAPLING_PRE_CLASSIC_RD_161348,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModBlocks.OAK_SAPLING_PRE_CLASSIC_RD_161348))
                        )
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Blocks.FLOWER_POT))
                        )
        );


//        CLASSIC 0.0.13a
        addDrop(ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a);
        addDrop(ModBlocks.POTTED_OAK_SAPLING_CLASSIC_0_0_13a,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a))
                        )
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Blocks.FLOWER_POT))
                        )
        );


//        CLASSIC 0.0.14a

        addDrop(ModBlocks.COAL_ORE_CLASSIC_0_0_14a, oreDrops(ModBlocks.COAL_ORE_CLASSIC_0_0_14a, Items.COAL));
        addDrop(ModBlocks.IRON_ORE_CLASSIC_0_0_14a, oreDrops(ModBlocks.IRON_ORE_CLASSIC_0_0_14a, Items.RAW_IRON));
        addDrop(ModBlocks.GOLD_ORE_CLASSIC_0_0_14a, oreDrops(ModBlocks.GOLD_ORE_CLASSIC_0_0_14a, Items.RAW_GOLD));
        addDrop(ModBlocks.SAND_CLASSIC_0_0_14a);

        addDrop(ModBlocks.GRAVEL_CLASSIC_0_0_14a,
                dropsWithSilkTouch(
                        ModBlocks.GRAVEL_CLASSIC_0_0_14a,
                        addSurvivesExplosionCondition(
                                ModBlocks.GRAVEL_CLASSIC_0_0_14a,
                                ItemEntry.builder(Items.FLINT)
                                        .conditionally(TableBonusLootCondition.builder(
                                                enchantmentRegistry.getOrThrow(Enchantments.FORTUNE),
                                                0.1F, 0.14285715F, 0.25F, 1.0F
                                        ))
                                        .alternatively(ItemEntry.builder(ModBlocks.GRAVEL_CLASSIC_0_0_14a))
                        )
                )
        );

        addDrop(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a, block -> oakLeavesDrops(block, ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a, SAPLING_DROP_CHANCE));

        addDrop(ModBlocks.COBBLESTONE_STAIRS_CLASSIC_0_0_14a);
        addDrop(ModBlocks.COBBLESTONE_SLAB_CLASSIC_0_0_14a, slabDrops(ModBlocks.COBBLESTONE_SLAB_CLASSIC_0_0_14a));
        addDrop(ModBlocks.COBBLESTONE_WALL_CLASSIC_0_0_14a);

        addDrop(ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);
        addDrop(ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a);
        addDrop(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a, slabDrops(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a));
        addDrop(ModBlocks.OAK_BUTTON_CLASSIC_0_0_14a);
        addDrop(ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a);
        addDrop(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a);
        addDrop(ModBlocks.OAK_FENCE_GATE_CLASSIC_0_0_14a);

//        CLASSIC 0.0.15a

        addDrop(ModBlocks.SAND_CLASSIC_0_0_15a);
        addDrop(ModBlocks.GRAVEL_CLASSIC_0_0_15a,
                dropsWithSilkTouch(
                        ModBlocks.GRAVEL_CLASSIC_0_0_15a,
                        addSurvivesExplosionCondition(
                                ModBlocks.GRAVEL_CLASSIC_0_0_15a,
                                ItemEntry.builder(Items.FLINT)
                                        .conditionally(TableBonusLootCondition.builder(
                                                enchantmentRegistry.getOrThrow(Enchantments.FORTUNE),
                                                0.1F, 0.14285715F, 0.25F, 1.0F
                                        ))
                                        .alternatively(ItemEntry.builder(ModBlocks.GRAVEL_CLASSIC_0_0_15a))
                        )
                )
        );

        addDrop(ModBlocks.OAK_LOG_CLASSIC_0_0_15a);
        addDrop(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a, block -> oakLeavesDrops(block, ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a, SAPLING_DROP_CHANCE));

//        CLASSIC 0.0.19a
        addDrop(ModBlocks.SPONGE_CLASSIC_0_0_19a);
        addDrop(ModBlocks.WET_SPONGE_CLASSIC_0_0_19a);
        addDrop(ModBlocks.GLASS_CLASSIC_0_0_19a,
                dropsWithSilkTouch(
                        ModBlocks.GLASS_CLASSIC_0_0_19a
                ));
        addDrop(ModBlocks.GLASS_PANE_CLASSIC_0_0_19a,
                dropsWithSilkTouch(
                        ModBlocks.GLASS_PANE_CLASSIC_0_0_19a
                ));

        addDrop(ModBlocks.GLASS_CLASSIC_0_0_19a_01,
                dropsWithSilkTouch(
                        ModBlocks.GLASS_CLASSIC_0_0_19a_01
                ));
        addDrop(ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_01,
                dropsWithSilkTouch(
                        ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_01
                ));

        addDrop(ModBlocks.GLASS_CLASSIC_0_0_19a_02,
                dropsWithSilkTouch(
                        ModBlocks.GLASS_CLASSIC_0_0_19a_02
                ));

        addDrop(ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_02,
                dropsWithSilkTouch(
                        ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_02
                ));

//        CLASSIC 0.0.20a

        addDrop(ModBlocks.POPPY_CLASSIC_0_0_20a);
        addDrop(ModBlocks.POTTED_POPPY_CLASSIC_0_0_20a,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModBlocks.POPPY_CLASSIC_0_0_20a))
                        )
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Blocks.FLOWER_POT))
                        )
        );
        addDrop(ModBlocks.DANDELION_CLASSIC_0_0_20a);
        addDrop(ModBlocks.POTTED_DANDELION_CLASSIC_0_0_20a,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModBlocks.DANDELION_CLASSIC_0_0_20a))
                        )
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Blocks.FLOWER_POT))
                        )
        );
        addDrop(ModBlocks.RED_MUSHROOM_CLASSIC_0_0_20a);
        addDrop(ModBlocks.POTTED_RED_MUSHROOM_CLASSIC_0_0_20a,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModBlocks.RED_MUSHROOM_CLASSIC_0_0_20a))
                        )
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Blocks.FLOWER_POT))
                        )
        );
        addDrop(ModBlocks.BROWN_MUSHROOM_CLASSIC_0_0_20a);
        addDrop(ModBlocks.POTTED_BROWN_MUSHROOM_CLASSIC_0_0_20a,
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(ModBlocks.BROWN_MUSHROOM_CLASSIC_0_0_20a))
                        )
                        .pool(LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .with(ItemEntry.builder(Blocks.FLOWER_POT))
                        )
        );
        addDrop(ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a);

        addDrop(ModBlocks.CAPRI_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.CHARTREUSE_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.CYAN_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.DARK_GRAY_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.GREEN_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.LIGHT_GRAY_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.MAGENTA_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.ORANGE_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.PURPLE_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.RED_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.ROSE_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.SPRING_GREEN_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.ULTRAMARINE_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.VIOLET_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.WHITE_WOOL_CLASSIC_0_0_20a);
        addDrop(ModBlocks.YELLOW_WOOL_CLASSIC_0_0_20a);

        addDrop(ModBlocks.BOOKSHELF_CLASSIC_0_26,
                dropsWithSilkTouch(
                        ModBlocks.BOOKSHELF_CLASSIC_0_26,
                        ItemEntry.builder(Items.BOOK)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3)))
                )
        );
        addDrop(ModBlocks.BRICKS_CLASSIC_0_26);
        addDrop(ModBlocks.GOLD_BLOCK_CLASSIC_0_26);
        addDrop(ModBlocks.IRON_BLOCK_CLASSIC_0_26);
        addDrop(ModBlocks.GOLD_ORE_CLASSIC_0_26, oreDrops(ModBlocks.GOLD_ORE_CLASSIC_0_26, Items.RAW_GOLD));
        addDrop(ModBlocks.MOSSY_COBBLESTONE_CLASSIC_0_26);
        addDrop(ModBlocks.TNT_CLASSIC_0_26);
        addDrop(ModBlocks.OBSIDIAN_CLASSIC_0_28);
        addDrop(ModBlocks.TNT_CLASSIC_0_28);
        addDrop(ModBlocks.CRAFTING_TABLE_INDEV_0_31_20100129_2332);

        addDrop(ModBlocks.TORCH_INDEV_0_31_20091223_1457);
        addDrop(
                ModBlocks.WALL_TORCH_INDEV_0_31_20091223_1457,
                ModBlocks.TORCH_INDEV_0_31_20091223_1457);



    }
}
