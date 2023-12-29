package model.towers;

import javax.swing.Timer;

import model.enemies.Enemy;
import model.enemies.EnemyModel;

public class ElGatoModel extends TowerModel{
    private static int pacificationTime = 3;
    private static int COST = 100;
    private static int RANGE = 2;
    private static int DAMAGE = 10;
    private static int UPGRADE_COST = 50;
    


    
    public ElGatoModel(){
        super(DAMAGE, RANGE, COST, UPGRADE_COST);
    }



    @Override
    public void upgradeSpecialEffect() {
        pacificationTime += 1;
    }



    @Override
    public void attackWithSpecialEffect(Enemy enemy) {
        int originalDamage = enemy.getDamage();
        enemy.setDamage(0);
        Timer timer = new Timer(pacificationTime * 1000, e -> {
            enemy.setDamage(originalDamage);
        });
        timer.setRepeats(false);
        timer.start();
    }
    
}
