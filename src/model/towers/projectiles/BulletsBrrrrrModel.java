package model.towers.projectiles;

import model.enemies.EnemyModel;

import javax.swing.Timer;

public class BulletsBrrrrrModel extends ProjectileModel{
    private static int damage = 2;
    private static int upgradeCost = 40;
    private Timer pacificationTimer;
    private int pacificationDuration = 1000;
    private static double range = 0.2;
    private static float speed = 10;


    public BulletsBrrrrrModel() {
        super(damage, upgradeCost, range, speed);
    }

    @Override
    public void applySpecialEffect(EnemyModel enemy) {
        int originalDamage = enemy.getDamage();
        enemy.setDamage(0);
        pacificationTimer = new Timer(pacificationDuration, e -> {
            enemy.setDamage(originalDamage);
        });
        pacificationTimer.setRepeats(false);
        pacificationTimer.start();
    }

    @Override
    public void upgradeSpecialEffect() {
        pacificationDuration += 500;
    }

    @Override
    public ProjectileModel newInstance() {
        BulletsBrrrrrModel copy = new BulletsBrrrrrModel();
        copy.setDamage(super.damage);
        copy.setRange(super.range);
        copy.setCost(super.cost);
        copy.setSpeed(super.speed);
        return copy;
    }
    
}
