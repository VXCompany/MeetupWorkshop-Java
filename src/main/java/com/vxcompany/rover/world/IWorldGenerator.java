package com.vxcompany.rover.world;

public interface IWorldGenerator {
    /**
     * Generates a random world with a number of obstacles in it.
     *
     * @param width  width of the world
     * @param height height of the world
     * @return
     */
    World generate(int width, int height);
}
