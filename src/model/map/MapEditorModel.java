package model.map;

import org.w3c.dom.events.MouseEvent;

import controller.BaseController;
import controller.EnemyController;
import model.enemies.EnemyModel;
import model.gamelogic.BaseModel;
import model.gamelogic.BottomSectionModel;
import model.gamelogic.ShmucklesModel;
import model.map.mapeditorstates.MapEditorState;
import model.map.mapeditorstates.TileStateModel;
import model.map.tiletypes.TileType;
import model.gamelogic.GameModel;
import model.towers.TowerModel;
import model.towers.TowerManagerModel;
import view.AppView;

public class MapEditorModel extends BottomSectionModel {

    private static MapEditorState mapEditorState = new TileStateModel();
    
    private static TileType selectedTileType = null;
    private static TowerModel selectedTower;

    private static TileModel tileToMod;

    public static void setTileToMod(TileModel tileToMod) {
        if(tileToMod != null)
            MapEditorModel.tileToMod = tileToMod;
    }

    public static int getTileToModX() {
        if (tileToMod != null) {
            return tileToMod.getX();
        } else {
            return -1; // had to do it, otherwise pressing t would crash the game
        }
    }

    public static int getTileToModY() {
        if (tileToMod != null) {
            return tileToMod.getY();
        } else {
            return -1;
        }
    }

    public static TileType getSelectedTileType() {
        return selectedTileType;
    }

    public static void setSelectedTileType(TileType selectedTileType) {
        MapEditorModel.selectedTileType = selectedTileType;
    }

    public static boolean isTileSelected() {
        return selectedTileType != null;
    }


    public static void setMapEditorState(MapEditorState mapEditorState) {
        MapEditorModel.mapEditorState = mapEditorState;
    }

    public static boolean stateIsTileState() {
        return mapEditorState instanceof TileStateModel;
    }
    
    public static TowerModel getSelectedTower() {
        return selectedTower;
    }

    public static void setSelectedTower(TowerModel selectedTower) {
        MapEditorModel.selectedTower = selectedTower;
    }

    // returns the name of the tile that is currently selected and will be shown in the Terminal
    public static String getTileName() {
        return selectedTileType.toString();
    }


    public static void updateTileToMod(int x, int y) {
        tileToMod.setX(x);
        tileToMod.setY(y);
    }

    public static void updateSpawnTileToSelectedTile() {
        EnemyController.updateEnemySpawnTile(tileToMod.getX(), tileToMod.getY());
    }

    public static void updateTargetTileToSelectedTile() {
        int x = tileToMod.getX();
        int y = tileToMod.getY();
        BaseController.updateBaseCoords(x, y);
        System.out.println("Target set to (" + x + ", " + y + ")");
    }

        // true if the tile selected is not the target tile and is walkable, false otherwise
    public static boolean selectedSpawnTileIsValid() {
        int x = tileToMod.getX();
        int y = tileToMod.getY();
        boolean differentLocations = x != BaseModel.getX() || y != BaseModel.getY();
        boolean spawnTileValid = MapModel.getTileTypeAt(x, y).isWalkable();
        return differentLocations && spawnTileValid;
    }

    // true if the tile selected is not the spawn tile and is walkable, false otherwise
    public static boolean selectedTargetTileIsValid() {
        int x = tileToMod.getX();
        int y = tileToMod.getY();
        boolean differentLocations = x != EnemyModel.getSpawnTileX() || y != EnemyModel.getSpawnTileY();
        boolean targetTileValid = MapModel.getTileTypeAt(x, y).isWalkable();
        return differentLocations && targetTileValid;
    }

    public static boolean selectedTowerTileIsValid() {
        int x = tileToMod.getX();
        int y = tileToMod.getY();
        return TowerManagerModel.canAddTowerAt(x, y);
    }

    public static void removeSelectedTowerIfExists(){
        int x = tileToMod.getX();
        int y = tileToMod.getY();
        if(MapModel.getTileAt(x, y).getMapComponent() instanceof TowerModel t){
            TowerManagerModel.removeTower(t);
        }
    }

    public static void placeSelectedTower(){
        int x = tileToMod.getX();
        int y = tileToMod.getY();
        TowerModel towerToAdd = selectedTower.newInstance();
        towerToAdd.setX(x);
        towerToAdd.setY(y);
        TowerManagerModel.addTower(towerToAdd);
    }

    public static void updateSelectedTileId(){
        tileToMod.setTileType(selectedTileType);
    }

    public static void handleModificationEvent(){
        mapEditorState.handleState();
    }

}


