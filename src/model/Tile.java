package model;

public enum Tile {
    GRASS(false, 0),
    FLOWER(false, 1),
    PATH(true, 2);

    private final boolean walkable;
    private final int id;

    public int getId() {
        return id;
    }

    Tile(boolean walkable, int id) {
        this.walkable = walkable;
        this.id = id;
    }

    public boolean isWalkable() {
        return walkable;
    }
}
