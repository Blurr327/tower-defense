package view;

import model.EnemyModel;
import model.EnemyType;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * this class is responsible for retriving the sprite of the enemy depending on its id
 */
public class EnemyView {
    private static final ArrayList<BufferedImage> EnemySprites = new ArrayList<>();
    private EnemyModel enemyModel;

    static {
        // storing all the sprites in an arraylist to maximize performance and avoid loading the same sprite multiple times
        int i =0;
        for(EnemyType enemyType : EnemyType.values()){
            EnemySprites.add(initSprite(enemyType));
            enemyType.setId(i++);
        }
    }

    public EnemyView(EnemyModel enemyModel) {
        this.enemyModel = enemyModel;
    }

    public static void renderEnemy(Graphics g, EnemyModel enemyModel){
        if(enemyModel.isAlive() && enemyModel.isSpawned())
            g.drawImage(getSprite(enemyModel.getType().getId()),(int) (enemyModel.getX()*AppView.UNIT_SIZE), (int) (enemyModel.getY()*AppView.UNIT_SIZE), null);
    }

    public static void renderEnemyHealth(Graphics g, EnemyModel enemyModel){
        if(enemyModel.isAlive() && enemyModel.isSpawned())
            g.drawString(String.valueOf(enemyModel.getHealth()), (int) (enemyModel.getX()*AppView.UNIT_SIZE) + g.getFontMetrics().stringWidth(String.valueOf(enemyModel.getHealth()))/2, (int) (enemyModel.getY()*AppView.UNIT_SIZE));
    }

    public void renderEnemyTarget(Graphics g, int x, int y){
        StringHelper.drawCenteredString(g, "S", EnemyModel.getSpawnTileX(), EnemyModel.getSpawnTileY(), AppView.UNIT_SIZE);
    }


    private static BufferedImage initSprite(EnemyType enemyType) {
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

    public static BufferedImage getSprite(int id) {
        return EnemySprites.get(id);
    }

}

