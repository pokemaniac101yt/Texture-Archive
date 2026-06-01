package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.pokemaniac.texturemod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
        dropSelf(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655);
        dropSelf(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655);
        add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655, createSlabItemTable(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655));
        dropSelf(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655);

        add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515, block -> createSingleItemTableWithSilkTouch(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515, ModBlocks.DIRT_PRE_CLASSIC_RD_20090515));
        dropSelf(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        dropSelf(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);
        dropSelf(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515);
        add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515, createSlabItemTable(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515));
        dropSelf(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515);
        add(ModBlocks.STONE_PRE_CLASSIC_RD_20090515, block -> createSingleItemTableWithSilkTouch(ModBlocks.STONE_PRE_CLASSIC_RD_20090515, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515));
    }

}
