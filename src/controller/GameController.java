package controller;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import model.AppModel;
import model.enemies.EnemyModel;
import model.gamelogic.BaseModel;
import model.gamelogic.GameModel;
import model.gamelogic.WaveModel;
import model.gamelogic.ShmucklesModel;
import model.gamelogic.GameModel.GameMode;
import model.gamelogic.wavestates.MarathonWaveState;
import model.gamelogic.wavestates.NormalWaveState;
import model.map.MapModel;
import model.map.TileModel;
import model.towers.TowerManagerModel;
import view.AppView;
import view.GameView;
import view.MapView;
import view.helperclasses.MessagesView;

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
    public void switchToEditAndEndGame() {
        endGame();
        switchToEdit();
    }

    public void switchToEdit(){
        System.out.println("Edit mode");
        
        if(GameModel.hasGameStarted()){
            view.getBottomSectionView().getMapEditorView().addResumeButton();
            view.getBottomSectionView().getMapEditorView().getSwitchToPlayManagerButton().setText("Restart");
        }    
        else{
         view.getBottomSectionView().getMapEditorView().removeResumeButton();
            view.getBottomSectionView().getMapEditorView().getSwitchToPlayManagerButton().setText("Play");
        }
        stopUpdateLoop();
        GameModel.setGameMode(GameModel.GameMode.EDIT);
        MapView.setMapViewState(new view.mapviewstates.EditStateView());
        view.getBottomSectionView().updateCard();
    }

    // this method switches to play mode
    public void switchToPlayAndStartGame() {
        if(GameModel.hasGameStarted()){
            endGame();
            GameModel.setGameStarted(false);
            switchToEdit();
            return;
        }
        initGame();
        switchToPlay();
    }

    public void switchToPlay(){
        System.out.println("Game Starts");
        runUpdateLoop();
        GameModel.setGameMode(GameModel.GameMode.PLAY);
        MapView.setMapViewState(new view.mapviewstates.PlayStateView());
        view.getBottomSectionView().updateCard();
    }

    // this method initializes the spawn and target tiles for the enemies and starts the update loop
    public void initGame(){
        // initializing base health
        BaseController.initBase();
        // initializing the enemy arraylist according to the algorithm described in wavemodel
        WaveController.initWave();
        // initializing the shmuckles
        ShmucklesModel.initShmuckles();
        
        GameModel.setGameStarted(true);
        // running the loop to update gamelogic
        runUpdateLoop(); 
    }

    public void endGame() {
        System.out.println("Game Ends");
        GameModel.setGameStarted(false);
        TowerManagerModel.clearTowers();
        ShmucklesModel.initShmuckles();
        MapModel.iniTiles();
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
            // TODO: Show game over message 
            switchToEditAndEndGame();
        }
        else if(WaveModel.getWaveModelState().checkNextWaveCondition()){
            // TODO: Show next wave message and congratulate player
            WaveModel.getWaveModelState().handleNextWaveCondition();
            if(WaveModel.getWaveModelState() instanceof NormalWaveState) {
                switchToEdit();
                stopUpdateLoop();
            }
        }
        else{
            GameModel.updateEnemiesAndTileObservers();
            TowerManagerModel.handleShotProjectiles();
            GameModel.updateBaseHealth();
        }
    }

    public static void runUpdateLoop(){
        updateTimer.start();
        WaveController.resumeEnemySpawning();
        WaveController.resumeWave();
        TowerManagerModel.startAllTowers();
    }

    public static void stopUpdateLoop(){
       updateTimer.stop();
        WaveController.stopEnemySpawning();
        WaveController.pauseWave();
        TowerManagerModel.stopAllTowers();
    }

    // pressing escapes pauses the update loop if it is running and unpauses if it is paused AND if the game mode is PLAY
    // unpausing the game while in EDIT mode can be problematic so it's better to get rid of it for now
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(updateTimer.isRunning()){
                System.out.println("Game Paused");
                stopUpdateLoop();
            }
            else if (GameModel.getGameMode() == GameModel.GameMode.PLAY){
                System.out.println("Game Resumed");
                runUpdateLoop();
            }
        }
        // pressing K kills all enemies, used for debugging and testing out wave management

        else if(e.getKeyCode() == KeyEvent.VK_K){
            Iterator<EnemyModel> iterator = WaveModel.getEnemyIterator();
            while(iterator.hasNext()){
                EnemyModel enemy = iterator.next();
                enemy.setHealth(0);
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

