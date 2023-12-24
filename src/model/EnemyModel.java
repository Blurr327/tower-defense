package model;

import java.util.ArrayList;

public enum EnemyModel {
    MRBLOB(30, 0.03f,1,10),
    MRSLIME(60, 0.01f, 5, 30),
    MRSNAKE(100, 0.1f, 3, 50);

    private int health;
    private float speed;
    private int damage;
    private int reward;
    private float x;
    private float y;

    private DirectionModel direction;
    private static int nextId = 0;
    private static int spawnTileX;
    private static int spawnTileY;
    private static int targetTileX;
    private static int targetTileY;

    private EnemyModel(int health, float speed, int damage, int reward) {
        
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        this.reward = reward;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
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

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        EnemyModel.nextId = nextId;
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
    

    public static ArrayList<EnemyModel> getEnemiesByDamage(int damage) {
        ArrayList<EnemyModel> res = new ArrayList<>();
        for (EnemyModel enemyModel : EnemyModel.values()) {
            if (enemyModel.getDamage() <= damage) {
                res.add(enemyModel);
            }
        }
        return res;
    }
    
}
