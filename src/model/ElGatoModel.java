package model;

import javax.swing.Timer;

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
    public void attackWithSpecialEffect(EnemyModel enemy) {
        enemy.setDamage(0);
        Timer timer = new Timer(pacificationTime * 1000, e -> {
            enemy.setDamage(enemy.getType().getDamage());
        });
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void upgradeSpecialEffect() {
        pacificationTime += 1;
    }
    
}
