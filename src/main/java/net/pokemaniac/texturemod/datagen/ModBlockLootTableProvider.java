package net.pokemaniac.texturemod.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pokemaniac.texturemod.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get());
        dropSelf(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get());
        dropSelf(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.get());
        add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.get(), createSlabItemTable(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.get()));
        dropSelf(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655.get());

        add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get(), (block -> createSingleItemTableWithSilkTouch(block, ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)));
        dropSelf(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get());

        dropSelf(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get());
        dropSelf(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.get());
        add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.get(), createSlabItemTable(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.get()));
        dropSelf(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515.get());
        add(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get(), block -> createSingleItemTableWithSilkTouch(block, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
