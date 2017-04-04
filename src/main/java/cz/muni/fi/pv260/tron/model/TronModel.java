package cz.muni.fi.pv260.tron.model;

import cz.muni.fi.pv260.engine.collision.CollisionUtils;
import cz.muni.fi.pv260.engine.graphics.ScreenManager;
import cz.muni.fi.pv260.engine.model.Model;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TronModel implements Model {

    private static final int MOVE_AMOUNT = 5;
    private final Set<TronPlayer> players;

    public TronModel() {
        this.players = new HashSet<>();
    }

    public void addPlayer(TronPlayer p) {
        players.add(p);
    }

    public Collection<TronPlayer> getPlayers() {
        return players;
    }


    @Override
    public void updateModel() {
        // update movement
        for (TronPlayer player : players) {
            movePlayer(player);
        }
        checkForCollision();
    }

    private void checkForCollision(){
        for (TronPlayer player : players){
            if(CollisionUtils.collides(player,player.tail())){
                System.exit(0);
            }
        }
        for (TronPlayer player1 : players){
            for (TronPlayer player2 : players){
                if (CollisionUtils.collides(player1,player2)){
                    System.exit(0);
                }
            }
        }
    }


    private void movePlayer(TronPlayer player) {
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
