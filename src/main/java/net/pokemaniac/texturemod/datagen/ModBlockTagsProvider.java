package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.pokemaniac.texturemod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.CONVERTABLE_TO_MUD)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.DIRT)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.FOXES_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.FROGS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.GRASS_BLOCKS)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.PARROTS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.RABBITS_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.SLABS)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.STONE_BUTTONS)
                .add(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.STONE_PRESSURE_PLATES)
                .add(ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.SUPPORTS_BIG_DRIPLEAF)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515)
                .add(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.VALID_SPAWN)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515);

        valueLookupBuilder(BlockTags.WOLVES_SPAWNABLE_ON)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655)
                .add(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);
    }
}
