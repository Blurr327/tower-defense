package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.PlayManagerModel;

public class PlayManagerView extends JPanel{
    PlayManagerModel model;

    public PlayManagerView(PlayManagerModel model){
        this.model = model;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,640,640);
    }
}
