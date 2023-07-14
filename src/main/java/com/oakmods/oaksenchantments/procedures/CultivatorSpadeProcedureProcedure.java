package com.oakmods.oaksenchantments.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.Map;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

@Mod.EventBusSubscriber
public class CultivatorSpadeProcedureProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem
				&& EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.CULTIVATOR.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 0) {
			if (((world.getBlockState(new BlockPos(x + 1, y + 0, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.DIRT
					|| (world.getBlockState(new BlockPos(x + 1, y + 0, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.GRASS) && (world.getBlockState(new BlockPos(x + 1, y + 1, z + 0))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = new BlockPos(x + 1, y + 0, z + 0);
					BlockState _bs = Blocks.DIRT_PATH.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (((world.getBlockState(new BlockPos(x - 1, y + 0, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.DIRT
					|| (world.getBlockState(new BlockPos(x - 1, y + 0, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.GRASS) && (world.getBlockState(new BlockPos(x - 1, y + 1, z + 0))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = new BlockPos(x - 1, y + 0, z + 0);
					BlockState _bs = Blocks.DIRT_PATH.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (((world.getBlockState(new BlockPos(x + 0, y + 0, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.DIRT
					|| (world.getBlockState(new BlockPos(x + 0, y + 0, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.GRASS) && (world.getBlockState(new BlockPos(x + 0, y + 1, z + 1))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = new BlockPos(x + 0, y + 0, z + 1);
					BlockState _bs = Blocks.DIRT_PATH.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (((world.getBlockState(new BlockPos(x + 0, y + 0, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.DIRT
					|| (world.getBlockState(new BlockPos(x + 0, y + 0, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.GRASS) && (world.getBlockState(new BlockPos(x + 0, y + 1, z - 1))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = new BlockPos(x + 0, y + 0, z - 1);
					BlockState _bs = Blocks.DIRT_PATH.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (((world.getBlockState(new BlockPos(x + 1, y + 0, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.DIRT
					|| (world.getBlockState(new BlockPos(x + 1, y + 0, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.GRASS) && (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = new BlockPos(x + 1, y + 0, z + 1);
					BlockState _bs = Blocks.DIRT_PATH.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (((world.getBlockState(new BlockPos(x + 1, y + 0, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.DIRT
					|| (world.getBlockState(new BlockPos(x + 1, y + 0, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.GRASS) && (world.getBlockState(new BlockPos(x + 0, y + 1, z - 1))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = new BlockPos(x + 1, y + 0, z - 1);
					BlockState _bs = Blocks.DIRT_PATH.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (((world.getBlockState(new BlockPos(x - 1, y + 0, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.DIRT
					|| (world.getBlockState(new BlockPos(x - 1, y + 0, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.GRASS) && (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = new BlockPos(x - 1, y + 0, z + 1);
					BlockState _bs = Blocks.DIRT_PATH.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (((world.getBlockState(new BlockPos(x - 1, y + 0, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.DIRT
					|| (world.getBlockState(new BlockPos(x - 1, y + 0, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.GRASS) && (world.getBlockState(new BlockPos(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR) {
				{
					BlockPos _bp = new BlockPos(x - 1, y + 0, z - 1);
					BlockState _bs = Blocks.DIRT_PATH.defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
						if (_property != null && _bs.getValue(_property) != null)
							try {
								_bs = _bs.setValue(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
	}
}
