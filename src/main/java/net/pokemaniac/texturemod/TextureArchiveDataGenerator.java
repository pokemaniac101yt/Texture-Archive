package net.pokemaniac.texturemod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.pokemaniac.texturemod.datagen.*;

public class TextureArchiveDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		var blockTags = pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider((output, registriesFuture) ->
				new ModItemTagsProvider(output, registriesFuture, blockTags));
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
