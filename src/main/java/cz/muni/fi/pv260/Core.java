package cz.muni.fi.pv260;

import cz.muni.fi.pv260.graphics.ScreenManager;

import java.awt.*;

abstract class Core {

    protected ScreenManager screenManager;
    private boolean running;

    void run() {
        try {
            init();
            gameLoop();
        } finally {
            screenManager.restoreScreen();
        }
    }

    void init() {
        screenManager = new ScreenManager();
        screenManager.enterFullScreen();
        screenManager.hideCursor();
        running = true;
    }

    private void gameLoop() {
        while (running) {
            Graphics2D context = screenManager.startDrawing();
            draw(context);
            screenManager.finishDrawing(context);

            try {
                Thread.sleep(20);
            } catch (Exception ex) {
            }
        }
    }

    protected abstract void draw(Graphics2D context);

}
