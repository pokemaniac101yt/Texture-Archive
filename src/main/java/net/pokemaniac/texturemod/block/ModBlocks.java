package net.pokemaniac.texturemod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.item.ModItems;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TextureArchive.MOD_ID);





    /*
    PRE-CLASSIC RD-131655
     */

    public static final DeferredBlock<Block> GRASS_BLOCK_PRE_CLASSIC_RD_131655 =
            registerBlock("grass_block_pre_classic_rd_131655",
            properties -> new GrassBlock(properties
                    .mapColor(MapColor.GRASS)
                    .randomTicks()
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> COBBLESTONE_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_pre_classic_rd_131655",
            properties -> new Block(properties
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));

    public static final DeferredBlock<Block> COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_stairs_pre_classic_rd_131655",
            properties -> new StairBlock(COBBLESTONE_PRE_CLASSIC_RD_131655.get().defaultBlockState(), properties
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));

    public static final DeferredBlock<Block> COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_slab_pre_classic_rd_131655",
            properties -> new SlabBlock(properties
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)));

    public static final DeferredBlock<Block> COBBLESTONE_WALL_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_wall_pre_classic_rd_131655",
            properties -> new WallBlock(properties
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
                    .forceSolidOn()));


    /*
    PRE-CLASSIC RD-20090515
    */

    public static final DeferredBlock<Block> GRASS_BLOCK_PRE_CLASSIC_RD_20090515 =
            registerBlock("grass_block_pre_classic_rd_20090515",
            properties -> new GrassBlock(properties
                    .mapColor(MapColor.GRASS)
                    .randomTicks()
                    .strength(0.6F)
                    .sound(SoundType.GRASS)));

    public static final DeferredBlock<Block> DIRT_PRE_CLASSIC_RD_20090515 =
            registerBlock("dirt_pre_classic_rd_20090515",
                    properties -> new Block(properties
                            .mapColor(MapColor.DIRT)
                            .strength(0.5F)
                            .sound(SoundType.GRAVEL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
