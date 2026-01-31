package net.arclight.programmableminecarts;

import net.arclight.programmableminecarts.block.ModBlocks;
import net.arclight.programmableminecarts.block.entity.ModBlockEntities;
import net.arclight.programmableminecarts.item.ModItemGroups;
import net.arclight.programmableminecarts.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgrammableMinecarts implements ModInitializer {
	public static final String MOD_ID = "programmableminecarts";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlockEntities.registerModBlockEntities();
		ModBlocks.registerModBlocks();
	}
}