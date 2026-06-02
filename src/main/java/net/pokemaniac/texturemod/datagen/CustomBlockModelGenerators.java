package net.pokemaniac.texturemod.datagen;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.pokemaniac.texturemod.block.ModBlocks;
import org.jspecify.annotations.Nullable;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CustomBlockModelGenerators extends BlockModelGenerators {


    private static final Map<Block, CustomBlockModelGenerators.BlockStateGeneratorSupplier> FULL_BLOCK_MODEL_CUSTOM_GENERATORS = Map.of(
            Blocks.STONE,
            BlockModelGenerators::createMirroredCubeGenerator,
            ModBlocks.STONE_PRE_CLASSIC_RD_20090515,
            BlockModelGenerators::createMirroredCubeGenerator,
            Blocks.DEEPSLATE,
            BlockModelGenerators::createMirroredColumnGenerator,
            Blocks.MUD_BRICKS,
            BlockModelGenerators::createNorthWestMirroredCubeGenerator
    );

    private static final List<Block> NON_ORIENTABLE_TRAPDOOR = List.of(Blocks.OAK_TRAPDOOR, Blocks.DARK_OAK_TRAPDOOR, Blocks.IRON_TRAPDOOR);

    private static final Map<BlockFamily.Variant, BiConsumer<CustomBlockModelGenerators.BlockFamilyProvider, Block>> SHAPE_CONSUMERS = ImmutableMap.<BlockFamily.Variant, BiConsumer<CustomBlockModelGenerators.BlockFamilyProvider, Block>>builder()
            .put(BlockFamily.Variant.BUTTON, CustomBlockModelGenerators.BlockFamilyProvider::button)
            .put(BlockFamily.Variant.DOOR, CustomBlockModelGenerators.BlockFamilyProvider::door)
            .put(BlockFamily.Variant.CHISELED, CustomBlockModelGenerators.BlockFamilyProvider::fullBlockVariant)
            .put(BlockFamily.Variant.CRACKED, CustomBlockModelGenerators.BlockFamilyProvider::fullBlockVariant)
            .put(BlockFamily.Variant.CUSTOM_FENCE, CustomBlockModelGenerators.BlockFamilyProvider::customFence)
            .put(BlockFamily.Variant.FENCE, CustomBlockModelGenerators.BlockFamilyProvider::fence)
            .put(BlockFamily.Variant.CUSTOM_FENCE_GATE, CustomBlockModelGenerators.BlockFamilyProvider::customFenceGate)
            .put(BlockFamily.Variant.FENCE_GATE, CustomBlockModelGenerators.BlockFamilyProvider::fenceGate)
            .put(BlockFamily.Variant.SIGN, CustomBlockModelGenerators.BlockFamilyProvider::sign)
            .put(BlockFamily.Variant.SLAB, CustomBlockModelGenerators.BlockFamilyProvider::slab)
            .put(BlockFamily.Variant.STAIRS, CustomBlockModelGenerators.BlockFamilyProvider::stairs)
            .put(BlockFamily.Variant.PRESSURE_PLATE, CustomBlockModelGenerators.BlockFamilyProvider::pressurePlate)
            .put(BlockFamily.Variant.TRAPDOOR, CustomBlockModelGenerators.BlockFamilyProvider::trapdoor)
            .put(BlockFamily.Variant.WALL, CustomBlockModelGenerators.BlockFamilyProvider::wall)
            .put(BlockFamily.Variant.BRICKS, CustomBlockModelGenerators.BlockFamilyProvider::fullBlockVariant)
            .put(BlockFamily.Variant.TILES, CustomBlockModelGenerators.BlockFamilyProvider::fullBlockVariant)
            .put(BlockFamily.Variant.COBBLED, CustomBlockModelGenerators.BlockFamilyProvider::fullBlockVariant)
            .build();

    private static final Map<Block, TexturedModel> TEXTURED_MODELS = ImmutableMap.<Block, TexturedModel>builder()
            .put(Blocks.SANDSTONE, TexturedModel.TOP_BOTTOM_WITH_WALL.get(Blocks.SANDSTONE))
            .put(Blocks.RED_SANDSTONE, TexturedModel.TOP_BOTTOM_WITH_WALL.get(Blocks.RED_SANDSTONE))
            .put(Blocks.SMOOTH_SANDSTONE, TexturedModel.createAllSame(TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top")))
            .put(Blocks.SMOOTH_RED_SANDSTONE, TexturedModel.createAllSame(TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top")))
            .put(
                    Blocks.CUT_SANDSTONE,
                    TexturedModel.COLUMN.get(Blocks.SANDSTONE).updateTextures(m -> m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.CUT_SANDSTONE)))
            )
            .put(
                    Blocks.CUT_RED_SANDSTONE,
                    TexturedModel.COLUMN.get(Blocks.RED_SANDSTONE).updateTextures(m -> m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.CUT_RED_SANDSTONE)))
            )
            .put(Blocks.QUARTZ_BLOCK, TexturedModel.COLUMN.get(Blocks.QUARTZ_BLOCK))
            .put(Blocks.SMOOTH_QUARTZ, TexturedModel.createAllSame(TextureMapping.getBlockTexture(Blocks.QUARTZ_BLOCK, "_bottom")))
            .put(Blocks.BLACKSTONE, TexturedModel.COLUMN_WITH_WALL.get(Blocks.BLACKSTONE))
            .put(Blocks.DEEPSLATE, TexturedModel.COLUMN_WITH_WALL.get(Blocks.DEEPSLATE))
            .put(
                    Blocks.CHISELED_QUARTZ_BLOCK,
                    TexturedModel.COLUMN
                            .get(Blocks.CHISELED_QUARTZ_BLOCK)
                            .updateTextures(m -> m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.CHISELED_QUARTZ_BLOCK)))
            )
            .put(Blocks.CHISELED_SANDSTONE, TexturedModel.COLUMN.get(Blocks.CHISELED_SANDSTONE).updateTextures(m -> {
                m.put(TextureSlot.END, TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"));
                m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.CHISELED_SANDSTONE));
            }))
            .put(Blocks.CHISELED_RED_SANDSTONE, TexturedModel.COLUMN.get(Blocks.CHISELED_RED_SANDSTONE).updateTextures(m -> {
                m.put(TextureSlot.END, TextureMapping.getBlockTexture(Blocks.RED_SANDSTONE, "_top"));
                m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.CHISELED_RED_SANDSTONE));
            }))
            .put(Blocks.CHISELED_TUFF_BRICKS, TexturedModel.COLUMN_WITH_WALL.get(Blocks.CHISELED_TUFF_BRICKS))
            .put(Blocks.CHISELED_TUFF, TexturedModel.COLUMN_WITH_WALL.get(Blocks.CHISELED_TUFF))
            .build();

    public CustomBlockModelGenerators(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    @Environment(EnvType.CLIENT)
    public class BlockFamilyProvider {
        private final TextureMapping mapping;
        private final Map<ModelTemplate, Identifier> models;
        @Nullable
        private BlockFamily family;
        @Nullable
        private Variant fullBlock;
        private final Set<Block> skipGeneratingModelsFor;

        public BlockFamilyProvider(final TextureMapping mapping) {
            Objects.requireNonNull(CustomBlockModelGenerators.this);
            super();
            this.models = new HashMap();
            this.skipGeneratingModelsFor = new HashSet();
            this.mapping = mapping;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider fullBlock(final Block block, final ModelTemplate template) {
            this.fullBlock = CustomBlockModelGenerators.plainModel(template.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            if (CustomBlockModelGenerators.FULL_BLOCK_MODEL_CUSTOM_GENERATORS.containsKey(block)) {
                CustomBlockModelGenerators.this.blockStateOutput
                        .accept(
                                ((CustomBlockModelGenerators.BlockStateGeneratorSupplier)CustomBlockModelGenerators.FULL_BLOCK_MODEL_CUSTOM_GENERATORS.get(block))
                                        .create(block, this.fullBlock, this.mapping, CustomBlockModelGenerators.this.modelOutput)
                        );
            } else {
                CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createSimpleBlock(block, CustomBlockModelGenerators.variant(this.fullBlock)));
            }

            return this;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider button(final Block block) {
            MultiVariant normal = CustomBlockModelGenerators.plainVariant(ModelTemplates.BUTTON.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant pressed = CustomBlockModelGenerators.plainVariant(ModelTemplates.BUTTON_PRESSED.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createButton(block, normal, pressed));
            Identifier inventory = ModelTemplates.BUTTON_INVENTORY.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput);
            CustomBlockModelGenerators.this.registerSimpleItemModel(block, inventory);
            return this;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider wall(final Block block) {
            MultiVariant post = CustomBlockModelGenerators.plainVariant(ModelTemplates.WALL_POST.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant low = CustomBlockModelGenerators.plainVariant(ModelTemplates.WALL_LOW_SIDE.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant high = CustomBlockModelGenerators.plainVariant(ModelTemplates.WALL_TALL_SIDE.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createWall(block, post, low, high));
            Identifier inventory = ModelTemplates.WALL_INVENTORY.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput);
            CustomBlockModelGenerators.this.registerSimpleItemModel(block, inventory);
            return this;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider customFence(final Block block) {
            TextureMapping mapping = TextureMapping.customParticle(block);
            MultiVariant post = CustomBlockModelGenerators.plainVariant(ModelTemplates.CUSTOM_FENCE_POST.create(block, mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant north = CustomBlockModelGenerators.plainVariant(ModelTemplates.CUSTOM_FENCE_SIDE_NORTH.create(block, mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant east = CustomBlockModelGenerators.plainVariant(ModelTemplates.CUSTOM_FENCE_SIDE_EAST.create(block, mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant south = CustomBlockModelGenerators.plainVariant(ModelTemplates.CUSTOM_FENCE_SIDE_SOUTH.create(block, mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant west = CustomBlockModelGenerators.plainVariant(ModelTemplates.CUSTOM_FENCE_SIDE_WEST.create(block, mapping, CustomBlockModelGenerators.this.modelOutput));
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createCustomFence(block, post, north, east, south, west));
            Identifier inventory = ModelTemplates.CUSTOM_FENCE_INVENTORY.create(block, mapping, CustomBlockModelGenerators.this.modelOutput);
            CustomBlockModelGenerators.this.registerSimpleItemModel(block, inventory);
            return this;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider fence(final Block block) {
            MultiVariant post = CustomBlockModelGenerators.plainVariant(ModelTemplates.FENCE_POST.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant side = CustomBlockModelGenerators.plainVariant(ModelTemplates.FENCE_SIDE.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createFence(block, post, side));
            Identifier inventory = ModelTemplates.FENCE_INVENTORY.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput);
            CustomBlockModelGenerators.this.registerSimpleItemModel(block, inventory);
            return this;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider customFenceGate(final Block block) {
            TextureMapping mapping = TextureMapping.customParticle(block);
            MultiVariant open = CustomBlockModelGenerators.plainVariant(ModelTemplates.CUSTOM_FENCE_GATE_OPEN.create(block, mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant closed = CustomBlockModelGenerators.plainVariant(
                    ModelTemplates.CUSTOM_FENCE_GATE_CLOSED.create(block, mapping, CustomBlockModelGenerators.this.modelOutput)
            );
            MultiVariant openWall = CustomBlockModelGenerators.plainVariant(
                    ModelTemplates.CUSTOM_FENCE_GATE_WALL_OPEN.create(block, mapping, CustomBlockModelGenerators.this.modelOutput)
            );
            MultiVariant closedWall = CustomBlockModelGenerators.plainVariant(
                    ModelTemplates.CUSTOM_FENCE_GATE_WALL_CLOSED.create(block, mapping, CustomBlockModelGenerators.this.modelOutput)
            );
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createFenceGate(block, open, closed, openWall, closedWall, false));
            return this;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider fenceGate(final Block block) {
            MultiVariant open = CustomBlockModelGenerators.plainVariant(ModelTemplates.FENCE_GATE_OPEN.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant closed = CustomBlockModelGenerators.plainVariant(ModelTemplates.FENCE_GATE_CLOSED.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant openWall = CustomBlockModelGenerators.plainVariant(
                    ModelTemplates.FENCE_GATE_WALL_OPEN.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput)
            );
            MultiVariant closedWall = CustomBlockModelGenerators.plainVariant(
                    ModelTemplates.FENCE_GATE_WALL_CLOSED.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput)
            );
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createFenceGate(block, open, closed, openWall, closedWall, true));
            return this;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider pressurePlate(final Block block) {
            MultiVariant off = CustomBlockModelGenerators.plainVariant(ModelTemplates.PRESSURE_PLATE_UP.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            MultiVariant on = CustomBlockModelGenerators.plainVariant(ModelTemplates.PRESSURE_PLATE_DOWN.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createPressurePlate(block, off, on));
            return this;
        }

        public CustomBlockModelGenerators.BlockFamilyProvider sign(final Block sign) {
            if (this.family == null) {
                throw new IllegalStateException("Family not defined");
            } else {
                Block wallSign = (Block)this.family.getVariants().get(BlockFamily.Variant.WALL_SIGN);
                MultiVariant model = CustomBlockModelGenerators.plainVariant(ModelTemplates.PARTICLE_ONLY.create(sign, this.mapping, CustomBlockModelGenerators.this.modelOutput));
                CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createSimpleBlock(sign, model));
                CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createSimpleBlock(wallSign, model));
                CustomBlockModelGenerators.this.registerSimpleFlatItemModel(sign.asItem());
                return this;
            }
        }

        public CustomBlockModelGenerators.BlockFamilyProvider slab(final Block slab) {
            if (this.fullBlock == null) {
                throw new IllegalStateException("Full block not generated yet");
            } else {
                Identifier bottom = this.getOrCreateModel(ModelTemplates.SLAB_BOTTOM, slab);
                MultiVariant top = CustomBlockModelGenerators.plainVariant(this.getOrCreateModel(ModelTemplates.SLAB_TOP, slab));
                CustomBlockModelGenerators.this.blockStateOutput
                        .accept(CustomBlockModelGenerators.createSlab(slab, CustomBlockModelGenerators.plainVariant(bottom), top, CustomBlockModelGenerators.variant(this.fullBlock)));
                CustomBlockModelGenerators.this.registerSimpleItemModel(slab, bottom);
                return this;
            }
        }

        public CustomBlockModelGenerators.BlockFamilyProvider stairs(final Block stairs) {
            MultiVariant inner = CustomBlockModelGenerators.plainVariant(this.getOrCreateModel(ModelTemplates.STAIRS_INNER, stairs));
            Identifier straight = this.getOrCreateModel(ModelTemplates.STAIRS_STRAIGHT, stairs);
            MultiVariant outer = CustomBlockModelGenerators.plainVariant(this.getOrCreateModel(ModelTemplates.STAIRS_OUTER, stairs));
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createStairs(stairs, inner, CustomBlockModelGenerators.plainVariant(straight), outer));
            CustomBlockModelGenerators.this.registerSimpleItemModel(stairs, straight);
            return this;
        }

        private CustomBlockModelGenerators.BlockFamilyProvider fullBlockVariant(final Block variant) {
            TexturedModel model = (TexturedModel)CustomBlockModelGenerators.TEXTURED_MODELS.getOrDefault(variant, TexturedModel.CUBE.get(variant));
            MultiVariant variantModel = CustomBlockModelGenerators.plainVariant(model.create(variant, CustomBlockModelGenerators.this.modelOutput));
            CustomBlockModelGenerators.this.blockStateOutput.accept(CustomBlockModelGenerators.createSimpleBlock(variant, variantModel));
            return this;
        }

        private CustomBlockModelGenerators.BlockFamilyProvider door(final Block door) {
            CustomBlockModelGenerators.this.createDoor(door);
            return this;
        }

        private void trapdoor(final Block result) {
            if (CustomBlockModelGenerators.NON_ORIENTABLE_TRAPDOOR.contains(result)) {
                CustomBlockModelGenerators.this.createTrapdoor(result);
            } else {
                CustomBlockModelGenerators.this.createOrientableTrapdoor(result);
            }
        }

        private Identifier getOrCreateModel(final ModelTemplate modelTemplate, final Block block) {
            return (Identifier)this.models.computeIfAbsent(modelTemplate, template -> template.create(block, this.mapping, CustomBlockModelGenerators.this.modelOutput));
        }

        public CustomBlockModelGenerators.BlockFamilyProvider generateFor(final BlockFamily family) {
            this.family = family;
            family.getVariants()
                    .forEach(
                            (variant, result) -> {
                                boolean modelAlreadyRegisteredAsAnotherFamilyBase = BlockFamilies.getAllFamilies().anyMatch(b -> b.getBaseBlock() == result);
                                if (!this.skipGeneratingModelsFor.contains(result) && !modelAlreadyRegisteredAsAnotherFamilyBase) {
                                    BiConsumer<CustomBlockModelGenerators.BlockFamilyProvider, Block> consumer = (BiConsumer<CustomBlockModelGenerators.BlockFamilyProvider, Block>)CustomBlockModelGenerators.SHAPE_CONSUMERS
                                            .get(variant);
                                    if (consumer != null) {
                                        consumer.accept(this, result);
                                    }
                                }
                            }
                    );
            return this;
        }
    }



    @FunctionalInterface
    @Environment(EnvType.CLIENT)
    private interface BlockStateGeneratorSupplier {
        BlockModelDefinitionGenerator create(Block block, Variant normal, TextureMapping mapping, BiConsumer<Identifier, ModelInstance> modelOutput);
    }
}
