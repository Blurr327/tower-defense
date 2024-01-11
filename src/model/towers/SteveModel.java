package model.towers;

import model.towers.projectiles.FireBallModel;
import model.towers.projectiles.ProjectileModel;

import model.gamelogic.ShmucklesModel;

public class SteveModel extends TowerModel {

    private static int range = 3;
    private static int attackSpeed = 1500;
    private static ProjectileModel projectile = new FireBallModel();
    private static int attackSpeedUpgradeCost = 30;
    private static int rangeUpgradeCost = 30;
    private static String name = "Steve";
    private static int count = 0;
   

    public SteveModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
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
        System.out.println("Number of Steve : " + count);
    }

    @Override
    public void decreaseCount(){
        count--;
        System.out.println("Number of Steve : " + count);
    }

    public static void resetCount() {
        count = 0;
    }
}
