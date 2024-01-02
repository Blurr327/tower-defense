package main;

import controller.AppController;
import model.AppModel;
import view.AppView;

import java.awt.EventQueue;

public class Game implements Runnable{
    private AppModel model;
    private AppController controller;
    private AppView view;
    private Thread gameThread;

    public Game(){
        model = new AppModel();
        controller = new AppController(model);
        view = new AppView(model, controller, 60);
        
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
