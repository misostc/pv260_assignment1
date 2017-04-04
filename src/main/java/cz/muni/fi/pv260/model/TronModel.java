package cz.muni.fi.pv260.model;

import cz.muni.fi.pv260.collision.CollisionUtils;
import cz.muni.fi.pv260.graphics.ScreenManager;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TronModel implements Model {

    private static final int MOVE_AMOUNT = 5;
    private final Set<Player> players;

    public TronModel() {
        this.players = new HashSet<>();
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public Collection<Player> getPlayers() {
        return players;
    }


    @Override
    public void updateModel() {
        // update movement
        for (Player player : players) {
            movePlayer(player);
        }
        checkForCollision();
    }

    private void checkForCollision(){
        for (Player player1 : players){
            for (Player player2 : players){
                if (CollisionUtils.collides(player1,player2)){
                    System.exit(0);
                }
            }
        }
    }


    private void movePlayer(Player player) {
        Window window = ScreenManager.getScreenManager().getFullScreenWindow();
        Point latest = player.getLatestPoint();
        int x = (int) latest.getX();
        int y = (int) latest.getY();
        switch (player.getCurrentDirection()) {
            case UP:
                if (y > 0) {
                    y -= MOVE_AMOUNT;
                } else {
                    y = window.getHeight();
                }
                break;
            case RIGHT:
                if (x < ScreenManager.getScreenManager().getWindowWidth()) {
                    x += MOVE_AMOUNT;
                } else {
                    x = 0;
                }
                break;
            case DOWN:
                if (y < ScreenManager.getScreenManager().getWindowHeight()) {
                    y += MOVE_AMOUNT;
                } else {
                    y = 0;
                }
                break;
            case LEFT:
                if (x > 0) {
                    x -= MOVE_AMOUNT;
                } else {
                    x = window.getWidth();
                }
                break;
        }
        player.addPoint(new Point(x, y));
    }
}
