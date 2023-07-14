
package com.oakmods.oaksenchantments.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

public class AutoSmeltingFortuneEnchantment extends Enchantment {
	public AutoSmeltingFortuneEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return this != ench && !List.of(Enchantments.MOB_LOOTING, Enchantments.BLOCK_FORTUNE, Enchantments.INFINITY_ARROWS, OaksenchantmentsModEnchantments.AUTO_SMELTER.get()).contains(ench);
	}
}
