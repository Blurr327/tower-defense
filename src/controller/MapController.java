package controller;

import model.enemies.EnemyModel;
import model.gamelogic.BaseModel;
import model.gamelogic.GameModel;
import model.gamelogic.ShmucklesModel;
import model.map.MapEditorModel;
import model.map.MapModel;
import model.map.TileType;
import model.towers.TowerManagerModel;
import model.towers.TowerModel;
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
        int x = e.getX()/AppView.UNIT_SIZE;
        int y = e.getY()/AppView.UNIT_SIZE;
        if(MapEditorModel.isTileSelected() && GameModel.getGameMode().equals(GameModel.GameMode.EDIT) && MapEditorModel.stateIsTileState() && GameModel.hasGameStarted() == false){
            MapEditorModel.setTileToMod(MapModel.getTileAt(x, y));
            MapEditorModel.updateSelectedTileId();
        }
    }

    // hovering the mouse over the map shows the selected tile, or displays the letter S or X depending on the current edit mode

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX()/AppView.UNIT_SIZE;
        int y = e.getY()/AppView.UNIT_SIZE;
        MapEditorModel.setTileToMod(MapModel.getTileAt(x, y));
    }

    /*
     * handles clicking event depending on the current edit mode
     * TILE mode : changes the tile at the mouse location to the selected tile
     * SPAWN mode : changes the spawn tile to the tile at the mouse location
     * TARGET mode : changes the target tile to the tile at the mouse location
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/AppView.UNIT_SIZE;
        int y = e.getY()/AppView.UNIT_SIZE;
        MapEditorModel.setTileToMod(MapModel.getTileAt(x, y));

        if(GameModel.getGameMode().equals(GameModel.GameMode.PLAY)) return;
        else if(e.getButton() == MouseEvent.BUTTON3) {
            ShmucklesModel.sellTower(MapModel.getTileAt(x, y).getTower());
            MapEditorModel.removeSelectedTowerIfExists();
            return;
        }
        MapEditorModel.handleModificationEvent();
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

