package model.towers.projectiles;

import model.enemies.EnemyModel;

import javax.swing.Timer;

public class FireBallModel extends ProjectileModel{
    private static int damage = 10;
    private static int upgradeCost = 10;
    private Timer pacificationTimer;
    private int pacificationDuration = 1000;
    private static double range = 0.4;
    private static float speed = 6;


    public FireBallModel() {
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
        return new FireBallModel();
    }
    
}
