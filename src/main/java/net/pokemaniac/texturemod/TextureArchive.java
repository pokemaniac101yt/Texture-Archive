package net.pokemaniac.texturemod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.world.level.block.Block;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.creativemodetab.ModCreativeModeTabs;
import net.pokemaniac.texturemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TextureArchive implements ModInitializer {
	public static final String MOD_ID = "texturemod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Map<Block, Block> CHISEL_MAP = new HashMap<>();

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			TextureArchive.CHISEL_MAP =
					BlockTextureCycleGenerator.load(server);
		});

		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}