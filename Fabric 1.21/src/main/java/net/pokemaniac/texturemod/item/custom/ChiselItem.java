package net.pokemaniac.texturemod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import static net.pokemaniac.texturemod.TextureMod.CHISEL_MAP;

public class ChiselItem extends ToolItem {
    public ChiselItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }


    public boolean isSuitableFor(BlockState state) {
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                BlockState oldState = world.getBlockState(context.getBlockPos());
                BlockState newState = CHISEL_MAP.get(clickedBlock).getDefaultState();

                for (Property<?> property : oldState.getProperties()) {
                    if (newState.contains(property)) {
                        newState = copyProperty(newState, oldState, property);
                    }
                }

                world.setBlockState(context.getBlockPos(), newState);

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> {
                            assert context.getPlayer() != null;
                            context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND);
                        });

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }

    private static <T extends Comparable<T>> BlockState copyProperty(
            BlockState newState,
            BlockState oldState,
            Property<T> property
    ) {
        return newState.with(property, oldState.get(property));
    }

}
