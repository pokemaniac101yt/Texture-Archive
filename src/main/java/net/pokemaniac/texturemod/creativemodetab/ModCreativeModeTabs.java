package net.pokemaniac.texturemod.creativemodetab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

public class ModCreativeModeTabs {
    public static final CreativeModeTab PRE_CLASSIC_BLOCKS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TextureArchive.MOD_ID, "pre_classic_blocks"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655))
                    .title(Component.translatable("creativetab.texturemod.pre_classic_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655);
                        output.accept(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655);
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655);
                        output.accept(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655);
                        output.accept(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655);

                        output.accept(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515);
                        output.accept(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);
                        output.accept(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515);
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515);
                        output.accept(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515);
                        output.accept(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515);
                        output.accept(ModBlocks.STONE_PRE_CLASSIC_RD_20090515);
                    }).build());

    public static void registerModCreativeModeTabs() {
        TextureArchive.LOGGER.info("Registering Creative Mode Tabs for " + TextureArchive.MOD_ID);
    }
}
