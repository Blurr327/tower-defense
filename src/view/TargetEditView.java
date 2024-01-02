package view;

import java.awt.Graphics;

import model.enemies.EnemyModel;
import model.map.MapEditorModel;
import model.gamelogic.BaseModel;


public class TargetEditView implements EditingState{
    private static final MessagesView targetEditInfo = new MessagesView("Click on a tile to set it as the target point");
    

    @Override 
    public void renderEditingState(Graphics g){
        int u = AppView.UNIT_SIZE;
        if(targetEditInfo.allowedToBeDrawn()) targetEditInfo.drawDisappearingMessage(g);
                    // Draw the "T" on hover
                    StringHelper.drawCenteredString(g, "X", MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), u);

                    BaseView.renderBase(g, BaseModel.getX(), BaseModel.getY());
    }
}
