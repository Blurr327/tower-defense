package model.enemies;

import model.gamelogic.BaseModel;

public class MrSnakeModel extends EnemyModel{
    private static int health = 100;
    private static int damage = 20;
    private static float speed = 0.1f;
    private static int attackSpeed = 1000;
    private static int id;

    public MrSnakeModel() {
        super(health, speed * EnemyModel.getDifficultyMultiplierSpeed(), damage, attackSpeed);
    }

    @Override
    public void attack() {
        BaseModel.takeDamage(damage);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        MrSnakeModel.id = id;
    }

    @Override
    public MrSnakeModel newInstance(){
        MrSnakeModel clone = new MrSnakeModel();
        return clone;
    }
}
