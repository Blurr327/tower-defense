package model.towers;

import java.util.Iterator;

public class GoesBrrrrrrrModel extends TowerModel{
    private static int range = 5;
    private static int attackSpeed = 300;
    private static ProjectileModel projectile = new BulletsBrrrrrModel();
    private static int attackSpeedUpgradeCost = 30;
    private static int rangeUpgradeCost = 30;
   

    public GoesBrrrrrrrModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void attack() {
        BulletsBrrrrrModel bullet =(BulletsBrrrrrModel) projectile.clone();
        bullet.setX(x);
        bullet.setY(y);
        bullet.targetEnemy(currentTargetEnemy);
        projectilesShot.add(bullet); 
    }
    
    @Override
    public TowerModel clone() {
        return new GoesBrrrrrrrModel();
    }
}
