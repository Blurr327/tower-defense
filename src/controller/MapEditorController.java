package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.map.MapEditorModel;
import model.map.MapEditorModel.MapEditorMode;
import view.MapEditorView;
import view.MapView;

/*
 * This class is responsible for handling all events that occur on the map editor (i.e the events that occur on the bottom section when the gameMode is EDIT)
 * It is responsible for changing the map editor mode and updating the selected tile id 
 *
 */

public class MapEditorController {
    MapEditorModel model;
    MapEditorView view;

    public MapEditorController(MapEditorModel model, MapEditorView view){
        this.model= model;
        this.view = view;
    }

    // this method is called when the user clicks on a tile button (present in the bottom section)

    public void tileSelected(int id){
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.TILE);
        MapEditorModel.setSelectedTileId(id);
    }
    
    // this method is called when the user clicks on the switch to play manager button (present in the bottom section)

    public void spawnPointEditorButtonClicked(){
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.SPAWN);
        //TODO : show a message telling the user to choose a spawn point
    }

    // this method is called when the user clicks on the switch to play manager button (present in the bottom section)
    
    public void targetPointEditorButtonClicked(){
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.TARGET);
        //TODO : show a message telling the user to choose a target point
    }

}
