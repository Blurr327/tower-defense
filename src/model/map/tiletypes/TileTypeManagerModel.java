package model.map.tiletypes;

import java.util.ArrayList;
import java.util.Iterator;

public class TileTypeManagerModel {
    private static final ArrayList<TileType> TILE_TYPES = new ArrayList<TileType>();

    static {
        TILE_TYPES.add(new GrassTileType());
        TILE_TYPES.add(new PathTileType());
        TILE_TYPES.add(new FlowerTileType());
    }

    public static Iterator<TileType> getTileTypesIterator() {
        return TILE_TYPES.iterator();
    }

    public static int getTileTypesCount() {
        return TILE_TYPES.size();
    }
}
