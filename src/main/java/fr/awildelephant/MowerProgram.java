package fr.awildelephant;

public class MowerProgram {

    private final Map map;

    private Position currentPosition;
    private Orientation currentOrientation;

    MowerProgram(Map map, Position startingPosition, Orientation startingOrientation) {
        this.map = map;
        this.currentPosition = startingPosition;
        this.currentOrientation = startingOrientation;
    }

    void turnRight() {
        currentOrientation = currentOrientation.turnRight();
    }

    void turnLeft() {
        currentOrientation = currentOrientation.turnLeft();
    }

    void advance() {
        final Position targetPosition = currentOrientation.advance(currentPosition);

        if (map.isWithinBounds(targetPosition)) {
            currentPosition = targetPosition;
        }
    }

    @Override
    public String toString() {
        return currentPosition + " " + currentOrientation;
    }
}
