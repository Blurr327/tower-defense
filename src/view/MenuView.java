package view;

import java.awt.*;
import javax.swing.*;

public class MenuView extends JPanel {
    AppView appView;
    JButton switchToPlayButton = new JButton("Play");
    JButton switchToSettingsButton = new JButton("Settings");

    public MenuView(AppView appView){
        super(new FlowLayout());
        this.appView = appView;
        switchToPlayButton.addActionListener(e -> 
            appView.controller.switchTo("game"));
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
