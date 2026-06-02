package net.pokemaniac.texturemod.tooltip;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class TooltipItemProvider {

    public static class TooltipBlockItem extends BlockItem {
        private final String[] tooltipKeys;

        public TooltipBlockItem(Block block, Properties properties, String... tooltipKeys) {
            super(block, properties);
            this.tooltipKeys = tooltipKeys;
        }

        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            for (String key : tooltipKeys) {
                builder.accept(Component.translatable(key));
            }

            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    }

    public static class TooltipItem extends Item {

        private final String[] tooltipKeys;


        public TooltipItem(Properties properties, String... tooltipKeys) {
            super(properties);
            this.tooltipKeys = tooltipKeys;
        }

        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            for (String key : tooltipKeys) {
                builder.accept(Component.translatable(key));
            }

            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    }

    public static class TooltipStandingAndWallBlockItem extends StandingAndWallBlockItem {

        private final String[] tooltipKeys;

        public TooltipStandingAndWallBlockItem(Block block, Block wallBlock, Direction attachmentDirection, Properties properties, String... tooltipKeys) {
            super(block, wallBlock, attachmentDirection, properties);
            this.tooltipKeys = tooltipKeys;
        }

        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {

            for (String key : tooltipKeys) {
                builder.accept(Component.translatable(key));
            }

            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    }

}

