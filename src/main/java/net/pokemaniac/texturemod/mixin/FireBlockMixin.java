package net.pokemaniac.texturemod.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.pokemaniac.texturemod.datagen.tags.ModBlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireBlock.class)
public class FireBlockMixin {

    @Inject(
            method = "isFlammable(Lnet/minecraft/block/BlockState;)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void texturemod$lavaFlammableOverride(
            BlockState state,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (cir == null) {
            return;
        }

        if (state.isIn(ModBlockTags.LAVA_FLAMMABLE)) {
            cir.setReturnValue(true);
        }
    }
}

