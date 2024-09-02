package model.map.tiletypes;

import java.awt.image.BufferedImage;

@FunctionalInterface
public interface TileType {

    boolean isWalkable();

}

