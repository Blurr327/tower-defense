package model.towers;

import model.gamelogic.ShmucklesModel;
import model.towers.projectiles.BulletsBrrrrrModel;
import model.towers.projectiles.ProjectileModel;

public class GoesBrrrrrrrModel extends TowerModel {

    private static int range = 4;
    private static int attackSpeed = 300;
    private static ProjectileModel projectile = new BulletsBrrrrrModel();
    private static int attackSpeedUpgradeCost = 100;
    private static int rangeUpgradeCost = 100;
    private static String name = "Bunker";
    private static int count = 0;
   

    public GoesBrrrrrrrModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
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
    public float getFireRate() {
        double mtos = (double) attackSpeed / 1000;
        double rpm = 60/mtos;
        return (float)rpm;
    }

    @Override 
    public int getDamage() {
        return projectile.getDamage();
    }

    @Override
    public void upgrade(){
        if (level < 10) {
            if (ShmucklesModel.getShmuckles() - upgradeCost*count >= 0){
                projectile.upgrade();
                range += 1;
                cost += upgradeCost;
                level++;
                ShmucklesModel.setShmuckles(ShmucklesModel.getShmuckles() - upgradeCost*count);
                System.out.println("Upgrade successful");
            }
            else {
                System.out.println("Not enough shmuckles");
            }
            
        }
        else {
            System.out.println("Tower is already at max level");
        }
    }

    @Override
    public void downgrade() {
        if (level > 1) {
            projectile.downgrade();
            range -= 1;
            cost -= upgradeCost;
            level--;
            ShmucklesModel.setShmuckles(ShmucklesModel.getShmuckles() + upgradeCost*count);
            System.out.println("Downgrade successful");
        }
        else {
            System.out.println("Tower is already at min level");
        }
    }

    @Override
    public void increaseCount(){
        count++;
        System.out.println("Number of bunker : " + count);
    }

    @Override
    public void decreaseCount(){
        count--;
        System.out.println("Number of bunker : " + count);
    }

    public static void resetCount() {
        count = 0;
    }
}
