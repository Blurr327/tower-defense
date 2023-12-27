package controller;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.AppModel;
import model.BaseModel;
import model.GameModel;
import model.WaveModel;
import view.AppView;
import view.GameView;
import view.MapView;

/*
 * this class is responsible for switching between the edit and play modes, it also handles events when the application is in GAME mode
 */

public class GameController implements KeyListener {
    private GameView view;
    private static Timer updateTimer;

    public GameController(GameView view) {
        this.view = view;
        int delay = ((int) (1000/AppModel.getUPS())); // delay for 60 updates per second
        // Set up Timer for game logic update (60 updates per second)
        updateTimer = new Timer(delay, e -> update());
    }

    // this method switches to edit mode and stops the update loop
    public void switchToEdit() {
        endGame();
        GameModel.setGameMode(GameModel.EDIT);
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
        // initializing base health
        BaseController.initBase();
        // initializing the enemy arraylist according to the algorithm described in wavemodel
        WaveController.initWave();
        // running the loop to update gamelogic
        runUpdateLoop();
    }

    public void endGame() {
        endWave();
        // stopping the update loop
        stopUpdateLoop();
    }

    public void endWave() {
        // stopping all attack timers
        WaveController.stopAttackTimers();
    }

    public void update(){
        updateGame();
    }

    public void updateGame(){
        if(GameModel.checkGameOverCondition()){
            switchToEdit();
        }
        else if(GameModel.checkNextWaveCondition()){
            endWave();
            WaveController.nextWave();
            WaveController.resumeEnemySpawning();
        }
        else{
            WaveController.handleEnemyMovement();
            GameModel.updateBaseHealth();
        }
    }

    public static void runUpdateLoop(){
        updateTimer.start();
        WaveController.resumeEnemySpawning();
        WaveController.resumeWave();
    }

    public static void stopUpdateLoop(){
       updateTimer.stop();
        WaveController.stopEnemySpawning();
        WaveController.pauseWave();
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
        // pressing K kills all enemies, used for debugging and testing out wave management

        else if(e.getKeyCode() == KeyEvent.VK_K){
            for(int i=0;WaveModel.enemies.size()>i;i++){
                WaveModel.enemies.get(i).setHealth(0);
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

