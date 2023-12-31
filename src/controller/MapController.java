package controller;

import model.enemies.EnemyModel;
import model.gamelogic.BaseModel;
import model.gamelogic.GameModel;
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
        if(MapEditorModel.isTileSelected() && GameModel.getGameMode().equals(GameModel.GameMode.EDIT) && MapEditorModel.getMapEditorMode().equals(MapEditorModel.MapEditorMode.TILE)){
            updateSetTileToMod(e);
            MapModel.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
        }
    }

    // hovering the mouse over the map shows the selected tile, or displays the letter S or X depending on the current edit mode

    @Override
    public void mouseMoved(MouseEvent e) {
        if(GameModel.getGameMode().equals(GameModel.GameMode.EDIT)){
            updateSetTileToMod(e);
        }
    }

    public void updateSetTileToMod(MouseEvent e) {
        MapEditorModel.setTileToModX(e.getX()/AppView.UNIT_SIZE);
        MapEditorModel.setTileToModY(e.getY()/AppView.UNIT_SIZE);
    }

    public void updateSpawnTile(MouseEvent e) {
        int newX = e.getX()/AppView.UNIT_SIZE;
        int newY = e.getY()/AppView.UNIT_SIZE;

        EnemyController.updateEnemySpawnTile(newX, newY);
    }

    public void updateTargetTile(MouseEvent e) {
        int newX = e.getX()/AppView.UNIT_SIZE;
        int newY = e.getY()/AppView.UNIT_SIZE;

        BaseController.updateBaseCoords(newX, newY);
    }

    // true if the tile selected is not the target tile and is walkable, false otherwise
    public boolean spawnTileValid(int x, int y) {
        boolean differentLocations = x != BaseModel.getX() || y != BaseModel.getY();
        boolean spawnTileValid = TileType.getTileById(MapModel.getTileIdAt(x, y)).isWalkable();
        return differentLocations && spawnTileValid;
    }

    // true if the tile selected is not the spawn tile and is walkable, false otherwise
    public boolean targetTileValid(int x, int y) {
        boolean differentLocations = x != EnemyModel.getSpawnTileX() || y != EnemyModel.getSpawnTileY();
        boolean targetTileValid = TileType.getTileById(MapModel.getTileIdAt(x, y)).isWalkable();
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
        int x = e.getX()/AppView.UNIT_SIZE;
        int y = e.getY()/AppView.UNIT_SIZE;
        if(GameModel.getGameMode().equals(GameModel.GameMode.PLAY)) return;
        switch(MapEditorModel.getMapEditorMode()) {
            case TILE:
                if(MapEditorModel.isTileSelected()) 
                    MapModel.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
                break; 
            case SPAWN:
                if(spawnTileValid(x, y)) {
                    System.out.println("Spawn tile valid");
                    updateSpawnTile(e);
                } else {
                    System.out.println("The spawn must be on a path !");
                }
                break;
            case TARGET:
                if(targetTileValid(x, y)) {
                    System.out.println("Target set to (" + x + ", " + y + ")");
                    updateTargetTile(e);
                } else {
                    System.out.println("The target must be on a path !");
                }
            case TOWER:
                if(MapEditorModel.getSelectedTower() !=null ) {
                    if (!GameModel.isRichEnoughForTower(MapEditorModel.getSelectedTower())){
                        System.out.println("Not enough money");
                    }
                    else {
                        
                        if(TowerManagerModel.canAddTowerAt(x, y)) {
                            buyTower(MapEditorModel.getSelectedTower());
                            placeTower(x, y);
                        }
                        else {
                            System.out.println("Can't add tower here");
                        }
                    }
                }
                break;
        }
    }

    public void placeTower(int x, int y){
        TowerModel towerToAdd = MapEditorModel.getSelectedTower().clone();
                            towerToAdd.setX(x);
                            towerToAdd.setY(y);
                            TowerManagerModel.addTower(towerToAdd);
    }

    public void buyTower(TowerModel tower) {
        GameModel.setShmuckles(GameModel.getShmuckles() - tower.getCost());
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

