package view;

import javax.swing.*;

import model.AppModel;
import java.awt.*;
import controller.AppController;

public class AppView extends JFrame {
    protected AppModel model;
    protected AppController controller;
    protected GamePanelContainer container;
    protected CardLayout cardLayout;

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
        container.add(new GameViewContainer(this), "game");
        container.add(new MenuView(this), "menu");
        container.add(new SettingsView(this), "settings");
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

    public GamePanelContainer getGamePanelContainer() {
        return container;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

}
