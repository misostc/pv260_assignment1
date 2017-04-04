package cz.muni.fi.pv260.engine.graphics;

import java.awt.*;

public class AwtUtils {
    public static boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {
        return displayModesDimensionsMatch(m1, m2) && displayModesBitDepthMatch(m1, m2) && displayModesRefreshRateMatch(m1, m2);
    }

    private static boolean displayModesRefreshRateMatch(DisplayMode m1, DisplayMode m2) {
        return m1.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || m2.getRefreshRate() == DisplayMode.REFRESH_RATE_UNKNOWN || m1.getRefreshRate() == m2.getRefreshRate();
    }

    private static boolean displayModesBitDepthMatch(DisplayMode m1, DisplayMode m2) {
        return m1.getBitDepth() == DisplayMode.BIT_DEPTH_MULTI || m2.getBitDepth() == DisplayMode.BIT_DEPTH_MULTI || m1.getBitDepth() == m2.getBitDepth();
    }

    private static boolean displayModesDimensionsMatch(DisplayMode m1, DisplayMode m2) {
        return m1.getWidth() == m2.getWidth() && m1.getHeight() == m2.getHeight();
    }
}
