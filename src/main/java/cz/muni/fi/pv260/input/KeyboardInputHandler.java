package cz.muni.fi.pv260.input;

import cz.muni.fi.pv260.model.Direction;
import cz.muni.fi.pv260.model.Player;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class KeyboardInputHandler implements InputHandler {

    private Player player;
    private int upCode;
    private int downCode;
    private int rightCode;
    private int leftCode;

    public KeyboardInputHandler(Player player, int upCode, int rightCode, int downCode, int leftCode) {
        this.player = player;
        this.upCode = upCode;
        this.downCode = downCode;
        this.rightCode = rightCode;
        this.leftCode = leftCode;
    }

    @Override
    public void handleEvent(InputEvent event) {
        if (!(event instanceof KeyEvent)) {
            return;
        }

        KeyEvent keyEvent = (KeyEvent) event;

        if (keyEvent.getKeyCode() == upCode) {
            if (player.getCurrentDirection() != Direction.DOWN) {
                player.setCurrentDirection(Direction.UP);
            }
        } else if (keyEvent.getKeyCode() == downCode) {
            if (player.getCurrentDirection() != Direction.UP) {
                player.setCurrentDirection(Direction.DOWN);
            }
        } else if (keyEvent.getKeyCode() == rightCode) {
            if (player.getCurrentDirection() != Direction.LEFT) {
                player.setCurrentDirection(Direction.RIGHT);
            }
        } else if (keyEvent.getKeyCode() == leftCode) {
            if (player.getCurrentDirection() != Direction.RIGHT) {
                player.setCurrentDirection(Direction.LEFT);
            }
        }
    }
}
