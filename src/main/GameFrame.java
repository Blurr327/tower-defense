package main;
import javax.swing.*;

import listener.GameKeyboardListener;
import listener.GameMouseListener;
import model.Map;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.nio.file.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.*;
import controller.*;
import helper.*;

public class GameFrame extends JFrame implements Runnable {
    public static final int UNIT_SIZE = 32;
    public static final int HEIGHT = Map.WIDTH*UNIT_SIZE;
    public static final int WIDTH = Map.HEIGHT*UNIT_SIZE;
    private GamePanel gamePanel;
    private CardController cardController;
    private ListenerInitializer listenerInitializer;
    private static final double FPS = 120; // frames per second
    private static final double UPS = 60; // updates per second
    private Thread gameThread;
    
    

    public GameFrame(){
        initUI();
        start();
    }

    public void initUI(){
   
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gamePanel = new GamePanel(this);
        add(gamePanel);
        
        cardController = new CardController(gamePanel); // Pass the GamePanel as the card container

        // Add cards to the CardManager
        cardController.addCard(new MenuPanel(), "Menu");
        cardController.addCard(new PlayPanel(), "Play");
        cardController.addCard(new SettingsPanel(), "Settings");

        cardController.showCard("Play"); // Show the default card

        listenerInitializer = new ListenerInitializer(this);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void start(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    public void switchSection(String s){
        cardController.showCard(s);
    }


    /* 
     * The render and update loops are seperate as to ensure that the graphical updates don't interfere with
     * the game's logic.
    */

    private void runRenderLoop(){
        int delay = ((int) (1000/FPS)); // delay for 120 frames per second
        // Set up Timer for rendering (120 frames per second)
        Timer renderTimer = new Timer(delay, e -> gamePanel.repaint());
        renderTimer.start();
    }

    private void runUpdateLoop(){
        int delay = ((int) (1000/UPS)); // delay for 60 updates per second
        // Set up Timer for game logic update (60 updates per second)
        Timer updateTimer = new Timer(delay, e -> System.out.println("update game lol"));
        updateTimer.start();
    }

    public static void main(String[] args) throws Exception {

            EventQueue.invokeLater(
                () ->  {
                    try{
                        GameFrame game = new GameFrame();
                        game.listenerInitializer.initListeners(game.gamePanel);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            );
            
           
    }

    @Override
    public void run() {

        runRenderLoop();
        runUpdateLoop();
        
    }
}
