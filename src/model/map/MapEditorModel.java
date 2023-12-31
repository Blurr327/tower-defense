package model.map;

import model.gamelogic.BottomSectionModel;
import model.towers.TowerModel;

public class MapEditorModel extends BottomSectionModel {

    public enum MapEditorMode {
        SPAWN, TARGET, TILE, TOWER;
    }

    private static MapEditorMode mapEditorMode = MapEditorMode.TILE;
    
    private static int selectedTileId = -1;
    private static TowerModel selectedTower;

    private static int tileToModX;
    private static int tileToModY;

    public static int getTileToModX() {
        return tileToModX;
    }

    public static void setTileToModX(int tileToModX) {
        MapEditorModel.tileToModX = tileToModX;
    }

    public static int getTileToModY() {
        return tileToModY;
    }

    public static void setTileToModY(int tileToModY) {
        MapEditorModel.tileToModY = tileToModY;
    }

    public static int getSelectedTileId() {
        return selectedTileId;
    }

    public static void setSelectedTileId(int selectedTileId) {
        MapEditorModel.selectedTileId = selectedTileId;
    }

    public static boolean isTileSelected() {
        return selectedTileId != -1;
    }

    public static MapEditorMode getMapEditorMode() {
        return mapEditorMode;
    }

    public static void setMapEditorMode(MapEditorMode mapEditorMode) {
        MapEditorModel.mapEditorMode = mapEditorMode;
    }

    public static TowerModel getSelectedTower() {
        return selectedTower;
    }

    public static void setSelectedTower(TowerModel selectedTower) {
        MapEditorModel.selectedTower = selectedTower;
    }

    // returns the name of the tile that is currently selected and will be shown in the Terminal
    public static String getTileName() {
        return TileType.getTileById(selectedTileId).toString();
    }

}


