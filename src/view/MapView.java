package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;


import model.MapModel;
import model.TileModel;

public class MapView extends JPanel{
    private MapModel map;

    public MapView(){
        map = new MapModel();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        renderMap(g);
        setPanelSize();
    }

    public void renderMap(Graphics g){
        int u= MapModel.UNIT_SIZE;
        for(int y=0;y<map.getMapHeight();y++){
            for(int x=0;x<map.getMapWidth();x++){
                TileModel tile = TileModel.getTileById(map.getTileIdAt(x, y));
                g.drawImage(tile.getSprite(),x*u, y*u, null);
            }
        }
    }

    public void setPanelSize(){
        Dimension size = new Dimension(MapModel.WIDTH*MapModel.UNIT_SIZE, MapModel.HEIGHT*MapModel.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }
}