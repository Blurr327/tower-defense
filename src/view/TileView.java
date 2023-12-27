package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import model.AppModel;
import model.MapModel;
import model.TileType;

/*
 * this class is responsible for retriving the sprite of the tile depending on its id
 */
public class TileView implements Iconable {
    private static final ArrayList<BufferedImage> Tilesprites = new ArrayList<>();
 
    static {
        int i = 0;
        for(TileType tileType : TileType.values()){
            Tilesprites.add(initSprite(tileType));
            tileType.setId(i++);
        }
    }

    public ImageIcon getIcon(int id) {
        return new ImageIcon(getSpriteById(id));
    }

    private static BufferedImage initSprite(TileType tileType) {
        BufferedImage spriteSheet = AppView.spriteSheet;
        int u = AppView.UNIT_SIZE;
        switch(tileType){
            case GRASS:
                return spriteSheet.getSubimage(u, u, u, u);
            case FLOWER:
                return spriteSheet.getSubimage(4*u, 3*u, u, u);
            case PATH:
                return spriteSheet.getSubimage(0*u, 6*u, u, u);
            default:
                return null;
        }
    }

    public static BufferedImage getSpriteById(int id){
        return Tilesprites.get(id);
    }

    public static void renderTile(Graphics g, int x, int y, int id){
        g.drawImage(getSpriteById(id),x*AppView.UNIT_SIZE, y*AppView.UNIT_SIZE, null);
    }

}
