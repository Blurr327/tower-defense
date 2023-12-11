package model;

public class MapEditorModel extends BottomSectionModel {
    private static int selectedTileId = -1;


    public static int getSelectedTileId() {
        return selectedTileId;
    }

    public static void setSelectedTileId(int selectedTileId) {
        MapEditorModel.selectedTileId = selectedTileId;
    }

    public static boolean isTileSelected() {
        return selectedTileId != -1;
    }

}
