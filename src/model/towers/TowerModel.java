package model.towers;

import model.enemies.AggressiveModel;
import model.enemies.EnemyModel;

public abstract class TowerModel extends AggressiveModel implements Upgradable{
    protected int x;
    protected int y;
    protected int damage;
    protected int range;
    protected int cost;
    protected int level;
    protected int upgradeCost;
    protected EnemyModel currentTargetEnemy;
    
    public TowerModel(int damage, int range, int cost, int upgradeCost, int attackSpeed) {
        super(attackSpeed);
        this.damage = damage;
        this.range = range;
        this.cost = cost;
        this.level = 1;
        this.upgradeCost = upgradeCost;
    }

    public abstract void attackWithSpecialEffect(EnemyModel enemy);

    public abstract void upgradeSpecialEffect();

    @Override
    public void attack(){
            currentTargetEnemy.takeDamage(damage);
            attackWithSpecialEffect(currentTargetEnemy);
    }

    public void upgrade(){
        damage += 5;
        range += 1;
        cost += upgradeCost;
        upgradeSpecialEffect();
        level++;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public boolean isInRange(EnemyModel enemy){
        return (Math.abs(enemy.getX() - x) <= range && Math.abs(enemy.getY() - y) <= range);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getCost() {
        return cost;
    }

    public int getLevel() {
        return level;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y= y;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentTargetEnemy(EnemyModel currentTargetEnemy) {
        if(this.currentTargetEnemy != null)
            this.currentTargetEnemy = currentTargetEnemy;
    }
}
