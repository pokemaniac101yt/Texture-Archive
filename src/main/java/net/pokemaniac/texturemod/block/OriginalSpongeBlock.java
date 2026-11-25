package net.pokemaniac.texturemod.block;

import net.aneyra.block.AneyraBlockProperties;
import net.aneyra.block.AneyraSpongeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;

public class OriginalSpongeBlock extends AneyraSpongeBlock {
    public OriginalSpongeBlock(Properties properties, AneyraBlockProperties.SpongeProperties spongeProperties) {
        super(properties, spongeProperties);
    }

    @Override
    protected boolean removeWaterBreadthFirstSearch(
            final Level level, final BlockPos startPos
    ) {
        boolean absorbed = false;

        for (BlockPos pos : BlockPos.betweenClosed(
                startPos.offset(-2, -2, -2),
                startPos.offset(2, 2, 2)
        )) {
            if (pos.equals(startPos)) {
                continue;
            }

            if (level.getFluidState(pos).is(fluid)
                    && level.getBlockState(pos).getBlock() instanceof LiquidBlock) {
                if (level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3)) {
                    absorbed = true;
                }
            }
        }

        return absorbed;
    }
}
