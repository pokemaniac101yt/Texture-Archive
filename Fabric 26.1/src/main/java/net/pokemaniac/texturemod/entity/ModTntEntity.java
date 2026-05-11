package net.pokemaniac.texturemod.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModTntEntity extends TntEntity {

    private Block tntBlock;

    public ModTntEntity(EntityType<? extends TntEntity> type, World world) {
        super(type, world);
    }

    public void setBlockFromWorld(BlockPos pos) {
        this.tntBlock = this.getWorld().getBlockState(pos).getBlock();
    }

    public void setTntBlock(Block block) {
        this.tntBlock = block;
    }

    public Block getTntBlock() {
        return tntBlock;
    }
}

