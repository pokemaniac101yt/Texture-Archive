package net.pokemaniac.texturemod;

import net.fabricmc.api.ModInitializer;

import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.creativemodetab.ModCreativeModeTabs;
import net.pokemaniac.texturemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextureArchive implements ModInitializer {
	public static final String MOD_ID = "texturemod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}