package cz.muni.fi.pv260.tron.input;

import cz.muni.fi.pv260.engine.input.MouseClickInput;
import cz.muni.fi.pv260.engine.model.Direction;
import cz.muni.fi.pv260.tron.model.TronPlayer;

public class TronMouseClickInput extends MouseClickInput {
    private TronPlayer player;

    public TronMouseClickInput(TronPlayer player) {
        this.player = player;
    }

    @Override
    protected void rightClickPerformed() {
        player.setCurrentDirection(Direction.rotateClockwise(player.getCurrentDirection()));
    }

    @Override
    protected void leftClickPerformed() {
        player.setCurrentDirection(Direction.rotateCounterClockwise(player.getCurrentDirection()));
    }

}
