package cz.muni.fi.pv260.engine.collision;

import java.awt.*;
import java.util.Collection;

public class CollisionUtils {
    public static boolean collides(Collidable c1, Collidable c2){
        for (Point point : c1.getBoundingPoints()){
            for (Point other : c2.getBoundingPoints()){
                if (point.equals(other)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean collides(Collidable c1, Point point){
        for (Point collidablePoint : c1.getBoundingPoints()){
            if (collidablePoint.equals(point)){
                return true;
            }
        }
        return false;
    }
}
