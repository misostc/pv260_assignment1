package cz.muni.fi.pv260.engine.collision;

import java.awt.geom.Rectangle2D;

public interface Collidable {
    Rectangle2D getBoundingBox();
    boolean collidesWith(Collidable other);
}
