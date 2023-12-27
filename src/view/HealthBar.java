package view;

import java.awt.Color;
import java.awt.Graphics;

public class HealthBar {
    

    public static void renderHealthBar(Graphics g, int x, int y, int width, int height, int health, int maxHealth, String title){
        StringHelper.drawString(g, title, x-width-width/2, y+height, width);
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
        g.setColor(Color.GREEN);
        g.fillRect(x, y, (int) (width * ((double) health / maxHealth)), height);
    }
    
}

