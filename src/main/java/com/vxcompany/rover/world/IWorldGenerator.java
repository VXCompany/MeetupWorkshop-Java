package com.vxcompany.rover.world;

public interface IWorldGenerator {
    /**
     * Generates a world with a number of obstacles in it.
     *
     * @return World instance
     */
    World generate();
}
