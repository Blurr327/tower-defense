package controller;

import model.GameModel;
import model.MapEditorModel;
import model.MapModel;
import model.TileModel;
import view.AppView;
import view.MapView;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/*
 * This class is responsible for handling all the mouse events that occur on the map depending on the current edit mode
 * for TILE mode, it shows the tile that is currently selected and allows the user to change the tile at the mouse location
 * for SPAWN mode, it allows the user to select the spawn tile
 * for TARGET mode, it allows the user to select the target tile
 */

public class MapController implements MouseMotionListener, MouseListener {
    MapModel model;
    MapView view;

    public MapController(MapModel model, MapView view) {
        this.model = model;
        this.view = view;
    }

    // dragging the mouse when a tile is selected changes all of the tiles along the path of the mouse to the selected tile
    @Override
    public void mouseDragged(MouseEvent e) {
        if(MapEditorModel.isTileSelected() && GameModel.getGameMode().equals(GameModel.EDIT) && MapEditorModel.getMapEditorMode().equals(MapEditorModel.MapEditorMode.TILE)){
            updateSetTileToMod(e);
            MapModel.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
        }
    }

    // hovering the mouse over the map shows the selected tile, or displays the letter S or X depending on the current edit mode

    @Override
    public void mouseMoved(MouseEvent e) {
        if(GameModel.getGameMode().equals(GameModel.EDIT)){
            updateSetTileToMod(e);
        }
    }

    public void updateSetTileToMod(MouseEvent e) {
        MapEditorModel.setTileToModX(e.getX()/AppView.UNIT_SIZE);
        MapEditorModel.setTileToModY(e.getY()/AppView.UNIT_SIZE);
    }

    public void updateSpawnTile(MouseEvent e) {
        MapEditorModel.setSpawnTileX(e.getX()/AppView.UNIT_SIZE);
        MapEditorModel.setSpawnTileY(e.getY()/AppView.UNIT_SIZE);
    }

    public void updateTargetTile(MouseEvent e) {
        MapEditorModel.setTargetTileX(e.getX()/AppView.UNIT_SIZE);
        MapEditorModel.setTargetTileY(e.getY()/AppView.UNIT_SIZE);
    }

    // true if the tile selected is not the target tile and is walkable, false otherwise
    public boolean spawnTileValid(int x, int y) {
        boolean differentLocations = x != MapEditorModel.getTargetTileX() || y != MapEditorModel.getTargetTileY();
        boolean spawnTileValid = TileModel.getTileById(MapModel.getTileIdAt(x, y)).isWalkable();
        return differentLocations && spawnTileValid;
    }

    // true if the tile selected is not the spawn tile and is walkable, false otherwise
    public boolean targetTileValid(int x, int y) {
        boolean differentLocations = x != MapEditorModel.getSpawnTileX() || y != MapEditorModel.getSpawnTileY();
        boolean targetTileValid = TileModel.getTileById(MapModel.getTileIdAt(x, y)).isWalkable();
        return differentLocations && targetTileValid;
    }

    /*
     * handles clicking event depending on the current edit mode
     * TILE mode : changes the tile at the mouse location to the selected tile
     * SPAWN mode : changes the spawn tile to the tile at the mouse location
     * TARGET mode : changes the target tile to the tile at the mouse location
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        switch(MapEditorModel.getMapEditorMode()) {
            case TILE:
                if(MapEditorModel.isTileSelected()) 
                    MapModel.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
                break; 
            case SPAWN:
                if(spawnTileValid(e.getX()/AppView.UNIT_SIZE, e.getY()/AppView.UNIT_SIZE)) {
                    System.out.println("Spawn tile valid");
                    updateSpawnTile(e);
                } else {
                    // TODO : Show message saying that the spawn tile is invalid
                }
                break;
            case TARGET:
                if(targetTileValid(e.getX()/AppView.UNIT_SIZE, e.getY()/AppView.UNIT_SIZE)) {
                    updateTargetTile(e);
                } else {
                    // TODO : Show message saying that the target tile is invalid
                }
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

}
