package net.pokemaniac.texturemod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.item.ModItems;
import net.pokemaniac.texturemod.tooltip.ModTooltips;
import net.pokemaniac.texturemod.tooltip.TooltipItemProvider;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TextureArchive.MOD_ID);





    /*
    PRE-CLASSIC RD-131655
     */

    public static final DeferredBlock<Block> GRASS_BLOCK_PRE_CLASSIC_RD_131655 =
            registerBlock("grass_block_pre_classic_rd_131655",
                    properties -> new GrassBlock(
                            properties
                                    .mapColor(MapColor.GRASS)
                                    .randomTicks()
                                    .strength(0.6F)
                                    .sound(SoundType.GRASS)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final DeferredBlock<Block> COBBLESTONE_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_pre_classic_rd_131655",
                    properties -> new Block(
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final DeferredBlock<Block> COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_stairs_pre_classic_rd_131655",
                    properties -> new StairBlock(
                            COBBLESTONE_PRE_CLASSIC_RD_131655.get().defaultBlockState(),
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final DeferredBlock<Block> COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_slab_pre_classic_rd_131655",
                    properties -> new SlabBlock(
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final DeferredBlock<Block> COBBLESTONE_WALL_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_wall_pre_classic_rd_131655",
                    properties -> new WallBlock(
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                                    .forceSolidOn()
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );


    /*
    PRE-CLASSIC RD-20090515
    */

    public static final DeferredBlock<Block> GRASS_BLOCK_PRE_CLASSIC_RD_20090515 =
            registerBlock("grass_block_pre_classic_rd_20090515",
                    properties -> new GrassBlock(
                            properties
                                    .mapColor(MapColor.GRASS)
                                    .randomTicks()
                                    .strength(0.6F)
                                    .sound(SoundType.GRASS)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> DIRT_PRE_CLASSIC_RD_20090515 =
            registerBlock("dirt_pre_classic_rd_20090515",
                    properties -> new Block(
                            properties
                                    .mapColor(MapColor.DIRT)
                                    .strength(0.5F)
                                    .sound(SoundType.GRAVEL)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> COBBLESTONE_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_pre_classic_rd_20090515",
                    properties -> new Block(
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_stairs_pre_classic_rd_20090515",
                    properties -> new StairBlock(
                            COBBLESTONE_PRE_CLASSIC_RD_131655.get().defaultBlockState(),
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_slab_pre_classic_rd_20090515",
                    properties -> new SlabBlock(
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_wall_pre_classic_rd_20090515",
                    properties -> new WallBlock(
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                                    .forceSolidOn()
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> STONE_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_pre_classic_rd_20090515",
                    properties -> new Block(
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.5F, 6.0F)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> STONE_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_stairs_pre_classic_rd_20090515",
                    properties -> new StairBlock(
                            STONE_PRE_CLASSIC_RD_20090515.get().defaultBlockState(),
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.5F, 6.0F)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
                    );

    public static final DeferredBlock<Block> STONE_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_slab_pre_classic_rd_20090515",
                    properties -> new SlabBlock(
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.5F, 6.0F)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
                    );

    public static final DeferredBlock<Block> STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_pressure_plate_pre_classic_rd_20090515",
                    properties -> new PressurePlateBlock(
                            BlockSetType.STONE,
                            properties
                                    .mapColor(MapColor.STONE)
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .noCollision()
                                    .strength(0.5F)
                                    .pushReaction(PushReaction.DESTROY)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> STONE_BUTTON_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_button_pre_classic_rd_20090515",
                    properties -> new ButtonBlock(
                            BlockSetType.STONE,
                            20,
                            properties
                                    .noCollision()
                                    .strength(0.5F)
                                    .pushReaction(PushReaction.DESTROY)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> OAK_PLANKS_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_planks_pre_classic_rd_20090515",
                    properties -> new Block(
                            properties
                                    .mapColor(MapColor.WOOD)
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .sound(SoundType.WOOD)
                                    .ignitedByLava()
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> OAK_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_stairs_pre_classic_rd_20090515",
                    properties -> new StairBlock(
                            OAK_PLANKS_PRE_CLASSIC_RD_20090515.get().defaultBlockState(),
                            properties
                                    .mapColor(MapColor.WOOD)
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .sound(SoundType.WOOD)
                                    .ignitedByLava()
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> OAK_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_slab_pre_classic_rd_20090515",
                    properties -> new SlabBlock(
                            properties
                                .mapColor(MapColor.WOOD)
                                .instrument(NoteBlockInstrument.BASS)
                                .strength(2.0F, 3.0F)
                                .sound(SoundType.WOOD)
                                .ignitedByLava()
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> OAK_FENCE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_fence_pre_classic_rd_20090515",
                    properties -> new FenceBlock(
                            properties
                                    .mapColor(OAK_PLANKS_PRE_CLASSIC_RD_20090515.get().defaultMapColor())
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .sound(SoundType.WOOD)
                                    .ignitedByLava()

                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_fence_gate_pre_classic_rd_20090515",
                    properties -> new FenceGateBlock(
                            WoodType.OAK,
                            properties
                                    .mapColor(OAK_PLANKS_PRE_CLASSIC_RD_20090515.get().defaultMapColor())
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .ignitedByLava()
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_pressure_plate_pre_classic_rd_20090515",
                    properties -> new PressurePlateBlock(
                            BlockSetType.OAK,
                            properties
                                    .mapColor(OAK_PLANKS_PRE_CLASSIC_RD_20090515.get().defaultMapColor())
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .noCollision()
                                    .strength(0.5F)
                                    .ignitedByLava()
                                    .pushReaction(PushReaction.DESTROY)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final DeferredBlock<Block> OAK_BUTTON_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_button_pre_classic_rd_20090515",
                    properties -> new ButtonBlock(
                            BlockSetType.OAK,
                            30,
                            properties
                                    .noCollision()
                                    .strength(0.5F)
                                    .pushReaction(PushReaction.DESTROY)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function, String... tooltipKeys) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn, tooltipKeys);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, String[] tooltipKeys) {
        ModItems.ITEMS.registerItem(name, properties -> new TooltipItemProvider.TooltipBlockItem(block.get(), properties.useBlockDescriptionPrefix(), tooltipKeys));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
