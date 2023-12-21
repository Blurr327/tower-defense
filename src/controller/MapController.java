package controller;

import model.MapEditorModel;
import model.MapModel;
import view.MapView;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MapController implements MouseMotionListener, MouseListener {
    MapModel model;
    MapView view;
    

    public MapController(MapModel model, MapView view) {
        this.model = model;
        this.view = view;
        view.addMouseMotionListener(this);
        view.addMouseListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(MapEditorModel.isTileSelected() && model.getMapEditorModel().getActiveCard().equals("edit")){
            /* 
            updateSetTileToMod(e);
            model.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
            */
            // if the tile is not a spawn nor a target
            if(model.getTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY()) != 3 && model.getTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY()) != 4){
                updateSetTileToMod(e);
                model.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
            }
            // there's not any else as the spawn and target are not draggable
        }
    }

    // nearly the same as drag but only for a single click
    @Override
    public void mouseClicked(MouseEvent e){
        if(MapEditorModel.isTileSelected() && model.getMapEditorModel().getActiveCard().equals("edit")){
            int selectedTileId = MapEditorModel.getSelectedTileId();
            // if the selected tile is not a spawn nor a target
            if(selectedTileId != 3 && selectedTileId != 4){
                // and if the tile to modify is a spawn or a target
                if(model.getTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY()) == 3 || model.getTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY()) == 4){
                    // then decrement the spawn/target count
                    if(model.getTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY()) == 3){
                        MapEditorModel.setSpawnCount(MapEditorModel.getSpawnCount()-1);
                    }
                    else if(model.getTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY()) == 4){
                        MapEditorModel.setTargetCount(MapEditorModel.getTargetCount()-1);
                    }
                    updateSetTileToMod(e);
                    model.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), selectedTileId);
                }
                updateSetTileToMod(e);
                model.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), selectedTileId);
            }
            // if the selected tile is a spawn
            else if(selectedTileId == 3){
                // and there's not already a spawn
                if(MapEditorModel.getSpawnCount() < 1){
                    // then update the tile and increment the spawn count
                    updateSetTileToMod(e);
                    model.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), selectedTileId);
                    MapEditorModel.setSpawnCount(MapEditorModel.getSpawnCount()+1);
                    System.out.println("Spawn set at " + MapEditorModel.getTileToModX() + " " + MapEditorModel.getTileToModY());
                }
                else {
                    System.out.println("There's already a spawn");
                }
            }
            // if the selected tile is a target 
            else if(selectedTileId == 4){
                // and there's not already a target
                if(MapEditorModel.getTargetCount() < 1){
                    // then update the tile and increment the target count
                    updateSetTileToMod(e);
                    model.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), selectedTileId);
                    MapEditorModel.setTargetCount(MapEditorModel.getTargetCount()+1);
                    System.out.println("Target set at " + MapEditorModel.getTileToModX() + " " + MapEditorModel.getTileToModY());
                }
                else {
                    System.out.println("There's already a target");
                }
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // ...
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // ...
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(MapEditorModel.isTileSelected() && model.getMapEditorModel().getActiveCard().equals("edit")){
            updateSetTileToMod(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // ...
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // ...
    }

    public void updateSetTileToMod(MouseEvent e){
        MapEditorModel.setTileToModX(e.getX()/MapModel.UNIT_SIZE);
        MapEditorModel.setTileToModY(e.getY()/MapModel.UNIT_SIZE);
    }

}
