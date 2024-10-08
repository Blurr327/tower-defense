package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.gamelogic.GameModel;
import model.map.MapEditorModel;
import model.towers.TowerModel;
import model.map.mapeditorstates.SpawnState;
import model.map.mapeditorstates.TargetStateModel;
import model.map.mapeditorstates.TileStateModel;
import model.map.mapeditorstates.TowerState;
import model.map.tiletypes.TileType;
import view.MapEditorView;
import view.MapView;
import view.helperclasses.MessagesView;
import view.mapviewstates.EditStateView;
import view.mapviewstates.editingstateviews.SpawnEditView;
import view.mapviewstates.editingstateviews.TargetEditView;
import view.mapviewstates.editingstateviews.TileEditStateView;
import view.mapviewstates.editingstateviews.TowerEditView;

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
        MapEditorModel.setMapEditorState(new TowerState());
        EditStateView.setEditStateView(new TowerEditView());
        MapEditorModel.setSelectedTower(tower);
        System.out.println("Tower selected : " + tower.getName());
    }

    // this method is called when the user clicks on a tile button (present in the bottom section)

    public void tileSelected(TileType type){
        if(GameModel.hasGameStarted()) {
            System.out.println("Can't modify map mid game");
            EditStateView.allowForbiddenMapModificationInfoToBeDrawn();
            return;
        }
        MapEditorModel.setMapEditorState(new TileStateModel());
        EditStateView.setEditStateView(new TileEditStateView());
        MapEditorModel.setSelectedTileType(type);
        MapEditorModel.setSelectedTower(null);
        // print the name of the tile selected
        System.out.println("Tile selected : " + MapEditorModel.getTileName());
    }
    
    // this method is called when the user clicks on the switch to play manager button (present in the bottom section)

    public void spawnPointEditorButtonClicked(){
        MapEditorModel.setMapEditorState(new SpawnState());
        EditStateView.setEditStateView(new SpawnEditView());
        MapEditorModel.setSelectedTower(null);
        System.out.println("Choose a spawn area :");
    }

    // this method is called when the user clicks on the switch to play manager button (present in the bottom section)
    
    public void targetPointEditorButtonClicked(){
        MapEditorModel.setMapEditorState(new TargetStateModel());
        EditStateView.setEditStateView(new TargetEditView());
        MapEditorModel.setSelectedTower(null);
        System.out.println("Choose a target area :");
    }

    public static TowerModel getSelectedTower() {
        return MapEditorModel.getSelectedTower();
    }
}
