package view;

import java.awt.Graphics;
import javax.swing.JPanel;

import controller.MapController;

import java.awt.Dimension;

import model.GameModel;
import model.MapEditorModel;
import model.MapModel;
import model.TileModel;

public class MapView extends JPanel{
    private MapModel map;

    public MapView(){
        map = new MapModel();
        setPanelSize();
        setFocusable(true);
        requestFocusInWindow();
        addMouseMotionListener(new MapController(new MapModel(), this));
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        renderMap(g);
    }

    public void renderMap(Graphics g){
        int u= MapModel.UNIT_SIZE;
        for(int y=0;y<MapModel.HEIGHT;y++){
            for(int x=0;x<MapModel.WIDTH;x++){
                TileModel tile = TileModel.getTileById(map.getTileIdAt(x, y));
                g.drawImage(tile.getSprite(),x*u, y*u, null);
            }
        }
;
        if(GameModel.getGameMode() == GameModel.EDIT && MapEditorModel.isTileSelected()) g.drawImage(TileModel.getTileById(MapEditorModel.getSelectedTileId()).getSprite(), MapEditorModel.getTileToModX()*MapModel.UNIT_SIZE, MapEditorModel.getTileToModY()*MapModel.UNIT_SIZE, null);
    }

    public void setPanelSize(){
        Dimension size = new Dimension(MapModel.WIDTH*MapModel.UNIT_SIZE, MapModel.HEIGHT*MapModel.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }
}