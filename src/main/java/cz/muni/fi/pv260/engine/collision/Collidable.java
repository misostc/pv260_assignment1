package cz.muni.fi.pv260.engine.collision;

import java.awt.*;
import java.util.Collection;

public interface Collidable {
    Collection<Point> getBoundingPoints();
}
