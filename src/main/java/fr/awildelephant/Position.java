package fr.awildelephant;

public final class Position {

    private final int x;
    private final int y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Position position(int x, int y) {
        return new Position(x, y);
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int hashCode() {
        return x * 32 + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }

        final Position other = (Position) obj;

        return x == other.x && y == other.y;
    }
}
