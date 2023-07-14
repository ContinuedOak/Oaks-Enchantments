package com.oakmods.oaksenchantments.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import javax.annotation.Nullable;

import java.util.Iterator;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

@Mod.EventBusSubscriber
public class PiratesLuckProcedureProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.PIRATES_LUCK.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem) {
			if (world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("beach")) || world.getBiome(new BlockPos(x, y, z)).is(new ResourceLocation("desert"))) {
				if (Blocks.DIRT == (world.getBlockState(new BlockPos(x, y, z))).getBlock() || Blocks.COARSE_DIRT == (world.getBlockState(new BlockPos(x, y, z))).getBlock() || Blocks.PODZOL == (world.getBlockState(new BlockPos(x, y, z))).getBlock()
						|| Blocks.ROOTED_DIRT == (world.getBlockState(new BlockPos(x, y, z))).getBlock() || Blocks.SAND == (world.getBlockState(new BlockPos(x, y, z))).getBlock()
						|| Blocks.RED_SAND == (world.getBlockState(new BlockPos(x, y, z))).getBlock()) {
					if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.PIRATES_LUCK.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 1) {
						if (Math.random() < 0.2) {
							if (Math.random() < 0.16) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GOLD_NUGGET));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.16) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.IRON_NUGGET));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.16) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.16) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STICK));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.16) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.16) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.LEAD));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
				}
				if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.PIRATES_LUCK.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 2) {
					if (Math.random() < 0.3) {
						if (Math.random() < 0.16) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else if (Math.random() < 0.16) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GOLD_NUGGET));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else if (Math.random() < 0.16) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else if (Math.random() < 0.16) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STICK));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else if (Math.random() < 0.16) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else if (Math.random() < 0.16) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.LEAD));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.PIRATES_LUCK.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 3) {
				if (Math.random() < 0.4) {
					if (Math.random() < 0.006) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.DIAMOND));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("oaksenchantments:lucky_find"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					} else if (Math.random() < 0.16) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GOLD_INGOT));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.16) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STRING));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.16) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.STICK));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.16) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BONE));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.16) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.LEAD));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
