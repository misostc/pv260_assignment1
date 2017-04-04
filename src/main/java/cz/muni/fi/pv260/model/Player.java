package cz.muni.fi.pv260.model;

import cz.muni.fi.pv260.collision.Collidable;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player implements Collidable{
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

    @Override
    public Rectangle2D getBoundingBox() {
        Rectangle result = new Rectangle();
        points.forEach(p -> result.add(p));
        return result;
    }

    @Override
    public boolean collidesWith(Collidable other) {
        if (other == null){
            return false;
        }
        if (!(other instanceof Player)){
            return false;
        }
        if (other == this){
            return collidesWithSelf();
        }
        final Player player = (Player)other;
        return collidesWithOtherPlayer(player);

    }

    private boolean collidesWithSelf() {
        for (int i = 0; i < points.size() - 1; i++) {
            if (getLatestPoint().equals(points.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean collidesWithOtherPlayer(Player other){
        for (Point selfPoint : points){
            for (Point otherPoint : other.getPoints()){
                if (selfPoint.equals(otherPoint)){
                    return true;
                }
            }
        }
        return false;
    }
}
