package controller;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.AppModel;
import model.GameModel;
import view.AppView;
import view.GameView;
import view.MapView;

/*
 * this class is responsible for switching between the edit and play modes, it also handles events when the application is in GAME mode
 */

public class GameController implements KeyListener {
    private GameView view;
    private static Timer updateTimer;

    static {
        int delay = ((int) (1000/AppModel.getUPS())); // delay for 60 updates per second
        // Set up Timer for game logic update (60 updates per second)
        updateTimer = new Timer(delay, e -> update());
    }

    public GameController(GameView view) {
        this.view = view;
    }

    // this method switches to edit mode and stops the update loop
    public void switchToEdit() {
        GameModel.setGameMode(GameModel.EDIT);
        stopUpdateLoop();
        view.getBottomSectionView().updateCard();
    }

    // this method switches to play mode
    public void switchToPlay() {
        initGame();
        GameModel.setGameMode(GameModel.PLAY);
        view.getBottomSectionView().updateCard();
    }

    // this method initializes the spawn and target tiles for the enemies and starts the update loop
    public void initGame(){
        runUpdateLoop();
    }

    public static void update(){
        int num = (int) (Math.random()*100);
        System.out.println(num);
    }

    public static void runUpdateLoop(){
        updateTimer.start();
    }

    public static void stopUpdateLoop(){
       updateTimer.stop();
    }

    // pressing escapes pauses the update loop if it is running and unpauses if it is paused AND if the game mode is PLAY
    // unpausing the game while in EDIT mode can be problematic so it's better to get rid of it for now
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(updateTimer.isRunning()){
                stopUpdateLoop();
            }
            else if (GameModel.getGameMode() == GameModel.PLAY){
                runUpdateLoop();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }

    

}
