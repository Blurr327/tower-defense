package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import model.Tile;
import main.GameFrame;

public class TileGraphicsFactory extends GraphicsFactory {
    private ArrayList<BufferedImage> tileSprites = new ArrayList<>();
    
    public TileGraphicsFactory(){
        super();
        int u = GameFrame.UNIT_SIZE;
        tileSprites.add(spriteSheet.getSubimage(0, 0, u, u));
        tileSprites.add(spriteSheet.getSubimage(0, 6*u, u, u));
        tileSprites.add(spriteSheet.getSubimage(5*u, 3*u, u, u));
    }

    public BufferedImage getTileSprite(int id){
        return tileSprites.get(id);
    }
}
