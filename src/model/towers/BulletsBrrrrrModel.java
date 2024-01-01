package model.towers;

import model.enemies.EnemyModel;
import javax.swing.Timer;

public class BulletsBrrrrrModel extends ProjectileModel{
    private static int damage = 2;
    private static int upgradeCost = 10;
    private Timer pacificationTimer;
    private int pacificationDuration = 3000;
    private static float range = 1.0f;

    public BulletsBrrrrrModel() {
        super(damage, upgradeCost, range);
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
    public ProjectileModel clone() {
        return new BulletsBrrrrrModel();
    }
}
