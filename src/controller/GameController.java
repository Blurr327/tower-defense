package controller;

import model.GameModel;
import view.GameView;
import javax.swing.Timer;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model){
        this.model = model;
    }

    public void switchTo(String s){
        model.setActiveCard(s);
        view.updateCard();
    }

    public void runUpdateLoop(){
        int delay = ((int) (1000/model.getUPS())); // delay for 60 updates per second
        // Set up Timer for game logic update (60 updates per second)
        Timer updateTimer = new Timer(delay, e -> System.out.println("update game lol"));
        updateTimer.start();
    }

    public void runLoops(){
        view.runRenderLoop();
        runUpdateLoop();
    }

    public void setModel(GameModel model) {
        this.model = model;
    }

    public void setView(GameView view) {
        this.view = view;
    }

    

}
