package model.map;

import java.awt.image.BufferedImage;

public enum TileType {
    GRASS(false),
    FLOWER(false),
    PATH(true);

    private final boolean walkable;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    TileType(boolean walkable) {
        this.walkable = walkable;
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

