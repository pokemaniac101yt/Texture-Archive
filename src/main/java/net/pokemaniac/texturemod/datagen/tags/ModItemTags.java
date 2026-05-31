package net.pokemaniac.texturemod.datagen.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {

    public static final TagKey<Item> COMPOSTABLE_LEAVES = create("compostable_leaves");

    private static TagKey<Item> create(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of("texturemod", name));
    }
}
