package com.oakmods.oaksenchantments.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.SimpleContainer;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

@Mod.EventBusSubscriber
public class AutoSmeltingFortuneProcedureProcedure {
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
		ItemStack temp = ItemStack.EMPTY;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.AUTO_SMELTING_FORTUNE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 1) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem().isCorrectToolForDrops((world.getBlockState(new BlockPos(x, y, z)))) == true) {
					if (Math.random() < 0.5) {
						if ((world instanceof Level _lvlCanSmelt
								? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
								: false) == true) {
							temp = ((world instanceof Level _lvlSmeltResult
									&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
													.copy()
											: ItemStack.EMPTY);
							world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								if (_ist.hurt(2, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						} else {
							{
								BlockPos _pos = new BlockPos(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					} else if (Math.random() < 0.4) {
						if ((world instanceof Level _lvlCanSmelt
								? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
								: false) == true) {
							temp = ((world instanceof Level _lvlSmeltResult
									&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
													.copy()
											: ItemStack.EMPTY);
							world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								if (_ist.hurt(2, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						} else {
							{
								BlockPos _pos = new BlockPos(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					}
				}
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.AUTO_SMELTING_FORTUNE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 2) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem().isCorrectToolForDrops((world.getBlockState(new BlockPos(x, y, z)))) == true) {
					if (Math.random() < 0.5) {
						if ((world instanceof Level _lvlCanSmelt
								? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
								: false) == true) {
							temp = ((world instanceof Level _lvlSmeltResult
									&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
													.copy()
											: ItemStack.EMPTY);
							{
								ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								if (_ist.hurt(2, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
							world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							{
								BlockPos _pos = new BlockPos(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					} else if (Math.random() < 0.4) {
						if ((world instanceof Level _lvlCanSmelt
								? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
								: false) == true) {
							temp = ((world instanceof Level _lvlSmeltResult
									&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
													.copy()
											: ItemStack.EMPTY);
							world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								if (_ist.hurt(2, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						} else {
							{
								BlockPos _pos = new BlockPos(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					} else {
						if ((world instanceof Level _lvlCanSmelt
								? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
								: false) == true) {
							temp = ((world instanceof Level _lvlSmeltResult
									&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
													.copy()
											: ItemStack.EMPTY);
							world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								if (_ist.hurt(2, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						} else {
							{
								BlockPos _pos = new BlockPos(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					}
				}
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.AUTO_SMELTING_FORTUNE.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 3) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem().isCorrectToolForDrops((world.getBlockState(new BlockPos(x, y, z)))) == true) {
					if (Math.random() < 0.5) {
						if ((world instanceof Level _lvlCanSmelt
								? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
								: false) == true) {
							temp = ((world instanceof Level _lvlSmeltResult
									&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
													.copy()
											: ItemStack.EMPTY);
							world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								if (_ist.hurt(2, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						} else {
							{
								BlockPos _pos = new BlockPos(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					} else if (Math.random() < 0.4) {
						if ((world instanceof Level _lvlCanSmelt
								? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
								: false) == true) {
							temp = ((world instanceof Level _lvlSmeltResult
									&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
													.copy()
											: ItemStack.EMPTY);
							world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								if (_ist.hurt(2, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						} else {
							{
								BlockPos _pos = new BlockPos(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					} else {
						if ((world instanceof Level _lvlCanSmelt
								? _lvlCanSmelt.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt).isPresent()
								: false) == true) {
							temp = ((world instanceof Level _lvlSmeltResult
									&& _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).isPresent())
											? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult).get().getResultItem()
													.copy()
											: ItemStack.EMPTY);
							world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
							if (world instanceof Level _level && !_level.isClientSide())
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 3));
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), temp);
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
							{
								ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
								if (_ist.hurt(2, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						} else {
							{
								BlockPos _pos = new BlockPos(x, y, z);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					}
				}
			}
		}
	}
}
