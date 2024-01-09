package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import model.AppModel;
import model.map.MapModel;
import model.map.tiletypes.FlowerTileType;
import model.map.tiletypes.GrassTileType;
import model.map.tiletypes.PathTileType;
import model.map.tiletypes.TileType;

/*
 * this class is responsible for retrieving the sprite of the tile depending on its id
 */
public class TileView {
    private static final HashMap<TileType, BufferedImage> tileSprites = new HashMap<>();

    public static ImageIcon getIcon(TileType type) {
        return new ImageIcon(getSprite(type));
    }

    private static BufferedImage getSprite(TileType tileType) {
        BufferedImage spriteSheet = AppView.spriteSheet;
        int u = AppView.UNIT_SIZE;
        if(tileType instanceof GrassTileType){ 
            if(!tileSprites.containsKey(tileType)){
                tileSprites.put(tileType, spriteSheet.getSubimage(u, u, u, u));
            }
        }
        else if(tileType instanceof FlowerTileType){
            if(!tileSprites.containsKey(tileType)){
                tileSprites.put(tileType, spriteSheet.getSubimage(4*u, 3*u, u, u));
            }
        }
        else if(tileType instanceof PathTileType){
            if(!tileSprites.containsKey(tileType)){
                tileSprites.put(tileType, spriteSheet.getSubimage(0*u, 6*u, u, u));
            }
        }
        return tileSprites.get(tileType);
    }

    public static void renderTile(Graphics g, int x, int y, TileType type){
        g.drawImage(getSprite(type),x*AppView.UNIT_SIZE, y*AppView.UNIT_SIZE, null);
    }

}
