package net.pokemaniac.texturemod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pokemaniac.texturemod.TextureArchive;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TextureArchive.MOD_ID);

    public static final DeferredItem<Item> WOODEN_CHISEL = ITEMS.registerSimpleItem("wooden_chisel");




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
