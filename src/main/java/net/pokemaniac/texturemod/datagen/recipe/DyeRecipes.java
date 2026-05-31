package net.pokemaniac.texturemod.datagen.recipe;

import com.google.gson.Gson;
import net.minecraft.data.server.recipe.RecipeExporter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DyeRecipes {

    public List<BlockSet> block_sets;

    public List<String> white_dyes;
    public List<String> light_gray_dyes;
    public List<String> gray_dyes;
    public List<String> black_dyes;
    public List<String> brown_dyes;
    public List<String> red_dyes;
    public List<String> orange_dyes;
    public List<String> yellow_dyes;
    public List<String> lime_dyes;
    public List<String> green_dyes;
    public List<String> cyan_dyes;
    public List<String> light_blue_dyes;
    public List<String> blue_dyes;
    public List<String> purple_dyes;
    public List<String> magenta_dyes;
    public List<String> pink_dyes;

    public static class BlockSet {
        public String set;
        public String blank;
        public String white;
        public String light_gray;
        public String gray;
        public String black;
        public String brown;
        public String red;
        public String orange;
        public String yellow;
        public String lime;
        public String green;
        public String cyan;
        public String light_blue;
        public String blue;
        public String purple;
        public String magenta;
        public String pink;

        public Map<String, String> asMap() {
            Map<String, String> map = new HashMap<>();

            for (Field field : this.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(this);
                    if (value instanceof String s) {
                        map.put(field.getName(), s);
                    }
                } catch (Exception ignored) {}
            }

            return map;
        }
    }

    private static final Gson GSON = new Gson();

    private static DyeRecipes loadConfig() {
        try {
            InputStream stream = DyeRecipes.class.getClassLoader()
                    .getResourceAsStream("data/texturemod/dye_recipes.json");

            if (stream == null) {
                throw new RuntimeException("Could not find dye_recipes.json");
            }

            InputStreamReader reader = new InputStreamReader(stream);
            return GSON.fromJson(reader, DyeRecipes.class);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load dye_recipes.json", e);
        }
    }

    public static void generate(RecipeExporter exporter) {
        DyeRecipes config = loadConfig();

        for (DyeRecipes.BlockSet blockSet : config.block_sets) {

            for (var entry : blockSet.asMap().entrySet()) {
                String id = entry.getKey();
                String value = entry.getValue();

                if (id.equals("blank") || id.equals("set")) continue;

                if (value == null || value.equalsIgnoreCase("NULL")) continue;

                String dyeListName = id + "_dyes";

                Field dyeField;
                try {
                    dyeField = DyeRecipes.class.getField(dyeListName);
                } catch (NoSuchFieldException e) {
                    continue;
                }

                try {
                    List<String> dyeList = (List<String>) dyeField.get(config);

                    if (dyeList == null || dyeList.isEmpty()) continue;

                    for (String dyeItem : dyeList) {
                        ModRecipeOffers.offerDyeRecipe(
                                exporter,
                                blockSet.blank,
                                value,
                                dyeItem
                        );
                    }

                } catch (Exception e) {
                    throw new RuntimeException("Error processing dye list: " + dyeListName, e);
                }
            }
        }
    }

}
