package com.vxcompany.rover;

import com.vxcompany.rover.world.Direction;
import com.vxcompany.rover.world.MarsGenerator;
import com.vxcompany.rover.world.Position;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.vxcompany.rover.Command.MOVE_FORWARD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    @Test
    public void example() {
        // Given
        List<Command> commands = Arrays.asList(MOVE_FORWARD, MOVE_FORWARD, MOVE_FORWARD);
        Rover testRover = new Rover(new MarsGenerator(), new Position(1, 1), Direction.NORTH);

        // When
        testRover.execute(commands);

        // Then
        assertEquals(new Position(1, 4), testRover.getPosition());
        assertEquals(Direction.NORTH, testRover.getOrientation());
    }
}
