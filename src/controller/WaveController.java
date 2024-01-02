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
    private static Timer spawningTimer;

    static {
        spawningTimer = new Timer(2 * 1000, e -> {

            Iterator<EnemyModel> iterator = WaveModel.getEnemyIterator();
            while (iterator.hasNext()) {
                EnemyModel enemy = iterator.next();
                if (!enemy.isSpawned()) {
                    enemy.setSpawned(true);
                    break;
                }
            }
        });
    }

     public static void startWave() {
         WaveModel.initEnemyArrayList();
     }

     public static void nextWave() {
         WaveModel.nextWave();
         initEnemySpawning();
     }

     public static void initWave() {
         WaveModel.initWave();
     }

    public static void initEnemySpawning() {


        spawningTimer.start();

    }

    public static void stopEnemySpawning(){
        spawningTimer.stop();
    }

    public static void resumeEnemySpawning(){
        spawningTimer.start();
    }
    

    public static void handleEnemyMovement(){
        Iterator<EnemyModel> iterator = WaveModel.getEnemyIterator();
        while (iterator.hasNext()) {
            EnemyModel enemy = iterator.next();
            if (enemy.isAlive() && enemy.isSpawned()) {
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

     public static void updateEnemyArrayList() {
        WaveModel.handleEnemyDeath();
     }
}

