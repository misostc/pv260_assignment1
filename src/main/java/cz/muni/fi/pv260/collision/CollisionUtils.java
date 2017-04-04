package cz.muni.fi.pv260.collision;

/**
 * Created by priad on 03.04.2017.
 */
public class CollisionUtils {
    public static boolean collides(Collidable c1,Collidable c2){
        return c1.collidesWith(c2) || c2.collidesWith(c1);
    }
}
