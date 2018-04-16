package fr.awildelephant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static fr.awildelephant.Orientation.NORTH;
import static fr.awildelephant.Position.position;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerProgramTest {

    private MowerProgram program;

    @BeforeEach
    void setUp() {
        program = new MowerProgram(new Map(position(2, 3)), position(1, 1), NORTH);
    }

    @Test
    void it_should_return_the_starting_state_of_the_mower_if_no_command_is_executed() {
        assertProgramOutputs("1 1 N");
    }

    @Test
    void turnRight_should_move_the_mower_90_degrees_to_the_right() {
        program.turnRight();

        assertProgramOutputs("1 1 E");
    }

    @Test
    void turnRight_should_move_the_mower_90_degrees_to_the_left() {
        program.turnLeft();

        assertProgramOutputs("1 1 W");
    }

    @Test
    void advance_should_move_the_mower_in_its_current_orientation() {
        program.advance();

        assertProgramOutputs("1 2 N");
    }

    @Test
    void advance_should_not_move_the_mower_if_it_would_make_it_out_of_bounds() {
        program.turnLeft();
        program.advance();
        program.advance();

        assertProgramOutputs("0 1 W");
    }

    private void assertProgramOutputs(String s) {
        assertEquals(s, program.toString());
    }
}
