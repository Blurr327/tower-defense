package view;

import model.enemies.Enemy;
import model.enemies.EnemyModel;
import model.enemies.MrBlobModel;
import model.enemies.MrSlimeModel;
import model.enemies.MrSnakeModel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * this class is responsible for retriving the sprite of the enemy depending on its id
 */
public class EnemyView {
    // hashmap to store the sprites of the enemies once they are loaded
    private static final HashMap<Enemy, BufferedImage> enemySprites = new HashMap<>();


    public static void renderEnemy(Graphics g, Enemy enemyModel){
        if(enemyModel.isAlive() && enemyModel.isSpawned())
            g.drawImage(getSprite(enemyModel),(int) (enemyModel.getX()*AppView.UNIT_SIZE), (int) (enemyModel.getY()*AppView.UNIT_SIZE), null);
    }

    public static void renderEnemyHealth(Graphics g, Enemy enemyModel){
        if(enemyModel.isAlive() && enemyModel.isSpawned())
            g.drawString(String.valueOf(enemyModel.getHealth()), (int) (enemyModel.getX()*AppView.UNIT_SIZE) + g.getFontMetrics().stringWidth(String.valueOf(enemyModel.getHealth()))/2, (int) (enemyModel.getY()*AppView.UNIT_SIZE));
    }


    private static BufferedImage getSprite(Enemy enemyType) {
            if(enemyType.getClass() == MrBlobModel.class){
                if(!enemySprites.containsKey(enemyType)) enemySprites.put(enemyType, AppView.spriteSheet.getSubimage(5*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
                return enemySprites.get(enemyType);
            }
            else if (enemyType.getClass() == MrSnakeModel.class){
                if(!enemySprites.containsKey(enemyType)) enemySprites.put(enemyType, AppView.spriteSheet.getSubimage(6*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
                return enemySprites.get(enemyType);
            }
            else if (enemyType.getClass() == MrSlimeModel.class){
                if(!enemySprites.containsKey(enemyType)) enemySprites.put(enemyType, AppView.spriteSheet.getSubimage(7*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
                return enemySprites.get(enemyType);
            }
            else
                return null;
        
    }


}

