package net.pokemaniac.texturemod.fluid;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderingRegistry;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.block.FluidRenderer;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import net.pokemaniac.texturemod.TextureArchive;

import java.util.function.Function;

public class ModFluids {

    public static ModWaterFluid.Source WATER_CLASSIC_0_0_12a = new ModWaterFluid.Source();
    public static ModWaterFluid.Flowing FLOWING_WATER_CLASSIC_0_0_12a = new ModWaterFluid.Flowing();
    public static Block WATER_BLOCK_CLASSIC_0_0_12a;

    public static ModLavaFluid.Source LAVA_CLASSIC_0_0_12a = new ModLavaFluid.Source();
    public static ModLavaFluid.Flowing FLOWING_LAVA_CLASSIC_0_0_12a = new ModLavaFluid.Flowing();
    public static Block LAVA_BLOCK_CLASSIC_0_0_12a;

    public static ModLavaFluid.Source LAVA_CLASSIC_0_0_13a = new ModLavaFluid.Source();
    public static ModLavaFluid.Flowing FLOWING_LAVA_CLASSIC_0_0_13a = new ModLavaFluid.Flowing();
    public static Block LAVA_BLOCK_CLASSIC_0_0_13a;

    public static void register() {
        WATER_CLASSIC_0_0_12a.setFlowing(FLOWING_WATER_CLASSIC_0_0_12a);
        FLOWING_WATER_CLASSIC_0_0_12a.setSource(WATER_CLASSIC_0_0_12a);

        LAVA_CLASSIC_0_0_12a.setFlowing(FLOWING_LAVA_CLASSIC_0_0_12a);
        FLOWING_LAVA_CLASSIC_0_0_12a.setSource(LAVA_CLASSIC_0_0_12a);

        LAVA_CLASSIC_0_0_13a.setFlowing(FLOWING_LAVA_CLASSIC_0_0_13a);
        FLOWING_LAVA_CLASSIC_0_0_13a.setSource(LAVA_CLASSIC_0_0_13a);

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

        WATER_CLASSIC_0_0_12a.setBlock(WATER_BLOCK_CLASSIC_0_0_12a);
        FLOWING_WATER_CLASSIC_0_0_12a.setBlock(WATER_BLOCK_CLASSIC_0_0_12a);

        LAVA_CLASSIC_0_0_12a.setBlock(LAVA_BLOCK_CLASSIC_0_0_12a);
        FLOWING_LAVA_CLASSIC_0_0_12a.setBlock(LAVA_BLOCK_CLASSIC_0_0_12a);

        LAVA_CLASSIC_0_0_13a.setBlock(LAVA_BLOCK_CLASSIC_0_0_13a);
        FLOWING_LAVA_CLASSIC_0_0_13a.setBlock(LAVA_BLOCK_CLASSIC_0_0_13a);

    }

    public static void registerModFluids() {
        TextureArchive.LOGGER.info("Registering Mod Fluids for " + TextureArchive.MOD_ID);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function, String... tooltipKeys) {
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name), function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name)))));
    }

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

        System.out.println("Registered fluid model: " + WATER_CLASSIC_0_0_12a);
        System.out.println("Registered fluid model: " + LAVA_CLASSIC_0_0_12a);
        System.out.println("Registered fluid model: " + LAVA_CLASSIC_0_0_13a);
    }
}
