package cz.muni.fi.pv260.engine.input;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public abstract class MouseClickInput implements InputHandler {

    @Override
    public void handleEvent(InputEvent event) {
        if (!(event instanceof MouseEvent)) {
            return;
        }

        MouseEvent mouseEvent = (MouseEvent) event;

        if (mouseEvent.getID() == MouseEvent.MOUSE_CLICKED) {
            if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                leftClickPerformed();
            } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                rightClickPerformed();
            }
        }
    }

    protected abstract void rightClickPerformed();
    protected abstract void leftClickPerformed();

}
