package net.pokemaniac.texturemod.fluid;

import net.aneyra.fluid.AneyraLavaFluid;
import net.aneyra.fluid.AneyraWaterFluid;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderingRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.*;
import net.pokemaniac.texturemod.TextureArchive;

import java.util.function.Function;

public class ModFluids {

    public static AneyraWaterFluid.Source WATER_CLASSIC_0_0_12a = new AneyraWaterFluid.Source();
    public static AneyraWaterFluid.Flowing FLOWING_WATER_CLASSIC_0_0_12a = new AneyraWaterFluid.Flowing();
    public static Block WATER_BLOCK_CLASSIC_0_0_12a;

    public static AneyraLavaFluid.Source LAVA_CLASSIC_0_0_12a = new AneyraLavaFluid.Source();
    public static AneyraLavaFluid.Flowing FLOWING_LAVA_CLASSIC_0_0_12a = new AneyraLavaFluid.Flowing();
    public static Block LAVA_BLOCK_CLASSIC_0_0_12a;

    public static AneyraLavaFluid.Source LAVA_CLASSIC_0_0_13a = new AneyraLavaFluid.Source();
    public static AneyraLavaFluid.Flowing FLOWING_LAVA_CLASSIC_0_0_13a = new AneyraLavaFluid.Flowing();
    public static Block LAVA_BLOCK_CLASSIC_0_0_13a;

    public static AneyraWaterFluid.Source WATER_ANEYRA_DEMO = new AneyraWaterFluid.Source();
    public static AneyraWaterFluid.Flowing FLOWING_WATER_ANEYRA_DEMO = new AneyraWaterFluid.Flowing();
    public static Block WATER_BLOCK_ANEYRA_DEMO;

    public static void register() {
        WATER_CLASSIC_0_0_12a.setFlowing(FLOWING_WATER_CLASSIC_0_0_12a);
        FLOWING_WATER_CLASSIC_0_0_12a.setSource(WATER_CLASSIC_0_0_12a);

        LAVA_CLASSIC_0_0_12a.setFlowing(FLOWING_LAVA_CLASSIC_0_0_12a);
        FLOWING_LAVA_CLASSIC_0_0_12a.setSource(LAVA_CLASSIC_0_0_12a);

        LAVA_CLASSIC_0_0_13a.setFlowing(FLOWING_LAVA_CLASSIC_0_0_13a);
        FLOWING_LAVA_CLASSIC_0_0_13a.setSource(LAVA_CLASSIC_0_0_13a);

        WATER_ANEYRA_DEMO.setFlowing(FLOWING_WATER_ANEYRA_DEMO);
        FLOWING_WATER_ANEYRA_DEMO.setSource(WATER_ANEYRA_DEMO);



        Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "water_classic_0_0_12a"), WATER_CLASSIC_0_0_12a);

        Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "flowing_water_classic_0_0_12a"), FLOWING_WATER_CLASSIC_0_0_12a);


        WATER_BLOCK_CLASSIC_0_0_12a = registerBlock(
                "water_block_classic_0_0_12a",
                properties -> new LiquidBlock(
                        WATER_CLASSIC_0_0_12a,
                        properties
                                .mapColor(MapColor.WATER)
                                .replaceable()
                                .noCollision()
                                .strength(100.0F)
                                .pushReaction(PushReaction.DESTROY)
                                .noLootTable()
                                .liquid()
                                .sound(SoundType.EMPTY)
                )
        );

        Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "lava_classic_0_0_12a"), LAVA_CLASSIC_0_0_12a);

        Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "flowing_lava_classic_0_0_12a"), FLOWING_LAVA_CLASSIC_0_0_12a);


        LAVA_BLOCK_CLASSIC_0_0_12a = registerBlock(
                "lava_block_classic_0_0_12a",
                properties -> new LiquidBlock(
                        LAVA_CLASSIC_0_0_12a,
                        properties
                                .mapColor(MapColor.FIRE)
                                .replaceable()
                                .noCollision()
                                .strength(100.0F)
                                .pushReaction(PushReaction.DESTROY)
                                .noLootTable()
                                .liquid()
                                .sound(SoundType.EMPTY)
                )
        );

        Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "lava_classic_0_0_13a"), LAVA_CLASSIC_0_0_13a);

        Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "flowing_lava_classic_0_0_13a"), FLOWING_LAVA_CLASSIC_0_0_13a);


        LAVA_BLOCK_CLASSIC_0_0_13a = registerBlock(
                "lava_block_classic_0_0_13a",
                properties -> new LiquidBlock(
                        LAVA_CLASSIC_0_0_13a,
                        properties
                                .mapColor(MapColor.FIRE)
                                .replaceable()
                                .noCollision()
                                .strength(100.0F)
                                .pushReaction(PushReaction.DESTROY)
                                .noLootTable()
                                .liquid()
                                .sound(SoundType.EMPTY)
                )
        );

        Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "water_aneyra_demo"), WATER_ANEYRA_DEMO);

        Registry.register(BuiltInRegistries.FLUID,
                Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "flowing_water_aneyra_demo"), FLOWING_WATER_ANEYRA_DEMO);


        WATER_BLOCK_ANEYRA_DEMO = registerBlock(
                "water_block_aneyra_demo",
                properties -> new LiquidBlock(
                        WATER_ANEYRA_DEMO,
                        properties
                                .mapColor(MapColor.WATER)
                                .replaceable()
                                .noCollision()
                                .strength(100.0F)
                                .pushReaction(PushReaction.DESTROY)
                                .noLootTable()
                                .liquid()
                                .sound(SoundType.EMPTY)
                )
        );

        WATER_CLASSIC_0_0_12a.setBlock(WATER_BLOCK_CLASSIC_0_0_12a);
        FLOWING_WATER_CLASSIC_0_0_12a.setBlock(WATER_BLOCK_CLASSIC_0_0_12a);

        LAVA_CLASSIC_0_0_12a.setBlock(LAVA_BLOCK_CLASSIC_0_0_12a);
        FLOWING_LAVA_CLASSIC_0_0_12a.setBlock(LAVA_BLOCK_CLASSIC_0_0_12a);

        LAVA_CLASSIC_0_0_13a.setBlock(LAVA_BLOCK_CLASSIC_0_0_13a);
        FLOWING_LAVA_CLASSIC_0_0_13a.setBlock(LAVA_BLOCK_CLASSIC_0_0_13a);

        WATER_ANEYRA_DEMO.setBlock(WATER_BLOCK_ANEYRA_DEMO);
        FLOWING_WATER_ANEYRA_DEMO.setBlock(WATER_BLOCK_ANEYRA_DEMO);

    }

    public static void registerModFluids() {
        TextureArchive.LOGGER.info("Registering Mod Fluids for " + TextureArchive.MOD_ID);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, String... tooltipKeys) {
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name), function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name)))));
    }
//
//    private static void createWaterFluid(AneyraWaterFluid.Source source, AneyraWaterFluid.Flowing flowing, Block block) {
//
//    }

    public static void initializeClient() {
        FluidRenderingRegistry.register(
                WATER_CLASSIC_0_0_12a,
                FLOWING_WATER_CLASSIC_0_0_12a,
                new FluidModel.Unbaked(
                        new Material(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/water_classic_0_0_12a")),
                        new Material(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/water_classic_0_0_12a")),
                        null,
                        BlockTintSources.water()
                )
        );
        FluidRenderingRegistry.register(
                LAVA_CLASSIC_0_0_12a,
                FLOWING_LAVA_CLASSIC_0_0_12a,
                new FluidModel.Unbaked(
                        new Material(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/lava_classic_0_0_12a")),
                        new Material(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/lava_classic_0_0_12a")),
                        null,
                        null
                )
        );
        FluidRenderingRegistry.register(
                LAVA_CLASSIC_0_0_13a,
                FLOWING_LAVA_CLASSIC_0_0_13a,
                new FluidModel.Unbaked(
                        new Material(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/lava_classic_0_0_13a")),
                        new Material(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/lava_classic_0_0_13a")),
                        null,
                        null
                )
        );

        FluidRenderingRegistry.register(
                WATER_ANEYRA_DEMO,
                FLOWING_WATER_ANEYRA_DEMO,
                new FluidModel.Unbaked(
                        new Material(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/water_classic_0_0_12a")),
                        new Material(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "block/water_classic_0_0_12a")),
                        null,
                        BlockTintSources.water()
                )
        );

        System.out.println("Registered fluid model: " + WATER_CLASSIC_0_0_12a);
        System.out.println("Registered fluid model: " + LAVA_CLASSIC_0_0_12a);
        System.out.println("Registered fluid model: " + LAVA_CLASSIC_0_0_13a);
    }
}
