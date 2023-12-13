package model;

import java.awt.image.BufferedImage;

public enum TileModel {
    GRASS(false, 0),
    FLOWER(false, 1),
    PATH(true, 2);

    private final boolean walkable;
    private final int id;
    private final BufferedImage sprite;

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }

    TileModel(boolean walkable, int id) {
        this.walkable = walkable;
        this.id = id;
        this.sprite = initSprites(id);
    }

    public boolean isWalkable() {
        return walkable;
    }

    private static BufferedImage initSprites(int id){
        BufferedImage spriteSheet = AppModel.spriteSheet;
        int u = MapModel.UNIT_SIZE;
        switch(id){
            case 0:
                return spriteSheet.getSubimage(u, u, u, u);
            case 1:
                return spriteSheet.getSubimage(4*u, 3*u, u, u);
            case 2:
                return spriteSheet.getSubimage(0*u, 6*u, u, u);
            default:
                return null;
        }
    }

    public static TileModel getTileById(int id){
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
