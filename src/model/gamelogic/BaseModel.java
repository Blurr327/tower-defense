package model.gamelogic;

import model.map.MapModel;

public class BaseModel {
    private static int x = MapModel.WIDTH-1;
    private static int y = MapModel.HEIGHT/4;

    private static int health;

    public static int getX() {
        return x;
    }
    public static void setX(int x) {
        BaseModel.x = x;
    }
    public static int getY() {
        return y;
    }
    public static void setY(int y) {
        BaseModel.y = y;
    }
    public static int getHealth() {
        return health;
    }
    public static void setHealth(int health) {
        BaseModel.health = health;
    }

    public static void initBase(){
        health = 100;
    }

    public static void takeDamage(int damage){
        health -= damage;
    }
    
}

