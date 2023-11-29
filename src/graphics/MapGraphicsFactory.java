package graphics;

import java.awt.Graphics;
import main.GameFrame;
import model.Map;

public class MapGraphicsFactory extends GraphicsFactory{
    private Map map;
    private TileGraphicsFactory tileGraphics;

    public MapGraphicsFactory(){
        super();
        tileGraphics = new TileGraphicsFactory();
        map = new Map();
    }

    public void renderMap(Graphics g){
        int u= GameFrame.UNIT_SIZE;
        for(int y=0;y<map.getMapHeight();y++){
            for(int x=0;x<map.getMapWidth();x++){
                g.drawImage(tileGraphics.getTileSprite(map.getPosId(x, y)),x*u, y*u, null);
            }
        }
    }
}
