package cz.muni.fi.pv260;

import cz.muni.fi.pv260.graphics.TronGraphics;
import cz.muni.fi.pv260.input.InputHandler;
import cz.muni.fi.pv260.input.KeyboardInputHandler;
import cz.muni.fi.pv260.model.Direction;
import cz.muni.fi.pv260.model.Player;
import cz.muni.fi.pv260.model.TronModel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TronGame {

    public static void main(String[] args) {

        Player player1 = new Player(new Point(10, 10), Direction.RIGHT, Color.BLUE);
        InputHandler player1Controls = new KeyboardInputHandler(player1,
                KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT);


        Player player2 = new Player(new Point(100, 100), Direction.DOWN, Color.GREEN);
        InputHandler player2Controls = new KeyboardInputHandler(player2,
                KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A);

        //Player player2 = new Player(new Point(100,100), Direction.DOWN, Color.GREEN);
        //InputHandler player2Controls = new MouseInputHandler(player2);

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
