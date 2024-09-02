package model.map;

import java.util.ArrayList;
import java.util.List;

import model.enemies.EnemyModel;
import model.gamelogic.MapComponentModel;
import model.map.tiletypes.TileType;
import model.towers.TowerModel;

public class TileModel {
    private List<TowerModel> observers = new ArrayList<>();
    private int x;
    private int y;
    private TileType type;

    private MapComponentModel mapComponent;

    public TileModel(int x, int y, TileType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    // all the getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TileType getTileType() {
        return type;
    }

    // all the setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTileType(TileType type) {
        this.type = type;
    }

    public void setMapComponentOnTile(MapComponentModel mapComponent) {
        this.mapComponent = mapComponent;
    }

    public boolean hasMapComponent() {
        return mapComponent != null;
    }

    public MapComponentModel getMapComponent() {
        return mapComponent;
    }

    public void addObserver(TowerModel observer) {
        if(type.isWalkable())
        observers.add(observer);
    }

    public void removeObserver(TowerModel observer) {
        if(type.isWalkable())
        observers.remove(observer);
    }

    public void notifyObserversOfDeparture(EnemyModel enemy,TileModel tile) {
        for (TowerModel observer : observers) {
            if(!tile.checkHasObserver(observer)) observer.updateEnemyOutOfRangeOrDead(enemy);
            else observer.updateEnemyInRange(enemy);
        }
    }

    public void notifyObserversOfEntering(EnemyModel enemy){
        for (TowerModel observer : observers) {
            observer.updateEnemyInRange(enemy);
        }
    }

    private boolean checkHasObserver(TowerModel tower) {
        return observers.contains(tower);
    }

    public void notifyObserversOfEnemyDeath(EnemyModel enemy) {
        for (TowerModel observer : observers) {
            observer.updateEnemyOutOfRangeOrDead(enemy);
        }
    }

    public void initObservers() {
        observers.clear();
    }

}

