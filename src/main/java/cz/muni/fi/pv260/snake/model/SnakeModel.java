package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.engine.collision.CollisionUtils;
import cz.muni.fi.pv260.engine.graphics.ScreenManager;
import cz.muni.fi.pv260.engine.model.Model;

import java.awt.*;
import java.util.Random;

/**
 * Created by micha on 04.04.2017.
 */
public class SnakeModel implements Model {
    private SnakePlayer player;
    private Point food;

    public SnakeModel(SnakePlayer player, Point foodInitialPosition) {
        this.player = player;
        this.food = foodInitialPosition;
    }

    @Override
    public void updateModel() {
        moveSnake();

        if (CollisionUtils.collidesWithPoint(player, food)) {
            growSnake();
            generateNewFood();
        }
    }

    private void generateNewFood() {
        Random r = new Random();
        do {
            this.food = new Point(r.nextInt(ScreenManager.getScreenManager().getWindowWidth()), r.nextInt(ScreenManager.getScreenManager().getWindowHeight()))
        } while (!CollisionUtils.collidesWithPoint(player, food));
    }


    private void moveSnake() {
        growSnake();
        player.getSnake().removeLast();
    }

    private void growSnake() {
        Point snakeHead = player.getSnake().getFirst();
        Point newSnakeHead = null;
        switch (player.getDirection()) {
            case UP:
                newSnakeHead = new Point(snakeHead.x, snakeHead.y - 1);
                break;
            case DOWN:
                newSnakeHead = new Point(snakeHead.x, snakeHead.y + 1);
                break;
            case LEFT:
                newSnakeHead = new Point(snakeHead.x - 1, snakeHead.y);
                break;
            case RIGHT:
                newSnakeHead = new Point(snakeHead.x + 1, snakeHead.y);
                break;
        }

        newSnakeHead = checkPointBounds(newSnakeHead);

        player.getSnake().addFirst(newSnakeHead);
    }

    private Point checkPointBounds(Point newSnakeHead) {
        int x = newSnakeHead.x % ScreenManager.getScreenManager().getWindowWidth();
        int y = newSnakeHead.y % ScreenManager.getScreenManager().getWindowHeight();
        return new Point(x, y);
    }
}
