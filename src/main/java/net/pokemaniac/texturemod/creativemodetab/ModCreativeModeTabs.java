package net.pokemaniac.texturemod.creativemodetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TextureArchive.MOD_ID);

    public static final Supplier<CreativeModeTab> PRE_CLASSIC_BLOCKS = CREATIVE_MODE_TABS.register("pre_classic_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                    .title(Component.translatable("itemgroup.texturemod.pre_classic_blocks"))
                    .withTabsAfter(Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "classic_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
