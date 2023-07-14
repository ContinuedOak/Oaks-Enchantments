
package com.oakmods.oaksenchantments.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.damagesource.DamageSource;

import java.util.List;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

public class AquaAspectEnchantment extends Enchantment {
	public AquaAspectEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public int getDamageProtection(int level, DamageSource source) {
		return level * 2;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(OaksenchantmentsModEnchantments.POISON_TIPPED.get(), Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.FIRE_ASPECT).contains(ench);
	}
}
