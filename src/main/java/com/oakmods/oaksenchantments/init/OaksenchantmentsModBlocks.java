
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.oakmods.oaksenchantments.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import com.oakmods.oaksenchantments.block.ThermalWalkerbreakstage3Block;
import com.oakmods.oaksenchantments.block.ThermalWalkerbreakstage2Block;
import com.oakmods.oaksenchantments.block.ThermalWalkerbreakstage1Block;
import com.oakmods.oaksenchantments.block.ThermalWalkerbreakstage0Block;
import com.oakmods.oaksenchantments.block.CloudBlockBlock;
import com.oakmods.oaksenchantments.OaksenchantmentsMod;

public class OaksenchantmentsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, OaksenchantmentsMod.MODID);
	public static final RegistryObject<Block> THERMAL_WALKERBREAKSTAGE_0 = REGISTRY.register("thermal_walkerbreakstage_0", () -> new ThermalWalkerbreakstage0Block());
	public static final RegistryObject<Block> THERMAL_WALKERBREAKSTAGE_1 = REGISTRY.register("thermal_walkerbreakstage_1", () -> new ThermalWalkerbreakstage1Block());
	public static final RegistryObject<Block> THERMAL_WALKERBREAKSTAGE_2 = REGISTRY.register("thermal_walkerbreakstage_2", () -> new ThermalWalkerbreakstage2Block());
	public static final RegistryObject<Block> THERMAL_WALKERBREAKSTAGE_3 = REGISTRY.register("thermal_walkerbreakstage_3", () -> new ThermalWalkerbreakstage3Block());
	public static final RegistryObject<Block> CLOUD_BLOCK = REGISTRY.register("cloud_block", () -> new CloudBlockBlock());
}
