package model;

import javax.swing.Timer;

import view.MapView;

public enum GameModel {
    EDIT, PLAY;
    private static GameModel gameMode = EDIT;
    private static Timer updateTimer;
    // TODO: Move this timer to a controller
    static {
        int delay = ((int) (1000/AppModel.getUPS())); // delay for 60 updates per second
        // Set up Timer for game logic update (60 updates per second)
        updateTimer = new Timer(delay, e -> update());
    }
    public static GameModel getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameModel gameMode) {
        GameModel.gameMode = gameMode;
    }

    public static void startUpdateLoop(){
        updateTimer.start();
    }

    public static void stopUpdateLoop(){
        updateTimer.stop();
    }

    public static boolean timerIsRunning(){
        return updateTimer.isRunning();
    }

    // TODO: Move this to a controller
    public static void update(){
        int num = (int) (Math.random()*100);
            System.out.println("update game" + num);
            System.out.println("blob x: " + MapView.blob.getX() + " y: " + MapView.blob.getY());
            MapView.blob.move();
            System.out.println("update game" + num);
            System.out.println("blob x: " + MapView.blob.getX() + " y: " + MapView.blob.getY());
    }
}

