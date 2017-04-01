package cz.muni.fi.pv260;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Main extends Core implements KeyListener, MouseListener,
        MouseMotionListener {
    int moveAmount = 5;
    Player playerOne = new Player(new Point(40, 40), Direction.RIGHT);
    Player playerTwo = new Player(new Point(600, 440), Direction.LEFT);

    public void init() {
        super.init();

        Window w = screenManager.getFullScreenWindow();
        w.addKeyListener(this);
        w.addMouseListener(this);
        w.addMouseMotionListener(this);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void draw(Graphics2D graphics) {
        addLatestPoint(playerOne);
        addLatestPoint(playerTwo);
        if (playerOne.getPoints().contains(playerTwo.getLatestPoint())) {
            System.exit(0);
        }
        if (playerTwo.getPoints().contains(playerOne.getLatestPoint())){
            System.exit(0);
        }
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWindowWidth(), screenManager.getWindowHeight());
        paintPoints(graphics);
    }

    private void paintPoints(Graphics2D graphics) {
        for (int x = 0; x < playerOne.getPoints().size(); x++) {
            Point p1 = playerOne.getPoints().get(x);
            Point p2 = playerTwo.getPoints().get(x);
            graphics.setColor(Color.green);
            graphics.fillRect((int) p1.getX(), (int) p1.getY(), 10, 10);
            graphics.setColor(Color.red);
            graphics.fillRect((int) p2.getX(), (int) p2.getY(), 10, 10);
        }
    }

    private void addLatestPoint(Player player) {
        Point latest = player.getLatestPoint();
        int x = (int) latest.getX();
        int y = (int) latest.getY();
        switch (player.getCurrentDirection()) {
            case UP:
                if (y > 0) {
                    y -= moveAmount;
                } else {
                    y = screenManager.getWindowHeight();
                }
                break;
            case RIGHT:
                if (x < screenManager.getWindowWidth()) {
                    x += moveAmount;
                } else {
                    x = 0;
                }
                break;
            case DOWN:
                if (y < screenManager.getWindowHeight()) {
                    y += moveAmount;
                } else {
                    y = 0;
                }
                break;
            case LEFT:
                if (x > 0) {
                    x -= moveAmount;
                } else {
                    x = screenManager.getWindowWidth();
                }
                break;
        }
        player.addPoint(new Point(x, y));
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (playerOne.getCurrentDirection() != Direction.DOWN) {
                playerOne.setCurrentDirection(Direction.UP);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (playerOne.getCurrentDirection() != Direction.UP) {
                playerOne.setCurrentDirection(Direction.DOWN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerOne.getCurrentDirection() != Direction.LEFT) {
                playerOne.setCurrentDirection(Direction.RIGHT);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerOne.getCurrentDirection() != Direction.RIGHT) {
                playerOne.setCurrentDirection(Direction.LEFT);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (playerTwo.getCurrentDirection() != Direction.DOWN) {
                playerTwo.setCurrentDirection(Direction.UP);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (playerTwo.getCurrentDirection() != Direction.UP) {
                playerTwo.setCurrentDirection(Direction.DOWN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (playerTwo.getCurrentDirection() != Direction.LEFT) {
                playerTwo.setCurrentDirection(Direction.RIGHT);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (playerTwo.getCurrentDirection() != Direction.RIGHT) {
                playerTwo.setCurrentDirection(Direction.LEFT);
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
