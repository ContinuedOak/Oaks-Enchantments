package com.oakmods.oaksenchantments.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.common.TierSortingRegistry;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.oakmods.oaksenchantments.init.OaksenchantmentsModEnchantments;

@Mod.EventBusSubscriber
public class MiningHammerProcedureProcedure {
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
			if (EnchantmentHelper.getItemEnchantmentLevel(OaksenchantmentsModEnchantments.MINING_HAMMER.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 0) {
				if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
					if ((world.getBlockState(new BlockPos(x + 0, y + 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
						public int getHarvestLevel(BlockState _bs) {
							return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
						}
					}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y + 1, z + 0))) < 3) {
						{
							BlockPos _pos = new BlockPos(x + 0, y + 1, z + 0);
							Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y + 1, z + 0), null);
							world.destroyBlock(_pos, false);
						}
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
						if ((world.getBlockState(new BlockPos(x + 1, y + 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
							public int getHarvestLevel(BlockState _bs) {
								return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
							}
						}.getHarvestLevel(world.getBlockState(new BlockPos(x + 1, y + 1, z + 0))) < 3) {
							{
								BlockPos _pos = new BlockPos(x + 1, y + 1, z + 0);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 1, y + 1, z + 0), null);
								world.destroyBlock(_pos, false);
							}
							((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
									.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
							if ((world.getBlockState(new BlockPos(x - 1, y + 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
								public int getHarvestLevel(BlockState _bs) {
									return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
								}
							}.getHarvestLevel(world.getBlockState(new BlockPos(x - 1, y + 1, z + 0))) < 3) {
								{
									BlockPos _pos = new BlockPos(x - 1, y + 1, z + 0);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 1, y + 1, z + 0), null);
									world.destroyBlock(_pos, false);
								}
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
										.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
								if ((world.getBlockState(new BlockPos(x + 1, y + 0, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
									public int getHarvestLevel(BlockState _bs) {
										return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
									}
								}.getHarvestLevel(world.getBlockState(new BlockPos(x + 1, y + 0, z + 0))) < 3) {
									{
										BlockPos _pos = new BlockPos(x + 1, y + 0, z + 0);
										Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 1, y + 0, z + 0), null);
										world.destroyBlock(_pos, false);
									}
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
											.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
									if ((world.getBlockState(new BlockPos(x - 1, y + 0, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
										public int getHarvestLevel(BlockState _bs) {
											return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
										}
									}.getHarvestLevel(world.getBlockState(new BlockPos(x - 1, y + 0, z + 0))) < 3) {
										{
											BlockPos _pos = new BlockPos(x - 1, y + 0, z + 0);
											Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 1, y + 0, z + 0), null);
											world.destroyBlock(_pos, false);
										}
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
												.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
										if ((world.getBlockState(new BlockPos(x + 0, y - 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
											public int getHarvestLevel(BlockState _bs) {
												return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
											}
										}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y - 1, z + 0))) < 3) {
											{
												BlockPos _pos = new BlockPos(x + 0, y - 1, z + 0);
												Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y - 1, z + 0), null);
												world.destroyBlock(_pos, false);
											}
											((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
													.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
											if ((world.getBlockState(new BlockPos(x + 1, y - 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
												public int getHarvestLevel(BlockState _bs) {
													return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
												}
											}.getHarvestLevel(world.getBlockState(new BlockPos(x + 1, y - 1, z + 0))) < 3) {
												{
													BlockPos _pos = new BlockPos(x + 1, y - 1, z + 0);
													Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 1, y - 1, z + 0), null);
													world.destroyBlock(_pos, false);
												}
												((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
														.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
												if ((world.getBlockState(new BlockPos(x - 1, y - 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
													public int getHarvestLevel(BlockState _bs) {
														return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
													}
												}.getHarvestLevel(world.getBlockState(new BlockPos(x - 1, y - 1, z + 0))) < 3) {
													{
														BlockPos _pos = new BlockPos(x - 1, y - 1, z + 0);
														Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 1, y - 1, z + 0), null);
														world.destroyBlock(_pos, false);
													}
													((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
															.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
												}
											}
										}
									}
								}
							}
						}
					}
				} else if ((entity.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.EAST) {
					if ((world.getBlockState(new BlockPos(x + 0, y + 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
						public int getHarvestLevel(BlockState _bs) {
							return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
						}
					}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y + 1, z + 0))) < 3) {
						{
							BlockPos _pos = new BlockPos(x + 0, y + 1, z + 0);
							Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y + 1, z + 0), null);
							world.destroyBlock(_pos, false);
						}
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
						if ((world.getBlockState(new BlockPos(x + 0, y + 1, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
							public int getHarvestLevel(BlockState _bs) {
								return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
							}
						}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y + 1, z + 1))) < 3) {
							{
								BlockPos _pos = new BlockPos(x + 0, y + 1, z + 1);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y + 1, z + 1), null);
								world.destroyBlock(_pos, false);
							}
							((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
									.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
							if ((world.getBlockState(new BlockPos(x - 0, y + 1, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
								public int getHarvestLevel(BlockState _bs) {
									return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
								}
							}.getHarvestLevel(world.getBlockState(new BlockPos(x - 0, y + 1, z - 1))) < 3) {
								{
									BlockPos _pos = new BlockPos(x - 0, y + 1, z - 1);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 0, y + 1, z - 1), null);
									world.destroyBlock(_pos, false);
								}
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
										.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
								if ((world.getBlockState(new BlockPos(x + 0, y + 0, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
									public int getHarvestLevel(BlockState _bs) {
										return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
									}
								}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y + 0, z + 1))) < 3) {
									{
										BlockPos _pos = new BlockPos(x + 0, y + 0, z + 1);
										Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y + 0, z + 1), null);
										world.destroyBlock(_pos, false);
									}
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
											.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
									if ((world.getBlockState(new BlockPos(x - 0, y + 0, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
										public int getHarvestLevel(BlockState _bs) {
											return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
										}
									}.getHarvestLevel(world.getBlockState(new BlockPos(x - 0, y + 0, z - 1))) < 3) {
										{
											BlockPos _pos = new BlockPos(x - 0, y + 0, z - 1);
											Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 0, y + 0, z - 1), null);
											world.destroyBlock(_pos, false);
										}
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
												.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
										if ((world.getBlockState(new BlockPos(x + 0, y - 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
											public int getHarvestLevel(BlockState _bs) {
												return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
											}
										}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y - 1, z + 0))) < 3) {
											{
												BlockPos _pos = new BlockPos(x + 0, y - 1, z + 0);
												Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y - 1, z + 0), null);
												world.destroyBlock(_pos, false);
											}
											((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
													.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
											if ((world.getBlockState(new BlockPos(x + 0, y - 1, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
												public int getHarvestLevel(BlockState _bs) {
													return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
												}
											}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y - 1, z + 1))) < 3) {
												{
													BlockPos _pos = new BlockPos(x + 0, y - 1, z + 1);
													Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y - 1, z + 1), null);
													world.destroyBlock(_pos, false);
												}
												((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
														.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
												if ((world.getBlockState(new BlockPos(x - 0, y - 1, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
													public int getHarvestLevel(BlockState _bs) {
														return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bs.is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
													}
												}.getHarvestLevel(world.getBlockState(new BlockPos(x - 0, y - 1, z - 1))) < 3) {
													{
														BlockPos _pos = new BlockPos(x - 0, y - 1, z - 1);
														Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 0, y - 1, z - 1), null);
														world.destroyBlock(_pos, false);
													}
													((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
															.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
