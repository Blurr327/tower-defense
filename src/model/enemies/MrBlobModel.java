package model.enemies;

import model.gamelogic.BaseModel;

public class MrBlobModel extends EnemyModel{
    private static int health = 30;
    private static int damage = 5;
    private static float speed = 0.01f;
    private static int attackSpeed = 1000;
    private static int id;

    public MrBlobModel() {
        super(health, speed, damage, attackSpeed);
    }
    
    @Override
    public void attack() {
        BaseModel.takeDamage(damage);
    }

     public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MrBlobModel.id = id;
    }

    @Override
    public MrBlobModel newInstance(){
        MrBlobModel clone = new MrBlobModel();
        return clone;
    }
}
