package com.vxcompany.rover.world;

import java.util.Random;

public class RandomWorldGenerator implements IWorldGenerator {
    private static final int MINSIZE = 3;
    private final Random random = new Random();

    @Override
    public World generate() {
        var width = random.nextInt(11 - MINSIZE) + MINSIZE;
        var height = random.nextInt(11 - MINSIZE) + MINSIZE;

        var maxObstacles = random.nextInt(width * height / 2);
        System.out.println("Generating " + width + "x" + height + " world with max " + maxObstacles + " obstacles");

        World world = new World(width, height);
        addObstacles(world, maxObstacles);

        return world;
    }

    private void addObstacles(World world, int numberOfObstacles) {
        var width = world.getWidth();
        var height = world.getHeight();

        for (int i = 0; i < numberOfObstacles; i++) {
            Position obstaclePosition = new Position(random.nextInt(width - 1) + 1, random.nextInt(height - 1) + 1);
            world.addObstacle(obstaclePosition);
        }
        System.out.println("Obstacles generated at " + world.getObstacles());
    }
}
