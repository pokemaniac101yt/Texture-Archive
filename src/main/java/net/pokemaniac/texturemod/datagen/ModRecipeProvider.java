package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.datagen.recipe.DyeRecipes;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.pokemaniac.texturemod.datagen.recipe.ModRecipeOffers.*;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        DyeRecipes.generate(recipeExporter);
//        PRE-CLASSIC RD-131655
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
        offerStairsRecipe(recipeExporter, ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);


//        PRE-CLASSIC RD-20090515
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);
        offerStairsRecipe(recipeExporter, ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);
        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);
        offerStairsRecipe(recipeExporter, ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);
        offerFenceRecipe(recipeExporter, ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);
        offerFenceGateRecipe(recipeExporter, ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);
        offerSingleRecipe(recipeExporter, ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515, 1);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515);

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515, ModBlocks.STONE_PRE_CLASSIC_RD_20090515);
        offerStairsRecipe(recipeExporter, ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515, ModBlocks.STONE_PRE_CLASSIC_RD_20090515);
        offerSingleRecipe(recipeExporter, ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515, ModBlocks.STONE_PRE_CLASSIC_RD_20090515, 1);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515, ModBlocks.STONE_PRE_CLASSIC_RD_20090515);


//        PRE-CLASSIC RD-161348
        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_161348, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348);
        offerStairsRecipe(recipeExporter, ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_161348, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348);
        offerFenceRecipe(recipeExporter, ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_161348, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348);
        offerFenceGateRecipe(recipeExporter, ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_161348, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348);
        offerSingleRecipe(recipeExporter, ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_161348, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348, 1);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348, ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_161348);


//        CLASSIC 0.0.14a
        offerSmelting(
                recipeExporter,
                List.of(
                        ModBlocks.COAL_ORE_CLASSIC_0_0_14a
                ),
                RecipeCategory.MISC,
                Items.COAL,
                0.1f,
                200,
                "coal"
        );
        offerSmelting(
                recipeExporter,
                List.of(
                        ModBlocks.IRON_ORE_CLASSIC_0_0_14a
                ),
                RecipeCategory.MISC,
                Items.IRON_INGOT,
                0.7f,
                200,
                "iron"
        );
        offerSmelting(
                recipeExporter,
                List.of(
                        ModBlocks.GOLD_ORE_CLASSIC_0_0_14a
                ),
                RecipeCategory.MISC,
                Items.GOLD_INGOT,
                1f,
                200,
                "gold"
        );

        offerSingleRecipe(recipeExporter, ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a, ModBlocks.OAK_LOG_CLASSIC_0_0_14a, 4);

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_CLASSIC_0_0_14a, ModBlocks.COBBLESTONE_CLASSIC_0_0_14a);
        offerStairsRecipe(recipeExporter, ModBlocks.COBBLESTONE_STAIRS_CLASSIC_0_0_14a, ModBlocks.COBBLESTONE_CLASSIC_0_0_14a);
        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_WALL_CLASSIC_0_0_14a, ModBlocks.COBBLESTONE_CLASSIC_0_0_14a);

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_SLAB_CLASSIC_0_0_14a, ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);
        offerStairsRecipe(recipeExporter, ModBlocks.OAK_STAIRS_CLASSIC_0_0_14a, ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);
        offerFenceRecipe(recipeExporter, ModBlocks.OAK_FENCE_CLASSIC_0_0_14a, ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);
        offerFenceGateRecipe(recipeExporter, ModBlocks.OAK_FENCE_GATE_CLASSIC_0_0_14a, ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);
        offerSingleRecipe(recipeExporter, ModBlocks.OAK_BUTTON_CLASSIC_0_0_14a, ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a, 1);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.OAK_PRESSURE_PLATE_CLASSIC_0_0_14a, ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a);

//        CLASSIC 0.0.15a
        offerSingleRecipe(recipeExporter, ModBlocks.OAK_PLANKS_CLASSIC_0_0_14a, ModBlocks.OAK_LOG_CLASSIC_0_0_15a, 4);

//        CLASSIC 0.0.19a
        offerSmelting(
                recipeExporter,
                List.of(
                        ModBlocks.SAND_CLASSIC_0_0_14a,
                        ModBlocks.SAND_CLASSIC_0_0_15a
                ),
                RecipeCategory.MISC,
                ModBlocks.GLASS_CLASSIC_0_0_19a,
                1f,
                200,
                "glass"
        );

        offerStainedGlassPaneRecipe(recipeExporter, ModBlocks.GLASS_PANE_CLASSIC_0_0_19a, ModBlocks.GLASS_CLASSIC_0_0_19a);
        offerStainedGlassPaneRecipe(recipeExporter, ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_01, ModBlocks.GLASS_CLASSIC_0_0_19a_01);
        offerStainedGlassPaneRecipe(recipeExporter, ModBlocks.GLASS_PANE_CLASSIC_0_0_19a_02, ModBlocks.GLASS_CLASSIC_0_0_19a_02);

        offerSmelting(
                recipeExporter,
                List.of(
                        ModBlocks.WET_SPONGE_CLASSIC_0_0_19a
                ),
                RecipeCategory.MISC,
                ModBlocks.SPONGE_CLASSIC_0_0_19a,
                0.15f,
                200,
                "sponge_drying"
        );

//        CLASSIC 0.0.20a
        offerSingleRecipe(recipeExporter, Items.RED_DYE, ModBlocks.POPPY_CLASSIC_0_0_20a, 1);
        offerSingleRecipe(recipeExporter, Items.YELLOW_DYE, ModBlocks.DANDELION_CLASSIC_0_0_20a, 1);
        offerSingleRecipe(recipeExporter, Items.GOLD_INGOT, ModBlocks.GOLD_BLOCK_CLASSIC_0_0_20a, 9);

        offerSmelting(
                recipeExporter,
                List.of(
                        ModBlocks.GOLD_ORE_CLASSIC_0_26
                ),
                RecipeCategory.MISC,
                Items.GOLD_INGOT,
                1f,
                200,
                "gold"
        );
        offerSingleRecipe(recipeExporter, Items.GOLD_INGOT, ModBlocks.GOLD_BLOCK_CLASSIC_0_26, 9);
        offerSingleRecipe(recipeExporter, Items.IRON_INGOT, ModBlocks.IRON_BLOCK_CLASSIC_0_26, 9);

    }


}
