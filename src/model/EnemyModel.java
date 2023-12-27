package model;

import java.util.ArrayList;

import javax.swing.Timer;

public class EnemyModel implements Enemy{

    private EnemyType type;
    private int health;
    private float speed;
    private int damage;
    private int reward;
    private float x;
    private float y;
    private boolean spawned;
    private boolean[][] path = new boolean[MapModel.HEIGHT][MapModel.WIDTH];
    private Timer attackTimer;

    private DirectionModel direction;

    private static int spawnTileX = 0;
    private static int spawnTileY = MapModel.HEIGHT/2;
    private static int targetTileX;
    private static int targetTileY;

    public EnemyModel(EnemyType type) {
        this.x = spawnTileX;
        this.y = spawnTileY;
        this.type = type;
        this.health = type.getHealth();
        this.speed = type.getSpeed();
        this.damage = type.getDamage();
        this.reward = type.getReward();
        this.direction = DirectionModel.EAST;
        attackTimer = new Timer(1000, e -> attackBase());

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

    public EnemyType getType() {
        return type;
    }

    public static int getSpawnTileX() {
        return spawnTileX;
    }

    public static void setSpawnTileX(int spawnTileX) {
        EnemyModel.spawnTileX = spawnTileX;
    }

    public static int getSpawnTileY() {
        return spawnTileY;
    }

    public static void setSpawnTileY(int spawnTileY) {
        EnemyModel.spawnTileY = spawnTileY;
    }

    public static int getTargetTileX() {
        return targetTileX;
    }

    public static void setTargetTileX(int targetTileX) {
        EnemyModel.targetTileX = targetTileX;
    }

    public static int getTargetTileY() {
        return targetTileY;
    }

    public static void setTargetTileY(int targetTileY) {
        EnemyModel.targetTileY = targetTileY;
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

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
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

    public void attackBase(){
        BaseModel.takeDamage(damage);
    }

    public void startAttackTimer(){
        attackTimer.start();
    }

    public void stopAttackTimer(){
        attackTimer.stop();
    }

    public void takeDamage(int damage){
        health -= damage;
    }
}


