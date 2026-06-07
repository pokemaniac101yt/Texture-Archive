package net.pokemaniac.texturemod.datagen;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;
import org.jspecify.annotations.Nullable;

import java.util.Map;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;
import static net.minecraft.client.data.models.BlockModelGenerators.variant;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    // Copied private map from BlockModelGenerators
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

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655);

        blockModelGenerators.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655)
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655)
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655)
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655);

        blockModelGenerators.createTrivialCube(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515);

        blockModelGenerators.createTrivialBlock(
                ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515,
                TexturedModel.createDefault(block -> new TextureMapping()
                                .put(TextureSlot.SIDE,
                                        TextureMapping.getBlockTexture(block, "_side"))
                                .put(TextureSlot.TOP,
                                        TextureMapping.getBlockTexture(block, "_top"))
                                .put(TextureSlot.BOTTOM,
                                        TextureMapping.getBlockTexture(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515)),
                        ModelTemplates.CUBE_BOTTOM_TOP));

        blockModelGenerators.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515)
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515)
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515)
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515);

        generateCustomFamily(
                blockModelGenerators,
                true,
                false,
                false,
                ModBlocks.STONE_PRE_CLASSIC_RD_20090515,
                ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515,
                ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515,
                null,
                ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515,
                ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515);

        blockModelGenerators.family(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515)
                .stairs(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515)
                .slab(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515)
                .fence(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515)
                .fenceGate(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515)
                .pressurePlate(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515)
                .button(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515);

        blockModelGenerators.createTrivialCube(ModBlocks.BEDROCK_CLASSIC_0_0_12a);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.WOODEN_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLDEN_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COPPER_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STONE_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DIAMOND_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHERITE_CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
    }


    public void generateCustomFamily(
            BlockModelGenerators blockModelGenerators,
            boolean mirroredCube,
            boolean mirroredColumn,
            boolean northWestMirroredCube,
            Block fullBlock,
            @Nullable Block stairs,
            @Nullable Block slab,
            @Nullable Block wall,
            @Nullable Block button,
            @Nullable Block pressurePlate) {


        TexturedModel model = TEXTURED_MODELS.getOrDefault(fullBlock, TexturedModel.CUBE.get(fullBlock));

        TextureMapping fullBlockMapping =
                TextureMapping.cube(fullBlock);

        Variant fullBlockVariant;

        assert model != null;
        fullBlockVariant = BlockModelGenerators.plainModel(model.getTemplate().create(fullBlock, fullBlockMapping, blockModelGenerators.modelOutput));


        if (mirroredCube) {

            blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createMirroredCubeGenerator(
                            fullBlock,
                            fullBlockVariant,
                            fullBlockMapping,
                            blockModelGenerators.modelOutput
                    )
            );
        } else if (mirroredColumn) {
            blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createMirroredColumnGenerator(
                            fullBlock,
                            fullBlockVariant,
                            fullBlockMapping,
                            blockModelGenerators.modelOutput
                    )
            );
        } else if (northWestMirroredCube) {
            blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createNorthWestMirroredCubeGenerator(
                            fullBlock,
                            fullBlockVariant,
                            fullBlockMapping,
                            blockModelGenerators.modelOutput
                    )
            );
        }


        if (stairs != null) {
            Identifier inner = ModelTemplates.STAIRS_INNER.create(
                    stairs,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            Identifier straight = ModelTemplates.STAIRS_STRAIGHT.create(
                    stairs,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            Identifier outer = ModelTemplates.STAIRS_OUTER.create(
                    stairs,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createStairs(
                            stairs,
                            plainVariant(inner),
                            plainVariant(straight),
                            plainVariant(outer)
                    )
            );
        }


        if (slab != null) {
            Identifier bottom = ModelTemplates.SLAB_BOTTOM.create(
                    slab,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            Identifier top = ModelTemplates.SLAB_TOP.create(
                    slab,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createSlab(
                            slab,
                            plainVariant(bottom),
                            plainVariant(top),
                            plainVariant(ModelLocationUtils.getModelLocation(fullBlock))
                    )
            );
        }

        if (wall != null) {


            Identifier post = ModelTemplates.WALL_POST.create(
                    wall,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            Identifier lowSide = ModelTemplates.WALL_LOW_SIDE.create(
                    wall,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            Identifier tallSide = ModelTemplates.WALL_TALL_SIDE.create(
                    wall,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createWall(
                            wall,
                            plainVariant(post),
                            plainVariant(lowSide),
                            plainVariant(tallSide)
                    )
            );
        }

        if (pressurePlate != null) {

            Identifier off = ModelTemplates.PRESSURE_PLATE_UP.create(
                    pressurePlate,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            Identifier on = ModelTemplates.PRESSURE_PLATE_DOWN.create(
                    pressurePlate,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createPressurePlate(
                            pressurePlate,
                            plainVariant(off),
                            plainVariant(on)
                    )
            );
        }

        if (button != null) {
            Identifier normal = ModelTemplates.BUTTON.create(
                    button,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            Identifier pressed = ModelTemplates.BUTTON_PRESSED.create(
                    button,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            Identifier inventory = ModelTemplates.BUTTON_INVENTORY.create(
                    button,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            blockModelGenerators.registerSimpleItemModel(button, inventory);

            blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createButton(
                            button,
                            plainVariant(normal),
                            plainVariant(pressed)
                    )
            );
        }

    }
}
