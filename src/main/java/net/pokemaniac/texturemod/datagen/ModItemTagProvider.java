package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.datagen.tags.ModBlockTags;
import net.pokemaniac.texturemod.datagen.tags.ModItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModItemTags.COMPOSTABLE_LEAVES)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a.asItem())
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a.asItem());

        getOrCreateTagBuilder(ItemTags.BUTTONS)
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.OAK_BUTTON_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.DAMPENS_VIBRATIONS)
                .add(ModBlocks.CAPRI_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.CHARTREUSE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.CYAN_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.DARK_GRAY_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.GREEN_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.LIGHT_GRAY_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.MAGENTA_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.ORANGE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.PURPLE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.RED_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.ROSE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.SPRING_GREEN_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.ULTRAMARINE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.VIOLET_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.WHITE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.YELLOW_WOOL_CLASSIC_0_0_20a.asItem());

        getOrCreateTagBuilder(ItemTags.FENCES)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(ModBlocks.POPPY_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.DANDELION_CLASSIC_0_0_20a.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_14a.asItem())
                .add(ModBlocks.OAK_LEAVES_CLASSIC_0_0_15a.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a.asItem())
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a.asItem())
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a.asItem());

        getOrCreateTagBuilder(ItemTags.OAK_LOGS)
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_14a.asItem())
                .add(ModBlocks.OAK_LOG_CLASSIC_0_0_15a.asItem());

        getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.GOLD_BLOCK_CLASSIC_0_26.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.SAND)
                .add(ModBlocks.SAND_CLASSIC_0_0_14a.asItem())
                .add(ModBlocks.SAND_CLASSIC_0_0_15a.asItem());

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.OAK_SAPLING_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.OAK_SAPLING_CLASSIC_0_0_13a.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS)
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.COBBLESTONE_SLAB_CLASSIC_0_0_14a.asItem())
                .add(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.POPPY_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.DANDELION_CLASSIC_0_0_20a.asItem());

        getOrCreateTagBuilder(ItemTags.SMELTS_TO_GLASS)
                .add(ModBlocks.SAND_CLASSIC_0_0_14a.asItem())
                .add(ModBlocks.SAND_CLASSIC_0_0_15a.asItem());

        getOrCreateTagBuilder(ItemTags.STAIRS)
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.COBBLESTONE_STAIRS_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.asItem());

        getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS)
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.asItem());

        getOrCreateTagBuilder(ItemTags.WALLS)
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655.asItem())
                .add(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.COBBLESTONE_WALL_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.OAK_BUTTON_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.OAK_FENCE_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348.asItem())
                .add(ModBlocks.OAK_SLAB_CLASSIC_0_0_14a.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515.asItem())
                .add(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348.asItem());

        getOrCreateTagBuilder(ItemTags.WOOL)
                .add(ModBlocks.CAPRI_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.CHARTREUSE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.CYAN_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.DARK_GRAY_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.GREEN_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.LIGHT_GRAY_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.MAGENTA_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.ORANGE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.PURPLE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.RED_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.ROSE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.SPRING_GREEN_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.ULTRAMARINE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.VIOLET_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.WHITE_WOOL_CLASSIC_0_0_20a.asItem())
                .add(ModBlocks.YELLOW_WOOL_CLASSIC_0_0_20a.asItem());
    }

}
