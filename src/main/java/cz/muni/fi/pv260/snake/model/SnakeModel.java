package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.engine.collision.CollisionUtils;
import cz.muni.fi.pv260.engine.graphics.ScreenManager;
import cz.muni.fi.pv260.engine.model.Model;

import java.awt.*;
import java.util.Collections;
import java.util.Random;

import static cz.muni.fi.pv260.snake.SnakeGame.SCALE_FACTOR;

/**
 * Created by micha on 04.04.2017.
 */
public class SnakeModel implements Model {

    private SnakePlayer player;
    private SnakeFood food;

    public SnakeModel(SnakePlayer player, SnakeFood initialFood) {
        this.player = player;
        this.food = initialFood;
    }

    @Override
    public void updateModel() {
        moveSnake();

        if (CollisionUtils.collides(player.getTailCollisionBox(), player.getSnake().getFirst())) {
            System.exit(0);
        }

        if (CollisionUtils.collides(player, food)) {
            growSnake();
            generateNewFood();
        }
    }

    public SnakePlayer getPlayer() {
        return player;
    }

    public SnakeFood getFood() {
        return food;
    }

    private void generateNewFood() {
        Random r = new Random();
        Point point = null;

        do {
            point = new Point(r.nextInt(ScreenManager.getScreenManager().getWindowWidth() / SCALE_FACTOR), r.nextInt(ScreenManager.getScreenManager().getWindowHeight() / SCALE_FACTOR));
        } while (CollisionUtils.collides(player, point));

        SnakeFood newFood = new SnakeFood(point, food.getColor());
        this.food = newFood;
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
        int x = newSnakeHead.x % (ScreenManager.getScreenManager().getWindowWidth() / SCALE_FACTOR);
        int y = newSnakeHead.y % (ScreenManager.getScreenManager().getWindowHeight() / SCALE_FACTOR);
        return new Point(x, y);
    }
}
