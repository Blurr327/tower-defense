package main;

import java.awt.*;
import javax.swing.*;

public class SettingsPanel extends JPanel {

    public SettingsPanel(){
        super(new FlowLayout());
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
