package cz.muni.fi.pv260.snake;

import cz.muni.fi.pv260.engine.GameCore;
import cz.muni.fi.pv260.engine.input.InputHandler;
import cz.muni.fi.pv260.engine.model.Direction;
import cz.muni.fi.pv260.snake.graphics.SnakeGraphics;
import cz.muni.fi.pv260.snake.input.SnakeKeyboardDirectionInput;
import cz.muni.fi.pv260.snake.model.SnakeFood;
import cz.muni.fi.pv260.snake.model.SnakeModel;
import cz.muni.fi.pv260.snake.model.SnakePlayer;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by micha on 04.04.2017.
 */
public class SnakeGame {

    public static final int SCALE_FACTOR = 10;

    public static void main(String[] args) {
        SnakePlayer player = new SnakePlayer(new Point(10, 10), Direction.RIGHT, Color.BLUE);
        InputHandler controls = new SnakeKeyboardDirectionInput(player,
                KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT);


        SnakeFood food = new SnakeFood(new Point(20,10), Color.GREEN);
        SnakeModel snakeModel = new SnakeModel(player, food);

        SnakeGraphics snakeGraphics = new SnakeGraphics(snakeModel);

        GameCore game = new GameCore(snakeModel, snakeGraphics, 100);
        game.addInputHandler(controls);

        game.run();
    }
}
