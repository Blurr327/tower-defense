package model.enemies;

import java.util.ArrayList;

import javax.swing.Timer;

import model.gamelogic.AggressiveModel;
import model.gamelogic.DirectionModel;
import model.map.MapModel;
import model.map.TileModel;

public abstract class EnemyModel extends AggressiveModel {

    public static enum Tier {
        C, B, A
    }

    private int health;
    private float speed;
    private int damage;
    private int reward;
    private boolean spawned;
    private boolean[][] path = new boolean[MapModel.HEIGHT][MapModel.WIDTH];
    private Tier tier;
    private DirectionModel direction;
    private static float difficultyMultiplierSpeed = 1.0f; // 1 by default static because it is the same for all enemies

    private static TileModel spawnTile = MapModel.getTileAt(0, MapModel.HEIGHT/2);

    public EnemyModel(int health, float speed, int damage, int attackSpeed) {
        super(attackSpeed);
        this.x = spawnTile.getX();
        this.y = spawnTile.getY();
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        this.tier = calculateTier();
        this.reward = calculateReward();
        this.direction = DirectionModel.EAST;
    }

    public abstract EnemyModel newInstance();

    public abstract void attack();

    public static void setSpawnTile(TileModel spawnTile) {
        EnemyModel.spawnTile = spawnTile;
    }

    public static int getSpawnTileX() {
        return spawnTile.getX();
    }

    public static int getSpawnTileY() {
        return spawnTile.getY();
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    private Tier calculateTier(){
            
        // very basic tier calculation
        if(this.health >= 100 || this.damage >= 20 || this.speed >= 0.1f){
            return Tier.A;
        }
        else if(this.health >= 50 || this.damage >= 10 || this.speed >= 0.05f){
            return Tier.B;
        }
        else{
            return Tier.C;
        }
    }

    private int calculateReward(){
        switch (this.tier){
            case A:
                return 100;
            case B:
                return 50;
            case C:
                return 25;
            default:
                return 0;
        }
    }

    public void move() {
        switch (direction) {
            case NORTH:
                y -= speed;
                break;
            case SOUTH:
                y += speed;
                break;
            case EAST:
                x += speed;
                break;
            case WEST:
                x -= speed;
                break;
            case NONE:
                break;
        }
    }
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }


    public DirectionModel getDirection() {
        return direction;
    }

    public void setDirection(DirectionModel direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isSpawned() {
        return spawned;
    }

    public void setSpawned(boolean spawned) {
        this.spawned = spawned;
    }

    public void traversedTile(int x, int y) {
        path[y][x] = true;
    }

    public boolean hasTraversedTile(int x, int y) {
        return path[y][x];
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    // will be usefull for the difficulties

    public static float getDifficultyMultiplierSpeed() {
        return EnemyModel.difficultyMultiplierSpeed;
    }

    public static void setDifficultyMultiplierSpeed(float difficultyMultiplierSpeed) {
        EnemyModel.difficultyMultiplierSpeed = difficultyMultiplierSpeed;
    }

}


