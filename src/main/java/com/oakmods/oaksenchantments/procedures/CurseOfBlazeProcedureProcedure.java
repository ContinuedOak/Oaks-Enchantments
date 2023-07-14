package com.oakmods.oaksenchantments.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

@Mod.EventBusSubscriber
public class CurseOfBlazeProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.CURSE_OF_BLAZE.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0
				|| EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.CURSE_OF_BLAZE.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0
				|| EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.CURSE_OF_BLAZE.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0
				|| EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.CURSE_OF_BLAZE.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0) {
			if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("nether_wastes")) || world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("soul_sand_valley"))
					|| world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("warped_forest")) || world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("crimson_forest"))) {
				entity.setSecondsOnFire(160);
			}
		}
	}
}
