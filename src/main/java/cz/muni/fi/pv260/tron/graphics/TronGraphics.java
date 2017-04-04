package cz.muni.fi.pv260.tron.graphics;

import cz.muni.fi.pv260.engine.graphics.*;
import cz.muni.fi.pv260.tron.model.TronModel;
import cz.muni.fi.pv260.tron.model.TronPlayer;

import java.awt.*;

public class TronGraphics implements cz.muni.fi.pv260.engine.graphics.Graphics {

    private final TronModel tronModel;

    public TronGraphics(TronModel tronModel) {
        this.tronModel = tronModel;
    }


    @Override
    public void draw(Graphics2D graphics) {
        Window window = ScreenManager.getScreenManager().getFullScreenWindow();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, window.getWidth(),window.getHeight());

        for (TronPlayer player : tronModel.getPlayers()) {
            paintPlayer(player, graphics);
        }
    }

    private void paintPlayer(TronPlayer player, Graphics2D graphics) {
        for (Point point : player.getPoints()) {
            graphics.setColor(player.getColor());
            graphics.fillRect((int) point.getX(), (int) point.getY(), 10, 10);
        }
    }

}
