package com.vxcompany.rover;

import com.vxcompany.rover.world.Direction;
import com.vxcompany.rover.world.Position;
import com.vxcompany.rover.world.RandomWorldGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {
    @Test
    public void exampleWithRandom() {
        // Given
        List<Character> commands = Arrays.asList('f', 'f', 'f');
        Rover testRover = new Rover(new RandomWorldGenerator(), new Position(1, 1), Direction.NORTH);

        // When
        testRover.execute(commands);

        // Then
        assertEquals(new Position(1, 4), testRover.getPosition());
        assertEquals(Direction.NORTH, testRover.getOrientation());
    }
}
