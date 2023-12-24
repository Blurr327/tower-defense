package model;

import java.awt.image.BufferedImage;

public enum TileType {
    GRASS(false, 0),
    FLOWER(false, 1),
    PATH(true, 2);

    private final boolean walkable;
    private final int id;

    public int getId() {
        return id;
    }

    TileType(boolean walkable, int id) {
        this.walkable = walkable;
        this.id = id;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public static TileType getTileById(int id){
        switch(id){
            case 0:
                return GRASS;
            case 1:
                return FLOWER;
            case 2:
                return PATH;
            default:
                return null;
        }
    }

}
