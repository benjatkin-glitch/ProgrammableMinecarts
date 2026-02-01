package net.arclight.programmableminecarts.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.RailShape;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;

public class RailPoints extends AbstractRailBlock {
    public static final EnumProperty<RailShape> SHAPE = Properties.RAIL_SHAPE;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public RailPoints(Settings settings) {
        super(false, settings);

        this.setDefaultState(this.stateManager.getDefaultState()
                .with(SHAPE, RailShape.NORTH_SOUTH)
                .with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, WATERLOGGED);
    }

    @Override
    protected MapCodec<? extends AbstractRailBlock> getCodec() {
        return null;
    }

    @Override
    public Property<RailShape> getShapeProperty() {
        return SHAPE;
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // Instead of calling super (which triggers the crash),
        // we manually return a default state.
        return this.getDefaultState().with(SHAPE, RailShape.NORTH_SOUTH);
    }
}