package main;

import controller.GameController;
import model.GameModel;
import view.GameView;

import java.awt.EventQueue;

public class Game implements Runnable{
    private GameModel model;
    private GameController controller;
    private GameView view;
    private Thread gameThread;

    public Game(){
        model = new GameModel();
        controller = new GameController(model);
        view = new GameView(model, controller);
        
        controller.setView(view);

        view.setVisible(true);
        start();
    }

    private void start(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        controller.runLoops();
    }
    
    public static void main(String[] args) throws Exception {

        EventQueue.invokeLater(
            () ->  {
                try{
                    new Game();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        );
        
       
}
}
