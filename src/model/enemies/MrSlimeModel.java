package model.enemies;

import model.gamelogic.BaseModel;

public class MrSlimeModel extends EnemyModel{
    private static int health = 50;
    private static int damage = 10;
    private static float speed = 0.04f;
    private static int attackSpeed = 1000;
    private static int id;

    public MrSlimeModel() {
        super((int)(health * EnemyModel.getDifficultyMultiplierSpeed()), speed, damage, attackSpeed);
    }

    @Override
    public void attack() {
        BaseModel.takeDamage(damage);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MrSlimeModel.id = id;
    }

    @Override
    public MrSlimeModel newInstance(){
        MrSlimeModel clone = new MrSlimeModel();
        return clone;
    }
}
