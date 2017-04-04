package cz.muni.fi.pv260.engine.model;

public enum Direction {
    UP, RIGHT, DOWN, LEFT;

    public static Direction rotateClockwise(Direction direction) {
        switch (direction) {
            case UP:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
        }
        throw new IllegalArgumentException("Unrecognized direction.");
    }

    public static Direction rotateCounterClockwise(Direction direction) {
        switch (direction) {
            case UP:
                return LEFT;
            case RIGHT:
                return UP;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
        }
        throw new IllegalArgumentException("Unrecognized direction.");
    }
}
