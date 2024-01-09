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
        view = new AppView(model, controller);
        
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
                    System.out.println("Vous êtes dans le menu ! Tapez S pour accéder aux paramètres, tapez P pour démarrer le jeu, tapez Q pour quitter");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        );
        
       
}
}
