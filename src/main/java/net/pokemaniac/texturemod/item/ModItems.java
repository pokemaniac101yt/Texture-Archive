package net.pokemaniac.texturemod.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.pokemaniac.texturemod.TextureArchive;

import java.util.function.Function;

public class ModItems {

    // Item::new can be replaced with properties
    public static final Item WOODEN_CHISEL = registerItem("wooden_chisel", Item::new);



    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name)))));
    }

    public static void registerModItems() {
        TextureArchive.LOGGER.info("Registering Mod Items for" + TextureArchive.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output ->
                output.accept(WOODEN_CHISEL));
    }
}
