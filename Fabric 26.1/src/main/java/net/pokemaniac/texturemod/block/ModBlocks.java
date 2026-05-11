package net.pokemaniac.texturemod.block;
//test again
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrassBlock;
import net.pokemaniac.texturemod.TextureMod;
import net.pokemaniac.texturemod.entity.ModEntities;
import net.pokemaniac.texturemod.entity.ModTntEntity;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ModBlocks {

    // ===== Define custom tooltips =====

    private static final String PROGRAMMER_ART_TOOLTIP =
            "tooltip.texturemod.programmer_art.tooltip";


    private static final String CAVE_GAME_TOOLTIP =
            "tooltip.texturemod.cave_game.tooltip";

    private static final String ORDER_OF_THE_STONE_TOOLTIP =
            "tooltip.texturemod.order_of_the_stone.tooltip";

    private static final String PRE_CLASSIC_RD_131655_TOOLTIP =
            "tooltip.texturemod.pre_classic_rd_131655.tooltip";

    private static final String PRE_CLASSIC_RD_20090515_TOOLTIP =
            "tooltip.texturemod.pre_classic_rd_20090515.tooltip";

    private static final String PRE_CLASSIC_RD_161348_TOOLTIP =
            "tooltip.texturemod.pre_classic_rd_161348.tooltip";

    private static final String CLASSIC_0_0_12a_TOOLTIP =
            "tooltip.texturemod.classic_0_0_12a.tooltip";

    private static final String CLASSIC_0_0_13a_TOOLTIP =
            "tooltip.texturemod.classic_0_0_13a.tooltip";

    private static final String CLASSIC_0_0_14a_TOOLTIP =
            "tooltip.texturemod.classic_0_0_14a.tooltip";

    private static final String CLASSIC_0_0_15a_TOOLTIP =
            "tooltip.texturemod.classic_0_0_15a.tooltip";

    private static final String CLASSIC_0_0_19a_TOOLTIP =
            "tooltip.texturemod.classic_0_0_19a.tooltip";

    private static final String CLASSIC_0_0_19a_01_TOOLTIP =
            "tooltip.texturemod.classic_0_0_19a_01.tooltip";

    private static final String CLASSIC_0_0_19a_02_TOOLTIP =
            "tooltip.texturemod.classic_0_0_19a_02.tooltip";

    private static final String CLASSIC_0_0_20a_TOOLTIP =
            "tooltip.texturemod.classic_0_0_20a.tooltip";

    private static final String CLASSIC_0_26_TOOLTIP =
            "tooltip.texturemod.classic_0_26.tooltip";

    private static final String CLASSIC_0_28_TOOLTIP =
            "tooltip.texturemod.classic_0_28.tooltip";

    private static final String INDEV_0_31_TOOLTIP =
            "tooltip.texturemod.indev_0_31.tooltip";

    private static final String SNAPSHOT_20100129_2332_TOOLTIP =
            "tooltip.texturemod.snapshot_20100129_2332.tooltip";

    private static final String SNAPSHOT_20091223_1457_TOOLTIP =
            "tooltip.texturemod.snapshot_20091223_1457.tooltip";


    // ===== Add custom tooltips =====
    private static class TooltipBlockItem extends BlockItem {

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

    public static class CustomSpongeBlock extends Block {
        public static final MapCodec<SpongeBlock> CODEC = createCodec(SpongeBlock::new);
        private static final Direction[] DIRECTIONS = Direction.values();
        private Block WET_SPONGE;

        public MapCodec<SpongeBlock> getCodec() {
            return CODEC;
        }

        public CustomSpongeBlock(AbstractBlock.Settings settings) {
            super(settings);
        }

        public void setWetSponge(Block WET_SPONGE){
            this.WET_SPONGE = WET_SPONGE;
        }

        protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
            if (!oldState.isOf(state.getBlock())) {
                this.update(world, pos);
            }
        }

        protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
            this.update(world, pos);
            super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
        }

        protected void update(World world, BlockPos pos) {
            if (this.absorbWater(world, pos)) {
                world.setBlockState(pos, WET_SPONGE.getDefaultState(), 2);
                world.playSound(null, pos, SoundEvents.BLOCK_SPONGE_ABSORB, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }

        }

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
        public static final MapCodec<WetSpongeBlock> CODEC = createCodec(WetSpongeBlock::new);
        public Block SPONGE;

        public MapCodec<WetSpongeBlock> getCodec() {
            return CODEC;
        }

        public CustomWetSpongeBlock(AbstractBlock.Settings settings) {
            super(settings);
        }

        public void setSponge(Block SPONGE){
            this.SPONGE = SPONGE;
        }

        protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
            if (world.getDimension().ultrawarm()) {
                world.setBlockState(pos, SPONGE.getDefaultState(), 3);
                world.syncWorldEvent(2009, pos, 0);
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WET_SPONGE_DRIES, SoundCategory.BLOCKS, 1.0F, (1.0F + world.getRandom().nextFloat() * 0.2F) * 0.7F);
            }

        }

        public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
            Direction direction = Direction.random(random);
            if (direction != Direction.UP) {
                BlockPos blockPos = pos.offset(direction);
                BlockState blockState = world.getBlockState(blockPos);
                if (!state.isOpaque() || !blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
                    double d = (double)pos.getX();
                    double e = (double)pos.getY();
                    double f = (double)pos.getZ();
                    if (direction == Direction.DOWN) {
                        e -= 0.05;
                        d += random.nextDouble();
                        f += random.nextDouble();
                    } else {
                        e += random.nextDouble() * 0.8;
                        if (direction.getAxis() == Direction.Axis.X) {
                            f += random.nextDouble();
                            if (direction == Direction.EAST) {
                                ++d;
                            } else {
                                d += 0.05;
                            }
                        } else {
                            d += random.nextDouble();
                            if (direction == Direction.SOUTH) {
                                ++f;
                            } else {
                                f += 0.05;
                            }
                        }
                    }

                    world.addParticle(ParticleTypes.DRIPPING_WATER, d, e, f, (double)0.0F, (double)0.0F, (double)0.0F);
                }
            }
        }
    }

    public static class CustomTntBlock extends Block {
        public static final MapCodec<net.minecraft.block.TntBlock> CODEC = createCodec(net.minecraft.block.TntBlock::new);
        public static final BooleanProperty UNSTABLE;

        public MapCodec<net.minecraft.block.TntBlock> getCodec() {
            return CODEC;
        }

        public CustomTntBlock(AbstractBlock.Settings settings) {
            super(settings);
            this.setDefaultState((BlockState)this.getDefaultState().with(UNSTABLE, false));
        }

        protected void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
            if (!oldState.isOf(state.getBlock())) {
                if (world.isReceivingRedstonePower(pos)) {
                    primeTnt(world, pos);
                    world.removeBlock(pos, false);
                }

            }
        }

        protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
            if (world.isReceivingRedstonePower(pos)) {
                primeTnt(world, pos);
                world.removeBlock(pos, false);
            }

        }

        public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
            if (!world.isClient() && !player.isCreative() && (Boolean)state.get(UNSTABLE)) {
                primeTnt(world, pos);
            }

            return super.onBreak(world, pos, state, player);
        }

        public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
            if (!world.isClient) {
                ModTntEntity tntEntity = new ModTntEntity(ModEntities.MOD_TNT_ENTITY, world);

                tntEntity.setTntBlock(this);

                int i = tntEntity.getFuse();
                tntEntity.setFuse((short)(world.random.nextInt(i / 4) + i / 8));
                world.spawnEntity(tntEntity);
            }
        }

        public static void primeTnt(World world, BlockPos pos) {
            primeTnt(world, pos, (LivingEntity)null);
        }

        private static void primeTnt(World world, BlockPos pos, @Nullable LivingEntity igniter) {
            if (!world.isClient) {
                ModTntEntity tntEntity = new ModTntEntity(ModEntities.MOD_TNT_ENTITY, world);

                tntEntity.refreshPositionAndAngles(
                        pos.getX() + 0.5,
                        pos.getY(),
                        pos.getZ() + 0.5,
                        0.0f,
                        0.0f
                );
                tntEntity.setBlockFromWorld(pos);


                world.spawnEntity(tntEntity);
                world.playSound((PlayerEntity)null, tntEntity.getX(), tntEntity.getY(), tntEntity.getZ(), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.emitGameEvent(igniter, GameEvent.PRIME_FUSE, pos);
            }
        }

        protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (!stack.isOf(Items.FLINT_AND_STEEL) && !stack.isOf(Items.FIRE_CHARGE)) {
                return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
            } else {
                primeTnt(world, pos, player);
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
                Item item = stack.getItem();
                if (stack.isOf(Items.FLINT_AND_STEEL)) {
                    stack.damage(1, player, LivingEntity.getSlotForHand(hand));
                } else {
                    stack.decrementUnlessCreative(1, player);
                }

                player.incrementStat(Stats.USED.getOrCreateStat(item));
                return ItemActionResult.success(world.isClient);
            }
        }

        protected void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
            if (!world.isClient) {
                BlockPos blockPos = hit.getBlockPos();
                Entity entity = projectile.getOwner();
                if (projectile.isOnFire() && projectile.canModifyAt(world, blockPos)) {
                    primeTnt(world, blockPos, entity instanceof LivingEntity ? (LivingEntity)entity : null);
                    world.removeBlock(blockPos, false);
                }
            }

        }

        public boolean shouldDropItemsOnExplosion(Explosion explosion) {
            return false;
        }

        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
            builder.add(new Property[]{UNSTABLE});
        }

        static {
            UNSTABLE = Properties.UNSTABLE;
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
                    CAVE_GAME_TOOLTIP,
                    PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_pre_classic_rd_131655",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE)
                    ),
                    CAVE_GAME_TOOLTIP,
                    PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_stairs_pre_classic_rd_131655",
                    new StairsBlock(
                            COBBLESTONE_PRE_CLASSIC_RD_131655.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_STAIRS)
                    ),
                    CAVE_GAME_TOOLTIP,
                    PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_slab_pre_classic_rd_131655",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_SLAB)
                    ),
                    CAVE_GAME_TOOLTIP,
                    PRE_CLASSIC_RD_131655_TOOLTIP
            );

    public static final Block COBBLESTONE_WALL_PRE_CLASSIC_RD_131655 =
            registerBlock("cobblestone_wall_pre_classic_rd_131655",
                    new WallBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL)
                    ),
                    CAVE_GAME_TOOLTIP,
                    PRE_CLASSIC_RD_131655_TOOLTIP
            );



    /*
    PRE-CLASSIC RD-20090515
     */



    public static final Block GRASS_BLOCK_PRE_CLASSIC_RD_20090515 =
            registerBlock("grass_block_pre_classic_rd_20090515",
                    new GrassBlock(
                            AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block DIRT_PRE_CLASSIC_RD_20090515 =
            registerBlock("dirt_pre_classic_rd_20090515",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.DIRT)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block COBBLESTONE_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_pre_classic_rd_20090515",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_stairs_pre_classic_rd_20090515",
                    new StairsBlock(
                            COBBLESTONE_PRE_CLASSIC_RD_131655.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_STAIRS)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );


    public static final Block COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_slab_pre_classic_rd_20090515",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_SLAB)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515 =
            registerBlock("cobblestone_wall_pre_classic_rd_20090515",
                    new WallBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_PLANKS_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_planks_pre_classic_rd_20090515",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_stairs_pre_classic_rd_20090515",
                    new StairsBlock(
                            OAK_PLANKS_PRE_CLASSIC_RD_20090515.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_slab_pre_classic_rd_20090515",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_SLAB)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_FENCE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_fence_pre_classic_rd_20090515",
                    new FenceBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_fence_gate_pre_classic_rd_20090515",
                    new FenceGateBlock(
                            WoodType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_BUTTON_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_button_pre_classic_rd_20090515",
                    new ButtonBlock(
                            BlockSetType.OAK, 30,
                            AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("oak_pressure_plate_pre_classic_rd_20090515",
                    new PressurePlateBlock(
                            BlockSetType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_pre_classic_rd_20090515",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.STONE)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_STAIRS_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_stairs_pre_classic_rd_20090515",
                    new StairsBlock(
                            STONE_PRE_CLASSIC_RD_20090515.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.STONE_STAIRS)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_SLAB_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_slab_pre_classic_rd_20090515",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.STONE_SLAB)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_BUTTON_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_button_pre_classic_rd_20090515",
                    new ButtonBlock(
                            BlockSetType.STONE, 20,
                            AbstractBlock.Settings.copy(Blocks.STONE_BUTTON)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );

    public static final Block STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515 =
            registerBlock("stone_pressure_plate_pre_classic_rd_20090515",
                    new PressurePlateBlock(
                            BlockSetType.STONE,
                            AbstractBlock.Settings.copy(Blocks.STONE_PRESSURE_PLATE)
                    ),
                    ORDER_OF_THE_STONE_TOOLTIP,
                    PRE_CLASSIC_RD_20090515_TOOLTIP
            );



    /*
    PRE-CLASSIC RD-161348
     */



    public static final Block OAK_PLANKS_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_planks_pre_classic_rd_161348",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    ),
                    PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_STAIRS_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_stairs_pre_classic_rd_161348",
                    new StairsBlock(
                            OAK_PLANKS_PRE_CLASSIC_RD_161348.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    ),
                    PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_SLAB_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_slab_pre_classic_rd_161348",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_SLAB)
                    ),
                    PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_FENCE_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_fence_pre_classic_rd_161348",
                    new FenceBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE)
                    ),
                    PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_FENCE_GATE_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_fence_gate_pre_classic_rd_161348",
                    new FenceGateBlock(
                            WoodType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)
                    ),
                    PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_BUTTON_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_button_pre_classic_rd_161348",
                    new ButtonBlock(
                            BlockSetType.OAK, 30,
                            AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)
                    ),
                    PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_161348 =
            registerBlock("oak_pressure_plate_pre_classic_rd_161348",
                    new PressurePlateBlock(
                            BlockSetType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)
                    ),
                    PRE_CLASSIC_RD_161348_TOOLTIP
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
                    PRE_CLASSIC_RD_161348_TOOLTIP
            );

    public static final Block POTTED_OAK_SAPLING_PRE_CLASSIC_RD_161348 =
            registerBlock("potted_oak_sapling_pre_classic_rd_161348",
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
                    CLASSIC_0_0_12a_TOOLTIP
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
                    CLASSIC_0_0_13a_TOOLTIP
            );

    public static final Block POTTED_OAK_SAPLING_CLASSIC_0_0_13a =
            registerBlock("potted_oak_sapling_classic_0_0_13a",
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
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block IRON_ORE_CLASSIC_0_0_14a =
            registerBlock("iron_ore_classic_0_0_14a",
                    new ExperienceDroppingBlock(
                            ConstantIntProvider.create(0),
                            AbstractBlock.Settings.copy(Blocks.IRON_ORE)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block GOLD_ORE_CLASSIC_0_0_14a =
            registerBlock("gold_ore_classic_0_0_14a",
                    new ExperienceDroppingBlock(
                            ConstantIntProvider.create(0),
                            AbstractBlock.Settings.copy(Blocks.GOLD_ORE)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block SAND_CLASSIC_0_0_14a =
            registerBlock("sand_classic_0_0_14a",
                    new ColoredFallingBlock(
                            new ColorCode(14406560),
                            AbstractBlock.Settings.copy(Blocks.SAND)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block GRAVEL_CLASSIC_0_0_14a =
            registerBlock("gravel_classic_0_0_14a",
                    new ColoredFallingBlock(
                            new ColorCode(-8356741),
                            AbstractBlock.Settings.copy(Blocks.GRAVEL)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_LOG_CLASSIC_0_0_14a =
            registerBlock("oak_log_classic_0_0_14a",
                    new PillarBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_LEAVES_CLASSIC_0_0_14a =
            registerBlock("oak_leaves_classic_0_0_14a",
                    new LeavesBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block COBBLESTONE_CLASSIC_0_0_14a =
            registerBlock("cobblestone_classic_0_0_14a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block COBBLESTONE_STAIRS_CLASSIC_0_0_14a =
            registerBlock("cobblestone_stairs_classic_0_0_14a",
                    new StairsBlock(
                            COBBLESTONE_CLASSIC_0_0_14a.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_STAIRS)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block COBBLESTONE_SLAB_CLASSIC_0_0_14a =
            registerBlock("cobblestone_slab_classic_0_0_14a",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_SLAB)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block COBBLESTONE_WALL_CLASSIC_0_0_14a =
            registerBlock("cobblestone_wall_classic_0_0_14a",
                    new WallBlock(
                            AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_PLANKS_CLASSIC_0_0_14a =
            registerBlock("oak_planks_classic_0_0_14a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_STAIRS_CLASSIC_0_0_14a =
            registerBlock("oak_stairs_classic_0_0_14a",
                    new StairsBlock(
                            OAK_PLANKS_CLASSIC_0_0_14a.getDefaultState(),
                            AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_SLAB_CLASSIC_0_0_14a =
            registerBlock("oak_slab_classic_0_0_14a",
                    new SlabBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_SLAB)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_FENCE_CLASSIC_0_0_14a =
            registerBlock("oak_fence_classic_0_0_14a",
                    new FenceBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_FENCE_GATE_CLASSIC_0_0_14a =
            registerBlock("oak_fence_gate_classic_0_0_14a",
                    new FenceGateBlock(
                            WoodType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_BUTTON_CLASSIC_0_0_14a =
            registerBlock("oak_button_classic_0_0_14a",
                    new ButtonBlock(
                            BlockSetType.OAK, 30,
                            AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
            );

    public static final Block OAK_PRESSURE_PLATE_CLASSIC_0_0_14a =
            registerBlock("oak_pressure_plate_classic_0_0_14a",
                    new PressurePlateBlock(
                            BlockSetType.OAK,
                            AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)
                    ),
                    CLASSIC_0_0_14a_TOOLTIP
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
                    CLASSIC_0_0_15a_TOOLTIP
            );

    public static final Block GRAVEL_CLASSIC_0_0_15a =
            registerBlock("gravel_classic_0_0_15a",
                    new ColoredFallingBlock(
                            new ColorCode(-8356741),
                            AbstractBlock.Settings.copy(Blocks.GRAVEL)
                    ),
                    CLASSIC_0_0_15a_TOOLTIP
            );

    public static final Block OAK_LOG_CLASSIC_0_0_15a =
            registerBlock("oak_log_classic_0_0_15a",
                    new PillarBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    ),
                    CLASSIC_0_0_15a_TOOLTIP
            );

    public static final Block OAK_LEAVES_CLASSIC_0_0_15a =
            registerBlock("oak_leaves_classic_0_0_15a",
                    new LeavesBlock(
                            AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    ),
                    CLASSIC_0_0_15a_TOOLTIP
            );

    /*
    CLASSIC 0.0.19a
     */

    public static final CustomSpongeBlock SPONGE_CLASSIC_0_0_19a =
            (CustomSpongeBlock) registerBlock("sponge_classic_0_0_19a",
                    new CustomSpongeBlock(
                            AbstractBlock.Settings.copy(Blocks.SPONGE)
                    ),
                    CLASSIC_0_0_19a_TOOLTIP
            );

    public static final CustomWetSpongeBlock WET_SPONGE_CLASSIC_0_0_19a =
            (CustomWetSpongeBlock) registerBlock("wet_sponge_classic_0_0_19a",
                    new CustomWetSpongeBlock(
                            AbstractBlock.Settings.copy(Blocks.WET_SPONGE)
                    ),
                    CLASSIC_0_0_19a_TOOLTIP
            );

    public static final Block GLASS_CLASSIC_0_0_19a =
            registerBlock("glass_classic_0_0_19a",
                    new TransparentBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS)
                    ),
                    CLASSIC_0_0_19a_TOOLTIP
            );

    public static final Block GLASS_PANE_CLASSIC_0_0_19a =
            registerBlock("glass_pane_classic_0_0_19a",
                    new PaneBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS_PANE)
                    ),
                    CLASSIC_0_0_19a_TOOLTIP
            );

    public static final Block GLASS_CLASSIC_0_0_19a_01 =
            registerBlock("glass_classic_0_0_19a_01",
                    new TransparentBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS)
                    ),
                    CLASSIC_0_0_19a_01_TOOLTIP
            );

    public static final Block GLASS_PANE_CLASSIC_0_0_19a_01 =
            registerBlock("glass_pane_classic_0_0_19a_01",
                    new PaneBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS_PANE)
                    ),
                    CLASSIC_0_0_19a_01_TOOLTIP
            );

    public static final Block GLASS_CLASSIC_0_0_19a_02 =
            registerBlock("glass_classic_0_0_19a_02",
                    new TransparentBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS)
                    ),
                    CLASSIC_0_0_19a_02_TOOLTIP
            );

    public static final Block GLASS_PANE_CLASSIC_0_0_19a_02 =
            registerBlock("glass_pane_classic_0_0_19a_02",
                    new PaneBlock(
                            AbstractBlock.Settings.copy(Blocks.GLASS_PANE)
                    ),
                    CLASSIC_0_0_19a_02_TOOLTIP
            );

    public static final Block POPPY_CLASSIC_0_0_20a =
            registerBlock("poppy_classic_0_0_20a",
                    new FlowerBlock(
                            StatusEffects.NIGHT_VISION,
                            5.0F,
                            AbstractBlock.Settings.copy(Blocks.POPPY)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP,
                    PROGRAMMER_ART_TOOLTIP
            );

    public static final Block POTTED_POPPY_CLASSIC_0_0_20a =
            registerBlock("potted_poppy_classic_0_0_20a",
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
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block POTTED_DANDELION_CLASSIC_0_0_20a =
            registerBlock("potted_dandelion_classic_0_0_20a",
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
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block POTTED_RED_MUSHROOM_CLASSIC_0_0_20a =
            registerBlock("potted_red_mushroom_classic_0_0_20a",
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
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block POTTED_BROWN_MUSHROOM_CLASSIC_0_0_20a =
            registerBlock("potted_brown_mushroom_classic_0_0_20a",
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
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block CAPRI_WOOL_CLASSIC_0_0_20a =
            registerBlock("capri_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block CHARTREUSE_WOOL_CLASSIC_0_0_20a =
            registerBlock("chartreuse_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block CYAN_WOOL_CLASSIC_0_0_20a =
            registerBlock("cyan_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block DARK_GRAY_WOOL_CLASSIC_0_0_20a =
            registerBlock("dark_gray_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block GREEN_WOOL_CLASSIC_0_0_20a =
            registerBlock("green_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block LIGHT_GRAY_WOOL_CLASSIC_0_0_20a =
            registerBlock("light_gray_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block MAGENTA_WOOL_CLASSIC_0_0_20a =
            registerBlock("magenta_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block ORANGE_WOOL_CLASSIC_0_0_20a =
            registerBlock("orange_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block PURPLE_WOOL_CLASSIC_0_0_20a =
            registerBlock("purple_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block RED_WOOL_CLASSIC_0_0_20a =
            registerBlock("red_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block ROSE_WOOL_CLASSIC_0_0_20a =
            registerBlock("rose_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block SPRING_GREEN_WOOL_CLASSIC_0_0_20a =
            registerBlock("spring_green_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block ULTRAMARINE_WOOL_CLASSIC_0_0_20a =
            registerBlock("ultramarine_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block VIOLET_WOOL_CLASSIC_0_0_20a =
            registerBlock("violet_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block WHITE_WOOL_CLASSIC_0_0_20a =
            registerBlock("white_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block YELLOW_WOOL_CLASSIC_0_0_20a =
            registerBlock("yellow_wool_classic_0_0_20a",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                    ),
                    CLASSIC_0_0_20a_TOOLTIP
            );

    public static final Block BOOKSHELF_CLASSIC_0_26 =
            registerBlock("bookshelf_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.BOOKSHELF)
                    ),
                    CLASSIC_0_26_TOOLTIP
            );

    public static final Block BRICKS_CLASSIC_0_26 =
            registerBlock("bricks_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.BRICKS)
                    ),
                    CLASSIC_0_26_TOOLTIP
            );

    public static final Block GOLD_BLOCK_CLASSIC_0_26 =
            registerBlock("gold_block_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)
                    ),
                    CLASSIC_0_26_TOOLTIP
            );

    public static final Block IRON_BLOCK_CLASSIC_0_26 =
            registerBlock("iron_block_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)
                    ),
                    CLASSIC_0_26_TOOLTIP
            );

    public static final Block GOLD_ORE_CLASSIC_0_26 =
            registerBlock("gold_ore_classic_0_26",
                    new ExperienceDroppingBlock(
                            ConstantIntProvider.create(0),
                            AbstractBlock.Settings.copy(Blocks.GOLD_ORE)
                    ),
                    CLASSIC_0_26_TOOLTIP
            );

    public static final Block MOSSY_COBBLESTONE_CLASSIC_0_26 =
            registerBlock("mossy_cobblestone_classic_0_26",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE)
                    ),
                    CLASSIC_0_26_TOOLTIP
            );

    public static final Block TNT_CLASSIC_0_26 =
            registerBlock("tnt_classic_0_26",
                    new CustomTntBlock(
                            AbstractBlock.Settings.copy(Blocks.TNT)
                    ),
                    CLASSIC_0_26_TOOLTIP
            );

    public static final Block OBSIDIAN_CLASSIC_0_28 =
            registerBlock("obsidian_classic_0_28",
                    new Block(
                            AbstractBlock.Settings.copy(Blocks.OBSIDIAN)
                    ),
                    CLASSIC_0_28_TOOLTIP
            );

    public static final Block TNT_CLASSIC_0_28 =
            registerBlock("tnt_classic_0_28",
                    new CustomTntBlock(
                            AbstractBlock.Settings.copy(Blocks.TNT)
                    ),
                    CLASSIC_0_28_TOOLTIP
            );

    public static final Block TORCH_INDEV_0_31_20091223_1457 =
            registerBlock("torch_indev_0_31_20091223_1457",
                    new TorchBlock(
                            ParticleTypes.FLAME,
                            AbstractBlock.Settings.copy(Blocks.TORCH)
                    ),
                    INDEV_0_31_TOOLTIP,
                    SNAPSHOT_20091223_1457_TOOLTIP
            );

    public static final Block WALL_TORCH_INDEV_0_31_20091223_1457 =
            registerBlock("wall_torch_indev_0_31_20091223_1457",
                    new WallTorchBlock(
                            ParticleTypes.FLAME,
                            AbstractBlock.Settings.copy(Blocks.WALL_TORCH)
                    ),
                    INDEV_0_31_TOOLTIP,
                    SNAPSHOT_20091223_1457_TOOLTIP
            );

    public static final Block CRAFTING_TABLE_INDEV_0_31_20100129_2332 =
            registerBlock("crafting_table_indev_0_31_20100129_2332",
                    new CraftingTableBlock(
                            AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)
                    ),
                    INDEV_0_31_TOOLTIP,
                    SNAPSHOT_20100129_2332_TOOLTIP
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
                new TooltipBlockItem(registeredBlock, new Item.Settings(), tooltipKeys)
        );

        return registeredBlock;
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
