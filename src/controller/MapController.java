package controller;

import model.GameModel;
import model.MapEditorModel;
import model.MapModel;
import view.MapView;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


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
        MapEditorModel.setTileToModX(e.getX()/MapModel.UNIT_SIZE);
        MapEditorModel.setTileToModY(e.getY()/MapModel.UNIT_SIZE);
    }

}
