package model;

public enum GameModel {
    EDIT, PLAY;
    private static GameModel gameMode = EDIT;

    public static GameModel getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameModel gameMode) {
        GameModel.gameMode = gameMode;
    }
}
