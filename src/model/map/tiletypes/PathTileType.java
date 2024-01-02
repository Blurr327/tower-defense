package model.map.tiletypes;

public class PathTileType implements TileType{
    
    private static final boolean WALKABLE = true;
    
    @Override
    public boolean isWalkable() {
        return WALKABLE;
    }
}
