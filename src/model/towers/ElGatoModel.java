package model.towers;

import java.util.Iterator;

import model.gamelogic.ShmucklesModel;
import model.towers.projectiles.ProjectileModel;
import model.towers.projectiles.YarnBallModel;

public class ElGatoModel extends TowerModel{
    private static int range = 1;
    private static int attackSpeed = 1000;
    private static ProjectileModel projectile = new YarnBallModel();
    private static int attackSpeedUpgradeCost = 30;
    private static int rangeUpgradeCost = 30;
    private static String name = "Tower Cat";
    private static int count = 0;
   

    public ElGatoModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
    }

    @Override
    public void attack() {
        YarnBallModel yarnBall =(YarnBallModel) projectile.newInstance();
        yarnBall.setX(x);
        yarnBall.setY(y);
        yarnBall.targetEnemy(currentTargetEnemy);
        projectilesShot.add(yarnBall); 
    }
    
    @Override
    public TowerModel newInstance() {
        return new ElGatoModel();
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
        ElGatoModel.count++;
        System.out.println("Number of Cat : " + count);
    }

    @Override
    public void decreaseCount(){
        count--;
        System.out.println("Number of Cat : " + count);
    }

    public static void resetCount() {
        count = 0;
    }
}
