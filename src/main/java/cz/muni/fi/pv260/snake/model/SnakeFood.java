package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.engine.collision.Collidable;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by micha on 04.04.2017.
 */
public class SnakeFood implements Collidable {

    private Point position;
    private final Color color;

    public SnakeFood(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Collection<Point> getBoundingPoints() {
        return Arrays.asList(position);
    }
}
