package view;

import java.awt.*;
import javax.swing.*;

public class SettingsView extends JPanel {
    MapView mapView;
    JButton switchToMenuButton = new JButton("Menu");

    public SettingsView(GameView gameView){
        super(new FlowLayout());
        mapView = new MapView();
        switchToMenuButton.addActionListener(e -> 
            gameView.controller.switchTo("menu"));
        add(switchToMenuButton);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow); // yellow like my skin's color
        g.fillRect(0,0,640,740);
    }
    
}
