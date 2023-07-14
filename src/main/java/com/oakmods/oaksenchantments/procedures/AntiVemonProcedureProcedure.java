package com.oakmods.oaksenchantments.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import javax.annotation.Nullable;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

@Mod.EventBusSubscriber
public class AntiVemonProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.ANTI_VENOM.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0
				|| EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.ANTI_VENOM.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0
				|| EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.ANTI_VENOM.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0
				|| EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.ANTI_VENOM.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.POISON) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(-(1));
			}
		}
	}
}
