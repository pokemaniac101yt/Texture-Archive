package net.pokemaniac.texturemod.datagen.recipe;

import net.minecraft.block.Block;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.server.recipe.RecipeProvider.*;

public class ModRecipeOffers extends RecipeProvider {
    public ModRecipeOffers(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    public static void offerStairsRecipe(
            RecipeExporter exporter,
            Block stairs,
            Block base) {

        createStairsRecipe(stairs, Ingredient.ofItems(base))
                .criterion(hasItem(base), conditionsFromItem(base))
                .offerTo(exporter);
    }

    public static void offerFenceRecipe(
            RecipeExporter exporter,
            Block fence,
            ItemConvertible planks) {

        createFenceRecipe(fence, Ingredient.ofItems(planks))
                .criterion(hasItem(planks), conditionsFromItem(planks))
                .offerTo(exporter);
    }

    public static void offerFenceGateRecipe(
            RecipeExporter exporter,
            Block gate,
            ItemConvertible planks) {

        createFenceGateRecipe(gate, Ingredient.ofItems(planks))
                .criterion(hasItem(planks), conditionsFromItem(planks))
                .offerTo(exporter);

    }

    public static void offerSingleRecipe(
            RecipeExporter exporter,
            ItemConvertible output,
            ItemConvertible input,
            int count
    ) {
        Identifier id = Identifier.of(
                "texturemod",
                Registries.ITEM.getId(output.asItem()).getPath()
                        + "_from_"
                        + Registries.ITEM.getId(input.asItem()).getPath()
        );

        ShapelessRecipeJsonBuilder.create(
                        RecipeCategory.MISC,
                        output, count
                )
                .input(input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter, id);
    }

    public static void offerDyeRecipe(
            RecipeExporter exporter,
            String blankBlockId,
            String outputBlockId,
            String dyeItemId
    ) {
        // Convert string IDs to actual items
        ItemConvertible blank = Registries.ITEM.get(Identifier.of("texturemod", blankBlockId));
        ItemConvertible output = Registries.ITEM.get(Identifier.of("texturemod", outputBlockId));
        ItemConvertible dye = Registries.ITEM.get(Identifier.of(dyeItemId));

        if (blank == Items.AIR || output == Items.AIR || dye == Items.AIR) {
            return;
        }

        // Build recipe ID
        Identifier id = Identifier.of(
                "texturemod",
                Registries.ITEM.getId(output.asItem()).getPath()
                        + "_from_"
                        + Registries.ITEM.getId(blank.asItem()).getPath()
                        + "_using_"
                        + Registries.ITEM.getId(dye.asItem()).getPath()
        );

        // Create shapeless recipe
        ShapelessRecipeJsonBuilder.create(
                        RecipeCategory.MISC,
                        output, 1
                )
                .input(blank)
                .input(dye)
                .criterion(hasItem(blank), conditionsFromItem(blank))
                .offerTo(exporter, id);
    }

    @Override
    public void generate(RecipeExporter exporter) {

    }
}
