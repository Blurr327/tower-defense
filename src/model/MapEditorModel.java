package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
public class MapEditorModel extends BottomSectionModel {
    
    private static final ImageIcon[] iconArray;
    private static int selectedTileId = -1;
    private static int tileToModX;
    private static int tileToModY;

    // to limit the amount of spawn/target
    private static int spawnCount = 0;
    private static int targetCount = 0;

    static {
        iconArray = new ImageIcon[TileModel.values().length];
        for(TileModel tile : TileModel.values()) {
            iconArray[tile.getId()] = new ImageIcon(tile.getSprite());
        }
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

    public static ImageIcon getIconById(int id) {
        return iconArray[id];
    }

    public static int getIconArrayLength() {
        return iconArray.length;
    }

    // to limit the amount of spawn/target 
    public static void incrementSpawnCount () {
        spawnCount++;
    }

    public static void incrementTargetCount () {
        targetCount++;
    }

    // get and set the spawn and target count will help x)
    public static int getSpawnCount () {
        return spawnCount;
    }

    public static int getTargetCount () {
        return targetCount;
    }

    public static void setSpawnCount (int spawnCount) {
        MapEditorModel.spawnCount = spawnCount;
    }

    public static void setTargetCount (int targetCount) {
        MapEditorModel.targetCount = targetCount;
    }
}
