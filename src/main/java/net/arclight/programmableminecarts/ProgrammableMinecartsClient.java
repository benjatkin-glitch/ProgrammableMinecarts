package net.arclight.programmableminecarts;

import net.arclight.programmableminecarts.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ProgrammableMinecartsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAIL_POINTS, RenderLayer.getCutout()); // Makes the RailPoints block transparent
    }
}
