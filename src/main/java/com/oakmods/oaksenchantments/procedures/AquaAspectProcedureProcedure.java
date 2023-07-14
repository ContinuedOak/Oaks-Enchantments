package com.oakmods.oaksenchantments.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import javax.annotation.Nullable;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

@Mod.EventBusSubscriber
public class AquaAspectProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.AQUA_ASPECT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.WATER : false) {
				if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.AQUA_ASPECT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 1) {
					entity.hurt(DamageSource.GENERIC, 5);
				} else if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.AQUA_ASPECT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 2) {
					entity.hurt(DamageSource.GENERIC, 6);
				} else if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.AQUA_ASPECT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 3) {
					entity.hurt(DamageSource.GENERIC, 7);
				} else if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.AQUA_ASPECT.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 4) {
					sourceentity.hurt(DamageSource.GENERIC, 8);
				}
			}
		}
	}
}
