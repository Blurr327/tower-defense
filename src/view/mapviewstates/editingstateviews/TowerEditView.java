package view.mapviewstates.editingstateviews;

import java.awt.Graphics;

import model.map.MapEditorModel;
import view.TowerView;
import view.helperclasses.MessagesView;


public class TowerEditView implements EditingState{
    private static final MessagesView towerEditInfo = new MessagesView("Select a tower from the bottom section and click on a tile to place it");
    
    @Override
    public void renderEditingState(Graphics g){
        if(towerEditInfo.allowedToBeDrawn()) towerEditInfo.drawDisappearingMessage(g);
                    if(MapEditorModel.getSelectedTower()!=null)
                        TowerView.renderTowerAt(g, MapEditorModel.getSelectedTower(), MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY());
    }

}
