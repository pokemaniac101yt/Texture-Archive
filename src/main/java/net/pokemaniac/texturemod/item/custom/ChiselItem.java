package net.pokemaniac.texturemod.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static net.pokemaniac.texturemod.TextureArchive.CHISEL_MAP;

public class ChiselItem extends Item {
    private final ToolMaterial material;

    public ChiselItem(
            ToolMaterial material,
            Properties properties
    ) {
        super(properties.durability(material.durability()));
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
                level.setBlockAndUpdate(
                        context.getClickedPos(),
                        CHISEL_MAP.get(clickedBlock).defaultBlockState()
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
}
