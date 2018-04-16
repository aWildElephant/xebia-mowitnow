package fr.awildelephant;

final class Map {

    private final Position topRightCorner;

    Map(Position topRightCorner) {
        this.topRightCorner = topRightCorner;
    }

    boolean isWithinBounds(Position position) {
        return position.x() >= 0
                && position.x() <= topRightCorner.x()
                && position.y() >= 0
                && position.y() < topRightCorner.y();

    }
}
