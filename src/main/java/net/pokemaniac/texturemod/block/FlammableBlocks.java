package net.pokemaniac.texturemod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class FlammableBlocks {

    public static class FlammableBlock extends Block {

        private final int igniteOdds;
        private final int burnOdds;

        public FlammableBlock(Properties properties, int igniteOdds, int burnOdds) {
            super(properties);
            this.igniteOdds = igniteOdds;
            this.burnOdds = burnOdds;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return burnOdds;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return igniteOdds;
        }
    }

    public static class FlammableStairBlock extends StairBlock {

        private final int igniteOdds;
        private final int burnOdds;

        public FlammableStairBlock(BlockState baseState, Properties properties, int igniteOdds, int burnOdds) {
            super(baseState, properties);
            this.igniteOdds = igniteOdds;
            this.burnOdds = burnOdds;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return burnOdds;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return igniteOdds;
        }
    }

    public static class FlammableSlabBlock extends SlabBlock {

        private final int igniteOdds;
        private final int burnOdds;


        public FlammableSlabBlock(Properties properties, int igniteOdds, int burnOdds) {
            super(properties);
            this.igniteOdds = igniteOdds;
            this.burnOdds = burnOdds;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return burnOdds;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return igniteOdds;
        }
    }

    public static class FlammableFenceBlock extends FenceBlock {

        private final int igniteOdds;
        private final int burnOdds;


        public FlammableFenceBlock(Properties properties, int igniteOdds, int burnOdds) {
            super(properties);
            this.igniteOdds = igniteOdds;
            this.burnOdds = burnOdds;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return burnOdds;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return igniteOdds;
        }
    }

    public static class FlammableFenceGateBlock extends FenceGateBlock {

        private final int igniteOdds;
        private final int burnOdds;


        public FlammableFenceGateBlock(WoodType type, Properties properties, int igniteOdds, int burnOdds) {
            super(type, properties);
            this.igniteOdds = igniteOdds;
            this.burnOdds = burnOdds;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return burnOdds;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction face) {
            return igniteOdds;
        }
    }




}
