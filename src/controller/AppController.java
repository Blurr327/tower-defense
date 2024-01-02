package controller;

import model.AppModel;
import model.gamelogic.GameModel;
import view.AppView;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * this class is responsible for switching between the menu, settings and game modes
 */
public class AppController {
    private AppModel model;
    private AppView view;
    private static Timer renderTimer;

    public AppController(AppModel model){
        this.model = model;
    }

    public void switchTo(AppModel.AppMode g){
        AppModel.setAppMode(g);
        view.updateCard();
        view.getAppContainer().getGameView().requestFocusInWindow();
        if(g == AppModel.AppMode.MENU || g == AppModel.AppMode.SETTINGS){
            GameController.stopUpdateLoop();
        }
    }

    public void runRenderLoop(){
        int delay = ((int) (1000/AppView.getFPS())); // delay for 120 frames per second
        // Set up Timer for rendering (120 frames per second)
        renderTimer = new Timer(delay, e -> view.getAppContainer().repaint());
        renderTimer.start();
    }

    public void runLoops(){
        runRenderLoop();

    }

    public void setModel(AppModel model) {
        this.model = model;
    }

    public void setView(AppView view) {
        this.view = view;
    }

    public void stopRenderLoop(){
        if(renderTimer != null){
            renderTimer.stop();
        }
    }

    public void updateFPS(int newFPS) {
        stopRenderLoop();
        int delay = (int) (1000 / newFPS);
        renderTimer = new Timer(delay, e -> view.getAppContainer().repaint());
        renderTimer.start();
    }

}
