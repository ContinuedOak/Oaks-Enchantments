
package com.oakmods.oaksenchantments.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

public class GraveDiggerEnchantment extends Enchantment {
	public GraveDiggerEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.DIGGER, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(Enchantments.UNBREAKING, Enchantments.BLOCK_FORTUNE, OaksenchantmentsModEnchantments.MINING_HAMMER.get(), OaksenchantmentsModEnchantments.AUTO_SMELTER.get(), Enchantments.MENDING, Enchantments.BLOCK_EFFICIENCY).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(Items.IRON_PICKAXE, Items.GOLDEN_PICKAXE, Items.DIAMOND_PICKAXE, Items.NETHERITE_PICKAXE).contains(item);
	}
}
