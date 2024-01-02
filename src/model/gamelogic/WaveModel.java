package model.gamelogic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import controller.WaveController;
import model.enemies.EnemyFactory;
import model.enemies.EnemyModel;

public class WaveModel {


    // TODO: show wavenumber on the playmanager
    private static int waveNumber;
    private static int numberOfEnemies;

    private static int numberOfCTierEnemies;
    private static int numberOfBTierEnemies;
    private static int numberOfATierEnemies;

    public static final ArrayList<EnemyModel> enemies = new ArrayList<>();


    public static void initEnemyArrayList(){
        
        printWave();
        calculatePercentageOfCTierEnemies();
        calculatePercentageOfBTierEnemies();
        calculatePercentageOfATierEnemies();
        System.out.println(numberOfBTierEnemies);
        for(int i = 0; i < numberOfCTierEnemies; i++){

            // generating random enemies from C tier

            enemies.add(EnemyFactory.createRandomCTierEnemy());
        }

        for(int i = numberOfCTierEnemies; i < numberOfCTierEnemies + numberOfBTierEnemies; i++){

            // generating random enemies from B tier

            enemies.add(EnemyFactory.createRandomBTierEnemy());
        }

        for(int i = numberOfCTierEnemies + numberOfBTierEnemies; i < numberOfEnemies; i++){

            // generating random enemies from A tier

            enemies.add(EnemyFactory.createRandomATierEnemy());
        }

    }

    public static void calculatePercentageOfCTierEnemies() {

        // at least 20% of enemies are C tier, at most 60% of enemies are C tier. Their percentage decreases by 40% each wave

        numberOfCTierEnemies = Math.max((20 * numberOfEnemies) / 100, numberOfEnemies - (40*numberOfEnemies)/100);
        System.out.println("C-tier ennemies : " + numberOfCTierEnemies);
    }

    public static void calculatePercentageOfBTierEnemies() {

        // 3/4 of the remaining enemies are B tier

        if(waveNumber>5/GameModel.getDifficulty()) numberOfBTierEnemies = (3*(numberOfEnemies - numberOfCTierEnemies))/4;
        else numberOfBTierEnemies = numberOfEnemies - numberOfCTierEnemies;
        System.out.println("B-tier ennemies : " + numberOfBTierEnemies);
    }

    public static void calculatePercentageOfATierEnemies() {

        // the rest are A tier if and only if the wave number is greater than 5

        if(waveNumber>5/GameModel.getDifficulty()) numberOfATierEnemies = (numberOfEnemies - numberOfCTierEnemies)/4;
        System.out.println("A-tier ennemies : " + numberOfATierEnemies);
    }

    // getter for waveNumber

    public static int getWaveNumber() {

        return waveNumber;

    }

    // setter for waveNumber

    public static void setWaveNumber(int waveNumber) {

        WaveModel.waveNumber = waveNumber;

    }

    // getter for numberOfEnemies

    public static int getNumberOfEnemies() {

        return numberOfEnemies;

    }

    // setter for numberOfEnemies

    public static void setNumberOfEnemies(int numberOfEnemies) {
        WaveModel.numberOfEnemies = numberOfEnemies;
    }

    public static void nextWave() {

        waveNumber++;
        numberOfEnemies += 3;
        initEnemyArrayList();

    }

    public static void initWave() {

        waveNumber = 1;
        numberOfEnemies = 5;
        enemies.clear();
        initEnemyArrayList();

    }

    public static boolean areAllEnemiesDead() {

        return enemies.size() ==0;

    }

    public static void stopAttackTimers() {
        for(EnemyModel enemy : WaveModel.enemies){
            enemy.stopAttackTimer();
        }
    }

    public static void printWave() {
        System.out.println("Wave : " + getWaveNumber());
    }

    public static void handleEnemyDeath() {
        Iterator<EnemyModel> iterator = WaveModel.enemies.iterator();
        while(iterator.hasNext()){
            EnemyModel enemy = iterator.next();
            if(!enemy.isAlive()){
                enemy.stopAttackTimer();
                iterator.remove();
                ShmucklesModel.setShmuckles(ShmucklesModel.getShmuckles()+enemy.getReward());
                System.out.println(ShmucklesModel.getShmuckles());
            }
        }
    }


}

