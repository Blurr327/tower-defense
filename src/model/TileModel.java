package model;

import java.awt.image.BufferedImage;

public enum TileModel {
    GRASS(false, false, false,0),
    FLOWER(false, false, false, 1),
    PATH(true, false, false, 2),
    SPAWN(true, true, false, 3),
    TARGET(true, false, true, 4);

    private final boolean walkable, spawn, target;
    private final int id;
    private final BufferedImage sprite;

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }

    TileModel(boolean walkable, boolean spawn, boolean target,int id) {
        this.walkable = walkable;
        this.spawn = spawn;
        this.target = target;
        this.id = id;
        this.sprite = initSprites(id);
    }

    public boolean isWalkable() {
        return walkable;
    }

    public boolean isSpawn() {
        return spawn;
    }

    public boolean isTarget() {
        return target;
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
            case 3:
                return spriteSheet.getSubimage(1*u, 3*u, u, u);
            case 4:
                return spriteSheet.getSubimage(0*u, 2*u, u, u);
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
            case 3:
                return SPAWN;
            case 4:
                return TARGET;
            default:
                return null;
        }
    }

}
