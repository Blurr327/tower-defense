package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import model.MapEditorModel;
import model.MapEditorModel.MapEditorMode;
import view.MapEditorView;
import view.MapView;

public class MapEditorController {
    MapEditorModel model;
    MapEditorView view;

    public MapEditorController(MapEditorModel model, MapEditorView view){
        this.model= model;
        this.view = view;
    }

    public void tileSelected(int id){
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.TILE);
        MapEditorModel.setSelectedTileId(id);
    }
    
    public void spawnPointEditorButtonClicked(){
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.SPAWN);
        //TODO : show a message telling the user to choose a spawn point
    }

    public void targetPointEditorButtonClicked(){
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.TARGET);
        //TODO : show a message telling the user to choose a target point
    }

}
