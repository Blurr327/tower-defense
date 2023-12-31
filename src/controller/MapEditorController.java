package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.gamelogic.GameModel;
import model.map.MapEditorModel;
import model.map.MapEditorModel.MapEditorMode;
import model.towers.TowerModel;
import view.MapEditorView;
import view.MapView;
import view.MessagesView;

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

    public void towerSelected(TowerModel tower) {
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.TOWER);
        MapEditorModel.setSelectedTower(tower);
    }

    // this method is called when the user clicks on a tile button (present in the bottom section)

    public void tileSelected(int id){
        if(GameModel.hasGameStarted()) {
            System.out.println("Can't modify map mid game");
            MapView.showForbiddenMessage();
            return;
        }
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.TILE);
        MapEditorModel.setSelectedTileId(id);
        // print the name of the tile selected
        System.out.println("Tile selected : " + MapEditorModel.getTileName());
    }
    
    // this method is called when the user clicks on the switch to play manager button (present in the bottom section)

    public void spawnPointEditorButtonClicked(){
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.SPAWN);
        System.out.println("Choose a spawn area :");
    }

    // this method is called when the user clicks on the switch to play manager button (present in the bottom section)
    
    public void targetPointEditorButtonClicked(){
        MapEditorModel.setMapEditorMode(MapEditorModel.MapEditorMode.TARGET);
        System.out.println("Choose a target area :");
    }
}
