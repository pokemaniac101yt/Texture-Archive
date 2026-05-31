package net.pokemaniac.texturemod;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.registry.FlattenableBlockRegistry;
import net.fabricmc.fabric.api.registry.TillableBlockRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;

import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemUsageContext;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.datagen.tags.ModBlockTags;

public class ModFunctionalRegistries {

    public static void register() {
        registerFlammability();
        registerComposting();
//        registerFuel();
//        registerStrippables();
        registerFlattenables();
        registerTillables();
//        registerWaxables();
//        registerOxidizables();
    }

    private static void registerFlammability() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlockTags.FLAMMABLE_LOGS, 5, 5);
        registry.add(ModBlockTags.FLAMMABLE_PLANKS, 5, 20);
        registry.add(ModBlockTags.FLAMMABLE_LEAVES, 30, 60);
        registry.add(ModBlockTags.FLAMMABLE_FLOWERS, 60, 100);

    }

    private static void registerComposting() {
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.POPPY_CLASSIC_0_0_20a, 0.65f);
    }

//    private static void registerFuel() {
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515, 150);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515, 100);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515, 300);
//
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348, 150);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348, 100);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348, 300);
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_SAPLING_PRE_CLASSIC_RD_161348, 100);
//
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a, 100);
//
//        FuelRegistry.INSTANCE.add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a, 300);
//    }
//
//    private static void registerStrippables() {
//        StrippableBlockRegistry.register(
//                ModBlocks.OAK_LOG_VERSION,
//                ModBlocks.STRIPPED_OAK_LOG_VERSION
//        );
//    }

    private static void registerFlattenables() {
        FlattenableBlockRegistry.register(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655, Blocks.DIRT_PATH.getDefaultState());
        FlattenableBlockRegistry.register(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515, Blocks.DIRT_PATH.getDefaultState());
        FlattenableBlockRegistry.register(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515, Blocks.DIRT_PATH.getDefaultState());
    }

    private static void registerTillables() {
        TillableBlockRegistry.register(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655, ctx -> true, Blocks.FARMLAND.getDefaultState());
        TillableBlockRegistry.register(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515, ctx -> true, Blocks.FARMLAND.getDefaultState());
        TillableBlockRegistry.register(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515, ctx -> true, Blocks.FARMLAND.getDefaultState());
    }

//    private static void registerWaxables() {
//        OxidizableBlocksRegistry.registerWaxableBlockPair(
//                ModBlocks.COPPER_BLOCK_VERSION,
//                ModBlocks.WAXED_COPPER_BLOCK_VERSION
//        );
//    }

//    private static void registerOxidizables() {
//        OxidizableBlocksRegistry.registerOxidizableBlockPair(
//                ModBlocks.COPPER_BLOCK_VERSION,
//                ModBlocks.EXPOSED_COPPER_BLOCK_VERSION
//        );
//    }
}
