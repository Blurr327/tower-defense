package main;
import javax.swing.*;

import listener.GameKeyboardListener;
import listener.GameMouseListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.nio.file.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.*;

public class GameFrame extends JFrame implements Runnable {

    private GamePanel gamePanel;
    private BufferedImage img; 
    private static final double FPS = 120;
    private static final double UPS = 60;
    private Thread gameThread;
    private GameKeyboardListener keyListener;
    private GameMouseListener mouseListener;

    public GameFrame(){
        initUI();
    }

    public void initUI(){
        importImg();
   
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gamePanel = new GamePanel(img);
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void start(){
        gameThread = new Thread(this){
        };
        gameThread.start();
    }

    public void initListeners(){
        keyListener = new GameKeyboardListener();
        mouseListener = new GameMouseListener();

        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        addKeyListener(keyListener);

        requestFocus();
    }

    private void importImg(){
        InputStream iS = getClass().getResourceAsStream(Paths.get("/res/tileset.png").toString());

        try {
            img = ImageIO.read(iS);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void updateGame(){
        
    }

    /* 
     * The render and update loops are seperate as to ensure that the graphical updates don't interfere with
     * the game's logic.
    */

    private void runRenderLoop(){
        // Set up Timer for rendering (60 frames per second)
        Timer renderTimer = new Timer((int) (1000/FPS), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.repaint(); // Trigger repaint
            }
        });
        renderTimer.start();
    }

    private void runUpdateLoop(){
        // Set up Timer for game logic update (120 updates per second)
        Timer updateTimer = new Timer((int) (1000/UPS), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
            }
        });
        updateTimer.start();
    }

    public static void main(String[] args) throws Exception {

            EventQueue.invokeLater(
                () ->  {
                    GameFrame game = new GameFrame();
                    game.start();
                }
            );
            
           
    }

    @Override
    public void run() {

        runRenderLoop();
        runUpdateLoop();
        
    }
}
