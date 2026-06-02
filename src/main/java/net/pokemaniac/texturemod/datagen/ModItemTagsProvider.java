package net.pokemaniac.texturemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TextureArchive.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.DIRT)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.asItem());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.WOODEN_CHISEL.get())
                .add(ModItems.STONE_CHISEL.get())
                .add(ModItems.COPPER_CHISEL.get())
                .add(ModItems.IRON_CHISEL.get())
                .add(ModItems.GOLDEN_CHISEL.get())
                .add(ModItems.DIAMOND_CHISEL.get())
                .add(ModItems.NETHERITE_CHISEL.get());

        tag(ItemTags.GRASS_BLOCKS)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.asItem());

        tag(ItemTags.SLABS)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.asItem());

        tag(ItemTags.STAIRS)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.asItem());

        tag(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.asItem());

        tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.asItem());

        tag(ItemTags.WALLS)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515.asItem());
    }
}
