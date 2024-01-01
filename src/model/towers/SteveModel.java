package model.towers;

import java.util.Iterator;

public class SteveModel extends TowerModel{
    private static int range = 10;
    private static int attackSpeed = 2000;
    private static ProjectileModel projectile = new FireBallModel();
    private static int attackSpeedUpgradeCost = 30;
    private static int rangeUpgradeCost = 30;
   

    public SteveModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void attack() {
        FireBallModel fireBall =(FireBallModel) projectile.clone();
        fireBall.setX(x);
        fireBall.setY(y);
        fireBall.targetEnemy(currentTargetEnemy);
        projectilesShot.add(fireBall); 
    }
    
    @Override
    public TowerModel clone() {
        return new SteveModel();
    }
}
