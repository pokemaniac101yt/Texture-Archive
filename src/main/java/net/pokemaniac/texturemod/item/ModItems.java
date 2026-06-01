package net.pokemaniac.texturemod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.item.custom.ChiselItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TextureArchive.MOD_ID);

    public static final DeferredItem<Item> WOODEN_CHISEL = ITEMS.registerItem("wooden_chisel",
            properties -> new ChiselItem(ToolMaterial.WOOD, properties));
    public static final DeferredItem<Item> STONE_CHISEL = ITEMS.registerItem("stone_chisel",
            properties -> new ChiselItem(ToolMaterial.STONE, properties));
    public static final DeferredItem<Item> COPPER_CHISEL = ITEMS.registerItem("copper_chisel",
            properties -> new ChiselItem(ToolMaterial.COPPER, properties));
    public static final DeferredItem<Item> IRON_CHISEL = ITEMS.registerItem("iron_chisel",
            properties -> new ChiselItem(ToolMaterial.IRON, properties));
    public static final DeferredItem<Item> GOLDEN_CHISEL = ITEMS.registerItem("golden_chisel",
            properties -> new ChiselItem(ToolMaterial.GOLD, properties));
    public static final DeferredItem<Item> DIAMOND_CHISEL = ITEMS.registerItem("diamond_chisel",
            properties -> new ChiselItem(ToolMaterial.DIAMOND, properties));
    public static final DeferredItem<Item> NETHERITE_CHISEL = ITEMS.registerItem("netherite_chisel",
            properties -> new ChiselItem(ToolMaterial.NETHERITE, properties));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
