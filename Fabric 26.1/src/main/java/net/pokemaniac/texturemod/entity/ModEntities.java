package net.pokemaniac.texturemod.entity;

import net.pokemaniac.texturemod.TextureMod;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<ModTntEntity> MOD_TNT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(TextureMod.MOD_ID, "mod_tnt_entity"),
            FabricEntityTypeBuilder.<ModTntEntity>create(SpawnGroup.MISC, ModTntEntity::new)
                    .dimensions(EntityDimensions.fixed(0.98f, 0.98f))
                    .trackRangeBlocks(10)
                    .trackedUpdateRate(10)
                    .build()
    );


    public static void register() {

    }
}
