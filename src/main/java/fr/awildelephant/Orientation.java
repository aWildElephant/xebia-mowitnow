package fr.awildelephant;

import static fr.awildelephant.Position.position;

public enum Orientation {

    EAST {
        @Override
        public Position advance(Position start) {
            return position(start.x() + 1, start.y());
        }

        @Override
        public Orientation turnLeft() {
            return NORTH;
        }

        @Override
        public Orientation turnRight() {
            return SOUTH;
        }
    }, NORTH {
        @Override
        public Position advance(Position start) {
            return position(start.x(), start.y() + 1);
        }

        @Override
        public Orientation turnLeft() {
            return WEST;
        }

        @Override
        public Orientation turnRight() {
            return EAST;
        }
    }, SOUTH {
        @Override
        public Position advance(Position start) {
            return position(start.x(), start.y() - 1);
        }

        @Override
        public Orientation turnLeft() {
            return EAST;
        }

        @Override
        public Orientation turnRight() {
            return WEST;
        }
    }, WEST {
        @Override
        public Position advance(Position start) {
            return position(start.x() - 1, start.y());
        }

        @Override
        public Orientation turnLeft() {
            return SOUTH;
        }

        @Override
        public Orientation turnRight() {
            return NORTH;
        }
    };

    public abstract Position advance(Position start);

    public abstract Orientation turnLeft();

    public abstract Orientation turnRight();
}
