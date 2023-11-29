package main;

import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel {

    public MenuPanel(){
        super(new FlowLayout());
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
