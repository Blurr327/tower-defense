package controller;

import model.EnemyModel;
import model.MapEditorModel;

public class EnemyController {
    private EnemyModel enemyModel;

    public EnemyController(EnemyModel enemyModel) {
        this.enemyModel = enemyModel;
    }

    public static void updateEnemySpawnTile(int newX, int newY) {
        EnemyModel.setSpawnTileX(newX);
        EnemyModel.setSpawnTileY(newY);
    }
}
