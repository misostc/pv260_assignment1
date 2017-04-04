package cz.muni.fi.pv260.tron;

import cz.muni.fi.pv260.engine.GameCore;
import cz.muni.fi.pv260.engine.input.InputHandler;
import cz.muni.fi.pv260.engine.model.Direction;
import cz.muni.fi.pv260.tron.graphics.TronGraphics;
import cz.muni.fi.pv260.tron.input.TronKeyboardDirectionInput;
import cz.muni.fi.pv260.tron.model.TronModel;
import cz.muni.fi.pv260.tron.model.TronPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TronGame {

    public static void main(String[] args) {

        TronPlayer player1 = new TronPlayer(new Point(10, 10), Direction.RIGHT, Color.BLUE);
        InputHandler player1Controls = new TronKeyboardDirectionInput(player1,
                KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT);


        TronPlayer player2 = new TronPlayer(new Point(100, 100), Direction.DOWN, Color.GREEN);
        InputHandler player2Controls = new TronKeyboardDirectionInput(player2,
                KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A);

        //TronPlayer player2 = new TronPlayer(new Point(100,100), Direction.DOWN, Color.GREEN);
        //InputHandler player2Controls = new TronMouseClickInput(player2);

        TronModel tronModel = new TronModel();
        tronModel.addPlayer(player1);
        tronModel.addPlayer(player2);

        TronGraphics tronGraphics = new TronGraphics(tronModel);

        GameCore game = new GameCore(tronModel, tronGraphics);
        game.addInputHandler(player1Controls);
        game.addInputHandler(player2Controls);

        game.run();
    }
}
