package view;

import java.awt.*;
import javax.swing.*;



public class PlayView extends JPanel{
    MapView mapView;
    JButton switchToMenuButton = new JButton("Menu");

    public PlayView(GameView gameView){
        super(new FlowLayout());
        mapView = new MapView(gameView);
        switchToMenuButton.addActionListener(e -> 
            gameView.controller.switchTo("menu"));
        add(switchToMenuButton);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g) {
        mapView.renderMap(g);
    }

    
}
