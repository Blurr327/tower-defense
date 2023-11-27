package main;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.nio.file.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.*;
import java.util.*;

public class GamePanel extends JPanel {

    private BufferedImage img;
    private ArrayList<BufferedImage> gameSprites = new ArrayList<>();
    private Dimension size;


    
    public GamePanel(BufferedImage img){
        this.img = img;
        setPanelSize();
        loadGameSprites();
    }

    public void setPanelSize(){
        size = new Dimension(640, 640);

        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

    }

    public void loadGameSprites(){
       for(int y = 0;y<=7;y++)
        for(int x = 0;x<=7;x++)
            gameSprites.add(img.getSubimage(32*x, 32*y, 32, 32));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int y = 0;y<=20;y++)
         for(int x = 0;x<=20;x++)
          g.drawImage(gameSprites.get(x+y),x*32,y*32,null);
    }

}
