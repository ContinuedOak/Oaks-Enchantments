
package com.oakmods.oaksenchantments.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class CurseOfBlazeEnchantment extends Enchantment {
	public CurseOfBlazeEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	public boolean isCurse() {
		return true;
	}
}
