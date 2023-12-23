package controller;

import model.EnemyModel;
import model.MapEditorModel;

public class EnemyController {
    private EnemyModel enemyModel;

    public EnemyController(EnemyModel enemyModel) {
        this.enemyModel = enemyModel;
    }

    public static void initSpawnTile(){
        EnemyModel.setSpawnTileX(MapEditorModel.getSpawnTileX());
        EnemyModel.setSpawnTileY(MapEditorModel.getSpawnTileY());
    }

    public static void initTargetTile(){
        EnemyModel.setTargetTileX(MapEditorModel.getTargetTileX());
        EnemyModel.setTargetTileY(MapEditorModel.getTargetTileY());
    }
}
