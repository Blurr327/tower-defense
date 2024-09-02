package model.map.mapeditorstates;

import model.gamelogic.GameModel;
import model.map.MapEditorModel;
import model.map.MapModel;

public class TileStateModel implements MapEditorState{
    

    @Override
    public void handleState() {
        if(MapEditorModel.isTileSelected() && !GameModel.hasGameStarted()) 
            MapModel.setTileTypeAt(MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileType());
    }

    
}
