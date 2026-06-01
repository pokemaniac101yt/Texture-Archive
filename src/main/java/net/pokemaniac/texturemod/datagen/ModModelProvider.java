package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655);

        blockModelGenerators.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655)
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655)
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655)
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.WOODEN_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
