package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, @Nullable BlockTagsProvider blockTagsProvider) {
        super(output, registryLookupFuture, blockTagsProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ItemTags.DIRT)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.asItem());

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.WOODEN_CHISEL)
                .add(ModItems.STONE_CHISEL)
                .add(ModItems.COPPER_CHISEL)
                .add(ModItems.IRON_CHISEL)
                .add(ModItems.GOLDEN_CHISEL)
                .add(ModItems.DIAMOND_CHISEL)
                .add(ModItems.NETHERITE_CHISEL);

        valueLookupBuilder(ItemTags.GRASS_BLOCKS)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.asItem());

        valueLookupBuilder(ItemTags.SLABS)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515.asItem());

        valueLookupBuilder(ItemTags.STAIRS)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515.asItem());

        valueLookupBuilder(ItemTags.STONE_BUTTONS)
                .add(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515.asItem());

        valueLookupBuilder(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.asItem());

        valueLookupBuilder(ItemTags.STONE_TOOL_MATERIALS)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.asItem());

        valueLookupBuilder(ItemTags.WALLS)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515.asItem());

    }
}
