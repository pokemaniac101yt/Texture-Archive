package net.pokemaniac.texturemod.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import static net.pokemaniac.texturemod.TextureArchive.CHISEL_MAP;

public class ChiselItem extends Item {
    private final ToolMaterial material;

    public ChiselItem(
            ToolMaterial material,
            Properties properties
    ) {
        super(properties
                .durability(material.durability())
                .repairable(material.repairItems()));
        this.material = material;
    }

    public ToolMaterial getMaterial() {
        return material;
    }



    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {

            if (!level.isClientSide()) {
                BlockState oldState = level.getBlockState(context.getClickedPos());
                BlockState newState = CHISEL_MAP.get(clickedBlock).defaultBlockState();

                for (Property<?> property : oldState.getProperties()) {
                    if (newState.hasProperty(property)) {
                        newState = copyProperty(newState, oldState, property);
                    }
                }


                level.setBlockAndUpdate(
                        context.getClickedPos(),
                        newState
                );

                context.getItemInHand().hurtAndBreak(
                        1,
                        context.getPlayer(),
                        context.getHand()
                );
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private static <T extends Comparable<T>> BlockState copyProperty(
            BlockState newState,
            BlockState oldState,
            Property<T> property
    ) {
        return newState.setValue(property, oldState.getValue(property));
    }

}
