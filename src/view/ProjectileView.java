package view;

import model.towers.BulletsBrrrrrModel;
import model.towers.FireBallModel;
import model.towers.ProjectileModel;
import model.towers.YarnBallModel;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.HashMap;


public class ProjectileView {
    private static HashMap<ProjectileModel, BufferedImage> projectileSprites = new HashMap<ProjectileModel, BufferedImage>();

    public static void renderProjectile(Graphics g,ProjectileModel projectile){
        g.drawImage(getSprite(projectile), (int) (projectile.getX()*AppView.UNIT_SIZE), (int) (projectile.getY()*AppView.UNIT_SIZE), null);
    }

    public static BufferedImage getSprite(ProjectileModel projectile){
        if(projectile.getClass() == YarnBallModel.class){
            if(!projectileSprites.containsKey(projectile)){
            projectileSprites.put(projectile, AppView.spriteSheet.getSubimage(1*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
            }
        }
        if(projectile.getClass() == BulletsBrrrrrModel.class){
            if(!projectileSprites.containsKey(projectile)){
            projectileSprites.put(projectile, AppView.spriteSheet.getSubimage(3*AppView.UNIT_SIZE, 7*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
            }
        }
        if(projectile.getClass() == FireBallModel.class){
            if(!projectileSprites.containsKey(projectile)){
            projectileSprites.put(projectile, AppView.spriteSheet.getSubimage(7*AppView.UNIT_SIZE, 6*AppView.UNIT_SIZE, AppView.UNIT_SIZE, AppView.UNIT_SIZE));
            }
        }

        return projectileSprites.get(projectile);
    }
}
