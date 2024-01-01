package view;

import model.towers.ElGatoModel;
import model.towers.GoesBrrrrrrrModel;
import model.towers.SteveModel;
import model.towers.TowerModel;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.HashMap;

public class TowerView {
    private static HashMap<TowerModel, BufferedImage> towerSprites = new HashMap<TowerModel, BufferedImage>();

    public static void renderTower(Graphics g, TowerModel tower){
        g.drawImage(getSprite(tower), tower.getX()*AppView.UNIT_SIZE, tower.getY()*AppView.UNIT_SIZE, null);
    }

    public static void renderTowerAt(Graphics g, TowerModel tower, int x, int y){
        g.drawImage(getSprite(tower), x*AppView.UNIT_SIZE, y*AppView.UNIT_SIZE, null);
    }

    public static BufferedImage getSprite(TowerModel tower){
        if(tower.getClass() == ElGatoModel.class){
            if(!towerSprites.containsKey(tower)){
            towerSprites.put(tower, AppView.spriteSheet.getSubimage(0, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
            }
        }
        if (tower.getClass() == GoesBrrrrrrrModel.class){
            if(!towerSprites.containsKey(tower)){
            towerSprites.put(tower, AppView.spriteSheet.getSubimage(2*AppView.UNIT_SIZE , 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
            }
        }
        if (tower.getClass() == SteveModel.class){
            if(!towerSprites.containsKey(tower)){
            towerSprites.put(tower, AppView.spriteSheet.getSubimage(4*AppView.UNIT_SIZE , 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
            }
        }
        
        return towerSprites.get(tower);
    }

    public static void renderProjectilesOf(Graphics g, TowerModel tower){
        for(int i = 0; i < tower.getNumberOfShotProjectiles(); i++){
            ProjectileView.renderProjectile(g, tower.getProjectileByIndex(i));
        }
    }
}
