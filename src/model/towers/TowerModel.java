package model.towers;

import model.enemies.EnemyModel;
import model.gamelogic.AggressiveModel;
import model.gamelogic.Upgradable;
import model.map.MapModel;
import model.map.TileModel;
import model.towers.projectiles.ProjectileModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class TowerModel extends AggressiveModel implements Upgradable {

    protected ProjectileModel projectile;
    protected int range;
    protected int cost;
    protected int level;
    protected int upgradeCost;
    protected List<EnemyModel> enemiesInRange = new ArrayList<>();
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

    public void manageShotProjectiles(){
        List<ProjectileModel> projectilesToRemove = new ArrayList<>();
        if(currentTargetEnemy== null) projectilesShot.clear();
        for (ProjectileModel projectile : projectilesShot) {
            projectile.move();
            if (projectile.isInRange(currentTargetEnemy)) {
                System.out.println("Projectile hit enemy");
                projectile.applyDamage(currentTargetEnemy);
                projectilesToRemove.add(projectile);
            }
        }
    
        // Remove projectiles after the iteration is complete
        projectilesShot.removeAll(projectilesToRemove);
    }

    public boolean hasTargetEnemy(){
        return currentTargetEnemy != null;
    }

    public Iterator<ProjectileModel> getShotProjectilesIterator(){
        return projectilesShot.iterator();
    }

    public void updateEnemyInRange(EnemyModel enemy) {
        if(currentTargetEnemy == null) {
             currentTargetEnemy = enemy;
            this.startAttackTimer();
        }
        if(!enemiesInRange.contains(enemy)) enemiesInRange.add(enemy);
    }

    public void updateEnemyOutOfRangeOrDead(EnemyModel enemy) {
        enemiesInRange.remove(enemy);
        this.stopAttackTimer();
        if(!enemiesInRange.isEmpty()){
            currentTargetEnemy = enemiesInRange.get(0);
            this.startAttackTimer();
        }
        else currentTargetEnemy = null;
    }

    public List<TileModel> getTilesWithinRange(){
        List<TileModel> tilesWithinRange = new ArrayList<>();
        for(int i = (int)x - range; i <= (int)x + range; i++){
            for(int j = (int)y - range; j <= (int)y + range; j++){
                if(i >= 0 && i < 20 && j >= 0 && j < 20){
                    tilesWithinRange.add(MapModel.getTileAt(i, j));
                }
            }
        }
        return tilesWithinRange;
    }

    // to get the type of ammunition being used 
    public ProjectileModel getProjectile() {
        return projectile;
    }

    public abstract String getName();

    public abstract int getFireRate();

}