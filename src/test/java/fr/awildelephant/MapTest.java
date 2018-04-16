package fr.awildelephant;

import org.junit.jupiter.api.Test;

import static fr.awildelephant.Position.position;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapTest {

    private static final int TOP_RIGHT_X = 3;
    private static final int TOP_RIGHT_Y = 5;
    private static final Map MAP = new Map(position(TOP_RIGHT_X, TOP_RIGHT_Y));

    @Test
    void isWithinBounds_should_return_false_if_the_position_is_south_of_the_map() {
        assertFalse(MAP.isWithinBounds(position(-1, 0)));
    }

    @Test
    void isWithinBounds_should_return_false_if_the_position_is_north_of_the_map() {
        assertFalse(MAP.isWithinBounds(position(TOP_RIGHT_X + 1, 0)));
    }

    @Test
    void isWithinBounds_should_return_false_if_the_position_is_west_of_the_map() {
        assertFalse(MAP.isWithinBounds(position(0, -1)));
    }

    @Test
    void isWithinBounds_should_return_false_if_the_position_is_east_of_the_map() {
        assertFalse(MAP.isWithinBounds(position(0, TOP_RIGHT_Y + 1)));
    }

    @Test
    void isWithinBounds_should_return_true_if_the_position_is_in_the_map() {
        assertTrue(MAP.isWithinBounds(position(0, 0)));
    }
}