package controller;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.AppModel;
import model.GameModel;
import model.enemies.MrBlobModel;
import view.AppView;
import view.GameView;
import view.MapView;

/*
 * this class is responsible for switching between the edit and play modes, it also handles events when the application is in GAME mode
 */

public class GameController implements KeyListener {
    private GameView view;

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
        EnemyController.initSpawnTile();
        EnemyController.initTargetTile();
        // temporary code to test enemy movement
        MapView.blob = new MrBlobModel();
    }

    public static void runUpdateLoop(){
        GameModel.startUpdateLoop();
    }

    public static void stopUpdateLoop(){
        GameModel.stopUpdateLoop();
    }

    // pressing escapes pauses the update loop if it is running and unpauses if it is paused AND if the game mode is PLAY
    // unpausing the game while in EDIT mode can be problematic so it's better to get rid of it for now
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(GameModel.timerIsRunning()){
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
