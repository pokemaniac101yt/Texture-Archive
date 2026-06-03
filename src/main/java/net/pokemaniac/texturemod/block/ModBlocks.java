package net.pokemaniac.texturemod.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.tooltip.ModTooltips;
import net.pokemaniac.texturemod.tooltip.TooltipItemProvider;

import java.util.function.Function;

public class ModBlocks {


    /*
    PRE-CLASSIC RD-131655
     */

    public static final Block GRASS_BLOCK_PRE_CLASSIC_RD_131655 =
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

    public static final Block COBBLESTONE_PRE_CLASSIC_RD_131655 =
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

    public static final Block COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_stairs_pre_classic_rd_131655",
                    properties -> new StairBlock(
                            COBBLESTONE_PRE_CLASSIC_RD_131655.defaultBlockState(),
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655 =
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

    public static final Block COBBLESTONE_WALL_PRE_CLASSIC_RD_131655 =
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

    public static final Block GRASS_BLOCK_PRE_CLASSIC_RD_20090515 =
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

    public static final Block DIRT_PRE_CLASSIC_RD_20090515 =
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

    public static final Block COBBLESTONE_PRE_CLASSIC_RD_20090515 =
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

    public static final Block COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_stairs_pre_classic_rd_20090515",
                    properties -> new StairBlock(
                            COBBLESTONE_PRE_CLASSIC_RD_131655.defaultBlockState(),
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(2.0F, 6.0F)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515 =
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

    public static final Block COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515 =
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

    public static final Block STONE_PRE_CLASSIC_RD_20090515 =
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

    public static final Block STONE_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_stairs_pre_classic_rd_20090515",
                    properties -> new StairBlock(
                            STONE_PRE_CLASSIC_RD_20090515.defaultBlockState(),
                            properties
                                    .mapColor(MapColor.STONE)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.5F, 6.0F)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_SLAB_PRE_CLASSIC_RD_20090515 =
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

    public static final Block STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515 =
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

    public static final Block STONE_BUTTON_PRE_CLASSIC_RD_20090515 =
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


    public static final Block OAK_PLANKS_PRE_CLASSIC_RD_20090515 =
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

    public static final Block OAK_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_stairs_pre_classic_rd_20090515",
                    properties -> new StairBlock(
                            OAK_PLANKS_PRE_CLASSIC_RD_20090515.defaultBlockState(),
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

    public static final Block OAK_SLAB_PRE_CLASSIC_RD_20090515 =
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

    public static final Block OAK_FENCE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_fence_pre_classic_rd_20090515",
                    properties -> new FenceBlock(
                            properties
                                    .mapColor(OAK_PLANKS_PRE_CLASSIC_RD_20090515.defaultMapColor())
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .sound(SoundType.WOOD)
                                    .ignitedByLava()

                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_fence_gate_pre_classic_rd_20090515",
                    properties -> new FenceGateBlock(
                            WoodType.OAK,
                            properties
                                    .mapColor(OAK_PLANKS_PRE_CLASSIC_RD_20090515.defaultMapColor())
                                    .forceSolidOn()
                                    .instrument(NoteBlockInstrument.BASS)
                                    .strength(2.0F, 3.0F)
                                    .ignitedByLava()
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_pressure_plate_pre_classic_rd_20090515",
                    properties -> new PressurePlateBlock(
                            BlockSetType.OAK,
                            properties
                                    .mapColor(OAK_PLANKS_PRE_CLASSIC_RD_20090515.defaultMapColor())
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

    public static final Block OAK_BUTTON_PRE_CLASSIC_RD_20090515 =
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


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, String... tooltipKeys) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name))));

        registerBlockItem(name, toRegister, tooltipKeys);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name), toRegister);
    }


    private static void registerBlockItem(String name, Block block, String[] tooltipKeys) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name), new TooltipItemProvider.TooltipBlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name))), tooltipKeys));
    }


    public static void registerModBlocks() {
        TextureArchive.LOGGER.info("Registering Mod Blocks for " + TextureArchive.MOD_ID);
    }
}
