package cz.muni.fi.pv260.snake.graphics;

import cz.muni.fi.pv260.engine.graphics.Graphics;
import cz.muni.fi.pv260.engine.graphics.ScreenManager;
import cz.muni.fi.pv260.snake.model.SnakeModel;

import java.awt.*;
import java.util.Deque;

import static cz.muni.fi.pv260.snake.SnakeGame.SCALE_FACTOR;


/**
 * Created by micha on 04.04.2017.
 */
public class SnakeGraphics implements Graphics {
    private SnakeModel snakeModel;

    public SnakeGraphics(SnakeModel snakeModel) {
        super();
        this.snakeModel = snakeModel;
    }

    @Override
    public void draw(Graphics2D graphics) {
        Window window = ScreenManager.getScreenManager().getFullScreenWindow();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, window.getWidth(),window.getHeight());

        drawSnake(graphics);
        drawFood(graphics);
    }

    private void drawSnake(Graphics2D graphics) {
        Deque<Point> snake = snakeModel.getPlayer().getSnake();
        for (Point point: snake) {
            graphics.setColor(snakeModel.getPlayer().getColor());
            graphics.fillRect(point.x*SCALE_FACTOR, point.y*SCALE_FACTOR, SCALE_FACTOR, SCALE_FACTOR);
        }
    }

    private void drawFood(Graphics2D graphics) {
        graphics.setColor(snakeModel.getFood().getColor());
        graphics.fillRect(snakeModel.getFood().getPosition().x*SCALE_FACTOR, snakeModel.getFood().getPosition().y*SCALE_FACTOR, SCALE_FACTOR, SCALE_FACTOR);
    }
}
