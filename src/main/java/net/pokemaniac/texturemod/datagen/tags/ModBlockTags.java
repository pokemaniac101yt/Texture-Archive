package net.pokemaniac.texturemod.datagen.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {

    public static final TagKey<Block> FLAMMABLE_FLOWERS = create("flammable_flowers");
    public static final TagKey<Block> FLAMMABLE_LEAVES = create("flammable_leaves");
    public static final TagKey<Block> FLAMMABLE_LOGS = create("flammable_logs");
    public static final TagKey<Block> FLAMMABLE_PLANKS = create("flammable_planks");

    public static final TagKey<Block> LAVA_FLAMMABLE = create("lava_flammable");

    private static TagKey<Block> create(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of("texturemod", name));
    }

    public static void register() {
    }
}
