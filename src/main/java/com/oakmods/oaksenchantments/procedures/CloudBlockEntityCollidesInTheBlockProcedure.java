package com.oakmods.oaksenchantments.procedures;

import net.minecraft.world.entity.Entity;

public class CloudBlockEntityCollidesInTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
	}
}
