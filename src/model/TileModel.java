package model;

import java.awt.image.BufferedImage;

import view.GameView;

public enum TileModel {
    GRASS(false, 0, "grass"),
    FLOWER(false, 1, "flower"),
    PATH(true, 2, "path");

    private final boolean walkable;
    private final int id;
    private final String name;
    private final BufferedImage sprite;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    TileModel(boolean walkable, int id, String name) {
        this.walkable = walkable;
        this.id = id;
        this.name = name;
        this.sprite = initSprites(id);
    }

    public boolean isWalkable() {
        return walkable;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    private static BufferedImage initSprites(int id){
        BufferedImage spriteSheet = GameModel.spriteSheet;
        int u = GameModel.UNIT_SIZE;
        switch(id){
            case 0:
                return spriteSheet.getSubimage(0, 0, u, u);
            case 1:
                return spriteSheet.getSubimage(0, 6*u, u, u);
            case 2:
                return spriteSheet.getSubimage(5*u, 3*u, u, u);
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
