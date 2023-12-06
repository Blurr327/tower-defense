package view;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class TileView{
    protected ArrayList<BufferedImage> tileSprites = new ArrayList<>();
    protected GameView gameView;

    public TileView(GameView gameView){
        BufferedImage spriteSheet = gameView.model.getSpriteSheet();
        this.gameView = gameView;
        int u = gameView.model.getUNIT_SIZE();
        tileSprites.add(spriteSheet.getSubimage(0, 0, u, u));
        tileSprites.add(spriteSheet.getSubimage(0, 6*u, u, u));
        tileSprites.add(spriteSheet.getSubimage(5*u, 3*u, u, u));
    }

    public BufferedImage getTileSprite(int id){
        return tileSprites.get(id);
    }
}
