package cz.muni.fi.pv260.engine.input;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public abstract class KeyboardDirectionInput implements InputHandler {

    private int upCode;
    private int downCode;
    private int rightCode;
    private int leftCode;

    public KeyboardDirectionInput(int upCode, int rightCode, int downCode, int leftCode) {
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
            upPerformed();
        } else if (keyEvent.getKeyCode() == downCode) {
            downPerformed();
        } else if (keyEvent.getKeyCode() == rightCode) {
            rightPerformed();
        } else if (keyEvent.getKeyCode() == leftCode) {
            leftPerformed();
        }
    }

    protected abstract void upPerformed();
    protected abstract void downPerformed();
    protected abstract void leftPerformed();
    protected abstract void rightPerformed();

}
