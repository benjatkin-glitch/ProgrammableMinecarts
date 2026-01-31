package net.arclight.programmableminecarts.item;

import net.arclight.programmableminecarts.ProgrammableMinecarts;
import net.arclight.programmableminecarts.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PROGRAMMABLE_MINECARTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ProgrammableMinecarts.MOD_ID, "programmable_minecarts_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LITHIUM_INGOT))
                    .displayName(Text.translatable("itemgroup.programmableminecarts.programmable_minecarts_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_LITHIUM);
                        entries.add(ModBlocks.RAW_LITHIUM_BLOCK);
                        entries.add(ModItems.LITHIUM_INGOT);
                        entries.add(ModBlocks.LITHIUM_BLOCK);
                        entries.add(ModBlocks.LITHIUM_ORE);
                        entries.add(ModBlocks.LITHIUM_DEEPSLATE_ORE);

                    }).build());


    public static void registerItemGroups() {
        ProgrammableMinecarts.LOGGER.info("Registering Item Groups for" +ProgrammableMinecarts.MOD_ID);
    }
}
