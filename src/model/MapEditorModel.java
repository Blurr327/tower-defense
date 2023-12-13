package model;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
public class MapEditorModel extends BottomSectionModel {
    private ImageIcon grassIcon = new ImageIcon(TileModel.GRASS.getSprite());
    private ImageIcon pathIcon = new ImageIcon(TileModel.PATH.getSprite());
    private ImageIcon flowerIcon = new ImageIcon(TileModel.FLOWER.getSprite());
    private static int selectedTileId = -1;
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

    public ImageIcon getGrassIcon() {
        return grassIcon;
    }

    public ImageIcon getPathIcon() {
        return pathIcon;
    }

    public ImageIcon getFlowerIcon() {
        return flowerIcon;
    }


}
