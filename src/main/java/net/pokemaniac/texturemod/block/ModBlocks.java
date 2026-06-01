package net.pokemaniac.texturemod.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.pokemaniac.texturemod.TextureArchive;

import java.util.function.Function;

public class ModBlocks {


    /*
    PRE-CLASSIC RD-131655
     */

    public static final Block GRASS_BLOCK_PRE_CLASSIC_RD_131655 = registerBlock("grass_block_pre_classic_rd_131655",
            properties -> new GrassBlock(properties
                    .mapColor(MapColor.GRASS)
                    .randomTicks()
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    public static final Block COBBLESTONE_PRE_CLASSIC_RD_131655 = registerBlock("cobblestone_pre_classic_rd_131655",
            properties -> new Block(properties
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));

    public static final Block COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655 = registerBlock("cobblestone_stairs_pre_classic_rd_131655",
            properties -> new StairBlock(COBBLESTONE_PRE_CLASSIC_RD_131655.defaultBlockState(), properties
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));

    public static final Block COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655 = registerBlock("cobblestone_slab_pre_classic_rd_131655",
            properties -> new SlabBlock(properties
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));

    public static final Block COBBLESTONE_WALL_PRE_CLASSIC_RD_131655 = registerBlock("cobblestone_wall_pre_classic_rd_131655",
            properties -> new WallBlock(properties
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
                    .forceSolidOn()));

    /*
    PRE-CLASSIC RD-20090515
     */

    public static final Block GRASS_BLOCK_PRE_CLASSIC_RD_20090515 =
            registerBlock("grass_block_pre_classic_rd_20090515",
                    properties -> new GrassBlock(properties
                            .mapColor(MapColor.GRASS)
                            .randomTicks()
                            .strength(0.6F)
                            .sound(SoundType.GRASS)));

    public static final Block DIRT_PRE_CLASSIC_RD_20090515 =
            registerBlock("dirt_pre_classic_rd_20090515",
                    properties -> new Block(properties
                            .mapColor(MapColor.DIRT)
                            .strength(0.5F)
                            .sound(SoundType.GRAVEL)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name))));

        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name), toRegister);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name)))));
    }


    public static void registerModBlocks() {
        TextureArchive.LOGGER.info("Registering Mod Blocks for " + TextureArchive.MOD_ID);
    }
}
