package net.arclight.programmableminecarts.block.entity.custom;

import net.arclight.programmableminecarts.ProgrammableMinecarts;
import net.arclight.programmableminecarts.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

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
        Box detectionBox = new Box(targetPos);
        List<AbstractMinecartEntity> minecarts = world.getEntitiesByClass(
                AbstractMinecartEntity.class,
                detectionBox,
                entity -> true
        );

        if (!minecarts.isEmpty()) {
            for (AbstractMinecartEntity minecart : minecarts) {
                double distance = Math.sqrt(targetPos.getSquaredDistanceFromCenter(minecart.getX(), minecart.getY(), minecart.getZ()));
                Vec3d velocity = minecart.getVelocity();
                if (distance < 0.45) {
                    minecart.setVelocity(Vec3d.ZERO);
                } else {
                    minecart.setVelocity(velocity.normalize().multiply(distance / 10));
                }
                minecart.velocityDirty = true;
            }
        }
    }
}
