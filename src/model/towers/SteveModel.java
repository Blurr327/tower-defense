package model.towers;

import model.towers.projectiles.FireBallModel;
import model.towers.projectiles.ProjectileModel;

public class SteveModel extends TowerModel {

    private static int range = 3;
    private static int attackSpeed = 1000;
    private static ProjectileModel projectile = new FireBallModel();
    private static int attackSpeedUpgradeCost = 30;
    private static int rangeUpgradeCost = 30;
    private static String name = "Steve";
   

    public SteveModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void attack() {
        FireBallModel fireBall = (FireBallModel) projectile.newInstance();
        fireBall.setX(x);
        fireBall.setY(y);
        fireBall.targetEnemy(currentTargetEnemy);
        projectilesShot.add(fireBall); 
    }
    
    @Override
    public TowerModel newInstance() {
        return new SteveModel();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getFireRate() {
        double mtos = (double) attackSpeed / 1000;
        double rpm = mtos * 60;
        return (float)rpm;
    }
    
}
