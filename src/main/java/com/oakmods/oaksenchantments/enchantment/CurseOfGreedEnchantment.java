
package com.oakmods.oaksenchantments.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.List;

public class CurseOfGreedEnchantment extends Enchantment {
	public CurseOfGreedEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(Items.WOODEN_PICKAXE, Items.STONE_PICKAXE, Items.IRON_PICKAXE, Items.GOLDEN_PICKAXE, Items.DIAMOND_PICKAXE, Items.NETHERITE_PICKAXE, Items.WOODEN_SHOVEL, Items.WOODEN_AXE, Items.STONE_SHOVEL, Items.STONE_AXE, Items.IRON_SHOVEL,
				Items.IRON_AXE, Items.GOLDEN_SHOVEL, Items.GOLDEN_AXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_AXE, Items.NETHERITE_SHOVEL, Items.NETHERITE_AXE).contains(item);
	}

	@Override
	public boolean isCurse() {
		return true;
	}
}
