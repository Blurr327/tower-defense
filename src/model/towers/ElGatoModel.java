package model.towers;

import java.util.Iterator;

import model.gamelogic.ShmucklesModel;
import model.towers.projectiles.ProjectileModel;
import model.towers.projectiles.YarnBallModel;

public class ElGatoModel extends TowerModel{
    private static int range = 1;
    private static int attackSpeed = 1000;
    private static int attackSpeedUpgradeCost = 30;
    private static int rangeUpgradeCost = 30;
    private static String name = "Tower Cat";
    private static int count = 0;
   

    public ElGatoModel() {
        super(range, attackSpeed, new YarnBallModel(), attackSpeedUpgradeCost, rangeUpgradeCost);
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
        ElGatoModel copy = new ElGatoModel();
        copy.setAttackSpeed(super.attackSpeed);
        copy.setRange(super.range);
        copy.setCost(super.cost);
        copy.projectile = super.projectile.newInstance();
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

    @Override
    public void resetStats() {
        projectile.resetStats();
        super.range = range;
        super.attackSpeed = attackSpeed;
        super.cost = calculateInitialCost();
        level = 1;
    }
}
