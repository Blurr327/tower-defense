package controller;

import model.enemies.EnemyModel;
import model.map.MapEditorModel;
import model.map.MapModel;

public class EnemyController {
    private EnemyModel enemyModel;

    public EnemyController(EnemyModel enemyModel) {
        this.enemyModel = enemyModel;
    }

    public static void updateEnemySpawnTile(int newX, int newY) {
        EnemyModel.setSpawnTile(MapModel.getTileAt(newX, newY));
    }
}
