package fr.awildelephant;

public class MowerProgram {

    private Position currentPosition;
    private Orientation currentOrientation;

    MowerProgram(Position startingPosition, Orientation startingOrientation) {
        currentPosition = startingPosition;
        currentOrientation = startingOrientation;
    }

    void turnRight() {
        currentOrientation = currentOrientation.turnRight();
    }

    void turnLeft() {
        currentOrientation = currentOrientation.turnLeft();
    }

    void advance() {
        currentPosition = currentOrientation.advance(currentPosition);
    }

    @Override
    public String toString() {
        return currentPosition + " " + currentOrientation;
    }
}
