package com.vxcompany.rover;

import com.vxcompany.rover.world.Direction;
import com.vxcompany.rover.world.Position;
import com.vxcompany.rover.world.RandomWorldGenerator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> commands = Arrays.asList('f', 'f', 'f');

        new Rover(new RandomWorldGenerator(), new Position(0, 0), Direction.NORTH).execute(commands);
    }
}
