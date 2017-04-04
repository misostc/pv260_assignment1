package cz.muni.fi.pv260.tron.input;

import cz.muni.fi.pv260.engine.input.KeyboardDirectionInput;
import cz.muni.fi.pv260.engine.model.Direction;
import cz.muni.fi.pv260.tron.model.TronPlayer;

/**
 * Created by micha on 04.04.2017.
 */
public class TronKeyboardDirectionInput extends KeyboardDirectionInput {

    private final TronPlayer player;

    public TronKeyboardDirectionInput(TronPlayer player, int upCode, int rightCode, int downCode, int leftCode) {
        super(upCode, rightCode, downCode, leftCode);
        this.player = player;
    }


    protected void leftPerformed() {
        if (player.getCurrentDirection() != Direction.RIGHT) {
            player.setCurrentDirection(Direction.LEFT);
        }
    }

    protected void rightPerformed() {
        if (player.getCurrentDirection() != Direction.LEFT) {
            player.setCurrentDirection(Direction.RIGHT);
        }
    }

    protected void downPerformed() {
        if (player.getCurrentDirection() != Direction.UP) {
            player.setCurrentDirection(Direction.DOWN);
        }
    }

    protected void upPerformed() {
        if (player.getCurrentDirection() != Direction.DOWN) {
            player.setCurrentDirection(Direction.UP);
        }
    }
}
