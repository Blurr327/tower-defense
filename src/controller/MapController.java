package controller;

import model.GameModel;
import model.MapEditorModel;
import model.MapModel;
import view.AppView;
import view.MapView;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;



public class MapController implements MouseMotionListener {
    MapModel model;
    MapView view;

    public MapController(MapModel model, MapView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(MapEditorModel.isTileSelected() && GameModel.getGameMode().equals(GameModel.EDIT)){
            updateSetTileToMod(e);
            model.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(MapEditorModel.isTileSelected() && GameModel.getGameMode().equals(GameModel.EDIT)){
            updateSetTileToMod(e);
        }
    }

    public void updateSetTileToMod(MouseEvent e){
        MapEditorModel.setTileToModX(e.getX()/AppView.UNIT_SIZE);
        MapEditorModel.setTileToModY(e.getY()/AppView.UNIT_SIZE);
    }

}
