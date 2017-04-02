package cz.muni.fi.pv260.model;

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


    private boolean hasPlayerCollidedWithHimself(Player player1) {
        for (int i = 0; i < player1.getPoints().size() - 1; i++) {
            if (player1.getLatestPoint().equals(player1.getPoints().get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean havePlayersCollided(Player player1, Player player2) {
        for (Point player1Point : player1.getPoints()) {
            for (Point player2Point : player2.getPoints()) {
                if (player1Point.equals(player2Point)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void updateModel() {
        // update movement
        for (Player player : players) {
            movePlayer(player);
        }

        // detect collision
        for (Player player1 : players) {
            if (hasPlayerCollidedWithHimself(player1)) {
                System.exit(0);
            }

            for (Player player2 : players) {
                if (player1 != player2 && havePlayersCollided(player1, player2)) {
                    System.exit(0);
                }
            }
        }
    }


    private void movePlayer(Player player) {
        Point latest = player.getLatestPoint();
        int x = (int) latest.getX();
        int y = (int) latest.getY();
        switch (player.getCurrentDirection()) {
            case UP:
                if (y > 0) {
                    y -= MOVE_AMOUNT;
                } else {
                    y = ScreenManager.getScreenManager().getWindowHeight();
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
                    x = ScreenManager.getScreenManager().getWindowWidth();
                }
                break;
        }
        player.addPoint(new Point(x, y));
    }
}
