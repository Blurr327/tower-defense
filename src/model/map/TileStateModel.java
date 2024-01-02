package model.map;

import model.gamelogic.GameModel;

public class TileStateModel implements MapEditorState{
    

    @Override
    public void handleState() {
        if(MapEditorModel.isTileSelected() && !GameModel.hasGameStarted()) 
            MapModel.setTileIdAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
    }

    
}
