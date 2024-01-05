package model.towers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.enemies.EnemyModel;
import model.gamelogic.WaveModel;
import model.map.MapModel;
import model.map.TileModel;

public class TowerManagerModel {
    public static final ArrayList<TowerModel> towersInGame = new ArrayList<TowerModel>();
    
    public static void addTower(TowerModel tower){
        TileModel tileContainingTower = MapModel.getTileAt((int) tower.getX(), (int)tower.getY());
        List<TileModel> tilesWithinRange = tower.getTilesWithinRange();
        towersInGame.add(tower);
        tileContainingTower.setMapComponentOnTile(tower);
        tilesWithinRange.forEach(tile -> tile.addObserver(tower));
    }

    public static boolean canAddTowerAt(int x, int y){
        boolean tileIsBuildable = !MapModel.getTileAt(x, y).getTileType().isWalkable();
        boolean positionIsTaken = MapModel.getTileAt(x, y).hasMapComponent();
        return !positionIsTaken && tileIsBuildable;
    }

    public static void removeTower(TowerModel tower){
        if(setToRemove(tower))
            towersInGame.remove(tower);
    }

    public static boolean setToRemove(TowerModel tower){
        if(tower == null)
            return false;
        if(towersInGame.contains(tower)){
            TileModel tile = MapModel.getTileAt((int) tower.getX(), (int)tower.getY());
            List<TileModel> tilesWithinRange = tower.getTilesWithinRange();
            tile.setMapComponentOnTile(null);
            tilesWithinRange.forEach(tileWithinRange -> tileWithinRange.removeObserver(tower));
            return true;
        }
        return false;
    }

    public static void updateCurrentEnemyTargets(){
        Iterator<EnemyModel> enemyIterator = WaveModel.getEnemyIterator();
        while(enemyIterator.hasNext()){
            EnemyModel enemy = enemyIterator.next();
            Iterator<TowerModel> towerIterator = towersInGame.iterator();
            while(towerIterator.hasNext()){
                TowerModel tower = towerIterator.next();
                if(tower.isInRange(enemy)) {
                    // if the tower is already attacking an enemy, don't change it until they're out of range or dead
                    tower.setCurrentTargetEnemyIfNotSet(enemy);
                    tower.startAttackTimer();  
                }
                 tower.handleCurrentEnemyTargetOutOfRangeOrDead();
            }
        }
    }

    public static void handleShotProjectiles() {
        Iterator<TowerModel> towerIterator = towersInGame.iterator();
        while(towerIterator.hasNext()){
            TowerModel tower = towerIterator.next();
            tower.manageShotProjectiles();
        }
    }

    public static int getNumberOfTowers(){
        return towersInGame.size();
    }

    public static TowerModel getTowerByIndex(int index){
        return towersInGame.get(index);
    }

    public static void clearTowers(){
        List<TowerModel> towersToRemove = new ArrayList<TowerModel>();
        Iterator<TowerModel> towerIterator = towersInGame.iterator();
        while(towerIterator.hasNext()){
            TowerModel tower = towerIterator.next();
            if(setToRemove(tower)) towersToRemove.add(tower);
        }
        towersInGame.removeAll(towersToRemove);
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

    public static Iterator<TowerModel> getTowerIterator(){
        return towersInGame.iterator();
    }
}
