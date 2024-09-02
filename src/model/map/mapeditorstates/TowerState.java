package model.map.mapeditorstates;

import model.gamelogic.GameModel;
import model.gamelogic.ShmucklesModel;
import model.gamelogic.WaveModel;
import model.gamelogic.wavestates.MarathonWaveState;
import model.map.MapEditorModel;
import model.towers.TowerManagerModel;
    

public class TowerState implements MapEditorState{
    
    
        @Override
        public void handleState() {
            if(MapEditorModel.getSelectedTower() !=null ) {
                if (!ShmucklesModel.isRichEnoughForTower(MapEditorModel.getSelectedTower())){
                    System.out.println("Not enough money");
                }
                else if(MapEditorModel.selectedTowerTileIsValid()) {
                        ShmucklesModel.buyTower(MapEditorModel.getSelectedTower());
                        MapEditorModel.getSelectedTower().increaseCount();
                        MapEditorModel.placeSelectedTower();
                    }
                else {
                        System.out.println("Can't add tower here");
                    }
            }
        }

}
