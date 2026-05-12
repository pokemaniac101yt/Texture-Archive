package net.pokemaniac.texturemod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.pokemaniac.texturemod.TextureMod;
import net.pokemaniac.texturemod.tooltip.ModTooltips;
import net.pokemaniac.texturemod.tooltip.TooltipItemProvider;

public class ModBlocks {

    public static class CustomSpongeBlock extends SpongeBlock {
        private static final Direction[] DIRECTIONS = Direction.values();
        private Block WET_SPONGE;

        public CustomSpongeBlock(AbstractBlock.Settings settings) {
            super(settings);
        }

        // Make the sponge pairs customizable
        public void setWetSponge(Block WET_SPONGE){
            this.WET_SPONGE = WET_SPONGE;
        }

        @Override
        protected void update(World world, BlockPos pos) {
            if (this.absorbWater(world, pos)) {
                world.setBlockState(pos, WET_SPONGE.getDefaultState(), 2);
                world.playSound(null, pos, SoundEvents.BLOCK_SPONGE_ABSORB, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }

        }

        // Just the vanilla method since it's private, just copied it over *shrug*

        private boolean absorbWater(World world, BlockPos pos) {
            return BlockPos.iterateRecursively(pos, 6, 65, (currentPos, queuer) -> {
                for(Direction direction : DIRECTIONS) {
                    queuer.accept(currentPos.offset(direction));
                }

            }, (currentPos) -> {
                if (currentPos.equals(pos)) {
                    return true;
                } else {
                    BlockState blockState = world.getBlockState(currentPos);
                    FluidState fluidState = world.getFluidState(currentPos);
                    if (!fluidState.isIn(FluidTags.WATER)) {
                        return false;
                    } else {
                        Block block = blockState.getBlock();
                        if (block instanceof FluidDrainable) {
                            FluidDrainable fluidDrainable = (FluidDrainable)block;
                            if (!fluidDrainable.tryDrainFluid((PlayerEntity)null, world, currentPos, blockState).isEmpty()) {
                                return true;
                            }
                        }

                        if (blockState.getBlock() instanceof FluidBlock) {
                            world.setBlockState(currentPos, Blocks.AIR.getDefaultState(), 3);
                        } else {
                            if (!blockState.isOf(Blocks.KELP) && !blockState.isOf(Blocks.KELP_PLANT) && !blockState.isOf(Blocks.SEAGRASS) && !blockState.isOf(Blocks.TALL_SEAGRASS)) {
                                return false;
                            }

                            BlockEntity blockEntity = blockState.hasBlockEntity() ? world.getBlockEntity(currentPos) : null;
                            dropStacks(blockState, world, currentPos, blockEntity);
                            world.setBlockState(currentPos, Blocks.AIR.getDefaultState(), 3);
                        }

                        return true;
                    }
                }
            }) > 1;
        }
    }

    public static class CustomWetSpongeBlock extends Block {
        public Block SPONGE;

        public CustomWetSpongeBlock(AbstractBlock.Settings settings) {
            super(settings);
        }

        public void setSponge(Block SPONGE){
            this.SPONGE = SPONGE;
        }

        @Override
        protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
            if (world.getDimension().ultrawarm()) {
                world.setBlockState(pos, SPONGE.getDefaultState(), 3);
                world.syncWorldEvent(2009, pos, 0);
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WET_SPONGE_DRIES, SoundCategory.BLOCKS, 1.0F, (1.0F + world.getRandom().nextFloat() * 0.2F) * 0.7F);
            }

        }
    }

    public static class CustomTorchBlock extends TorchBlock {
        public CustomTorchBlock(SimpleParticleType particle, Settings settings) {
            super(particle, settings);
        }

        // Fix the particle placement for 13 pixel tall torches instead of 10
        @Override
        public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            double d = (double)pos.getX() + (double)0.5F;
            double e = (double)pos.getY() + 0.8875;
            double f = (double)pos.getZ() + (double)0.5F;
            world.addParticle(ParticleTypes.SMOKE, d, e, f, (double)0.0F, (double)0.0F, (double)0.0F);
            world.addParticle(this.particle, d, e, f, (double)0.0F, (double)0.0F, (double)0.0F);
        }
    }

    public static class CustomWallTorchBlock extends WallTorchBlock {

        public CustomWallTorchBlock(SimpleParticleType simpleParticleType, Settings settings) {
            super(simpleParticleType, settings);
        }

        // Fix the particle placement for 13 pixel tall torches instead of 10
        @Override
        public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            Direction direction = state.get(FACING);
            double d = (double)pos.getX() + (double)0.5F;
            // Height. Vanilla is 0.7 * 13/10 = 0.8875
            double e = (double)pos.getY() + 0.8875;
            double f = (double)pos.getZ() + (double)0.5F;
            double g = 0.22;
            // Horizontal offset. Vanilla is 0.27 * 10/13 = 0.207 because adding sends the particle closer to the block
            double h = 0.207;
            Direction direction2 = direction.getOpposite();
            world.addParticle(ParticleTypes.SMOKE, d + h * (double)direction2.getOffsetX(), e + g, f + h * (double)direction2.getOffsetZ(), (double)0.0F, (double)0.0F, (double)0.0F);
            world.addParticle(this.particle, d + h * (double)direction2.getOffsetX(), e + g, f + h * (double)direction2.getOffsetZ(), (double)0.0F, (double)0.0F, (double)0.0F);
        }
    }






    // ===== Blocks =====



    /*
    PRE-CLASSIC RD-131655
    */



    public static final Block GRASS_BLOCK_PRE_CLASSIC_RD_131655 =
            registerBlock("grass_block_pre_classic_rd_131655",
                    new GrassBlock(
                            AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_pre_classic_rd_131655",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_stairs_pre_classic_rd_131655",
                    new StairsBlock(
                            COBBLESTONE_PRE_CLASSIC_RD_131655.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_STAIRS)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_slab_pre_classic_rd_131655",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_SLAB)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_WALL_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_wall_pre_classic_rd_131655",
                    new WallBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL)
                    ),
                    ModTooltips.CAVE_GAME_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_131655_TOOLTIP
            );



    /*
    PRE-CLASSIC RD-20090515
     */



    public static final Block GRASS_BLOCK_PRE_CLASSIC_RD_20090515 =
            registerBlock("grass_block_pre_classic_rd_20090515",
                    new GrassBlock(
                            AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block DIRT_PRE_CLASSIC_RD_20090515 =
            registerBlock("dirt_pre_classic_rd_20090515",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.DIRT)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block COBBLESTONE_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_pre_classic_rd_20090515",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_stairs_pre_classic_rd_20090515",
                    new StairsBlock(
                            COBBLESTONE_PRE_CLASSIC_RD_131655.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_STAIRS)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );


    public static final Block COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_slab_pre_classic_rd_20090515",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_SLAB)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_wall_pre_classic_rd_20090515",
                    new WallBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_PLANKS_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_planks_pre_classic_rd_20090515",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_stairs_pre_classic_rd_20090515",
                    new StairsBlock(
                            OAK_PLANKS_PRE_CLASSIC_RD_20090515.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_slab_pre_classic_rd_20090515",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_SLAB)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_FENCE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_fence_pre_classic_rd_20090515",
                    new FenceBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_fence_gate_pre_classic_rd_20090515",
                    new FenceGateBlock(
                            WoodType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_BUTTON_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_button_pre_classic_rd_20090515",
                    new ButtonBlock(
                            BlockSetType.OAK, 30,
                            AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_pressure_plate_pre_classic_rd_20090515",
                    new PressurePlateBlock(
                            BlockSetType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_pre_classic_rd_20090515",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.STONE)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_stairs_pre_classic_rd_20090515",
                    new StairsBlock(
                            STONE_PRE_CLASSIC_RD_20090515.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.STONE_STAIRS)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_slab_pre_classic_rd_20090515",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.STONE_SLAB)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_BUTTON_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_button_pre_classic_rd_20090515",
                    new ButtonBlock(
                            BlockSetType.STONE, 20,
                            AbstractBlock.Settings.copy(Blocks.STONE_BUTTON)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_pressure_plate_pre_classic_rd_20090515",
                    new PressurePlateBlock(
                            BlockSetType.STONE,
                            AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE)
                    ),
                    ModTooltips.ORDER_OF_THE_STONE_TOOLTIP,
                    ModTooltips.PRE_CLASSIC_RD_20090515_TOOLTIP
            );



    /*
    PRE-CLASSIC RD-161348
     */



    public static final Block OAK_PLANKS_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_planks_pre_classic_rd_161348",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    ),
                    ModTooltips.PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_STAIRS_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_stairs_pre_classic_rd_161348",
                    new StairsBlock(
                            OAK_PLANKS_PRE_CLASSIC_RD_161348.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    ),
                    ModTooltips.PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_SLAB_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_slab_pre_classic_rd_161348",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_SLAB)
                    ),
                    ModTooltips.PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_FENCE_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_fence_pre_classic_rd_161348",
                    new FenceBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE)
                    ),
                    ModTooltips.PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_FENCE_GATE_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_fence_gate_pre_classic_rd_161348",
                    new FenceGateBlock(
                            WoodType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)
                    ),
                    ModTooltips.PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_BUTTON_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_button_pre_classic_rd_161348",
                    new ButtonBlock(
                            BlockSetType.OAK, 30,
                            AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)
                    ),
                    ModTooltips.PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_pressure_plate_pre_classic_rd_161348",
                    new PressurePlateBlock(
                            BlockSetType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)
                    ),
                    ModTooltips.PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_SAPLING_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_sapling_pre_classic_rd_161348",
                    new PlantBlock(AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                            .noCollision()
                            .breakInstantly()
                    ) {
                        @Override
                        protected MapCodec<? extends PlantBlock> getCodec() {
                            return null;
                        }
                    },
                    ModTooltips.PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block POTTED_OAK_SAPLING_PRE_CLASSIC_RD_161348 =
            registerBlockWithoutItem("potted_oak_sapling_pre_classic_rd_161348",
                    new FlowerPotBlock(
                            OAK_SAPLING_PRE_CLASSIC_RD_161348,
                            AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING)
                    )
            );



    /*
    CLASSIC 0.0.12a
    */



    public static final Block BEDROCK_CLASSIC_0_0_12a =
            registerBlock("bedrock_classic_0_0_12a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.BEDROCK)
                    ),
                    ModTooltips.CLASSIC_0_0_12a_TOOLTIP
            );



    /*
    CLASSIC 0.0.13a
    */



    public static final Block OAK_SAPLING_CLASSIC_0_0_13a =
            registerBlock("oak_sapling_classic_0_0_13a",
                    new PlantBlock(AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                            .noCollision()
                            .breakInstantly()
                    ) {
                        @Override
                        protected MapCodec<? extends PlantBlock> getCodec() {
                            return null;
                        }
                    },
                    ModTooltips.CLASSIC_0_0_13a_TOOLTIP
            );

    public static final Block POTTED_OAK_SAPLING_CLASSIC_0_0_13a =
            registerBlockWithoutItem("potted_oak_sapling_classic_0_0_13a",
                    new FlowerPotBlock(
                            OAK_SAPLING_CLASSIC_0_0_13a,
                            AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING)
                    )
            );

    /*
    CLASSIC 0.0.14a
     */


    public static final Block COAL_ORE_CLASSIC_0_0_14a =
            registerBlock("coal_ore_classic_0_0_14a",
                    new ExperienceDroppingBlock(
                            ConstantIntProvider.create(0),
                            AbstractBlock.Settings.copy(Blocks.COAL_ORE)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block IRON_ORE_CLASSIC_0_0_14a =
            registerBlock("iron_ore_classic_0_0_14a",
                    new ExperienceDroppingBlock(
                            ConstantIntProvider.create(0),
                            AbstractBlock.Settings.copy(Blocks.IRON_ORE)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block GOLD_ORE_CLASSIC_0_0_14a =
            registerBlock("gold_ore_classic_0_0_14a",
                    new ExperienceDroppingBlock(
                            ConstantIntProvider.create(0),
                            AbstractBlock.Settings.copy(Blocks.GOLD_ORE)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block SAND_CLASSIC_0_0_14a =
            registerBlock("sand_classic_0_0_14a",
                    new ColoredFallingBlock(
                            new ColorCode(14406560),
                            AbstractBlock.Settings.copy(Blocks.SAND)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block GRAVEL_CLASSIC_0_0_14a =
            registerBlock("gravel_classic_0_0_14a",
                    new ColoredFallingBlock(
                            new ColorCode(-8356741),
                            AbstractBlock.Settings.copy(Blocks.GRAVEL)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_LOG_CLASSIC_0_0_14a =
            registerBlock("oak_log_classic_0_0_14a",
                    new PillarBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_LEAVES_CLASSIC_0_0_14a =
            registerBlock("oak_leaves_classic_0_0_14a",
                    new LeavesBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block COBBLESTONE_CLASSIC_0_0_14a =
            registerBlock("cobblestone_classic_0_0_14a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block COBBLESTONE_STAIRS_CLASSIC_0_0_14a =
            registerBlock("cobblestone_stairs_classic_0_0_14a",
                    new StairsBlock(
                            COBBLESTONE_CLASSIC_0_0_14a.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_STAIRS)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block COBBLESTONE_SLAB_CLASSIC_0_0_14a =
            registerBlock("cobblestone_slab_classic_0_0_14a",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_SLAB)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block COBBLESTONE_WALL_CLASSIC_0_0_14a =
            registerBlock("cobblestone_wall_classic_0_0_14a",
                    new WallBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_PLANKS_CLASSIC_0_0_14a =
            registerBlock("oak_planks_classic_0_0_14a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_STAIRS_CLASSIC_0_0_14a =
            registerBlock("oak_stairs_classic_0_0_14a",
                    new StairsBlock(
                            OAK_PLANKS_CLASSIC_0_0_14a.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_SLAB_CLASSIC_0_0_14a =
            registerBlock("oak_slab_classic_0_0_14a",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_SLAB)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_FENCE_CLASSIC_0_0_14a =
            registerBlock("oak_fence_classic_0_0_14a",
                    new FenceBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_FENCE_GATE_CLASSIC_0_0_14a =
            registerBlock("oak_fence_gate_classic_0_0_14a",
                    new FenceGateBlock(
                            WoodType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_BUTTON_CLASSIC_0_0_14a =
            registerBlock("oak_button_classic_0_0_14a",
                    new ButtonBlock(
                            BlockSetType.OAK, 30,
                            AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_PRESSURE_PLATE_CLASSIC_0_0_14a =
            registerBlock("oak_pressure_plate_classic_0_0_14a",
                    new PressurePlateBlock(
                            BlockSetType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)
                    ),
                    ModTooltips.CLASSIC_0_0_14a_TOOLTIP
            );

    /*
    CLASSIC 0.0.15a
     */

    public static final Block SAND_CLASSIC_0_0_15a =
            registerBlock("sand_classic_0_0_15a",
                    new ColoredFallingBlock(
                            new ColorCode(14406560),
                            AbstractBlock.Settings.copy(Blocks.SAND)
                    ),
                    ModTooltips.CLASSIC_0_0_15a_TOOLTIP
            );

    public static final Block GRAVEL_CLASSIC_0_0_15a =
            registerBlock("gravel_classic_0_0_15a",
                    new ColoredFallingBlock(
                            new ColorCode(-8356741),
                            AbstractBlock.Settings.copy(Blocks.GRAVEL)
                    ),
                    ModTooltips.CLASSIC_0_0_15a_TOOLTIP
            );

    public static final Block OAK_LOG_CLASSIC_0_0_15a =
            registerBlock("oak_log_classic_0_0_15a",
                    new PillarBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    ),
                    ModTooltips.CLASSIC_0_0_15a_TOOLTIP
            );

    public static final Block OAK_LEAVES_CLASSIC_0_0_15a =
            registerBlock("oak_leaves_classic_0_0_15a",
                    new LeavesBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    ),
                    ModTooltips.CLASSIC_0_0_15a_TOOLTIP
            );

    /*
    CLASSIC 0.0.19a
     */

    public static final CustomSpongeBlock SPONGE_CLASSIC_0_0_19a =
            (CustomSpongeBlock) registerBlock("sponge_classic_0_0_19a",
                    new CustomSpongeBlock(
                            AbstractBlock.Settings.copy(Blocks.SPONGE)
                    ),
                    ModTooltips.CLASSIC_0_0_19a_TOOLTIP
            );

    public static final CustomWetSpongeBlock WET_SPONGE_CLASSIC_0_0_19a =
            (CustomWetSpongeBlock) registerBlock("wet_sponge_classic_0_0_19a",
                    new CustomWetSpongeBlock(
                            AbstractBlock.Settings.copy(Blocks.WET_SPONGE)
                    ),
                    ModTooltips.CLASSIC_0_0_19a_TOOLTIP
            );

    public static final Block GLASS_CLASSIC_0_0_19a =
            registerBlock("glass_classic_0_0_19a",
                    new TransparentBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS)
                    ),
                    ModTooltips.CLASSIC_0_0_19a_TOOLTIP
            );

    public static final Block GLASS_PANE_CLASSIC_0_0_19a =
            registerBlock("glass_pane_classic_0_0_19a",
                    new PaneBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS_PANE)
                    ),
                    ModTooltips.CLASSIC_0_0_19a_TOOLTIP
            );

    public static final Block GLASS_CLASSIC_0_0_19a_01 =
            registerBlock("glass_classic_0_0_19a_01",
                    new TransparentBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS)
                    ),
                    ModTooltips.CLASSIC_0_0_19a_01_TOOLTIP
            );

    public static final Block GLASS_PANE_CLASSIC_0_0_19a_01 =
            registerBlock("glass_pane_classic_0_0_19a_01",
                    new PaneBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS_PANE)
                    ),
                    ModTooltips.CLASSIC_0_0_19a_01_TOOLTIP
            );

    public static final Block GLASS_CLASSIC_0_0_19a_02 =
            registerBlock("glass_classic_0_0_19a_02",
                    new TransparentBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS)
                    ),
                    ModTooltips.CLASSIC_0_0_19a_02_TOOLTIP
            );

    public static final Block GLASS_PANE_CLASSIC_0_0_19a_02 =
            registerBlock("glass_pane_classic_0_0_19a_02",
                    new PaneBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS_PANE)
                    ),
                    ModTooltips.CLASSIC_0_0_19a_02_TOOLTIP
            );

    public static final Block POPPY_CLASSIC_0_0_20a =
            registerBlock("poppy_classic_0_0_20a",
                    new FlowerBlock(
                            StatusEffects.NIGHT_VISION,
                            5.0F,
                            AbstractBlock.Settings.copy(Blocks.POPPY)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP,
                    ModTooltips.PROGRAMMER_ART_TOOLTIP
            );

    public static final Block POTTED_POPPY_CLASSIC_0_0_20a =
            registerBlockWithoutItem("potted_poppy_classic_0_0_20a",
                    new FlowerPotBlock(
                            POPPY_CLASSIC_0_0_20a,
                            AbstractBlock.Settings.copy(Blocks.POTTED_POPPY)
                    )
            );

    public static final Block DANDELION_CLASSIC_0_0_20a =
            registerBlock("dandelion_classic_0_0_20a",
                    new FlowerBlock(
                            StatusEffects.SATURATION,
                            5.0F,
                            AbstractBlock.Settings.copy(Blocks.DANDELION)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block POTTED_DANDELION_CLASSIC_0_0_20a =
            registerBlockWithoutItem("potted_dandelion_classic_0_0_20a",
                    new FlowerPotBlock(
                            DANDELION_CLASSIC_0_0_20a,
                            AbstractBlock.Settings.copy(Blocks.POTTED_DANDELION)
                    )
            );

    public static final Block RED_MUSHROOM_CLASSIC_0_0_20a =
            registerBlock(
                    "red_mushroom_classic_0_0_20a",
                    new MushroomPlantBlock(
                            TreeConfiguredFeatures.HUGE_RED_MUSHROOM,
                            AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block POTTED_RED_MUSHROOM_CLASSIC_0_0_20a =
            registerBlockWithoutItem("potted_red_mushroom_classic_0_0_20a",
                    new FlowerPotBlock(
                            RED_MUSHROOM_CLASSIC_0_0_20a,
                            AbstractBlock.Settings.copy(Blocks.POTTED_RED_MUSHROOM)
                    )
            );

    public static final Block BROWN_MUSHROOM_CLASSIC_0_0_20a =
            registerBlock(
                    "brown_mushroom_classic_0_0_20a",
                    new MushroomPlantBlock(
                            TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM,
                            AbstractBlock.Settings.copy(Blocks.BROWN_MUSHROOM)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block POTTED_BROWN_MUSHROOM_CLASSIC_0_0_20a =
            registerBlockWithoutItem("potted_brown_mushroom_classic_0_0_20a",
                    new FlowerPotBlock(
                            BROWN_MUSHROOM_CLASSIC_0_0_20a,
                            AbstractBlock.Settings.copy(Blocks.POTTED_BROWN_MUSHROOM)
                    )
            );

    public static final Block GOLD_BLOCK_CLASSIC_0_0_20a =
            registerBlock("gold_block_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block CAPRI_WOOL_CLASSIC_0_0_20a =
            registerBlock("capri_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block CHARTREUSE_WOOL_CLASSIC_0_0_20a =
            registerBlock("chartreuse_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block CYAN_WOOL_CLASSIC_0_0_20a =
            registerBlock("cyan_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block DARK_GRAY_WOOL_CLASSIC_0_0_20a =
            registerBlock("dark_gray_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block GREEN_WOOL_CLASSIC_0_0_20a =
            registerBlock("green_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block LIGHT_GRAY_WOOL_CLASSIC_0_0_20a =
            registerBlock("light_gray_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block MAGENTA_WOOL_CLASSIC_0_0_20a =
            registerBlock("magenta_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block ORANGE_WOOL_CLASSIC_0_0_20a =
            registerBlock("orange_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block PURPLE_WOOL_CLASSIC_0_0_20a =
            registerBlock("purple_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block RED_WOOL_CLASSIC_0_0_20a =
            registerBlock("red_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block ROSE_WOOL_CLASSIC_0_0_20a =
            registerBlock("rose_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block SPRING_GREEN_WOOL_CLASSIC_0_0_20a =
            registerBlock("spring_green_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block ULTRAMARINE_WOOL_CLASSIC_0_0_20a =
            registerBlock("ultramarine_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block VIOLET_WOOL_CLASSIC_0_0_20a =
            registerBlock("violet_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block WHITE_WOOL_CLASSIC_0_0_20a =
            registerBlock("white_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block YELLOW_WOOL_CLASSIC_0_0_20a =
            registerBlock("yellow_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    ModTooltips.CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block BOOKSHELF_CLASSIC_0_26 =
            registerBlock("bookshelf_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.BOOKSHELF)
                    ),
                    ModTooltips.CLASSIC_0_26_TOOLTIP
            );

    public static final Block BRICKS_CLASSIC_0_26 =
            registerBlock("bricks_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.BRICKS)
                    ),
                    ModTooltips.CLASSIC_0_26_TOOLTIP
            );

    public static final Block GOLD_BLOCK_CLASSIC_0_26 =
            registerBlock("gold_block_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)
                    ),
                    ModTooltips.CLASSIC_0_26_TOOLTIP
            );

    public static final Block IRON_BLOCK_CLASSIC_0_26 =
            registerBlock("iron_block_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                    ),
                    ModTooltips.CLASSIC_0_26_TOOLTIP
            );

    public static final Block GOLD_ORE_CLASSIC_0_26 =
            registerBlock("gold_ore_classic_0_26",
                    new ExperienceDroppingBlock(
                            ConstantIntProvider.create(0),
                            AbstractBlock.Settings.copy(Blocks.GOLD_ORE)
                    ),
                    ModTooltips.CLASSIC_0_26_TOOLTIP
            );

    public static final Block MOSSY_COBBLESTONE_CLASSIC_0_26 =
            registerBlock("mossy_cobblestone_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE)
                    ),
                    ModTooltips.CLASSIC_0_26_TOOLTIP
            );

    public static final Block TNT_CLASSIC_0_26 =
            registerBlock("tnt_classic_0_26",
                    new TntBlock(
                            AbstractBlock.Settings.copy(Blocks.TNT)
                    ),
                    ModTooltips.CLASSIC_0_26_TOOLTIP
            );

    public static final Block OBSIDIAN_CLASSIC_0_28 =
            registerBlock("obsidian_classic_0_28",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.OBSIDIAN)
                    ),
                    ModTooltips.CLASSIC_0_28_TOOLTIP
            );

    public static final Block TNT_CLASSIC_0_28 =
            registerBlock("tnt_classic_0_28",
                    new TntBlock(
                            AbstractBlock.Settings.copy(Blocks.TNT)
                    ),
                    ModTooltips.CLASSIC_0_28_TOOLTIP
            );

    public static final Block TORCH_INDEV_0_31_20091223_1457 =
            registerBlockWithoutItem("torch_indev_0_31_20091223_1457",
                    new CustomTorchBlock(
                            ParticleTypes.FLAME,
                            AbstractBlock.Settings.copy(Blocks.TORCH)
                    )
            );

    public static final Block WALL_TORCH_INDEV_0_31_20091223_1457 =
            registerBlockWithoutItem("wall_torch_indev_0_31_20091223_1457",
                    new CustomWallTorchBlock(
                            ParticleTypes.FLAME,
                            AbstractBlock.Settings.copy(Blocks.WALL_TORCH)
                    )
            );

    public static final Block TORCH_INDEV_0_31_20091231_1856 =
            registerBlockWithoutItem("torch_indev_0_31_20091231_1856",
                    new TorchBlock(
                            ParticleTypes.FLAME,
                            AbstractBlock.Settings.copy(Blocks.TORCH)
                    )
            );

    public static final Block WALL_TORCH_INDEV_0_31_20091231_1856 =
            registerBlockWithoutItem("wall_torch_indev_0_31_20091231_1856",
                    new WallTorchBlock(
                            ParticleTypes.FLAME,
                            AbstractBlock.Settings.copy(Blocks.WALL_TORCH)
                    )
            );


    public static final Block CRAFTING_TABLE_INDEV_0_31_20100129_2332 =
            registerBlock("crafting_table_indev_0_31_20100129_2332",
                    new CraftingTableBlock(
                            AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)
                    ),
                    ModTooltips.INDEV_0_31_TOOLTIP,
                    ModTooltips.SNAPSHOT_20100129_2332_TOOLTIP
            );

    // ===== Registration helpers =====

    private static Block registerBlock(
            String name,
            Block block,
            String... tooltipKeys
    ) {
        Identifier id = Identifier.of(TextureMod.MOD_ID, name);

        Block registeredBlock = Registry.register(
                Registries.BLOCK,
                id,
                block
        );

        Registry.register(
                Registries.ITEM,
                id,
                new TooltipItemProvider.TooltipBlockItem(registeredBlock, new Item.Settings(), tooltipKeys)
        );

        return registeredBlock;
    }


    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(
                Registries.BLOCK,
                Identifier.of(TextureMod.MOD_ID, name),
                block
        );
    }



    public static Item asItem(Block block) {
        return Registries.ITEM.get(Registries.BLOCK.getId(block));
    }


    // ===== Item group registration =====

    public static void registerModBlocks() {
        TextureMod.LOGGER.info("Registering Mod Blocks for " + TextureMod.MOD_ID);

        SPONGE_CLASSIC_0_0_19a.setWetSponge(WET_SPONGE_CLASSIC_0_0_19a);
        WET_SPONGE_CLASSIC_0_0_19a.setSponge(SPONGE_CLASSIC_0_0_19a);

//      VANILLA CREATIVE TAB GROUPS TBD
//
//      ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//            entries.add(GRASS_BLOCK_PRE_CLASSIC_RD_131655);
//            entries.add(STONE_PRE_CLASSIC_RD_131655);
//
//            entries.add(COBBLESTONE_PRE_CLASSIC_RD_20090515);
//            entries.add(DIRT_PRE_CLASSIC_RD_20090515);
//            entries.add(GRASS_BLOCK_PRE_CLASSIC_RD_20090515);
//            entries.add(OAK_PLANKS_PRE_CLASSIC_RD_20090515);
//            entries.add(STONE_PRE_CLASSIC_RD_20090515);
//
//            entries.add(OAK_PLANKS_PRE_CLASSIC_RD_161348);
//            entries.add(OAK_SAPLING_PRE_CLASSIC_RD_161348);
//
//            entries.add(BEDROCK_CLASSIC_0_0_12a);
//        });
    }
}
