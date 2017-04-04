package cz.muni.fi.pv260.tron.model;

import cz.muni.fi.pv260.engine.collision.Collidable;
import cz.muni.fi.pv260.engine.model.Direction;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TronPlayer implements Collidable{
    private final Color color;
    private List<Point> points;
    private Direction currentDirection;

    public TronPlayer(Point startingPoint, Direction startingDirection, Color color) {
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

    @Override
    public Collection<Point> getBoundingPoints() {
        return Collections.unmodifiableCollection(points);
    }

    public Collidable tail(){
        return () -> points.subList(1,points.size());
    }
}
