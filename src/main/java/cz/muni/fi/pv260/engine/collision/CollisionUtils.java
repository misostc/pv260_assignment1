package cz.muni.fi.pv260.engine.collision;

import java.awt.*;
import java.util.Collection;

public class CollisionUtils {
    public static boolean collides(Collidable c1, Collidable c2){
        return collidesPoints(c1.getBoundingPoints(),c2.getBoundingPoints());
    }
    public static boolean collides(Collidable c1, Collection<Point> points){
        return collidesPoints(c1.getBoundingPoints(),points);
    }
    private static boolean collidesPoints(Collection<Point> points, Collection<Point> otherPoints){
        for (Point point : points){
            for (Point other : otherPoints){
                if (point.equals(other)){
                    return true;
                }
            }
        }
        return false;
    }
}
