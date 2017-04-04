package cz.muni.fi.pv260.snake.input;

import cz.muni.fi.pv260.engine.input.KeyboardDirectionInput;
import cz.muni.fi.pv260.engine.model.Direction;
import cz.muni.fi.pv260.snake.model.SnakePlayer;

/**
 * Created by micha on 04.04.2017.
 */
public class SnakeKeyboardDirectionInput extends KeyboardDirectionInput {
    private final SnakePlayer player;

    public SnakeKeyboardDirectionInput(SnakePlayer player, int vkUp, int vkRight, int vkDown, int vkLeft) {
        super(vkUp, vkRight, vkDown, vkLeft);
        this.player = player;
    }

    protected void leftPerformed() {
        if (player.getDirection() != Direction.RIGHT) {
            player.setDirection(Direction.LEFT);
        }
    }

    protected void rightPerformed() {
        if (player.getDirection() != Direction.LEFT) {
            player.setDirection(Direction.RIGHT);
        }
    }

    protected void downPerformed() {
        if (player.getDirection() != Direction.UP) {
            player.setDirection(Direction.DOWN);
        }
    }

    protected void upPerformed() {
        if (player.getDirection() != Direction.DOWN) {
            player.setDirection(Direction.UP);
        }
    }
}
