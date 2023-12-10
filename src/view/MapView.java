package view;

import java.awt.Graphics;

import model.GameModel;
import model.MapModel;
import model.TileModel;

public class MapView {
    private MapModel map;

    public MapView(){
        map = new MapModel();
    }

    public void renderMap(Graphics g){
        int u= GameModel.UNIT_SIZE;
        for(int y=0;y<map.getMapHeight();y++){
            for(int x=0;x<map.getMapWidth();x++){
                g.drawImage(TileModel.getTileById(map.getPosId(x, y)).getSprite(),x*u, y*u, null);
            }
        }
    }
}
