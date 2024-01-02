package model.gamelogic;

import model.towers.TowerModel;

public class ShmucklesModel {
    private static int shmuckles = 100;

    public static int getShmuckles() {
        return shmuckles;
    }

    public static void setShmuckles(int shmuckles) {
        ShmucklesModel.shmuckles = shmuckles;
    }

    public static void buyTower(TowerModel tower) {
        if(tower!=null) shmuckles -= tower.getCost();
    }

    public static void sellTower(TowerModel tower) {
        if(tower !=null) shmuckles += tower.getCost();
    }

    public static boolean isRichEnoughForTower(TowerModel tower) {
        if(tower == null) return false;
        return shmuckles >= tower.getCost();
    }

    public static void initShmuckles() {
        shmuckles = 100;
    }
}
