package model;

public enum TileModel {
    GRASS(false, 0, "grass"),
    FLOWER(false, 1, "flower"),
    PATH(true, 2, "path");

    private final boolean walkable;
    private final int id;
    private final String name;

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
    }

    public boolean isWalkable() {
        return walkable;
    }
}
