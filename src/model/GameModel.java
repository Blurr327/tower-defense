package model;

import javax.swing.Timer;

import view.MapView;

public enum GameModel {
    EDIT, PLAY;
    private static GameModel gameMode = EDIT;
    private static int health = 100;
    
   
    public static GameModel getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameModel gameMode) {
        GameModel.gameMode = gameMode;
    }

}

