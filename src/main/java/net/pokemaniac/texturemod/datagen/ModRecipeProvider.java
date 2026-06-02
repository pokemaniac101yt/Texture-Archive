package net.pokemaniac.texturemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

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

                shaped(RecipeCategory.TOOLS, ModItems.WOODEN_CHISEL)
                        .pattern("X")
                        .pattern("#")
                        .define('X', ItemTags.WOODEN_TOOL_MATERIALS)
                        .define('#', Items.STICK)
                        .unlockedBy("has_wood_material", has(ItemTags.WOODEN_TOOL_MATERIALS))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_CHISEL)
                        .pattern("X")
                        .pattern("#")
                        .define('X', ItemTags.GOLD_TOOL_MATERIALS)
                        .define('#', Items.STICK)
                        .unlockedBy("has_gold_material", has(ItemTags.GOLD_TOOL_MATERIALS))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.STONE_CHISEL)
                        .pattern("X")
                        .pattern("#")
                        .define('X', ItemTags.STONE_TOOL_MATERIALS)
                        .define('#', Items.STICK)
                        .unlockedBy("has_stone_material", has(ItemTags.STONE_TOOL_MATERIALS))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.COPPER_CHISEL)
                        .pattern("X")
                        .pattern("#")
                        .define('X', ItemTags.COPPER_TOOL_MATERIALS)
                        .define('#', Items.STICK)
                        .unlockedBy("has_copper_material", has(ItemTags.COPPER_TOOL_MATERIALS))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.IRON_CHISEL)
                        .pattern("X")
                        .pattern("#")
                        .define('X', ItemTags.IRON_TOOL_MATERIALS)
                        .define('#', Items.STICK)
                        .unlockedBy("has_iron_material", has(ItemTags.IRON_TOOL_MATERIALS))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_CHISEL)
                        .pattern("X")
                        .pattern("#")
                        .define('X', ItemTags.DIAMOND_TOOL_MATERIALS)
                        .define('#', Items.STICK)
                        .unlockedBy("has_diamond_material", has(ItemTags.DIAMOND_TOOL_MATERIALS))
                        .save(output);

                netheriteSmithing(ModItems.DIAMOND_CHISEL, RecipeCategory.COMBAT, ModItems.NETHERITE_CHISEL);




                stairBuilder(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655, Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                        .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                        .group("cobblestone_stairs")
                        .save(output);
                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655, Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                        .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                        .group("cobblestone_slabs")
                        .save(output);
                wallBuilder(RecipeCategory.MISC, ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655, Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                        .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                        .group("cobblestone_walls")
                        .save(output);


                stairBuilder(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515, Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                        .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                        .group("cobblestone_stairs")
                        .save(output);
                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515, Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                        .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                        .group("cobblestone_slabs")
                        .save(output);
                wallBuilder(RecipeCategory.MISC, ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515, Ingredient.of(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                        .unlockedBy(getHasName(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515), has(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515))
                        .group("cobblestone_walls")
                        .save(output);

                stairBuilder(ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515, Ingredient.of(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                        .unlockedBy(getHasName(ModBlocks.STONE_PRE_CLASSIC_RD_20090515), has(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                        .group("stone_stairs")
                        .save(output);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515, Ingredient.of(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                        .unlockedBy(getHasName(ModBlocks.STONE_PRE_CLASSIC_RD_20090515), has(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                        .group("stone_slabs")
                        .save(output);

                pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515, Ingredient.of(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                        .unlockedBy(getHasName(ModBlocks.STONE_PRE_CLASSIC_RD_20090515), has(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                        .group("stone_pressure_plates")
                        .save(output);

                buttonBuilder(ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515, Ingredient.of(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                        .unlockedBy(getHasName(ModBlocks.STONE_PRE_CLASSIC_RD_20090515), has(ModBlocks.STONE_PRE_CLASSIC_RD_20090515))
                        .group("stone_buttons")
                        .save(output);




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
