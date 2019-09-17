package com.vxcompany.rover.world;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MarsGenerator implements IWorldGenerator {
    private static final int MINSIZE = 3;
    private final Random random = new Random();

    @Override
    public World generate() {
        var width = 4;
        var height = 4;

        List<Position> obstacles = Arrays.asList(new Position(1, 2), new Position(3, 1));
        System.out.println("Generating Mars: a " + width + "x" + height + " world with obstacles " + obstacles);

        World mars = new World(width, height);
        mars.addObstacles(obstacles);

        return mars;
    }
}
