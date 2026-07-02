package net.pokemaniac.texturemod.fluid;

import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, TextureArchive.MOD_ID);

    public static final BaseFlowingFluid.Properties WATER_CLASSIC_0_0_12a_PROPERTIES =
            new BaseFlowingFluid.Properties(
                    (Supplier<? extends FluidType>) Fluids.WATER.getFluidType(),          // Supplier<FluidType>
                    ModFluids.WATER_CLASSIC_0_0_12a,      // Supplier<Fluid>
                    ModFluids.FLOWING_WATER_CLASSIC_0_0_12a // Supplier<Fluid>
            )
                    .bucket((Supplier<? extends Item>) Items.WATER_BUCKET)
                    .block((Supplier<? extends LiquidBlock>) ModBlocks.WATER_CLASSIC_0_0_12a)
                    .tickRate(5)
                    .slopeFindDistance(4)
                    .levelDecreasePerBlock(1)
                    .explosionResistance(100.0f);

    public static final DeferredHolder<Fluid, ModWaterFluid.Source> WATER_CLASSIC_0_0_12a =
            FLUIDS.register("water_classic_0_0_12a", () -> new ModWaterFluid.Source(WATER_CLASSIC_0_0_12a_PROPERTIES));

    public static final DeferredHolder<Fluid, ModWaterFluid.Flowing> FLOWING_WATER_CLASSIC_0_0_12a =
            FLUIDS.register("flowing_water_classic_0_0_12a", () -> new ModWaterFluid.Flowing(WATER_CLASSIC_0_0_12a_PROPERTIES));

    public static final DeferredHolder<Fluid, ModLavaFluid.Source> LAVA_CLASSIC_0_0_12a =
            FLUIDS.register("lava_classic_0_0_12a", ModLavaFluid.Source::new);

    public static final DeferredHolder<Fluid, ModLavaFluid.Flowing> FLOWING_LAVA_CLASSIC_0_0_12a =
            FLUIDS.register("flowing_lava_classic_0_0_12a", ModLavaFluid.Flowing::new);

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }


}
