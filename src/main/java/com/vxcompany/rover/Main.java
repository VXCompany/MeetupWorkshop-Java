package com.vxcompany.rover;

import com.vxcompany.rover.world.Direction;
import com.vxcompany.rover.world.Position;
import com.vxcompany.rover.world.RandomWorldGenerator;

import java.util.Arrays;
import java.util.List;

import static com.vxcompany.rover.Command.MOVE_FORWARD;

public class Main {
    public static void main(String[] args) {
        List<Command> commands = Arrays.asList(MOVE_FORWARD, MOVE_FORWARD, MOVE_FORWARD);

        new Rover(new RandomWorldGenerator(), new Position(0, 0), Direction.NORTH).execute(commands);
    }
}
