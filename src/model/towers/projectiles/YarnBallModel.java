package model.towers.projectiles;

import model.enemies.EnemyModel;

import javax.swing.Timer;

public class YarnBallModel extends ProjectileModel{
    private static int damage = 5;
    private static int upgradeCost = 10;
    private static Timer pacificationTimer;
    private static int pacificationDuration = 3000;
    private static double range = 0.4;
    private static float speed = 3; // this is the speed of the projectile in pixels per frame

    public YarnBallModel() {
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
        return new YarnBallModel();
    }
}
