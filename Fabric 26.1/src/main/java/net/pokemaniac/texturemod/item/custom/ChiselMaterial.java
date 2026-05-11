package net.pokemaniac.texturemod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public enum ChiselMaterial implements ToolMaterial {

    WOOD(59, 2.0f, 1.0f, 1.0f, 0, 15, Ingredient.ofItems(Items.OAK_PLANKS)),
    GOLD(32, 12.0f, 1.0f, 1.0f, 0, 22, Ingredient.ofItems(Items.GOLD_INGOT)),
    STONE(131, 4.0f, 1.0f, 2.0f, 1, 5, Ingredient.ofItems(Items.COBBLESTONE)),
    COPPER(190, 5.0f, 1.0f,2.0f, 1, 13, Ingredient.ofItems(Items.COPPER_INGOT)),
    IRON(250, 6.0f, 1.0f,3.0f, 2, 14, Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND(1561, 8.0f, 1.0f,4.0f, 3, 10, Ingredient.ofItems(Items.DIAMOND)),
    NETHERITE(2031, 9.0f, 1.0f,4.0f, 4, 15, Ingredient.ofItems(Items.NETHERITE_INGOT));

    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;
    private final float attackSpeed;
    private final int miningLevel;
    private final int enchantability;
    private final Ingredient repairIngredient;

    ChiselMaterial(int durability, float miningSpeed, float attackDamage, float attackSpeed,
                   int miningLevel, int enchantability, Ingredient repairIngredient) {
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }
}
