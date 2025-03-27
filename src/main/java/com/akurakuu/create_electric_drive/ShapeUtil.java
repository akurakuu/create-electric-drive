package com.akurakuu.create_electric_drive;

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShapeUtil {
    public VoxelShape shapeUp;
    public VoxelShape shapeDown;
    public VoxelShape shapeNorth;
    public VoxelShape shapeSouth;
    public VoxelShape shapeWest;
    public VoxelShape shapeEast;

    public ShapeUtil(double x1, double y1, double z1, double x2, double y2, double z2, Direction direction) {
//        CreateElectricDrive.LOGGER.error("Set them all up individually, you cunt!");
    }

    public ShapeUtil(
            VoxelShape shapeUp,
            VoxelShape shapeDown,
            VoxelShape shapeNorth,
            VoxelShape shapeSouth,
            VoxelShape shapeUpWest,
            VoxelShape shapeUpEast
    ) {
        this.shapeUp = shapeUp;
        this.shapeDown = shapeDown;
        this.shapeNorth = shapeNorth;
        this.shapeSouth = shapeSouth;
        this.shapeWest = shapeUpWest;
        this.shapeEast = shapeUpEast;

    }

    public VoxelShape getShape(Direction direction) {
        return switch (direction) {
            case UP -> this.shapeUp;
            case DOWN -> this.shapeDown;
            case NORTH -> this.shapeNorth;
            case SOUTH -> this.shapeSouth;
            case WEST -> this.shapeWest;
            case EAST -> this.shapeEast;
            default -> this.shapeUp;
        };
    }

    public static VoxelShape getShape(ShapeUtil shape, Direction direction) {
        return switch (direction) {
            case UP -> shape.shapeUp;
            case DOWN -> shape.shapeDown;
            case NORTH -> shape.shapeNorth;
            case SOUTH -> shape.shapeSouth;
            case WEST -> shape.shapeWest;
            case EAST -> shape.shapeEast;
            default -> shape.shapeUp;
        };
    }


    public static class Builder {
        private double x1, y1, z1, x2, y2, z2;
        private Direction direction;

        //        VoxelShape
        public Builder() {

        }

        public Builder box(double x1, double y1, double z1, double x2, double y2, double z2) {
            this.x1 = x1;
            this.y1 = y1;
            this.z1 = z1;
            this.x2 = x2;
            this.y2 = y2;
            this.z2 = z2;
            return this;
        }

        public Builder direction(Direction direction) {
            this.direction = direction;
            return this;
        }

        public ShapeUtil build() {
            return new ShapeUtil(x1, y1, z1, x2, y2, z2, direction);
        }
    }
}

