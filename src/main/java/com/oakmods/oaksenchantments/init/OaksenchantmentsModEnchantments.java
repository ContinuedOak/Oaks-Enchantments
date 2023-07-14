
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.oakmods.oaksenchantments.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import com.oakmods.oaksenchantments.enchantment.ThermalWalkerEnchantment;
import com.oakmods.oaksenchantments.enchantment.RestfulSleepEnchantment;
import com.oakmods.oaksenchantments.enchantment.RabbitsJumpEnchantment;
import com.oakmods.oaksenchantments.enchantment.PoisonTippedEnchantment;
import com.oakmods.oaksenchantments.enchantment.PiratesLuckEnchantment;
import com.oakmods.oaksenchantments.enchantment.MiningHammerEnchantment;
import com.oakmods.oaksenchantments.enchantment.LightWeightEnchantment;
import com.oakmods.oaksenchantments.enchantment.IlluminationEnchantment;
import com.oakmods.oaksenchantments.enchantment.GrimReaperEnchantment;
import com.oakmods.oaksenchantments.enchantment.GraveDiggerEnchantment;
import com.oakmods.oaksenchantments.enchantment.CurseOfGreedEnchantment;
import com.oakmods.oaksenchantments.enchantment.CurseOfBlazeEnchantment;
import com.oakmods.oaksenchantments.enchantment.CultivatorEnchantment;
import com.oakmods.oaksenchantments.enchantment.CosinessEnchantment;
import com.oakmods.oaksenchantments.enchantment.BladesEnchantment;
import com.oakmods.oaksenchantments.enchantment.AutoSmeltingFortuneEnchantment;
import com.oakmods.oaksenchantments.enchantment.AutoSmelterEnchantment;
import com.oakmods.oaksenchantments.enchantment.AquaAspectEnchantment;
import com.oakmods.oaksenchantments.enchantment.AntiVenomEnchantment;
import com.oakmods.oaksenchantments.OaksenchantmentsMod;

public class OaksenchantmentsModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, OaksenchantmentsMod.MODID);
	public static final RegistryObject<Enchantment> MINING_HAMMER = REGISTRY.register("mining_hammer", () -> new MiningHammerEnchantment());
	public static final RegistryObject<Enchantment> AUTO_SMELTER = REGISTRY.register("auto_smelter", () -> new AutoSmelterEnchantment());
	public static final RegistryObject<Enchantment> RESTFUL_SLEEP = REGISTRY.register("restful_sleep", () -> new RestfulSleepEnchantment());
	public static final RegistryObject<Enchantment> RABBITS_JUMP = REGISTRY.register("rabbits_jump", () -> new RabbitsJumpEnchantment());
	public static final RegistryObject<Enchantment> GRIM_REAPER = REGISTRY.register("grim_reaper", () -> new GrimReaperEnchantment());
	public static final RegistryObject<Enchantment> LIGHT_WEIGHT = REGISTRY.register("light_weight", () -> new LightWeightEnchantment());
	public static final RegistryObject<Enchantment> THERMAL_WALKER = REGISTRY.register("thermal_walker", () -> new ThermalWalkerEnchantment());
	public static final RegistryObject<Enchantment> GRAVE_DIGGER = REGISTRY.register("grave_digger", () -> new GraveDiggerEnchantment());
	public static final RegistryObject<Enchantment> ILLUMINATION = REGISTRY.register("illumination", () -> new IlluminationEnchantment());
	public static final RegistryObject<Enchantment> CULTIVATOR = REGISTRY.register("cultivator", () -> new CultivatorEnchantment());
	public static final RegistryObject<Enchantment> BLADES = REGISTRY.register("blades", () -> new BladesEnchantment());
	public static final RegistryObject<Enchantment> ANTI_VENOM = REGISTRY.register("anti_venom", () -> new AntiVenomEnchantment());
	public static final RegistryObject<Enchantment> COSINESS = REGISTRY.register("cosiness", () -> new CosinessEnchantment());
	public static final RegistryObject<Enchantment> POISON_TIPPED = REGISTRY.register("poison_tipped", () -> new PoisonTippedEnchantment());
	public static final RegistryObject<Enchantment> CURSE_OF_GREED = REGISTRY.register("curse_of_greed", () -> new CurseOfGreedEnchantment());
	public static final RegistryObject<Enchantment> CURSE_OF_BLAZE = REGISTRY.register("curse_of_blaze", () -> new CurseOfBlazeEnchantment());
	public static final RegistryObject<Enchantment> PIRATES_LUCK = REGISTRY.register("pirates_luck", () -> new PiratesLuckEnchantment());
	public static final RegistryObject<Enchantment> AUTO_SMELTING_FORTUNE = REGISTRY.register("auto_smelting_fortune", () -> new AutoSmeltingFortuneEnchantment());
	public static final RegistryObject<Enchantment> AQUA_ASPECT = REGISTRY.register("aqua_aspect", () -> new AquaAspectEnchantment());
}
