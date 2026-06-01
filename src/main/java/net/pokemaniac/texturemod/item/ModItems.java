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
import net.minecraft.world.item.ToolMaterial;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.item.custom.ChiselItem;

import java.util.function.Function;

public class ModItems {

    // Item::new can be replaced with properties
    public static final Item WOODEN_CHISEL = registerItem("wooden_chisel", properties -> new ChiselItem(ToolMaterial.WOOD, properties));
    public static final Item GOLDEN_CHISEL = registerItem("golden_chisel", properties -> new ChiselItem(ToolMaterial.GOLD, properties));
    public static final Item STONE_CHISEL = registerItem("stone_chisel", properties -> new ChiselItem(ToolMaterial.STONE, properties));
    public static final Item COPPER_CHISEL = registerItem("copper_chisel", properties -> new ChiselItem(ToolMaterial.COPPER, properties));
    public static final Item IRON_CHISEL = registerItem("iron_chisel", properties -> new ChiselItem(ToolMaterial.IRON, properties));
    public static final Item DIAMOND_CHISEL = registerItem("diamond_chisel", properties -> new ChiselItem(ToolMaterial.DIAMOND, properties));
    public static final Item NETHERITE_CHISEL = registerItem("netherite_chisel", properties -> new ChiselItem(ToolMaterial.NETHERITE, properties));


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, name)))));
    }

    public static void registerModItems() {
        TextureArchive.LOGGER.info("Registering Mod Items for" + TextureArchive.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> {
            output.accept(WOODEN_CHISEL);
            output.accept(GOLDEN_CHISEL);
            output.accept(STONE_CHISEL);
            output.accept(COPPER_CHISEL);
            output.accept(IRON_CHISEL);
            output.accept(DIAMOND_CHISEL);
            output.accept(NETHERITE_CHISEL);
        });

    }
}
