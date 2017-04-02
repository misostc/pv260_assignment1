package cz.muni.fi.pv260;

import cz.muni.fi.pv260.graphics.Graphics;
import cz.muni.fi.pv260.graphics.ScreenManager;
import cz.muni.fi.pv260.input.InputHandler;
import cz.muni.fi.pv260.model.Model;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public final class GameCore implements KeyListener, MouseListener {

    private final Model model;
    private final cz.muni.fi.pv260.graphics.Graphics graphics;
    private final Set<InputHandler> handlers;
    private boolean running;

    public GameCore(Model model, Graphics graphics) {
        this.model = model;
        this.graphics = graphics;
        handlers = new HashSet<InputHandler>();
    }


    public void run() {
        try {
            init();
            gameLoop();
        } finally {
            ScreenManager.getScreenManager().restoreScreen();
        }
    }

    public void addInputHandler(InputHandler inputHandler) {
        handlers.add(inputHandler);
    }

    private void init() {
        ScreenManager.getScreenManager().enterFullScreen();
        ScreenManager.getScreenManager().hideCursor();
        ScreenManager.getScreenManager().getFullScreenWindow().addMouseListener(this);
        ScreenManager.getScreenManager().getFullScreenWindow().addKeyListener(this);

        running = true;
    }

    private void gameLoop() {
        while (running) {
            model.updateModel();

            Graphics2D context = ScreenManager.getScreenManager().startDrawing();
            graphics.draw(context);
            ScreenManager.getScreenManager().finishDrawing(context);

            try {
                Thread.sleep(20);
            } catch (Exception ex) {
            }
        }
    }

    private void handleInput(InputEvent event) {
        for (InputHandler handler : handlers) {
            handler.handleEvent(event);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        handleInput(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        handleInput(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        handleInput(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        handleInput(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        handleInput(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        handleInput(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        handleInput(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        handleInput(e);
    }
}
