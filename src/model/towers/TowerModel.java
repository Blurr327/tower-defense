package model.towers;

import model.enemies.AggressiveModel;
import model.enemies.EnemyModel;
import model.gamelogic.Upgradable;
import model.towers.projectiles.ProjectileModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class TowerModel extends AggressiveModel implements Upgradable, Cloneable {

    protected ProjectileModel projectile;
    protected int range;
    protected int cost;
    protected int level;
    protected int upgradeCost;
    protected EnemyModel currentTargetEnemy;
    protected ArrayList<ProjectileModel> projectilesShot = new ArrayList<>();

    public TowerModel(int range, int attackSpeed, ProjectileModel projectile, int attackSpeedUpgradeCost, int rangeUpgradeCost) {
        super(attackSpeed);
        this.range = range;
        this.projectile = projectile;
        this.cost = calculateInitialCost();
        this.level = 1;
        this.upgradeCost = projectile.getUpgradeCost() + attackSpeedUpgradeCost + rangeUpgradeCost;
    }

    public int calculateInitialCost(){
        int cost = projectile.getCost();
        if(attackSpeed<=2 || range>=5){
            cost += 50;
        }
        else if(attackSpeed<=1 || range>=4){
            cost += 20;
        }
        return cost;
    }

    public abstract void attack();

    public abstract TowerModel newInstance();

    public void upgrade(){
        projectile.upgrade();
        range += 1;
        cost += upgradeCost;
        level++;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public void upgradeAttackSpeed(){
        attackSpeed -= 500;
    }


    public boolean isInRange(EnemyModel enemy){
        return Math.sqrt(Math.pow(enemy.getX() - x, 2) + Math.pow(enemy.getY() - y, 2)) <= range;
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

    public void setRange(int range) {
        this.range = range;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentTargetEnemyIfNotSet(EnemyModel currentTargetEnemy) {
        if (this.currentTargetEnemy != null && isInRange(this.currentTargetEnemy)) {
            return;
        }
        else this.currentTargetEnemy = currentTargetEnemy;
    }

    public void handleCurrentEnemyTargetOutOfRangeOrDead(){
        if(currentTargetEnemy != null && (!isInRange(currentTargetEnemy) || !currentTargetEnemy.isAlive())){
            System.out.println("Enemy out of range");
            currentTargetEnemy = null;
            stopAttackTimer();
        }
    }
    public void manageShotProjectiles(){
        List<ProjectileModel> projectilesToRemove = new ArrayList<>();
        if(currentTargetEnemy== null) projectilesShot.clear();
        for (ProjectileModel projectile : projectilesShot) {
            projectile.move();
            System.out.println(projectile);
            if (projectile.isInRange(currentTargetEnemy)) {
                System.out.println("Projectile hit enemy");
                projectile.applyDamage(currentTargetEnemy);
                projectilesToRemove.add(projectile);
            }
        }
    
        // Remove projectiles after the iteration is complete
        projectilesShot.removeAll(projectilesToRemove);
    }

    public int getNumberOfShotProjectiles(){
        return projectilesShot.size();
    }

    public ProjectileModel getProjectileByIndex(int i){
        return projectilesShot.get(i);
    }

    public boolean hasTargetEnemy(){
        return currentTargetEnemy != null;
    }
}
