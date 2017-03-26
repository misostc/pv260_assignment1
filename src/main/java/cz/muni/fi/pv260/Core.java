package cz.muni.fi.pv260;

import cz.muni.fi.pv260.graphics.ScreenManager;

import java.awt.*;
import java.awt.image.BufferedImage;

abstract class Core {

    ScreenManager sm;
    private boolean running;

    void run() {
        try {
            init();
            gameLoop();
        } finally {
            sm.restoreScreen();
        }
    }

    void init() {
        sm = new ScreenManager();
        sm.enterFullScreen();
        Window w = sm.getFullScreenWindow();
        w.setFont(new Font("Arial", Font.PLAIN, 20));
        w.setBackground(Color.WHITE);
        w.setForeground(Color.RED);
        w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
        running = true;
    }

    private void gameLoop() {
        while (running) {
            Graphics2D g = sm.getGraphics();
            draw(g);
            g.dispose();
            sm.update();

            try {
                Thread.sleep(20);
            } catch (Exception ex) {
            }
        }
    }

    protected abstract void draw(Graphics2D g);

}
