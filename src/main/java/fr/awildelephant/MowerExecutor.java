package fr.awildelephant;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringJoiner;

import static fr.awildelephant.Orientation.*;
import static fr.awildelephant.Position.position;

final class MowerExecutor {

    private final Scanner input;

    static String execute(String inputString) {
        return new MowerExecutor(new Scanner(inputString)).execute();
    }

    private MowerExecutor(Scanner input) {
        this.input = input;
    }

    private String execute() {
        input.nextInt();
        input.nextInt();

        // TODO: map height and width is given but not used. I'm guessing we want to react if the mower becomes out of bounds.

        return executeAllMowerPrograms();
    }

    private String executeAllMowerPrograms() {
        final StringJoiner joiner = new StringJoiner("\n");

        while (input.hasNextInt()) {
            joiner.add(executeSingleMowerProgram());
        }

        return joiner.toString();
    }

    private String executeSingleMowerProgram() {
        final int x = input.nextInt();
        final int y = input.nextInt();
        final String orientationSymbol = input.next();

        final Position startingPosition = position(x, y);
        final Orientation startingOrientation = orientation(orientationSymbol);

        final MowerProgram program = new MowerProgram(startingPosition, startingOrientation);

        input.nextLine(); // Go to the instructions line

        final String instructions = input.nextLine();

        for (int i = 0; i < instructions.length(); i++) {
            char action = instructions.charAt(i);

            switch (action) {
                case 'A':
                    program.advance();
                    break;
                case 'D':
                    program.turnRight();
                    break;
                case 'G':
                    program.turnLeft();
                    break;
                default:
                    throw new InputMismatchException();
            }
        }

        return program.toString();
    }

    private Orientation orientation(String symbol) {
        char character = symbol.charAt(0);
        switch (character) {
            case 'E':
                return EAST;
            case 'N':
                return NORTH;
            case 'S':
                return SOUTH;
            case 'W':
                return WEST;
            default:
                throw new InputMismatchException();
        }
    }
}
