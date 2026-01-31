package net.arclight.programmableminecarts.block.entity;

import net.arclight.programmableminecarts.ProgrammableMinecarts;
import net.arclight.programmableminecarts.block.ModBlocks;
import net.arclight.programmableminecarts.block.entity.custom.ProgrammerBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ProgrammerBlockEntity> PROGRAMMER_BLOCK_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(ProgrammableMinecarts.MOD_ID, "programmer_be"),
            BlockEntityType.Builder.create(ProgrammerBlockEntity::new , ModBlocks.PROGRAMMER_BLOCK).build(null));


    public static void registerModBlockEntities() {
        ProgrammableMinecarts.LOGGER.info("Registering Mod Block Entities for " + ProgrammableMinecarts.MOD_ID);
    }
}
