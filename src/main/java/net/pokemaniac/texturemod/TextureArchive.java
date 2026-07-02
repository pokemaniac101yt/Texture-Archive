package net.pokemaniac.texturemod;

import net.minecraft.world.item.*;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.creativemodetab.ModCreativeModeTabs;
import net.pokemaniac.texturemod.fluid.ModFluids;
import net.pokemaniac.texturemod.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TextureArchive.MOD_ID)
public class TextureArchive {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "texturemod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final Map<Block, Block> CHISEL_MAP = new HashMap<>();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public TextureArchive(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);

        ModFluids.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);



        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (TextureArchive) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.insertAfter(Items.WOODEN_AXE.getDefaultInstance(), ModItems.WOODEN_CHISEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.STONE_AXE.getDefaultInstance(), ModItems.STONE_CHISEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.COPPER_AXE.getDefaultInstance(), ModItems.COPPER_CHISEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.IRON_AXE.getDefaultInstance(), ModItems.IRON_CHISEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.GOLDEN_AXE.getDefaultInstance(), ModItems.GOLDEN_CHISEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.DIAMOND_AXE.getDefaultInstance(), ModItems.DIAMOND_CHISEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.insertAfter(Items.NETHERITE_AXE.getDefaultInstance(), ModItems.NETHERITE_CHISEL.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        CHISEL_MAP.clear();
        CHISEL_MAP.putAll(BlockTextureCycleGenerator.load(event.getServer()));
    }
}
