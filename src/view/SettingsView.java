package view;

import java.awt.*;
import javax.swing.*;

public class SettingsView extends JPanel {
    GameView gameView;
    public SettingsView(GameView gameView){
        super(new FlowLayout());
        this.gameView = gameView;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0,0,640,640);
    }
    
}
