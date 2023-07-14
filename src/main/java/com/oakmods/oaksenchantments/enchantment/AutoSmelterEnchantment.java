
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

public class AutoSmelterEnchantment extends Enchantment {
	public AutoSmelterEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.DIGGER, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(Enchantments.UNBREAKING, Enchantments.MENDING, Enchantments.BLOCK_EFFICIENCY, OaksenchantmentsModEnchantments.AUTO_SMELTING_FORTUNE.get()).contains(ench);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(Items.WOODEN_PICKAXE, Items.WOODEN_AXE, Items.STONE_PICKAXE, Items.STONE_AXE, Items.IRON_PICKAXE, Items.IRON_AXE, Items.GOLDEN_PICKAXE, Items.GOLDEN_AXE, Items.DIAMOND_PICKAXE, Items.DIAMOND_AXE, Items.NETHERITE_PICKAXE,
				Items.NETHERITE_AXE, Items.WOODEN_SHOVEL, Items.STONE_SHOVEL, Items.IRON_SHOVEL, Items.GOLDEN_SHOVEL, Items.DIAMOND_SHOVEL, Items.NETHERITE_SHOVEL).contains(item);
	}
}
