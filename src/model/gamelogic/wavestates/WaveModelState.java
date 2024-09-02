package model.gamelogic.wavestates;

public interface WaveModelState {
    

    boolean checkNextWaveCondition();
    void handleNextWaveCondition();


}
