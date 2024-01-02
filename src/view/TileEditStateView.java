package view;

import java.awt.Graphics;

import model.map.MapEditorModel;

public class TileEditStateView implements EditingState {
    private static final MessagesView tileEditInfo = new MessagesView("Select a tile from the bottom section and click on a tile to change it");
    private static final MessagesView forbiddenMapModificationInfo = new MessagesView("Can't modify map mid game");

    static {
        forbiddenMapModificationInfo.setAllowedToBeDrawn(false);
    }
    
    @Override
    public void renderEditingState(Graphics g) {
        if(tileEditInfo.allowedToBeDrawn()) tileEditInfo.drawDisappearingMessage(g);
                if(forbiddenMapModificationInfo.allowedToBeDrawn()) forbiddenMapModificationInfo.drawDisappearingMessage(g);
                if(MapEditorModel.isTileSelected()) {
                    TileView.renderTile(g, MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
                }
    }

    public static void allowForbiddenMapModificationInfoToBeDrawn() {
        forbiddenMapModificationInfo.setAllowedToBeDrawn(true);
    }
}
