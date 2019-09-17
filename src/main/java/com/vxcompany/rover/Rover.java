package com.vxcompany.rover;

import com.vxcompany.rover.world.Direction;
import com.vxcompany.rover.world.IWorldGenerator;
import com.vxcompany.rover.world.Position;
import com.vxcompany.rover.world.World;

import java.util.ArrayList;
import java.util.List;

public class Rover {
    private World world;

    private Position position;

    private Direction orientation = Direction.NORTH;

    public Rover(IWorldGenerator generator, Position initialPosition, Direction initialOrientation) {
        this.world = generator.generate();
        this.position = initialPosition;

        System.out.println("Rover entered the world at position " + initialPosition + " facing " + initialOrientation);
    }

    public void execute(List<Character> commands) {
        List<Command> validatedCommands = determineCommands(commands);
        for (Command command : validatedCommands) {
            executeCommand(command);
        }
    }

    private void executeCommand(Command command) {
        switch (command) {
            case MOVE_FORWARD:
                position = world.move(position, orientation);
                break;
            case MOVE_BACKWARD:
                position = world.move(position, orientation.reverse());
                break;
            case TURN_LEFT:
                orientation = orientation.counterClockwise();
            case TURN_RIGHT:
                orientation = orientation.clockwise();
                break;
            default:
                throw new UnsupportedOperationException("Unknown command: " + command);
        }
        System.out.println("Executed " + command + ": rover is at " + position + " facing " + orientation);
    }

    private List<Command> determineCommands(List<Character> input) {
        List<Command> commands = new ArrayList<>();

        for (int i = 0; i < determineNumberOfElements(input); i++) {
            commands.add(Command.valueOf(input.get(i)));
        }

        int memoryLimit = 10;
        if (input.size() > memoryLimit) {
            throw new OutOfMemoryError();
        }

        return commands;
    }

    private int determineNumberOfElements(List<Character> input) {
        if (input == null) {
            return 0;

        }
        return Math.min(input.size(), 3);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getOrientation() {
        return orientation;
    }
}
