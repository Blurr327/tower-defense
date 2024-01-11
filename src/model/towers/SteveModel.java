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
        SteveModel copy = new SteveModel();
        copy.setAttackSpeed(super.attackSpeed);
        copy.setRange(super.range);
        copy.setCost(super.cost);

        return copy;
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
