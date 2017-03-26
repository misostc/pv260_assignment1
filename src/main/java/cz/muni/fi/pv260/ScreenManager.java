package cz.muni.fi.pv260;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class ScreenManager {

    private final GraphicsDevice vc;

    public ScreenManager() {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = e.getDefaultScreenDevice();
    }

    public DisplayMode findFirstCompatibaleMode(DisplayMode[] modes) {

        DisplayMode goodModes[] = vc.getDisplayModes();
        for (DisplayMode mode : modes) {
            for (DisplayMode goodMode : goodModes) {
                if (displayModesMatch(mode, goodMode)) {
                    return mode;
                }
            }
        }
        return null;
    }

    private boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {
        if (m1.getWidth() != m2.getWidth() || m1.getHeight() != m2.getHeight()) {
            return false;
        }
        return !(m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && m1.getBitDepth() != m2.getBitDepth()) && !(m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && m1.getRefreshRate() != m2.getRefreshRate());
    }

    public void setFullScreen(DisplayMode dm) {
        JFrame f = new JFrame();
        f.setUndecorated(true);
        f.setIgnoreRepaint(true);
        f.setResizable(false);
        vc.setFullScreenWindow(f);

        if (dm != null && vc.isDisplayChangeSupported()) {
            try {
                vc.setDisplayMode(dm);
            } catch (Exception ex) {
            }
            f.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            BufferStrategy bs = w.getBufferStrategy();
            return (Graphics2D) bs.getDrawGraphics();
        } else {
            return null;
        }
    }

    public void update() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            BufferStrategy bs = w.getBufferStrategy();
            if (!bs.contentsLost()) {
                bs.show();
            }
        }
    }

    public Window getFullScreenWindow() {
        return vc.getFullScreenWindow();
    }

    public int getWidth() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            return w.getWidth();
        } else {
            return 0;
        }
    }

    public int getHeight() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            return w.getHeight();
        } else {
            return 0;
        }
    }

    public void restoreScreen() {
        Window w = vc.getFullScreenWindow();
        if (w != null) {
            w.dispose();
        }
        vc.setFullScreenWindow(null);
    }

}
