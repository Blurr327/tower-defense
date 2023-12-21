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

    // This function is called 60 times per second because it is contained in the container panel that is repainted 60 times per second by the App Controller
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        renderMap(g);
    }

    public void renderMap(Graphics g){
        // drawing the map
        int u= AppView.UNIT_SIZE;
        for(int y=0;y<MapModel.HEIGHT;y++){
            for(int x=0;x<MapModel.WIDTH;x++){
                g.drawImage(TileView.getSpriteById(map.getTileIdAt(x, y)),x*u, y*u, null);
            }
        }
;       // drawing the selected tile if in edit mode
        if(GameModel.getGameMode() == GameModel.EDIT && MapEditorModel.isTileSelected()) g.drawImage(TileView.getSpriteById(MapEditorModel.getSelectedTileId()), MapEditorModel.getTileToModX()*u, MapEditorModel.getTileToModY()*u, null);
    }

    public void setPanelSize(){
        Dimension size = new Dimension(MapModel.WIDTH*AppView.UNIT_SIZE, MapModel.HEIGHT*AppView.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }
}