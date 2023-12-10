package view;

import javax.swing.*;

import model.GameModel;
import java.awt.*;
import controller.GameController;

public class GameView extends JFrame {
    protected GameModel model;
    protected GameController controller;
    protected GamePanelContainer container;
    protected CardLayout cardLayout;

    public GameView(GameModel model, GameController controller){
        this.model = model;
        this.controller = controller;
        initUI();
        
    }

    public void setModel(GameModel model) {
        this.model = model;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }
    
    public void initUI(){
        container = new GamePanelContainer(this);
        add(container);
        
        initCardLayout();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private void initCardLayout() {
        cardLayout = (CardLayout) container.getLayout();
        container.add(new PlayView(this), "play");
        container.add(new MenuView(this), "menu");
        container.add(new SettingsView(this), "settings");
        //container.add(new CustomView(this), "custom");
        cardLayout.show(container, model.getActiveCard());
    }

    public void updateCard(){
        cardLayout.show(container, model.getActiveCard());
        container.setPanelSize();
    }

    public void runRenderLoop(){
        int delay = ((int) (1000/model.getFPS())); // delay for 120 frames per second
        // Set up Timer for rendering (120 frames per second)
        Timer renderTimer = new Timer(delay, e -> container.repaint());
        renderTimer.start();
    }

}
