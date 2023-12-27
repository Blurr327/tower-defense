package view;

import model.EnemyModel;
import model.EnemyType;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * this class is responsible for retriving the sprite of the enemy depending on its id
 */
public class EnemyView {
    private EnemyModel enemyModel;
    private BufferedImage sprite;

    public EnemyView(EnemyModel enemyModel) {
        this.enemyModel = enemyModel;
        this.sprite = EnemyView.getSprite(enemyModel.getType());
    }

    public static void renderEnemy(Graphics g, EnemyModel enemyModel){
        if(enemyModel.isAlive() && enemyModel.isSpawned())
            g.drawImage(getSprite(enemyModel.getType()),(int) (enemyModel.getX()*AppView.UNIT_SIZE), (int) (enemyModel.getY()*AppView.UNIT_SIZE), null);
    }

    public static void renderEnemyHealth(Graphics g, EnemyModel enemyModel){
        if(enemyModel.isAlive() && enemyModel.isSpawned())
            g.drawString(String.valueOf(enemyModel.getHealth()), (int) (enemyModel.getX()*AppView.UNIT_SIZE) + g.getFontMetrics().stringWidth(String.valueOf(enemyModel.getHealth()))/2, (int) (enemyModel.getY()*AppView.UNIT_SIZE));
    }

    public void renderEnemyTarget(Graphics g, int x, int y){
        StringHelper.drawCenteredString(g, "S", EnemyModel.getSpawnTileX(), EnemyModel.getSpawnTileY(), AppView.UNIT_SIZE);
    }

    // needs some changes since we're not working with ID 
    private static BufferedImage getSprite(EnemyType enemyType) {
        switch(enemyType) {
            case MRBLOB:     
                return AppView.spriteSheet.getSubimage(5*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            case MRSNAKE:
                return AppView.spriteSheet.getSubimage(6*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            case MRSLIME:
                return AppView.spriteSheet.getSubimage(7*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            default:
                return null;
        }
    }

    public BufferedImage getSprite() {
        return sprite;
    }

}

