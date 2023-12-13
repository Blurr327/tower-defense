package controller;

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
        if(MapEditorModel.isTileSelected() && model.getMapEditorModel().getActiveCard().equals("edit")){
            updateSetTileToMod(e);
            model.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(MapEditorModel.isTileSelected() && model.getMapEditorModel().getActiveCard().equals("edit")){
            updateSetTileToMod(e);
        }
    }

    public void updateSetTileToMod(MouseEvent e){
        MapEditorModel.setTileToModX(e.getX()/MapModel.UNIT_SIZE);
        MapEditorModel.setTileToModY(e.getY()/MapModel.UNIT_SIZE);
    }

}
