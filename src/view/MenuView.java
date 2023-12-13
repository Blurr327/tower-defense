package view;

import java.awt.*;
import javax.swing.*;

import model.AppModel;

public class MenuView extends JPanel {
    CustomButtonView switchToGameButton = new CustomButtonView("Start");
    CustomButtonView switchToSettingsButton = new CustomButtonView("Settings");
    CustomButtonView quitButton = new CustomButtonView("Quit");

    public MenuView(){
        this.setLayout(null);
        add(switchToGameButton);
        add(switchToSettingsButton);
        add(quitButton);
        quitButton.addActionListener( e -> System.exit(0));
        switchToGameButton.setBounds((AppModel.WIDTH/2)-50, (AppModel.HEIGHT/2)-15*5, 100, 30);
        switchToSettingsButton.setBounds((AppModel.WIDTH/2)-50, (AppModel.HEIGHT/2)-15, 100, 30);
        quitButton.setBounds((AppModel.WIDTH/2)-50, (AppModel.HEIGHT/2)+15*3, 100, 30);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0,0,AppModel.WIDTH,AppModel.HEIGHT);
    }

        public CustomButtonView getSwitchToGameButton() {
        return switchToGameButton;
    }

        public CustomButtonView getSwitchToSettingsButton() {
        return switchToSettingsButton;
    }
}
