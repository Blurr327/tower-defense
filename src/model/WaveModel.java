package model;

import java.util.ArrayList;
import java.util.Random;

public class WaveModel {

    private int waveNumber;
    private int numberOfEnemies;
    private static EnemyModel[] enemies;

    // constructor
    public WaveModel(int waveNumber, int numberOfEnemies) {

        this.waveNumber = waveNumber;
        this.numberOfEnemies = numberOfEnemies;
        WaveModel.enemies = new EnemyModel[numberOfEnemies];
        initEnemiesArray();
    }

    public void initEnemiesArray() {
        ArrayList<EnemyModel> possibleEnemies = EnemyModel.getEnemiesByDamage(waveNumber*2);
        Random r = new Random();
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies[i] = possibleEnemies.get(r.nextInt(possibleEnemies.size()));
        }
    }

    // getter for waveNumber
    public int getWaveNumber() {
        return waveNumber;
    }

    // setter for waveNumber
    public void setWaveNumber(int waveNumber) {
        this.waveNumber = waveNumber;
    }

    // getter for numberOfEnemies

    public int getNumberOfEnemies() {
        return numberOfEnemies;
    }

    // setter for numberOfEnemies

    public void setNumberOfEnemies(int numberOfEnemies) {
        this.numberOfEnemies = numberOfEnemies;
    }

}
