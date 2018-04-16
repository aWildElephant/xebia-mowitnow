package fr.awildelephant;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static fr.awildelephant.Orientation.*;
import static fr.awildelephant.Position.position;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrientationTest {

    @ParameterizedTest(name = "{index} - Starting at ({0}) and going {1} brings us to ({2})")
    @MethodSource("advanceParams")
    void advance_should_move_to_the_expected_position(Position start, Orientation direction, Position expected) {
        assertEquals(expected, direction.advance(start));
    }

    @ParameterizedTest(name = "{index} - Facing {0} and then turning left makes us face {1}")
    @MethodSource("turnLeftParams")
    void turnLeft_should_make_us_face_the_correct_orientation(Orientation start, Orientation expectedAfterTurningLeft) {
        assertEquals(expectedAfterTurningLeft, start.turnLeft());
    }

    @ParameterizedTest(name = "{index} - Facing {0} and then turning right makes us face {1}")
    @MethodSource("turnRightParams")
    void turnRight_should_make_us_face_the_correct_orientation(Orientation start, Orientation expectedAfterTurningRight) {
        assertEquals(expectedAfterTurningRight, start.turnRight());
    }

    private static Object[][] turnLeftParams() {
        return new Object[][]{
                new Object[]{NORTH, WEST},
                new Object[]{WEST, SOUTH},
                new Object[]{SOUTH, EAST},
                new Object[]{EAST, NORTH}
        };
    }

    private static Object[][] turnRightParams() {
        return new Object[][]{
                new Object[]{NORTH, EAST},
                new Object[]{EAST, SOUTH},
                new Object[]{SOUTH, WEST},
                new Object[]{WEST, NORTH}
        };
    }

    private static Object[][] advanceParams() {
        return new Object[][]{
                new Object[]{position(1, 1), NORTH, position(1, 2)},
                new Object[]{position(1, 1), SOUTH, position(1, 0)},
                new Object[]{position(1, 1), EAST, position(2, 1)},
                new Object[]{position(1, 1), WEST, position(0, 1)}
        };
    }
}
