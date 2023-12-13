package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import model.MapEditorModel;
import view.MapEditorView;

public class MapEditorController {
    MapEditorModel model;
    MapEditorView view;

    public MapEditorController(MapEditorModel model, MapEditorView view){
        this.model= model;
        this.view = view;
    }

    public void tileSelected(int id){
        MapEditorModel.setSelectedTileId(id);
    }
    
}
