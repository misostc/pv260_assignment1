package cz.muni.fi.pv260.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Color color;
    private List<Point> points;
    private Direction currentDirection;

    public Player(Point startingPoint, Direction startingDirection, Color color) {
        this.currentDirection = startingDirection;
        this.color = color;
        points = new ArrayList<>();
        points.add(startingPoint);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public Point getLatestPoint() {
        return points.get(points.size() - 1);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public Color getColor() {
        return color;
    }

}
