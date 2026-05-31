package net.pokemaniac.texturemod.tooltip;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.VerticallyAttachableBlockItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.math.Direction;

import java.util.List;

public class TooltipItemProvider {

    public static class TooltipBlockItem extends BlockItem {

        private final String[] tooltipKeys;

        public TooltipBlockItem(Block block, Settings settings, String... tooltipKeys) {
            super(block, settings);
            this.tooltipKeys = tooltipKeys;
        }

        @Override
        public void appendTooltip(
                ItemStack stack,
                TooltipContext context,
                List<Text> tooltip,
                TooltipType type
        ) {
            for (String key : tooltipKeys) {
                tooltip.add(Text.translatable(key));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    }

    public static class TooltipItem extends Item {

        private final String[] tooltipKeys;

        public TooltipItem(Settings settings, String... tooltipKeys) {
            super(settings);
            this.tooltipKeys = tooltipKeys;
        }


        @Override
        public void appendTooltip(
                ItemStack stack,
                TooltipContext context,
                List<Text> tooltip,
                TooltipType type
        ) {
            for (String key : tooltipKeys) {
                tooltip.add(Text.translatable(key));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    }

    public static class TooltipVerticallyAttachableBlockItem extends VerticallyAttachableBlockItem {

        private final String[] tooltipKeys;

        public TooltipVerticallyAttachableBlockItem(Block standingBlock, Block wallBlock, Settings settings, Direction verticalAttachmentDirection, String... tooltipKeys) {
            super(standingBlock, wallBlock, settings, verticalAttachmentDirection);
            this.tooltipKeys = tooltipKeys;
        }


        @Override
        public void appendTooltip(
                ItemStack stack,
                TooltipContext context,
                List<Text> tooltip,
                TooltipType type
        ) {
            for (String key : tooltipKeys) {
                tooltip.add(Text.translatable(key));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    }
}
