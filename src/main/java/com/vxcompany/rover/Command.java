package com.vxcompany.rover;

public enum Command {
    TURN_LEFT('l'),
    TURN_RIGHT('r'),
    MOVE_FORWARD('f'),
    MOVE_BACKWARD('b');

    private Character input;

    private Command(Character input) {
        this.input = input;
    }

    public static Command valueOf(Character character) {
        for (Command command : values()) {
            if (command.input.equals(character)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Unknown input: '" + character + "'");
    }
}
