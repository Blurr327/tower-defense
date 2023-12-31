package model.towers;

import model.enemies.EnemyModel;
import model.gamelogic.CoordinatesHelper;
import view.AppView;

public abstract class ProjectileModel extends MapComponentModel implements Upgradable{
    private float xVelocity; // this is the x component of the velocity vector of the projectile
    private float yVelocity; // this is the y component of the velocity vector of the projectile
    private int damage;
    private int level;
    private int upgradeCost;
    private int cost;
    private double range; // using double for more precision
    private float speed; // this is the speed of the projectile in pixels per frame


    public ProjectileModel(int damage ,int upgradeCost, double range, float speed) {
        this.damage = damage;
        this.upgradeCost = upgradeCost;
        this.range = range;
        this.cost = calculateInitialCost();;
        this.speed = speed;
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

    public abstract ProjectileModel clone();

    public void applyDamage(EnemyModel enemy) {
        enemy.setHealth(enemy.getHealth() - damage);
        applySpecialEffect(enemy);
    }

    public boolean isInRange(EnemyModel enemy) {
        if(enemy==null){
            return false;
        }
        float xDistance = enemy.getX() - x;
        float yDistance = enemy.getY() - y;
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        return distance <= range;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void targetEnemy(EnemyModel enemy) {
        if(enemy==null){
            return;
        }
        // let B be the point where the projectile is fired from, and A be the point where the enemy is
        float xDistance = enemy.getX() - x; // xDistance represents the x coordinate of the vector AB
        float yDistance = enemy.getY() - y; // yDistance represents the y coordinate of the vector AB
        float distance = (float) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)); // this is the norm of AB
        // we divide the xDistance and yDistance by the norm of AB to get the unit vector of AB (i.e. the direction of AB)
        xVelocity = speed*xDistance / (distance* 32); // we multiply by 32 because 1 Unit in our game is 32 pixels
        yVelocity = speed*yDistance / (distance *32);  
        
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


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }


    public void setCost(int cost) {
        this.cost = cost;
    }


    public float getSpeed() {
        return speed;
    }


    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
