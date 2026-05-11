package net.pokemaniac.texturemod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.block.Block;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.entity.ModEntities;
import net.pokemaniac.texturemod.client.renderer.ModTntEntityRenderer;
import net.pokemaniac.texturemod.item.ModItemGroups;
import net.pokemaniac.texturemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TextureMod implements ModInitializer {
	public static final String MOD_ID = "texturemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Map<Block, Block> CHISEL_MAP = new HashMap<>();

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			CHISEL_MAP = BlockTextureCycleGenerator.load(server);
		});

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFunctionalRegistries.register();

		ModEntities.register();

		EntityRendererRegistry.register(ModEntities.MOD_TNT_ENTITY, ModTntEntityRenderer::new);


	}
}