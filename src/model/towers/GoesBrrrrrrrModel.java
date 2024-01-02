package model.towers;

public class GoesBrrrrrrrModel extends TowerModel {

    private static int range = 4;
    private static int attackSpeed = 300;
    private static ProjectileModel projectile = new BulletsBrrrrrModel();
    private static int attackSpeedUpgradeCost = 100;
    private static int rangeUpgradeCost = 100;
   

    public GoesBrrrrrrrModel() {
        super(range, attackSpeed, projectile, attackSpeedUpgradeCost, rangeUpgradeCost);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void attack() {
        BulletsBrrrrrModel bullets = new BulletsBrrrrrModel();
        bullets.setX(x);
        bullets.setY(y);
        bullets.targetEnemy(currentTargetEnemy, attackSpeed);
        projectilesShot.add(bullets); 
    }
    
    @Override
    public TowerModel clone() {
        return new GoesBrrrrrrrModel();
    }
    
}
