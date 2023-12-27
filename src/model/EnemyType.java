package model;

import java.util.ArrayList;

public enum EnemyType {
    MRBLOB(30 ,5, 0.01f), MRSLIME(50,10, 0.05f), MRSNAKE(100,20, 0.1f);

    public enum Tier{
        A, B, C;
    }

    private final int health;
    private final int damage;
    private final int reward;
    private final float speed;
    private final Tier tier;

    private EnemyType(int health, int damage, float speed){
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.tier = calculateTier();
        this.reward = calculateReward();
    }

    public Tier calculateTier(){
            
        // very basic tier calculation
        if(this.health >= 100 || this.damage >= 20 || this.speed >= 0.1f){
            return Tier.A;
        }
        else if(this.health >= 50 || this.damage >= 10 || this.speed >= 0.05f){
            return Tier.B;
        }
        else{
            return Tier.C;
        }
    }

    public int calculateReward(){
        switch (this.tier){
            case A:
                return 100;
            case B:
                return 50;
            case C:
                return 25;
            default:
                return 0;
        }
    }
    
    public int getDamage() {
        return damage;
    }

    public int getReward() {
        return reward;
    }

    public float getSpeed() {
        return speed;
    }

    public Tier getTier() {
        return tier;
    }

    public int getHealth() {
        return health;
    }

    public static ArrayList<EnemyType> getEnemyTypeByTier(Tier tier){
        ArrayList<EnemyType> enemyTypes = new ArrayList<>();
        for(EnemyType enemyType : EnemyType.values()){
            if(enemyType.getTier() == tier){
                enemyTypes.add(enemyType);
            }
        }
        return enemyTypes;
    }

}

