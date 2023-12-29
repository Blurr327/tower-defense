package model.map;

public class TileModel {
    private int x;
    private int y;
    private TileType type;
    private boolean hasTile;


    public TileModel(int x, int y, TileType type) {
        this.x = x;
        this.y = y;
        this.type = type;
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

    public boolean hasTile() {
        return hasTile;
    }

    public void setHasTile(boolean hasTile) {
        this.hasTile = hasTile;
    }

}

