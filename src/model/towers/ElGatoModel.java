package model.towers;

import java.util.Iterator;

public class ElGatoModel extends TowerModel{
    private static int range = 3;
    private static int attackSpeed = 1000;
    private static ProjectileModel projectile = new YarnBallModel();
    private static int attackSpeedUpgradeCost = 30;
    private static int rangeUpgradeCost = 30;
   

    public ElGatoModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void attack() {
        YarnBallModel yarnBall =(YarnBallModel) projectile.clone();
        yarnBall.setX(x);
        yarnBall.setY(y);
        yarnBall.targetEnemy(currentTargetEnemy);
        projectilesShot.add(yarnBall); 
    }
    
    @Override
    public TowerModel clone() {
        return new ElGatoModel();
    }
}
