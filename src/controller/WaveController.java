package controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

import model.EnemyModel;
import model.GameModel;
import model.WaveModel;

public class WaveController {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static Timer spawningTimer;

    static {
        spawningTimer = new Timer(2 * 1000, e -> {
            for (EnemyModel enemy : WaveModel.enemies) {
                if(!enemy.isSpawned()){
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


        /* for (EnemyModel enemy : WaveModel.enemies) {
            scheduler.schedule(() -> {
                if(!enemy.isSpawned())
                    enemy.setSpawned(true);
            }, initialDelay, TimeUnit.SECONDS);

            initialDelay += delayBetweenMovements;
        } */
        spawningTimer.start();

    }

    public static void stopEnemySpawning(){
        spawningTimer.stop();
    }

    public static void resumeEnemySpawning(){
        spawningTimer.start();
    }
    

    public static void handleEnemyMovement(){
        for (EnemyModel enemy : WaveModel.enemies) {
            if(enemy.isAlive() && enemy.isSpawned()){
                GameModel.handleEnemyMovement(enemy);
            }
        }
    }

    public static void stopAttackTimers(){
        WaveModel.stopAttackTimers();
    }

    public static void pauseWave(){
        for(EnemyModel enemy : WaveModel.enemies){
            enemy.stopAttackTimer();
        }
    }

    public static void resumeWave(){
        for(EnemyModel enemy : WaveModel.enemies){
            if(GameModel.checkEnemyReachedBase(enemy))
                enemy.startAttackTimer();
        }
    }
     
}

