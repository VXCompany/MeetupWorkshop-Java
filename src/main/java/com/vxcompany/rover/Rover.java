package com.vxcompany.rover;

import com.vxcompany.rover.world.Direction;
import com.vxcompany.rover.world.IWorldGenerator;
import com.vxcompany.rover.world.Position;
import com.vxcompany.rover.world.World;

import java.util.ArrayList;
import java.util.List;

public class Rover {
    /**
     * Kata: Mars-rover
     * <p>
     * Alle features testen
     * <p>
     * 4 bugs:
     * een nieuwe rover wijst altijd naar N
     * achteruit rijden rijd ook vooruit
     * array is 1 groter dan dat hij is (dus iets met arrays en indexen)
     * <p>
     * voor obstacle: leer een exceptie te testen
     * <p>
     * vage edge cases bugs:
     * out of memory exception (20)
     * <p>
     * Zelf code maken, volgens plaatje
     * <p>
     * Voor mensen die snel klaar zijn: maak een integratietest
     * <p>
     * Rover(IWorldGenerator, Position, Direction)
     * <p>
     * RandomWorldGenerator genereert een world met een Grid en Obstacles
     */
    private World world;

    private Position position;

    private Direction orientation = Direction.NORTH;

    public Rover(IWorldGenerator generator, Position initialPosition, Direction initialOrientation) {
        this.world = generator.generate();
        this.position = initialPosition;

        System.out.println("Rover entered the world at position " + initialPosition + " facing " + initialOrientation);
    }

    public void execute(List<Command> commands) {
        List<Command> validatedCommands = validateCommands(commands);
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

    private List<Command> validateCommands(List<Command> input) {
        List<Command> commands = new ArrayList<>();

        for (int i = 0; i < determineNumberOfElements(input); i++) {
            commands.add(input.get(i));
        }

        int memoryLimit = 10;
        if (input.size() > memoryLimit) {
            throw new OutOfMemoryError();
        }

        return commands;
    }

    private int determineNumberOfElements(List<Command> input) {
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
