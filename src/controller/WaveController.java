package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

import model.enemies.EnemyModel;
import model.gamelogic.GameModel;
import model.gamelogic.WaveModel;

public class WaveController {

     public static void nextWave() {
         WaveModel.nextWave();
     }

     public static void initWave() {
         WaveModel.initWave();
     }

    public static void stopEnemySpawning(){
        WaveModel.stopSpawning();
    }

    public static void resumeEnemySpawning(){
        if(WaveModel.getStopSpawning())
            WaveModel.spawnEnemies();
    }
    

    public static void handleEnemyMovement(){
        Iterator<EnemyModel> iterator = WaveModel.getEnemyIterator();
        while (iterator.hasNext()) {
            EnemyModel enemy = iterator.next();
            if (enemy.isAlive()) {
                GameModel.handleEnemyMovement(enemy);
            }
        }
    }

    public static void stopAttackTimers(){
        WaveModel.stopAttackTimers();
    }

    public static void pauseWave(){
        Iterator<EnemyModel> iterator = WaveModel.getEnemyIterator();
        while (iterator.hasNext()) {
            EnemyModel enemy = iterator.next();
            enemy.stopAttackTimer();
        }
    }

    public static void resumeWave(){
        Iterator<EnemyModel> iterator = WaveModel.getEnemyIterator();
        while (iterator.hasNext()) {
            EnemyModel enemy = iterator.next();
            if (GameModel.checkEnemyReachedBase(enemy)) {
                enemy.startAttackTimer();
            }
        }
    }

}

