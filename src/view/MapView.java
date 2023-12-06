package view;

import java.awt.Graphics;
import model.MapModel;

public class MapView {
    private MapModel map;
    private TileView tileView;

    public MapView(GameView gameView){
        tileView = new TileView(gameView);
        map = new MapModel();
    }

    public void renderMap(Graphics g){
        int u= tileView.gameView.model.getUNIT_SIZE();
        for(int y=0;y<map.getMapHeight();y++){
            for(int x=0;x<map.getMapWidth();x++){
                g.drawImage(tileView.getTileSprite(map.getPosId(x, y)),x*u, y*u, null);
            }
        }
    }
}
