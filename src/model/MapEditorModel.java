package model;

public class MapEditorModel extends BottomSectionModel {

    public enum MapEditorMode {
        SPAWN, TARGET, TILE;
    }

    private static MapEditorMode mapEditorMode = MapEditorMode.TILE;
    
    private static int selectedTileId = -1;
    private static int tileToModX;
    private static int tileToModY;

    private static int targetTileX = MapModel.WIDTH-1;
    private static int targetTileY = (MapModel.HEIGHT/4);

    private static int spawnTileX = 0;
    private static int spawnTileY = (MapModel.HEIGHT/2);

    public static int getTargetTileX() {
        return targetTileX;
    }

    public static void setTargetTileX(int targetTileX) {
        MapEditorModel.targetTileX = targetTileX;
    }

    public static int getTargetTileY() {
        return targetTileY;
    }

    public static void setTargetTileY(int targetTileY) {
        MapEditorModel.targetTileY = targetTileY;
    }

    public static int getSpawnTileX() {
        return spawnTileX;
    }

    public static void setSpawnTileX(int spawnTileX) {
        MapEditorModel.spawnTileX = spawnTileX;
    }

    public static int getSpawnTileY() {
        return spawnTileY;
    }

    public static void setSpawnTileY(int spawnTileY) {
        MapEditorModel.spawnTileY = spawnTileY;
    }

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

}
