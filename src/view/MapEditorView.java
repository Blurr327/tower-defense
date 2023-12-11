package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.MapEditorModel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;


public class MapEditorView extends JPanel{
    MapEditorModel model;
    

    
    public MapEditorView(MapEditorModel model){
        super(new FlowLayout());
        this.model = model;
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(0,0,640,640);
    }
}
