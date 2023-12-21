package controller;

import model.AppModel;
import view.AppView;
import javax.swing.Timer;

public class AppController {
    private AppModel model;
    private AppView view;

    public AppController(AppModel model){
        this.model = model;
    }

    public void switchTo(AppModel.AppMode g){
        AppModel.setAppMode(g);;
        view.updateCard();
    }

    public void runUpdateLoop(){
        int delay = ((int) (1000/model.getUPS())); // delay for 60 updates per second
        // Set up Timer for game logic update (60 updates per second)
        Timer updateTimer = new Timer(delay, e -> System.out.println("update game lol"));
        updateTimer.start();
    }

    public void runRenderLoop(){
        int delay = ((int) (1000/view.getFPS())); // delay for 120 frames per second
        // Set up Timer for rendering (120 frames per second)
        Timer renderTimer = new Timer(delay, e -> view.getAppContainer().repaint());
        renderTimer.start();
    }


    public void runLoops(){
        runRenderLoop();
        runUpdateLoop();
    }

    public void setModel(AppModel model) {
        this.model = model;
    }

    public void setView(AppView view) {
        this.view = view;
    }

    

}
