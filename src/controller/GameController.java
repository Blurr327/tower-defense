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

public class GameController implements KeyListener {
    private GameView view;

    public GameController(GameView view) {
        this.view = view;
    }

    public void switchToEdit() {
        GameModel.setGameMode(GameModel.EDIT);
        stopUpdateLoop();
        view.getBottomSectionView().updateCard();
    }

    public void switchToPlay() {
        initGame();
        GameModel.setGameMode(GameModel.PLAY);
        view.getBottomSectionView().updateCard();
    }

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
