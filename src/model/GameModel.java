package model;

import javax.swing.Timer;

import view.MapView;

public enum GameModel {
    EDIT, PLAY;
    private static GameModel gameMode = EDIT;
    
    
   
    public static GameModel getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameModel gameMode) {
        GameModel.gameMode = gameMode;
    }

    public static boolean checkEnemyReachedBase(EnemyModel enemy) {
        if((int) enemy.getX() == BaseModel.getX() && (int) enemy.getY() == BaseModel.getY()){
            return true;
        }
        return false;
    }

    public static boolean  checkNextWaveCondition() {
        if(WaveModel.areAllEnemiesDead()){
            return true;
        }
        return false;
    }

    public static boolean checkGameOverCondition() {
        if(BaseModel.getHealth() <= 0){
            return true;
        }
        return false;
    }

    public static void handleEnemyMovement(EnemyModel enemyModel){
        handeEnemyDirection(enemyModel);
        enemyModel.move();
    }

    // this function implements a basic AI, designed to work on linear paths only. 
    public static void handeEnemyDirection(EnemyModel enemyModel){

        float ex = enemyModel.getX();
        float ey = enemyModel.getY();
        int x = (int) ex;
        int y = (int) ey;
        
        // general idea : when the enemy reaches the center of the tile it is on, it changes direction and declares that has traversed the tile. If a tile has been traversed, changing direction on it becomes impossible

        // if the enemy has already traversed the tile, then it should not change direction on it
        // traversing a tile means that the enemy has passed the center of the tile
        if (enemyModel.getDirection() == DirectionModel.NONE || !CoordinatesHelper.areApproximatelyEqual(ex, x) || !CoordinatesHelper.areApproximatelyEqual(ey, y) || enemyModel.hasTraversedTile(x, y)) {
            return;
        }
        
        else if(checkEnemyReachedBase(enemyModel)){
            enemyModel.setDirection(DirectionModel.NONE);
            enemyModel.traversedTile(x, y);
            return;
        }
        else if(x+1 < MapModel.WIDTH && MapModel.getTileAt(x+1, y).getTileType().isWalkable() && enemyModel.getDirection() != DirectionModel.WEST){
            enemyModel.setDirection(DirectionModel.EAST);
            enemyModel.traversedTile(x, y);
            return;
        }
        else if(x-1 >= 0 && MapModel.getTileAt(x-1, y).getTileType().isWalkable() && enemyModel.getDirection() != DirectionModel.EAST){
            enemyModel.setDirection(DirectionModel.WEST);
            enemyModel.traversedTile(x, y);
            return;
        }
         else if(y+1 < MapModel.HEIGHT && MapModel.getTileAt(x, y+1).getTileType().isWalkable() && enemyModel.getDirection() != DirectionModel.NORTH){
            enemyModel.setDirection(DirectionModel.SOUTH);
            enemyModel.traversedTile(x, y);
            return;
        }
        else if(y-1 >= 0 && MapModel.getTileAt(x, y-1).getTileType().isWalkable() && enemyModel.getDirection() != DirectionModel.SOUTH){
            enemyModel.setDirection(DirectionModel.NORTH);
            enemyModel.traversedTile(x, y);
            return;

        }

        else{
            enemyModel.setDirection(DirectionModel.NONE);return;
        }

    }
    
    public static void updateBaseHealth(){
        for(EnemyModel enemy : WaveModel.enemies){
            if(checkEnemyReachedBase(enemy)){
                enemy.startAttackTimer();
            }
        }
    }

}


