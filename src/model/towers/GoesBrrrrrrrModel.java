package model.towers;

import model.towers.projectiles.BulletsBrrrrrModel;
import model.towers.projectiles.ProjectileModel;

public class GoesBrrrrrrrModel extends TowerModel {

    private static int range = 4;
    private static int attackSpeed = 300;
    private static ProjectileModel projectile = new BulletsBrrrrrModel();
    private static int attackSpeedUpgradeCost = 100;
    private static int rangeUpgradeCost = 100;
    private static String name = "Bunker";
   

    public GoesBrrrrrrrModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void attack() {
        BulletsBrrrrrModel bullets = (BulletsBrrrrrModel) projectile.newInstance();
        bullets.setX(x);
        bullets.setY(y);
        bullets.targetEnemy(currentTargetEnemy);
        projectilesShot.add(bullets); 
    }
    
    @Override
    public TowerModel newInstance() {
        return new GoesBrrrrrrrModel();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getFireRate() {
        return attackSpeed;
    }
    
}
