package model;

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
    
}

