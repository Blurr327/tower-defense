package model.towers;

import java.util.ArrayList;

import model.enemies.EnemyModel;
import model.gamelogic.WaveModel;
import model.map.MapModel;

public class TowerManagerModel {
    public static final ArrayList<TowerModel> towersInGame = new ArrayList<TowerModel>();
    
    public static void addTower(TowerModel tower){
        towersInGame.add(tower);
        MapModel.getTileAt((int) tower.getX(), (int)tower.getY()).setMapComponentOnTile(tower);
    }

    public static boolean canAddTowerAt(int x, int y){
        boolean tileIsBuildable = !MapModel.getTileAt(x, y).getTileType().isWalkable();
        boolean positionIsTaken = MapModel.getTileAt(x, y).hasMapComponent();
        return !positionIsTaken && tileIsBuildable;
    }

    public static void removeTower(TowerModel tower){
        if(towersInGame.contains(tower)){
            towersInGame.remove(tower);
            MapModel.getTileAt((int) tower.getX(), (int) tower.getY()).setMapComponentOnTile(null);
        }
    }

    public static void updateCurrentEnemyTargets(){
        for(EnemyModel enemy : WaveModel.enemies) {
            for(TowerModel tower : towersInGame){
                if(tower.isInRange(enemy)) {
                    // if the tower is already attacking an enemy, don't change it until they're out of range or dead
                    tower.setCurrentTargetEnemyIfNotSet(enemy);
                    tower.startAttackTimer();  
                }
                 tower.manageShotProjectiles();
                 tower.handleCurrentEnemyTargetOutOfRangeOrDead();
            }
        }
    }

    public static int getNumberOfTowers(){
        return towersInGame.size();
    }

    public static TowerModel getTowerByIndex(int index){
        return towersInGame.get(index);
    }

    public static void clearTowers(){
        towersInGame.clear();
    }

    public static void stopAllTowers(){
        for(TowerModel tower : towersInGame){
            tower.stopAttackTimer();
        }
    }

    public static void startAllTowers(){
        for(TowerModel tower : towersInGame){
            if(tower.hasTargetEnemy())
            tower.startAttackTimer();
        }
    }
}
