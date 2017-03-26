package cz.muni.fi.pv260;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class ScreenManager {

    private static final DisplayMode[] SUPPORTED_DISPLAY_MODES =
            {
                    //new DisplayMode(1920,1080,32,0),
                    new DisplayMode(1680, 1050, 32, 0),
                    //new DisplayMode(1280,1024,32,0),
                    new DisplayMode(800, 600, 32, 0),
                    new DisplayMode(800, 600, 24, 0),
                    new DisplayMode(800, 600, 16, 0),
                    new DisplayMode(640, 480, 32, 0),
                    new DisplayMode(640, 480, 24, 0),
                    new DisplayMode(640, 480, 16, 0),
            };

    private final GraphicsDevice graphicsDevice;

    public ScreenManager() {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = e.getDefaultScreenDevice();
    }


    private DisplayMode findFirstCompatibleMode() {
        DisplayMode availableModes[] = graphicsDevice.getDisplayModes();
        for (DisplayMode supportedMode : ScreenManager.SUPPORTED_DISPLAY_MODES) {
            for (DisplayMode availableMode : availableModes) {
                if (AwtUtils.displayModesMatch(supportedMode, availableMode)) {
                    return supportedMode;
                }
            }
        }
        return null;
    }

    public void enterFullScreen() {
        DisplayMode dm = findFirstCompatibleMode();
        JFrame f = new JFrame();
        f.setUndecorated(true);
        f.setIgnoreRepaint(true);
        f.setResizable(false);
        graphicsDevice.setFullScreenWindow(f);

        if (dm != null && graphicsDevice.isDisplayChangeSupported()) {
            try {
                graphicsDevice.setDisplayMode(dm);
            } catch (Exception ex) {
            }
            f.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        Window w = graphicsDevice.getFullScreenWindow();
        if (w != null) {
            BufferStrategy bs = w.getBufferStrategy();
            return (Graphics2D) bs.getDrawGraphics();
        } else {
            return null;
        }
    }

    public void update() {
        Window w = graphicsDevice.getFullScreenWindow();
        if (w != null) {
            BufferStrategy bs = w.getBufferStrategy();
            if (!bs.contentsLost()) {
                bs.show();
            }
        }
    }

    public Window getFullScreenWindow() {
        return graphicsDevice.getFullScreenWindow();
    }

    public int getWindowWidth() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            return window.getWidth();
        } else {
            return 0;
        }
    }

    public int getWindowHeight() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            return window.getHeight();
        } else {
            return 0;
        }
    }

    public void restoreScreen() {
        Window w = graphicsDevice.getFullScreenWindow();
        if (w != null) {
            w.dispose();
        }
        graphicsDevice.setFullScreenWindow(null);
    }

}
