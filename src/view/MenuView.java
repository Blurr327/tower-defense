package view;

import java.awt.*;
import javax.swing.*;

public class MenuView extends JPanel {
    GameView gameView;
    JButton switchToPlayButton = new JButton("Play");
    JButton switchToSettingsButton = new JButton("Settings");
    //JButton switchToCustomButton = new JButton("Map Editor");
    JButton switchToExitButton = new JButton("Exit");

    public MenuView(GameView gameView){
        super(new FlowLayout());
        this.gameView = gameView;
        switchToPlayButton.addActionListener(e -> 
            gameView.controller.switchTo("play"));
        switchToSettingsButton.addActionListener(e ->
            gameView.controller.switchTo("settings"));
        /*
        switchToCustomButton.addActionListener(e -> 
                gameView.controller.switchTo("custom"));
        */
        switchToExitButton.addActionListener(e ->
            System.exit(0));
            
        add(switchToPlayButton);
        add(switchToSettingsButton);
        //add(switchToCustomButton);
        add(switchToExitButton);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(0,0,640,740);
    }

}
