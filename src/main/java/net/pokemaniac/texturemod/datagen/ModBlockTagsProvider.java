package net.pokemaniac.texturemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TextureArchive.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.CONVERTABLE_TO_MUD)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.DIRT)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.FOXES_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.FROGS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.GRASS_BLOCKS)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get())
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.get())
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get())
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.PARROTS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.RABBITS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.SLABS)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.SNIFFER_DIGGABLE_BLOCK)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.STAIRS)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.SUPPORTS_BIG_DRIPLEAF)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get())
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.VALID_SPAWN)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515.get());

        tag(BlockTags.WOLVES_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get())
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get());

    }
}
