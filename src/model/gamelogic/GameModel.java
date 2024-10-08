package model.gamelogic;

import java.util.Iterator;

import javax.swing.Timer;

import model.enemies.EnemyModel;
import model.map.MapModel;
import model.towers.TowerModel;
import view.MapView;

public class GameModel {
    public enum GameMode{
    EDIT, PLAY;
    }
    private static GameMode gameMode = GameMode.EDIT;
    private static int difficulty = 1;
    private static boolean gameStarted = false;
     

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int difficulty) {
        GameModel.difficulty = difficulty;
    }
    
   
    public static boolean hasGameStarted() {
        return gameStarted;
    }

    public static void setGameStarted(boolean gameStarted) {
        GameModel.gameStarted = gameStarted;
    }

    public static GameMode getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameMode gameMode) {
        GameModel.gameMode = gameMode;
    }

    public static boolean checkEnemyReachedBase(EnemyModel enemy) {
        if((int) enemy.getX() == BaseModel.getX() && (int) enemy.getY() == BaseModel.getY()){
            return true;
        }
        return false;
    }

    public static boolean checkGameOverCondition() {
        if(BaseModel.getHealth() <= 0){
            return true;
        }
        return false;
    }

    public static void updateEnemiesAndTileObservers() {
        int oldx;
        int oldy;
        int newx;
        int newy;
        Iterator<EnemyModel> iterator = WaveModel.getEnemyIterator();
        while (iterator.hasNext()) {
            EnemyModel enemy = iterator.next();
            
            if (enemy.isAlive()) {
                oldx = (int) enemy.getX();
                oldy = (int) enemy.getY();

                handeEnemyDirection(enemy);
                enemy.move();

                newx = (int) enemy.getX();
                newy = (int) enemy.getY();

                if(oldx != newx || oldy != newy){
                    MapModel.getTileAt(oldx, oldy).notifyObserversOfDeparture(enemy, MapModel.getTileAt(newx, newy));
                    MapModel.getTileAt(newx, newy).notifyObserversOfEntering(enemy);
                }
            }
            else {
                enemy.stopAttackTimer();
                iterator.remove();
                ShmucklesModel.setShmuckles(ShmucklesModel.getShmuckles()+enemy.getReward());
                MapModel.getTileAt((int)enemy.getX(), (int)enemy.getY()).notifyObserversOfEnemyDeath(enemy);
            }

        }
    }

    public static void handleEnemyMovement(EnemyModel enemyModel){
        handeEnemyDirection(enemyModel);
        enemyModel.move();
    }

    // this function implements a basic AI, designed to work on linear paths only. 
    public static void handeEnemyDirection(EnemyModel enemyModel){

        float ex = enemyModel.getX();
        float ey = enemyModel.getY();
        int x = (int) ex;
        int y = (int) ey;
        
        // general idea : when the enemy reaches the center of the tile it is on, it changes direction and declares that it has traversed the tile. If a tile has been traversed, changing direction on it becomes impossible

        // if the enemy has already traversed the tile, then it should not change direction on it
        // traversing a tile means that the enemy has passed the center of the tile
        if (enemyModel.getDirection() == DirectionModel.NONE || !CoordinatesHelper.areApproximatelyEqual(ex, x) || !CoordinatesHelper.areApproximatelyEqual(ey, y) || enemyModel.hasTraversedTile(x, y)) {
            return;
        }
        
        else if(checkEnemyReachedBase(enemyModel)){
            enemyModel.setDirection(DirectionModel.NONE);
            enemyModel.traversedTile(x, y);
            return;
        }
        else if(x+1 < MapModel.WIDTH && MapModel.getTileAt(x+1, y).getTileType().isWalkable() && enemyModel.getDirection() != DirectionModel.WEST){
            enemyModel.setDirection(DirectionModel.EAST);
            enemyModel.traversedTile(x, y);
            return;
        }
        else if(x-1 >= 0 && MapModel.getTileAt(x-1, y).getTileType().isWalkable() && enemyModel.getDirection() != DirectionModel.EAST){
            enemyModel.setDirection(DirectionModel.WEST);
            enemyModel.traversedTile(x, y);
            return;
        }
         else if(y+1 < MapModel.HEIGHT && MapModel.getTileAt(x, y+1).getTileType().isWalkable() && enemyModel.getDirection() != DirectionModel.NORTH){
            enemyModel.setDirection(DirectionModel.SOUTH);
            enemyModel.traversedTile(x, y);
            return;
        }
        else if(y-1 >= 0 && MapModel.getTileAt(x, y-1).getTileType().isWalkable() && enemyModel.getDirection() != DirectionModel.SOUTH){
            enemyModel.setDirection(DirectionModel.NORTH);
            enemyModel.traversedTile(x, y);
            return;

        }

        else{
            enemyModel.setDirection(DirectionModel.NONE);return;
        }

    }
    
    public static void updateBaseHealth(){
        Iterator<EnemyModel> iterator = WaveModel.getEnemyIterator();
        while(iterator.hasNext()){
            EnemyModel enemy = iterator.next();
            if(checkEnemyReachedBase(enemy)  && enemy.isAlive()){
                enemy.startAttackTimer();
            }
            else{
                enemy.stopAttackTimer();
            }
        }
    }

}


