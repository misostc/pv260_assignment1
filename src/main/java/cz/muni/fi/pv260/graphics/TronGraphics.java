package cz.muni.fi.pv260.graphics;

import cz.muni.fi.pv260.model.Player;
import cz.muni.fi.pv260.model.TronModel;

import java.awt.*;

public class TronGraphics implements Graphics {

    private final TronModel tronModel;

    public TronGraphics(TronModel tronModel) {
        this.tronModel = tronModel;
    }


    @Override
    public void draw(Graphics2D graphics) {
        Window window = ScreenManager.getScreenManager().getFullScreenWindow();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, window.getWidth(),window.getHeight());

        for (Player player : tronModel.getPlayers()) {
            paintPlayer(player, graphics);
        }
    }

    private void paintPlayer(Player player, Graphics2D graphics) {
        for (Point point : player.getPoints()) {
            graphics.setColor(player.getColor());
            graphics.fillRect((int) point.getX(), (int) point.getY(), 10, 10);
        }
    }

}
