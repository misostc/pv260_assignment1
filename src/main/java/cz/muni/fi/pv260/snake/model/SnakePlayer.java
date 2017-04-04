package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.engine.model.Direction;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by micha on 04.04.2017.
 */
public class SnakePlayer {
    private final Deque<Point> snake;
    private final Color color;
    private Direction direction;

    public SnakePlayer(Point startingLocation, Direction direction, Color color) {
        this.direction = direction;
        this.color = color;

        this.snake = new ArrayDeque<>();
        this.snake.add(startingLocation);
    }

    public Deque<Point> getSnake() {
        return snake;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Color getColor() {
        return color;
    }
}
