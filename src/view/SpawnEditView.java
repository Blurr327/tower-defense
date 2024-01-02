package view;

import java.awt.Graphics;

import model.enemies.EnemyModel;
import model.map.MapEditorModel;

public class SpawnEditView implements EditingState{
    private static final MessagesView spawnEditInfo = new MessagesView("Click on a tile to set it as the spawn point");
    

    @Override 
    public void renderEditingState(Graphics g){
        int u = AppView.UNIT_SIZE;
        if(spawnEditInfo.allowedToBeDrawn()) spawnEditInfo.drawDisappearingMessage(g);
                    // Draw the "S" on hover
                    StringHelper.drawCenteredString(g, "S", MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), u);

                    // Draw the "S" on the spawn tile
                    StringHelper.drawCenteredString(g, "S", EnemyModel.getSpawnTileX(), EnemyModel.getSpawnTileY(), u);
    }

}
