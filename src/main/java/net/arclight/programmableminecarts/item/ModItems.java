package net.arclight.programmableminecarts.item;

import net.arclight.programmableminecarts.ProgrammableMinecarts;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LITHIUM_INGOT = registeritem("lithium_ingot", new Item(new Item.Settings()));
    public static final Item RAW_LITHIUM = registeritem("raw_lithium", new Item(new Item.Settings()));

    private static Item registeritem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ProgrammableMinecarts.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ProgrammableMinecarts.LOGGER.info("Registering Mod Items for" + ProgrammableMinecarts.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(LITHIUM_INGOT);
            fabricItemGroupEntries.add(RAW_LITHIUM);
        });
    }
}
