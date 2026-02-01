package net.arclight.programmableminecarts.block.entity.custom;

import net.arclight.programmableminecarts.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;


public class ProgrammerBlockEntity extends BlockEntity {
    public ProgrammerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PROGRAMMER_BLOCK_BE, pos, state);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        checkFacingForMinecart(world, pos, state);
    }

    public void checkFacingForMinecart(World world, BlockPos pos, BlockState state) {
        Direction facing = state.get(Properties.HORIZONTAL_FACING);
        BlockPos targetPos = pos.offset(facing);
        BlockState targetState = world.getBlockState(targetPos);
        if(targetState.isIn(BlockTags.RAILS));
    }
}
