package fr.awildelephant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerExecutorTest {

    @Test
    void it_should_execute_a_single_mower_program() {
        assertExecutionOutputs(
                "5 5\n"
                        + "1 2 N\n"
                        + "GAGAGAGAA",

                "1 3 N");
    }

    @Test
    void it_should_execute_the_example_given_in_the_problem_statement() {
        assertExecutionOutputs(
                "5 5\n"
                        + "1 2 N\n"
                        + "GAGAGAGAA\n"
                        + "3 3 E\n"
                        + "AADAADADDA",

                "1 3 N\n"
                        + "5 1 E"
        );
    }

    private void assertExecutionOutputs(String input, String expectedOutput) {
        assertEquals(expectedOutput, MowerExecutor.execute(input));
    }
}