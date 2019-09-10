package com.vxcompany.rover.world;

import java.util.Set;
import java.util.TreeSet;

public class World {
    private final int width;
    private final int height;
    private Set<Position> obstacles = new TreeSet<>();

    World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    Set<Position> getObstacles() {
        return obstacles;
    }

    void addObstacle(Position position) {
        obstacles.add(position);
    }

    public Position move(Position start, Direction direction) {
        validatePosition(start);
        Position newPosition = calculateNewPosition(start, direction);

        // check for obstacles
        if (obstacles.contains(newPosition)) {
            System.out.println("Computer says no");
            return start;
        }
        // world wrapping
        wrapPosition(newPosition);

        return newPosition;
    }

    private void validatePosition(Position position) {
        if (obstacles.contains(position)) {
            throw new IllegalStateException("There is an obstacle here!");
        }

        if (position.getX() < 0 || position.getX() >= width || position.getY() < 0 || position.getY() >= height) {
            throw new IllegalStateException("Position " + position + " is outside this world's grid");
        }
    }

    private Position calculateNewPosition(Position start, Direction direction) {
        switch (direction) {
            case NORTH:
                return new Position(start.getX(), start.getY() + 1);
            case EAST:
                return new Position(start.getX() + 1, start.getY());
            case SOUTH:
                return new Position(start.getX(), start.getY() - 1);
            case WEST:
                return new Position(start.getX() - 1, start.getY());
            default:
                throw new UnsupportedOperationException("Unknown direction " + direction);
        }
    }

    private void wrapPosition(Position newPosition) {
        if (newPosition.getX() >= width) {
            newPosition.setX(0);
        } else if (newPosition.getX() == -1) {
            newPosition.setX(width);
        }

        if (newPosition.getY() >= height) {
            newPosition.setY(0);
        } else if (newPosition.getY() == -1) {
            newPosition.setY(height);
        }
    }
}
