package model;

public class TileModel {
    private int x;
    private int y;
    private TileType type;
    private boolean hasEnemy;
    private boolean hasTower;
    private boolean isTarget;
    private boolean isSpawn;

    public TileModel(int x, int y, TileType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.hasEnemy = false;
        this.hasTower = false;
    }

    // all the getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TileType getTileType() {
        return type;
    }

    public boolean getHasEnemy() {
        return hasEnemy;
    }

    public boolean getHasTower() {
        return hasTower;
    }

    public boolean getIsTarget() {
        return isTarget;
    }

    public boolean getIsSpawn() {
        return isSpawn;
    }

    // all the setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTileType(TileType type) {
        this.type = type;
    }

    public void setHasEnemy(boolean hasEnemy) {
        this.hasEnemy = hasEnemy;
    }

    public void setHasTower(boolean hasTower) {
        this.hasTower = hasTower;
    }

    public void setIsTarget(boolean isTarget) {
        this.isTarget = isTarget;
    }

    public void setIsSpawn(boolean isSpawn) {
        this.isSpawn = isSpawn;
    }

}
