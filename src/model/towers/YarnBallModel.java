package model.towers;

import model.enemies.EnemyModel;
import javax.swing.Timer;

public class YarnBallModel extends ProjectileModel{
    private static int damage = 5;
    private static int upgradeCost = 10;
    private Timer pacificationTimer;
    private int pacificationDuration = 3000;
    private static float range = 0.5f;

    public YarnBallModel() {
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
        return new YarnBallModel();
    }
}
