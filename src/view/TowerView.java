package view;

import model.towers.ElGatoModel;
import model.towers.GoesBrrrrrrrModel;
import model.towers.SteveModel;
import model.towers.TowerModel;
import model.towers.projectiles.ProjectileModel;
import view.helperclasses.MessagesView;
import model.towers.TowerManagerModel;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class TowerView {
    private static HashMap<TowerModel, BufferedImage> towerSprites = new HashMap<TowerModel, BufferedImage>();
    private static final MessagesView towerRemovalInfo = new MessagesView("Right click on a tower to remove it");

    public static void renderTower(Graphics g, TowerModel tower){
        g.drawImage(getSprite(tower), (int) tower.getX()*AppView.UNIT_SIZE, (int) tower.getY()*AppView.UNIT_SIZE, null);
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
        Iterator<ProjectileModel> projectileIterator = tower.getShotProjectilesIterator();
        while(projectileIterator.hasNext()){
            ProjectileView.renderProjectile(g, projectileIterator.next());
        }
    }


    public static void renderTowers(Graphics g){
        Iterator<TowerModel> towerIterator = TowerManagerModel.getTowerIterator();
        while(towerIterator.hasNext()){
            if(towerRemovalInfo.allowedToBeDrawn()) towerRemovalInfo.drawDisappearingMessage(g);
            TowerView.renderTower(g, towerIterator.next());
        }
    }

    public static ImageIcon getIcon(TowerModel tower){
        return new ImageIcon(getSprite(tower));
    }

    
    
}
