package model.towers;

import java.util.Iterator;

import model.towers.projectiles.ProjectileModel;
import model.towers.projectiles.YarnBallModel;

public class ElGatoModel extends TowerModel{
    private static int range = 1;
    private static int attackSpeed = 1000;
    private static ProjectileModel projectile = new YarnBallModel();
    private static int attackSpeedUpgradeCost = 30;
    private static int rangeUpgradeCost = 30;
    private static String name = "Tower Cat";
   

    public ElGatoModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
        //TODO Auto-generated constructor stub
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
        double rpm = mtos * 60;
        return (float)rpm;
    }
}
