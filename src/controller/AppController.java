package controller;

import model.AppModel;
import model.gamelogic.GameModel;
import view.AppView;
import javax.swing.Timer;

/*
 * this class is responsible for switching between the menu, settings and game modes
 */
public class AppController {
    private AppModel model;
    private AppView view;

    public AppController(AppModel model){
        this.model = model;
    }

    public void switchTo(AppModel.AppMode g){
        AppModel.setAppMode(g);
        if(g == AppModel.AppMode.MENU || g == AppModel.AppMode.SETTINGS)
            GameController.stopUpdateLoop();
            // TODO: Show a temporary message telling the user to hit escape to unapuse/pause the game
        view.updateCard();
        view.getAppContainer().getGameView().requestFocusInWindow();
        
    }

    public void runRenderLoop(){
        int delay = ((int) (1000/AppView.getFPS())); // delay for 120 frames per second
        // Set up Timer for rendering (120 frames per second)
        Timer renderTimer = new Timer(delay, e -> view.getAppContainer().repaint());
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

    

}
