package view;

import model.EnemyModel;
import java.awt.image.BufferedImage;

/*
 * this class is responsible for retriving the sprite of the enemy depending on its id
 */
public class EnemyView {
    private EnemyModel enemyModel;
    private BufferedImage sprite;

    public EnemyView(EnemyModel enemyModel) {
        this.enemyModel = enemyModel;
        this.sprite = EnemyView.getSprite(enemyModel);
    }

    // needs some changes since we're not working with ID 
    private static BufferedImage getSprite(EnemyModel enemyModel) {
        switch(enemyModel) {
            case MRBLOB:     
                return AppView.spriteSheet.getSubimage(5*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            case MRSNAKE:
                return AppView.spriteSheet.getSubimage(0, AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            case MRSLIME:
                return AppView.spriteSheet.getSubimage(0, 0, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            default:
                return null;
        }
    }

    public BufferedImage getSprite() {
        return sprite;
    }

}
