package net.arclight.programmableminecarts.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.state.StateManager;
import java.util.List;

public class ProgrammerBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public ProgrammerBlock(Settings settings) {

        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }


    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }


    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public void checkFacingForMinecart(World world, BlockPos pos, BlockState state) {
        Direction facing = state.get(Properties.HORIZONTAL_FACING);
        BlockPos targetPos = pos.offset(facing);
        Box detectionBox = new Box(targetPos);
        List<AbstractMinecartEntity> minecarts = world.getEntitiesByClass(
                AbstractMinecartEntity.class,
                detectionBox,
                entity -> true
        );

        if(!minecarts.isEmpty()) {
            for(AbstractMinecartEntity minecart : minecarts) {
                minecart.setVelocity(Vec3d.ZERO);
                minecart.velocityDirty = true;
            }
        }
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    }


