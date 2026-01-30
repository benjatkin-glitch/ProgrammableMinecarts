package net.arclight.programmableminecarts.block;

import net.arclight.programmableminecarts.ProgrammableMinecarts;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block LITHIUM_BLOCK = registerBlock("lithium_block", new Block(AbstractBlock.Settings.create().strength(2f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ProgrammableMinecarts.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ProgrammableMinecarts.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));

    }

    public static void registerModBlocks() {
        ProgrammableMinecarts.LOGGER.info("Registering Mod Blocks for " + ProgrammableMinecarts.MOD_ID);
    }
}
