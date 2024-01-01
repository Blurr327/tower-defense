package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.AppModel;
import model.AppModel.AppMode;
import model.enemies.EnemyModel;
import model.gamelogic.BottomSectionModel;
import model.map.MapModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import controller.AppController;

/*
 * This class is the main JFRAME of the entire application
 */

public class AppView extends JFrame {

    public static final int UNIT_SIZE = 32; // size of a tile in pixels
    public static final int HEIGHT = (MapModel.HEIGHT + BottomSectionModel.SECTION_HEIGHT)*UNIT_SIZE; // height of the window, considering the bottom section
    public static final int WIDTH = MapModel.WIDTH*UNIT_SIZE;

    private static double FPS = 30; // frames per second

    private AppModel model;
    private AppController controller;
    private AppContainer container; // container for the 3 main views of the game
    private CardLayout cardLayout; // used to switch between the 3 main views of the game

    public static final BufferedImage spriteSheet = importImg();
    
    private GameView gameView = new GameView();
    private MenuView menuView = new MenuView();
    private SettingsView settingsView = new SettingsView();

    

    public AppView(AppModel model, AppController controller){
        this.model = model;
        this.controller = controller;
        initUI();
    }

    public void setModel(AppModel model) {  
        this.model = model;
    }

    public void setController(AppController controller) {
        this.controller = controller;
    }
    
    public void initUI(){
        setTitle("Tower Defense");

        container = new AppContainer(WIDTH, HEIGHT, gameView);
        getContentPane().add(container);

        addActionListeners();

        initCardLayout();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
    }

    public String getActiveCard() {
        return switch (AppModel.getAppMode()){
            case MENU -> "menu";
            case SETTINGS -> "settings";
            case GAME -> "game";
        };
    }

    private void initCardLayout() {
        cardLayout = (CardLayout) container.getLayout();
        container.add(gameView, "game");
        container.add(menuView, "menu");
        container.add(settingsView, "settings");
        cardLayout.show(container, getActiveCard());
    }

    public void updateCard(){
        cardLayout.show(container, getActiveCard());
    }

    public AppModel getModel() {
        return model;
    }

    public AppController getController() {
        return controller;
    }

    public AppContainer getAppContainer() {
        return container;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void addActionListeners(){
        gameView.getSwitchToMenuButton().addActionListener(e -> {
            controller.switchTo(AppModel.AppMode.MENU);
            System.out.println("Switching to menu !");});
        menuView.getSwitchToGameButton().addActionListener(e-> {
            controller.switchTo(AppModel.AppMode.GAME);
            System.out.println("Good luck have fun :) !");});
        menuView.getSwitchToSettingsButton().addActionListener(e -> {
            controller.switchTo(AppModel.AppMode.SETTINGS);
            System.out.println("Switching to settings !");
        });
        settingsView.getSwitchToMenuButton().addActionListener(e -> {
            controller.switchTo(AppModel.AppMode.MENU);
            System.out.println("Switching to menu !");
        }); 
        settingsView.getChangeFPSTo30Button().addActionListener(e -> {
            AppView.setFPS(30);
            System.out.println("FPS : " + AppView.getFPS());
        });
        settingsView.getChangeFPSTo60Button().addActionListener(e -> {
            AppView.setFPS(60);
            System.out.println("FPS : " + AppView.getFPS());
        });
        settingsView.getChangeFPSTo120Button().addActionListener(e -> {
            AppView.setFPS(120);
            System.out.println("FPS : " + AppView.getFPS());
        });
        settingsView.getChangeTickRateTo32Button().addActionListener(e -> {
            AppModel.setUPS(32);
            System.out.println("Tickrate : " + AppModel.getUPS());
        });
        settingsView.getChangeTickRateTo64Button().addActionListener(e -> {
            AppModel.setUPS(64);
            System.out.println("Tickrate : " + AppModel.getUPS());
        });
        settingsView.getChangeTickRateTo128Button().addActionListener(e -> {
            AppModel.setUPS(128);
            System.out.println("Tickrate : " + AppModel.getUPS());
        });
        settingsView.getChangeDifficultyToEasyButton().addActionListener(e -> {
            EnemyModel.setDifficultyMultiplierSpeed(0.75f);
            System.out.println("Difficulty : Easy" + " (" + EnemyModel.getDifficultyMultiplierSpeed() + ")");
        });
        settingsView.getChangeDifficultyToNormalButton().addActionListener(e -> {
            EnemyModel.setDifficultyMultiplierSpeed(1.0f);
            System.out.println("Difficulty : Normal" + " (" + EnemyModel.getDifficultyMultiplierSpeed() + ")");
        });
        settingsView.getChangeDifficultyToHardButton().addActionListener(e -> {
            EnemyModel.setDifficultyMultiplierSpeed(0.25f);
            System.out.println("Difficulty : Hard" + " (" + EnemyModel.getDifficultyMultiplierSpeed() + ")");
        });
    
    }

    private static BufferedImage importImg(){
        InputStream is = AppView.class.getClassLoader().getResourceAsStream(Paths.get("res/sprites.png").toString());
        BufferedImage ss = null;

        try {
            ss = ImageIO.read(is);
        } catch (IOException e) {
            System.out.println("Error importing image");
            e.printStackTrace();
        }
        return ss;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        System.out.println(WIDTH);
        return WIDTH;
    }

    public static double getFPS() {
        return FPS;
    }

    public static void setFPS(double fPS) {
        FPS = fPS;
    }

}
