package model.gamelogic;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import controller.WaveController;
import model.enemies.EnemyFactory;
import model.enemies.EnemyModel;
import model.gamelogic.wavestates.NormalWaveState;
import model.gamelogic.wavestates.WaveModelState;

public class WaveModel extends ArrayList<EnemyModel>{


    // TODO: show wavenumber on the playmanager
    private static boolean stopSpawning;
    private static int waveNumber;
    private static int numberOfEnemies;
    private static WaveModelState waveModelState = new NormalWaveState();

    private static int numberOfCTierEnemies;
    private static int numberOfBTierEnemies;
    private static int numberOfATierEnemies;

    private static final ArrayList<EnemyModel> enemies = new ArrayList<>();


    public static WaveModelState getWaveModelState() {
        return waveModelState;
    }

    public static void setWaveModelState(WaveModelState waveModelState) {
        WaveModel.waveModelState = waveModelState;
    }


    public static void initEnemyArrayList(){
        
        printWave();
        calculatePercentageOfCTierEnemies();
        calculatePercentageOfBTierEnemies();
        calculatePercentageOfATierEnemies();
        enemies.add(EnemyFactory.createRandomCTierEnemy());
        numberOfCTierEnemies--;
        System.out.println(numberOfBTierEnemies);
        spawnEnemies();

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
        if(enemies.size() == 0) System.out.println("No enemies left");
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


    public static Iterator<EnemyModel> getEnemyIterator() {
        return enemies.iterator();
    }

    private static void addCtierThenTheRest(){
        System.out.println(numberOfCTierEnemies);
        if(numberOfCTierEnemies<=0 || stopSpawning){
            if(!stopSpawning) addBTierThenTheRest();
            return;
        }
        Timer timer = new Timer(2000, e -> {
            numberOfCTierEnemies--;
            enemies.add(EnemyFactory.createRandomCTierEnemy());
            addCtierThenTheRest();  
        });
        timer.setRepeats(false);
        timer.start();
    }

    private static void addBTierThenTheRest(){
        if(numberOfBTierEnemies<=0 || stopSpawning){
            if(!stopSpawning) addATierEnemies();
            return;
        }
        Timer timer = new Timer(2000, e -> {
            numberOfBTierEnemies--;
            enemies.add(EnemyFactory.createRandomBTierEnemy());
            addBTierThenTheRest();
        });
        timer.setRepeats(false);
        timer.start();
    }


    private static void addATierEnemies(){
        if(numberOfATierEnemies<=0 || stopSpawning) return;
        Timer timer = new Timer(2000, e -> {
            numberOfATierEnemies--;
            enemies.add(EnemyFactory.createRandomATierEnemy());
            addATierEnemies();
        });
        timer.setRepeats(false);
        timer.start();
    }


    public static void stopSpawning(){
        stopSpawning = true;
    }

    public static void spawnEnemies(){
        stopSpawning = false;
        addCtierThenTheRest();
    }

    public static boolean getStopSpawning(){
        return stopSpawning;
    }


    public static int getNumberOfCTierEnemies() {
        return numberOfCTierEnemies;
    }

    public static int getNumberOfBTierEnemies() {
        return numberOfBTierEnemies;
    }

    public static int getNumberOfATierEnemies() {
        return numberOfATierEnemies;
    }
}

