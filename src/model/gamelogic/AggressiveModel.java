package model.gamelogic;

import javax.swing.Timer;

public abstract class AggressiveModel extends MapComponentModel{
    protected Timer attackTimer;
    protected int attackSpeed;

    public AggressiveModel(int attackSpeed) {
        this.attackSpeed = attackSpeed;
        attackTimer = new Timer(attackSpeed, e -> attack());
    }

    public abstract void attack();

    public void startAttackTimer() {
        attackTimer.start();
    }

    public void stopAttackTimer() {
        attackTimer.stop();
    }
    
    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
    
}