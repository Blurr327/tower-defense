package model.towers;

import model.enemies.EnemyModel;
import model.gamelogic.CoordinatesHelper;
import view.AppView;

public abstract class ProjectileModel implements Upgradable{
    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity;
    private int damage;
    private int level;
    private int upgradeCost;
    private int cost;


    public ProjectileModel(int damage ,int upgradeCost) {
        this.damage = damage;
        this.upgradeCost = upgradeCost;
        this.cost = calculateInitialCost();;
    }

    public int calculateInitialCost(){
        if(damage>=20){
            return 30;
        }
        else if(damage>=10){
            return 20;
        }
        else{
            return 10;
        }
    }

    public abstract void applySpecialEffect(EnemyModel enemy);

    public abstract void upgradeSpecialEffect();

    public void applyDamage(EnemyModel enemy) {
        enemy.setHealth(enemy.getHealth() - damage);
    }

    public boolean isInRange(EnemyModel enemy) {
        if(enemy==null){
            return false;
        }
        float xDistance = enemy.getX() - x;
        float yDistance = enemy.getY() - y;
        float distance = (float) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        return CoordinatesHelper.areApproximatelyEqual(0, distance);
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void targetEnemy(EnemyModel enemy, float durationTillImpact) {
        if(enemy==null){
            return;
        }
        // let B be the point where the projectile is fired from, and A be the point where the enemy is
        float xDistance = enemy.getX() - x; // xDistance represents the x coordinate of the vector AB
        float yDistance = enemy.getY() - y; // yDistance represents the y coordinate of the vector AB
        float distance = (float) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)); // this is the norm of AB
        // we divide the xDistance and yDistance by the norm of AB to get the unit vector of AB (i.e. the direction of AB)
        xVelocity = 5*xDistance / (distance* 32); // we multiply by 32 because 1 Unit in our game is 32 pixels
        yVelocity = 5*yDistance / (distance *32);  
        
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public float getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public int getCost() {
        return cost;
    }

    public void upgrade() {
        damage += 1;
        cost += upgradeCost;
        upgradeSpecialEffect();
        level++;
    }

}
