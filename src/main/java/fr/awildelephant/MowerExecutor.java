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
        final int topRightCornerX = input.nextInt();
        final int topRightCornerY = input.nextInt();

        final Map map = new Map(position(topRightCornerX, topRightCornerY));

        return executeAllMowerPrograms(map);
    }

    private String executeAllMowerPrograms(Map map) {
        final StringJoiner joiner = new StringJoiner("\n");

        while (input.hasNextInt()) {
            joiner.add(executeSingleMowerProgram(map));
        }

        return joiner.toString();
    }

    private String executeSingleMowerProgram(Map map) {
        final int x = input.nextInt();
        final int y = input.nextInt();
        final String orientationSymbol = input.next();

        final Position startingPosition = position(x, y);
        final Orientation startingOrientation = orientation(orientationSymbol);

        final MowerProgram program = new MowerProgram(map, startingPosition, startingOrientation);

        goToInstructionsLine();

        final String instructions = input.nextLine();

        char action;
        for (int i = 0; i < instructions.length(); i++) {
            action = instructions.charAt(i);

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

    private void goToInstructionsLine() {
        input.nextLine();
    }

    private Orientation orientation(String symbol) {
        switch (symbol.charAt(0)) {
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
