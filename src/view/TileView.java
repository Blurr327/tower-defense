package view;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.AppModel;
import model.MapModel;
import model.TileModel;

/*
 * this class is responsible for retriving the sprite of the tile depending on its id
 */
public class TileView {
    private static final ArrayList<BufferedImage> Tilesprites = new ArrayList<>();

    static {
        for(int i = 0; i<TileModel.values().length;i++){
            Tilesprites.add(initSprite(i));
        }
    }

    private static BufferedImage initSprite(int id){
        BufferedImage spriteSheet = AppView.spriteSheet;
        int u = AppView.UNIT_SIZE;
        switch(id){
            case 0:
                return spriteSheet.getSubimage(u, u, u, u);
            case 1:
                return spriteSheet.getSubimage(4*u, 3*u, u, u);
            case 2:
                return spriteSheet.getSubimage(0*u, 6*u, u, u);
            default:
                return null;
        }
    }

    public static BufferedImage getSpriteById(int id){
        return Tilesprites.get(id);
    }

}
