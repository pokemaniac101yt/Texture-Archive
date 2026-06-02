package net.pokemaniac.texturemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Texture Archive Recipes";
        }
    }

    @Override
    protected void buildRecipes() {

        /*
        CRAFTING
         */

        stairBuilder(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.get(), Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get()))
                .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get()), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                .group("cobblestone_stairs")
                .save(output);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.get(), Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get()))
                .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get()), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                .group("cobblestone_slabs")
                .save(output);

        wallBuilder(RecipeCategory.MISC, ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655.get(), Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get()))
                .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get()), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                .group("cobblestone_walls")
                .save(output);




        stairBuilder(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.get(), Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get()))
                .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get()), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                .group("cobblestone_stairs")
                .save(output);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.get(), Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get()))
                .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get()), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                .group("cobblestone_slabs")
                .save(output);

        wallBuilder(RecipeCategory.MISC, ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515.get(), Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get()))
                .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get()), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                .group("cobblestone_walls")
                .save(output);



        stairBuilder(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515.get(), Ingredient.of(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get()))
                .unlockedBy(getHasName(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get()), has(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                .group("stone_stairs")
                .save(output);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515.get(), Ingredient.of(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get()))
                .unlockedBy(getHasName(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get()), has(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                .group("stone_slabs")
                .save(output);

        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515.get(), Ingredient.of(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get()))
                .unlockedBy(getHasName(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get()), has(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                .group("stone_pressure_plates")
                .save(output);

        buttonBuilder(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515.get(), Ingredient.of(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get()))
                .unlockedBy(getHasName(ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get()), has(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                .group("stone_buttons")
                .save(output);


        /*
        SMELTING
         */

        List<ItemLike> STONE_PRE_CLASSIC_20090515_SMELTABLES = List.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655, ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);

        oreSmelting(STONE_PRE_CLASSIC_20090515_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModBlocks.STONE_PRE_CLASSIC_RD_20090515, 0.1f, 200, "stone_pre_classic_rd_20090515");
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, TextureArchive.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
