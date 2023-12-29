package model.enemies;

import model.enemies.EnemyModel.Tier;
import model.gamelogic.DirectionModel;

public interface Enemy {
    int getHealth();
    void setHealth(int health);
    int getDamage();
    void setDamage(int damage);
    int getReward();
    void setReward(int reward);
    DirectionModel getDirection();
    void setDirection(DirectionModel direction);
    float getSpeed();
    void setSpeed(float speed);
    float getX();
    void setX(float x);
    float getY();
    void setY(float y);
    void move();
    boolean isAlive();
    void takeDamage(int damage);
    void attack();
    void startAttackTimer();
    void stopAttackTimer();
    void traversedTile(int x, int y);
    boolean hasTraversedTile(int x, int y);
    boolean isSpawned();
    void setSpawned(boolean spawned);
    Tier getTier();
    void setTier(Tier tier);
    Enemy clone();

}

