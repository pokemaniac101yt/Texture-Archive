package net.pokemaniac.texturemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.pokemaniac.texturemod.TextureMod;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.custom.ChiselItem;
import net.pokemaniac.texturemod.item.custom.ChiselMaterial;
import net.pokemaniac.texturemod.tooltip.ModTooltips;
import net.pokemaniac.texturemod.tooltip.TooltipItemProvider;

public class ModItems {
    public static final Item WOODEN_CHISEL = registerItem("wooden_chisel", new ChiselItem(ChiselMaterial.WOOD, new Item.Settings()));
    public static final Item GOLDEN_CHISEL = registerItem("golden_chisel", new ChiselItem(ChiselMaterial.GOLD, new Item.Settings()));
    public static final Item STONE_CHISEL = registerItem("stone_chisel", new ChiselItem(ChiselMaterial.STONE, new Item.Settings()));
    public static final Item COPPER_CHISEL = registerItem("copper_chisel", new ChiselItem(ChiselMaterial.COPPER, new Item.Settings()));
    public static final Item IRON_CHISEL = registerItem("iron_chisel", new ChiselItem(ChiselMaterial.IRON, new Item.Settings()));
    public static final Item DIAMOND_CHISEL = registerItem("diamond_chisel", new ChiselItem(ChiselMaterial.DIAMOND, new Item.Settings()));
    public static final Item NETHERITE_CHISEL = registerItem("netherite_chisel", new ChiselItem(ChiselMaterial.NETHERITE, new Item.Settings()));

    public static final Item TORCH_INDEV_0_31_20091223_1457 = registerItem(
            "torch_indev_0_31_20091223_1457",
            new TooltipItemProvider.TooltipVerticallyAttachableBlockItem(
                    ModBlocks.TORCH_INDEV_0_31_20091223_1457,
                    ModBlocks.WALL_TORCH_INDEV_0_31_20091223_1457,
                    new Item.Settings(),
                    Direction.DOWN,
                    ModTooltips.INDEV_0_31_TOOLTIP,
                    ModTooltips.SNAPSHOT_20091223_1457_TOOLTIP
            )
    );

    public static final Item TORCH_INDEV_0_31_20091231_1856 = registerItem(
            "torch_indev_0_31_20091231_1856",
            new TooltipItemProvider.TooltipVerticallyAttachableBlockItem(
                    ModBlocks.TORCH_INDEV_0_31_20091231_1856,
                    ModBlocks.WALL_TORCH_INDEV_0_31_20091231_1856,
                    new Item.Settings(),
                    Direction.DOWN,
                    ModTooltips.INDEV_0_31_TOOLTIP,
                    ModTooltips.SNAPSHOT_20091231_1856_TOOLTIP,
                    ModTooltips.PROGRAMMER_ART_TOOLTIP
            )
    );

    private static Item registerItem(
            String name,
            Item item) {
        {
            Identifier id = Identifier.of(TextureMod.MOD_ID, name);

            return Registry.register(
                    Registries.ITEM,
                    id,
                    item
            );
        }
    }

    public static void registerModItems() {
        TextureMod.LOGGER.info("Registering Mod Items for " + TextureMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(WOODEN_CHISEL);
            entries.add(GOLDEN_CHISEL);
            entries.add(STONE_CHISEL);
            entries.add(COPPER_CHISEL);
            entries.add(IRON_CHISEL);
            entries.add(DIAMOND_CHISEL);
            entries.add(NETHERITE_CHISEL);
        });
    }


}
