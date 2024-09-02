package model.map.tiletypes;

public class FlowerTileType implements TileType{
    
    private static final boolean WALKABLE = false;
    
    @Override
    public boolean isWalkable() {
        return WALKABLE;
    }
}
