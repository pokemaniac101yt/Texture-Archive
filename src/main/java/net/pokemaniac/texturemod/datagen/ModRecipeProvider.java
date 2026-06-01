package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.pokemaniac.texturemod.block.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                /*
                CRAFTING
                 */

                stairBuilder(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655, Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                        .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                        .group("cobblestone_pre_classic_rd_131655")
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);


                stairBuilder(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515, Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                        .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                        .group("cobblestone_pre_classic_rd_20090515")
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);




                /*
                SMELTING
                 */

                List<ItemLike> STONE_PRE_CLASSIC_RD_20090515_SMELTABLES = List.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);

                oreSmelting(STONE_PRE_CLASSIC_RD_20090515_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModBlocks.STONE_PRE_CLASSIC_RD_20090515, 0.1f, 200, "stone_pre_classic_rd_20090515");
            }
        };
    }

    @Override
    public String getName() {
        return "Tecture Archive Recipes";
    }
}
