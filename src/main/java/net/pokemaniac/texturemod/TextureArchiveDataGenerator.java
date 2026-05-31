package net.pokemaniac.texturemod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.pokemaniac.texturemod.datagen.ModBlockLootTableProvider;
import net.pokemaniac.texturemod.datagen.ModBlockTagsProvider;
import net.pokemaniac.texturemod.datagen.ModModelProvider;

public class TextureArchiveDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
	}
}
