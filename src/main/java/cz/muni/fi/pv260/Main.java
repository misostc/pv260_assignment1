package cz.muni.fi.pv260;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends Core implements KeyListener, MouseListener,
        MouseMotionListener {
    private final int moveAmount = 5;
    private final ArrayList<Integer> pathX1 = new ArrayList();
    private final ArrayList<Integer> pathY1 = new ArrayList();
    private final ArrayList<Integer> pathX2 = new ArrayList();
    private final ArrayList<Integer> pathY2 = new ArrayList();
    private int centerX1 = 40;
    private int centerY1 = 40;
    private int centerX2 = 600;
    private int centerY2 = 440;
    private int currentDirection1 = 1;
    private int currentDirection2 = 3;

    public static void main(String[] args) {
        new Main().run();
    }

    public void init() {
        super.init();

        Window w = sm.getFullScreenWindow();
        w.addKeyListener(this);
        w.addMouseListener(this);
        w.addMouseMotionListener(this);
    }

    public void draw(Graphics2D g) {
        switch (currentDirection1) {
            case 0:
                if (centerY1 > 0) {
                    centerY1 -= moveAmount;
                } else {
                    centerY1 = sm.getWindowHeight();
                }
                break;
            case 1:
                if (centerX1 < sm.getWindowWidth()) {
                    centerX1 += moveAmount;
                } else {
                    centerX1 = 0;
                }
                break;
            case 2:
                if (centerY1 < sm.getWindowHeight()) {
                    centerY1 += moveAmount;
                } else {
                    centerY1 = 0;
                }
                break;
            case 3:
                if (centerX1 > 0) {
                    centerX1 -= moveAmount;
                } else {
                    centerX1 = sm.getWindowWidth();
                }
                break;
        }
        switch (currentDirection2) {
            case 0:
                if (centerY2 > 0) {
                    centerY2 -= moveAmount;
                } else {
                    centerY2 = sm.getWindowHeight();
                }
                break;
            case 1:
                if (centerX2 < sm.getWindowWidth()) {
                    centerX2 += moveAmount;
                } else {
                    centerX2 = 0;
                }
                break;
            case 2:
                if (centerY2 < sm.getWindowHeight()) {
                    centerY2 += moveAmount;
                } else {
                    centerY2 = 0;
                }
                break;
            case 3:
                if (centerX2 > 0) {
                    centerX2 -= moveAmount;
                } else {
                    centerX2 = sm.getWindowWidth();
                }
                break;
        }
        for (int x = 0; x < pathX1.size(); x++) {
            if (((centerX1 == pathX1.get(x)) && (centerY1 == pathY1.get(x))) || ((centerX2 == pathX2.get(x)) && (centerY2 == pathY2.get(x))) || ((centerX1 == pathX2.get(x)) && (centerY1 == pathY2.get(x))) || ((centerX2 == pathX1.get(x)) && (centerY2 == pathY1.get(x)))) {
                System.exit(0);
            }
        }
        pathX1.add(centerX1);
        pathY1.add(centerY1);
        pathX2.add(centerX2);
        pathY2.add(centerY2);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWindowWidth(), sm.getWindowHeight());
        for (int x = 0; x < pathX1.size(); x++) {
            g.setColor(Color.green);
            g.fillRect(pathX1.get(x), pathY1.get(x), 10, 10);
            g.setColor(Color.red);
            g.fillRect(pathX2.get(x), pathY2.get(x), 10, 10);
        }
    }

    public void keyPressed(KeyEvent e) {
        handlePlayerOne(e);
        handlePlayerTwo(e);
    }

    private void handlePlayerTwo(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (currentDirection2 != 2) {
                    currentDirection2 = 0;
                }
                break;
            case KeyEvent.VK_S:
                if (currentDirection2 != 0) {
                    currentDirection2 = 2;
                }
                break;
            case KeyEvent.VK_D:
                if (currentDirection2 != 3) {
                    currentDirection2 = 1;
                }
            case KeyEvent.VK_A:
                if (currentDirection2 != 1) {
                    currentDirection2 = 3;
                }
        }
    }

    private void handlePlayerOne(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (currentDirection1 != 2) {
                    currentDirection1 = 0;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (currentDirection1 != 0) {
                    currentDirection1 = 2;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (currentDirection1 != 3) {
                    currentDirection1 = 1;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (currentDirection1 != 1) {
                    currentDirection1 = 3;
                }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}
