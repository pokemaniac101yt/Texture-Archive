package net.pokemaniac.texturemod.datagen;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.pokemaniac.texturemod.TextureArchive;
import net.pokemaniac.texturemod.block.ModBlocks;
import net.pokemaniac.texturemod.item.ModItems;

import javax.annotation.Nullable;
import java.util.Map;

import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TextureArchive.MOD_ID);
    }

    public static final Map<Block, TexturedModel> TEXTURED_MODELS = ImmutableMap.<Block, TexturedModel>builder()
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
                    TexturedModel.COLUMN
                            .get(Blocks.RED_SANDSTONE)
                            .updateTextures(m -> m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.CUT_RED_SANDSTONE)))
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
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.WOODEN_CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.STONE_CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.GOLDEN_CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.COPPER_CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.IRON_CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.DIAMOND_CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.NETHERITE_CHISEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);




        blockModels.createTrivialCube(ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_131655.get());

        blockModels.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_131655.get())
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_131655.get())
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_131655.get())
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_131655.get());

        blockModels.createTrivialCube(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get());

        blockModels.createTrivialBlock(
                ModBlocks.GRASS_BLOCK_PRE_CLASSIC_RD_20090515.get(),
                TexturedModel.createDefault(block -> new TextureMapping()
                                .put(TextureSlot.SIDE,
                                        TextureMapping.getBlockTexture(block, "_side"))
                                .put(TextureSlot.TOP,
                                        TextureMapping.getBlockTexture(block, "_top"))
                                .put(TextureSlot.BOTTOM,
                                        TextureMapping.getBlockTexture(ModBlocks.DIRT_PRE_CLASSIC_RD_20090515.get())),
                        ModelTemplates.CUBE_BOTTOM_TOP));

        blockModels.family(ModBlocks.COBBLESTONE_PRE_CLASSIC_RD_20090515.get())
                .stairs(ModBlocks.COBBLESTONE_STAIRS_PRE_CLASSIC_RD_20090515.get())
                .slab(ModBlocks.COBBLESTONE_SLAB_PRE_CLASSIC_RD_20090515.get())
                .wall(ModBlocks.COBBLESTONE_WALL_PRE_CLASSIC_RD_20090515.get());

        generateCustomFamily(
                blockModels,
                true,
                false,
                false,
                ModBlocks.STONE_PRE_CLASSIC_RD_20090515.get(),
                ModBlocks.STONE_STAIRS_PRE_CLASSIC_RD_20090515.get(),
                ModBlocks.STONE_SLAB_PRE_CLASSIC_RD_20090515.get(),
                null,
                ModBlocks.STONE_BUTTON_PRE_CLASSIC_RD_20090515.get(),
                ModBlocks.STONE_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515.get()
        );

        blockModels.family(ModBlocks.OAK_PLANKS_PRE_CLASSIC_RD_20090515.get())
                .stairs(ModBlocks.OAK_STAIRS_PRE_CLASSIC_RD_20090515.get())
                .slab(ModBlocks.OAK_SLAB_PRE_CLASSIC_RD_20090515.get())
                .fence(ModBlocks.OAK_FENCE_PRE_CLASSIC_RD_20090515.get())
                .fenceGate(ModBlocks.OAK_FENCE_GATE_PRE_CLASSIC_RD_20090515.get())
                .pressurePlate(ModBlocks.OAK_PRESSURE_PLATE_PRE_CLASSIC_RD_20090515.get())
                .button(ModBlocks.OAK_BUTTON_PRE_CLASSIC_RD_20090515.get());

        blockModels.createTrivialCube(ModBlocks.BEDROCK_CLASSIC_0_0_12a.get());

        blockModels.createTrivialCube(ModBlocks.WATER_CLASSIC_0_0_12a.get());
        blockModels.createTrivialCube(ModBlocks.LAVA_CLASSIC_0_0_12a.get());

    }

    public void generateCustomFamily(
            BlockModelGenerators blockModels,
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
        fullBlockVariant = BlockModelGenerators.plainModel(model.getTemplate().create(fullBlock, fullBlockMapping, blockModels.modelOutput));


        if (mirroredCube) {

            blockModels.blockStateOutput.accept(
                    BlockModelGenerators.createMirroredCubeGenerator(
                            fullBlock,
                            fullBlockVariant,
                            fullBlockMapping,
                            blockModels.modelOutput
                    )
            );
        } else if (mirroredColumn) {
            blockModels.blockStateOutput.accept(
                    BlockModelGenerators.createMirroredColumnGenerator(
                            fullBlock,
                            fullBlockVariant,
                            fullBlockMapping,
                            blockModels.modelOutput
                    )
            );
        } else if (northWestMirroredCube) {
            blockModels.blockStateOutput.accept(
                    BlockModelGenerators.createNorthWestMirroredCubeGenerator(
                            fullBlock,
                            fullBlockVariant,
                            fullBlockMapping,
                            blockModels.modelOutput
                    )
            );
        }


        if (stairs != null) {
            Identifier inner = ModelTemplates.STAIRS_INNER.create(
                    stairs,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            Identifier straight = ModelTemplates.STAIRS_STRAIGHT.create(
                    stairs,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            Identifier outer = ModelTemplates.STAIRS_OUTER.create(
                    stairs,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
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
                    blockModels.modelOutput
            );

            Identifier top = ModelTemplates.SLAB_TOP.create(
                    slab,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
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
                    blockModels.modelOutput
            );

            Identifier lowSide = ModelTemplates.WALL_LOW_SIDE.create(
                    wall,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            Identifier tallSide = ModelTemplates.WALL_TALL_SIDE.create(
                    wall,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
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
                    blockModels.modelOutput
            );

            Identifier on = ModelTemplates.PRESSURE_PLATE_DOWN.create(
                    pressurePlate,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            blockModels.blockStateOutput.accept(
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
                    blockModels.modelOutput
            );

            Identifier pressed = ModelTemplates.BUTTON_PRESSED.create(
                    button,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            Identifier inventory = ModelTemplates.BUTTON_INVENTORY.create(
                    button,
                    fullBlockMapping,
                    blockModels.modelOutput
            );

            blockModels.registerSimpleItemModel(button, inventory);

            blockModels.blockStateOutput.accept(
                    BlockModelGenerators.createButton(
                            button,
                            plainVariant(normal),
                            plainVariant(pressed)
                    )
            );
        }

    }
}
