
package net.pokemaniac.texturemod.aneyra;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.Nullable;

import java.util.Map;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public final class AneyraBlockModelGenerators {

    private AneyraBlockModelGenerators() {
        // Utility class
    }

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

    public static void generateCustomFamily(
            BlockModelGenerators blockModelGenerators,
            Integer fullBlockMap,
            Integer mirrored,
            Block fullBlock,
            TexturedModel.@Nullable Provider modelProvider,
            @Nullable Block stairs,
            @Nullable Block slab,
            @Nullable Block wall,
            @Nullable Block button,
            @Nullable Block pressurePlate) {


        TexturedModel model;

        if (modelProvider != null) {
            model = modelProvider.get(fullBlock);
        } else {
            model = switch (fullBlockMap) {
                case 0 -> TexturedModel.CUBE.get(fullBlock);
                case 1 -> TexturedModel.CUBE_TOP_BOTTOM.get(fullBlock);
                case 2 -> TexturedModel.TOP_BOTTOM_WITH_WALL.get(fullBlock);
                case null, default -> TexturedModel.CUBE.get(fullBlock);
            };
        }

        TextureMapping fullBlockMapping = model.getMapping();

        Variant fullBlockVariant;

        fullBlockVariant = BlockModelGenerators.plainModel(model.getTemplate().create(fullBlock, fullBlockMapping, blockModelGenerators.modelOutput));


        switch (mirrored) {
            case 0 -> blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createSimpleBlock(
                            fullBlock,
                            BlockModelGenerators.variant(fullBlockVariant)
                    )
            );
            case 1 -> blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createMirroredCubeGenerator(
                            fullBlock,
                            fullBlockVariant,
                            fullBlockMapping,
                            blockModelGenerators.modelOutput
                    )
            );
            case 2 ->  blockModelGenerators.blockStateOutput.accept(
                    BlockModelGenerators.createMirroredColumnGenerator(
                            fullBlock,
                            fullBlockVariant,
                            fullBlockMapping,
                            blockModelGenerators.modelOutput
                    )
            );
            case 3 -> blockModelGenerators.blockStateOutput.accept(
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

            Identifier inventory = ModelTemplates.WALL_INVENTORY.create(
                    wall,
                    fullBlockMapping,
                    blockModelGenerators.modelOutput
            );

            blockModelGenerators.registerSimpleItemModel(wall, inventory);
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
