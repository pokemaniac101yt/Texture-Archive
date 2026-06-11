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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pokemaniac.texturemod.TextureArchive;

import java.util.function.Function;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, TextureArchive.MOD_ID);

    public static final DeferredHolder<Fluid, ModWaterFluid.Source> WATER_CLASSIC_0_0_12a =
            FLUIDS.register("water_classic_0_0_12a", ModWaterFluid.Source::new);

    public static final DeferredHolder<Fluid, ModWaterFluid.Flowing> FLOWING_WATER_CLASSIC_0_0_12a =
            FLUIDS.register("flowing_water_classic_0_0_12a", ModWaterFluid.Flowing::new);

    public static final DeferredHolder<Fluid, ModLavaFluid.ModSource> LAVA_CLASSIC_0_0_12a =
            FLUIDS.register("lava_classic_0_0_12a", ModLavaFluid.ModSource::new);

    public static final DeferredHolder<Fluid, ModLavaFluid.ModFlowing> FLOWING_LAVA_CLASSIC_0_0_12a =
            FLUIDS.register("flowing_lava_classic_0_0_12a", ModLavaFluid.ModFlowing::new);

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }


}
