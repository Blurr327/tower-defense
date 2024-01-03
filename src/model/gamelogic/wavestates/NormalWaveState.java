package model.gamelogic.wavestates;

import model.gamelogic.WaveModel;

public class NormalWaveState implements WaveModelState{
    
    @Override
    public boolean checkNextWaveCondition() {
        return WaveModel.getEnemyIterator().hasNext() == false;
    }

    @Override
    public void handleNextWaveCondition() {
        WaveModel.nextWave();
    }
}
