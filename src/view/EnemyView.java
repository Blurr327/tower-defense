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
        this.sprite = EnemyView.getSpriteById(enemyModel.getId());
    }

    private static BufferedImage getSpriteById(int id) {
        switch(id) {
            case 0:     
                return AppView.spriteSheet.getSubimage(5*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            case 1:
                return AppView.spriteSheet.getSubimage(0, AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            default:
                return null;
        }
    }

    public BufferedImage getSprite() {
        return sprite;
    }

}
