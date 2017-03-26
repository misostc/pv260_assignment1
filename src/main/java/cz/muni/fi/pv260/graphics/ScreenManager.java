package cz.muni.fi.pv260.graphics;

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
        for (DisplayMode supportedMode : ScreenManager.SUPPORTED_DISPLAY_MODES) {
            for (DisplayMode availableMode : graphicsDevice.getDisplayModes()) {
                if (AwtUtils.displayModesMatch(supportedMode, availableMode)) {
                    return supportedMode;
                }
            }
        }
        return null;
    }

    public void enterFullScreen() {
        DisplayMode supportedMode = findFirstCompatibleMode();

        JFrame frame = initFrameWindow();
        graphicsDevice.setFullScreenWindow(frame);

        if (supportedMode != null && graphicsDevice.isDisplayChangeSupported()) {
            try {
                graphicsDevice.setDisplayMode(supportedMode);
            } catch (Exception ex) {
                throw new GraphicsException("Cannot enter fullscreen", ex);
            }
            frame.createBufferStrategy(2);
        } else {
            throw new GraphicsException("No supported diplay mode found or the graphics device doesn't support change.");
        }
    }

    private JFrame initFrameWindow() {
        JFrame f = new JFrame();
        f.setUndecorated(true);
        f.setIgnoreRepaint(true);
        f.setResizable(false);
        return f;
    }

    public Graphics2D getGraphics() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            BufferStrategy bs = window.getBufferStrategy();
            return (Graphics2D) bs.getDrawGraphics();
        } else {
            throw new GraphicsException("Full screen is not active.");
        }
    }

    public void update() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            BufferStrategy bs = window.getBufferStrategy();
            if (!bs.contentsLost()) {
                bs.show();
            }
        } else {
            throw new GraphicsException("Full screen is not active.");
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
            throw new GraphicsException("Full screen is not active.");
        }
    }

    public int getWindowHeight() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            return window.getHeight();
        } else {
            throw new GraphicsException("Full screen is not active.");
        }
    }

    public void restoreScreen() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            window.dispose();
        }
        graphicsDevice.setFullScreenWindow(null);
    }

}
