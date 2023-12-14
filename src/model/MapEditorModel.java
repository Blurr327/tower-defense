package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
public class MapEditorModel extends BottomSectionModel {
    
    private static final ImageIcon[] iconArray;
    private static int selectedTileId = -1;
    private static int tileToModX;
    private static int tileToModY;

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

}
