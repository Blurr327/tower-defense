package view;

import java.awt.*;
import javax.swing.*;

public class MenuView extends JPanel {
    GameView gameView;
    JButton switchToPlayButton = new JButton("Play");
    JButton switchToSettingsButton = new JButton("Settings");

    public MenuView(GameView gameView){
        super(new FlowLayout());
        this.gameView = gameView;
        switchToPlayButton.addActionListener(e -> 
            gameView.controller.switchTo("play"));
        add(switchToPlayButton);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(0,0,640,640);
    }

}
