package net.pokemaniac.texturemod.client.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TntEntityRenderer;
import net.minecraft.entity.TntEntity;
import net.minecraft.util.Identifier;
import net.pokemaniac.texturemod.TextureMod;
import net.pokemaniac.texturemod.entity.ModTntEntity;
import net.minecraft.block.Block;

public class ModTntEntityRenderer extends TntEntityRenderer {

    public ModTntEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(TntEntity entity) {

        if (entity instanceof ModTntEntity mod) {
            Block block = mod.getTntBlock();

            var sprite = MinecraftClient.getInstance()
                    .getBlockRenderManager()
                    .getModel(block.getDefaultState())
                    .getParticleSprite();

            return sprite.getContents().getId();
        }

        return Identifier.of("minecraft", "textures/entity/tnt/tnt.png");
    }


}
