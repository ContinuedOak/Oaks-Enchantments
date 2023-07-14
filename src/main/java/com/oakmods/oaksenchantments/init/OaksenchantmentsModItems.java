
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.oakmods.oaksenchantments.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import com.oakmods.oaksenchantments.item.SoulsItem;
import com.oakmods.oaksenchantments.OaksenchantmentsMod;

public class OaksenchantmentsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, OaksenchantmentsMod.MODID);
	public static final RegistryObject<Item> SOULS = REGISTRY.register("souls", () -> new SoulsItem());
	public static final RegistryObject<Item> THERMAL_WALKERBREAKSTAGE_0 = block(OaksenchantmentsModBlocks.THERMAL_WALKERBREAKSTAGE_0, null);
	public static final RegistryObject<Item> THERMAL_WALKERBREAKSTAGE_1 = block(OaksenchantmentsModBlocks.THERMAL_WALKERBREAKSTAGE_1, null);
	public static final RegistryObject<Item> THERMAL_WALKERBREAKSTAGE_2 = block(OaksenchantmentsModBlocks.THERMAL_WALKERBREAKSTAGE_2, null);
	public static final RegistryObject<Item> THERMAL_WALKERBREAKSTAGE_3 = block(OaksenchantmentsModBlocks.THERMAL_WALKERBREAKSTAGE_3, null);
	public static final RegistryObject<Item> CLOUD_BLOCK = block(OaksenchantmentsModBlocks.CLOUD_BLOCK, null);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
