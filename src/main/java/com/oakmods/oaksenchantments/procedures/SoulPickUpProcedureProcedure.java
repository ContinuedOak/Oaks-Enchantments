package com.oakmods.oaksenchantments.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

@Mod.EventBusSubscriber
public class SoulPickUpProcedureProcedure {
	@SubscribeEvent
	public static void onPickupXP(PlayerXpEvent.PickupXp event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.GRIM_REAPER.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 1) {
				if (Math.random() < 0.25) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, true, false));
				}
			} else if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.GRIM_REAPER.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 2) {
				if (Math.random() < 0.35) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, true, false));
				}
			} else if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.GRIM_REAPER.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 3) {
				if (Math.random() < 0.45) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, true, false));
				}
			}
		} else if (entity instanceof Player) {
			if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.GRIM_REAPER.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) == 1) {
				if (Math.random() < 0.25) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, true, false));
				}
			} else if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.GRIM_REAPER.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) == 2) {
				if (Math.random() < 0.35) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, true, false));
				}
			} else if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.GRIM_REAPER.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) == 3) {
				if (Math.random() < 0.45) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, true, false));
				}
			}
		}
	}
}
