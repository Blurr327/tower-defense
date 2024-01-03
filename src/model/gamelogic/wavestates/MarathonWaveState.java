package model.gamelogic.wavestates;

import model.gamelogic.WaveModel;

public class MarathonWaveState implements WaveModelState{
    
    @Override
    public boolean checkNextWaveCondition() {
        return WaveModel.getNumberOfCTierEnemies() == 0 && WaveModel.getNumberOfBTierEnemies() == 0 && WaveModel.getNumberOfATierEnemies() == 0;
    }

    @Override
    public void handleNextWaveCondition() {
        WaveModel.nextWave();
    }
}
