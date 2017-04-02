package cz.muni.fi.pv260.input;

import cz.muni.fi.pv260.model.Direction;
import cz.muni.fi.pv260.model.Player;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public class MouseInputHandler implements InputHandler {

    private Player player;

    public MouseInputHandler(Player player) {
        this.player = player;
    }

    @Override
    public void handleEvent(InputEvent event) {
        if (!(event instanceof MouseEvent)) {
            return;
        }

        MouseEvent mouseEvent = (MouseEvent) event;

        if (mouseEvent.getID() == MouseEvent.MOUSE_CLICKED) {
            if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                player.setCurrentDirection(Direction.rotateCounterClockwise(player.getCurrentDirection()));
            } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                player.setCurrentDirection(Direction.rotateClockwise(player.getCurrentDirection()));
            }
        }
    }
}
