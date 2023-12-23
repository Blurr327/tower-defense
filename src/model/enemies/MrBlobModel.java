package model.enemies;

import model.DirectionModel;
import model.EnemyModel;

public class MrBlobModel extends EnemyModel{
    
    public MrBlobModel() {
        super(100, 0.1f, 1, 10, 0);
        this.setDirection(DirectionModel.EAST);
    }

}
