package view;

import javax.swing.*;

import model.AppModel;
import java.awt.*;
import controller.AppController;

public class AppView extends JFrame {
    protected AppModel model;
    protected AppController controller;
    protected AppContainer container;
    protected CardLayout cardLayout;
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

        container = new AppContainer(model.getWIDTH(), model.getHEIGHT(), gameView);
        getContentPane().add(container);

        addActionListeners();

        initCardLayout();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
    }

    private void initCardLayout() {
        cardLayout = (CardLayout) container.getLayout();
        container.add(gameView, "game");
        container.add(menuView, "menu");
        container.add(settingsView, "settings");
        cardLayout.show(container, model.getActiveCard());
    }

    public void updateCard(){
        cardLayout.show(container, model.getActiveCard());
    }

    public AppModel getModel() {
        return model;
    }

    public AppController getController() {
        return controller;
    }

    public AppContainer getGamePanelContainer() {
        return container;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void addActionListeners(){
        gameView.getSwitchToMenuButton().addActionListener(e -> controller.switchTo("menu"));
        menuView.getSwitchToGameButton().addActionListener(e-> controller.switchTo("game"));
        menuView.getSwitchToSettingsButton().addActionListener(e -> controller.switchTo("settings"));
        settingsView.getSwitchToMenuButton().addActionListener(e -> controller.switchTo("menu"));
    }

}
