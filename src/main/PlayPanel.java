package main;

import java.awt.*;
import javax.swing.*;
import graphics.*;

public class PlayPanel extends JPanel{
    MapGraphicsFactory mapGraphics;

    public PlayPanel(){
        super(new FlowLayout());
        mapGraphics = new MapGraphicsFactory();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g) {
        mapGraphics.renderMap(g);
    }

}
