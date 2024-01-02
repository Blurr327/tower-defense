package view.mapviewstates.editingstateviews;

import java.awt.Graphics;

import model.map.MapEditorModel;
import view.TileView;
import view.helperclasses.MessagesView;

public class TileEditStateView implements EditingState {
    private static final MessagesView tileEditInfo = new MessagesView("Select a tile from the bottom section and click on a tile to change it");
    
    @Override
    public void renderEditingState(Graphics g) {
        if(tileEditInfo.allowedToBeDrawn()) tileEditInfo.drawDisappearingMessage(g);
                if(MapEditorModel.isTileSelected()) {
                    TileView.renderTile(g, MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
                }
    }

}