package com.vxcompany.rover.world;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction reverse() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction clockwise() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction counterClockwise() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalStateException();
        }
    }
}
