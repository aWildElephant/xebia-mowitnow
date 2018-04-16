package fr.awildelephant;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static fr.awildelephant.Position.position;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    void it_should_implement_equals_and_hashCode() {
        EqualsVerifier.forClass(Position.class).verify();
    }

    @Test
    void toString_should_print_x_and_y_separated_by_a_space() {
        assertEquals("14 4", position(14, 4).toString());
    }
}
