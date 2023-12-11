package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.imageio.ImageIO;


public class AppModel {
    public static final int HEIGHT = (MapModel.HEIGHT + BottomSectionModel.SECTION_HEIGHT)*MapModel.UNIT_SIZE;
    public static final int WIDTH = MapModel.WIDTH*MapModel.UNIT_SIZE;
    public static final BufferedImage spriteSheet = importImg();
    private double FPS = 120; // frames per second
    private double UPS = 60; // updates per second
    private String activeCard = "menu"; // Default card is menu

    public String getActiveCard() {
        return activeCard;
    }

    public void setActiveCard(String activeCard) {
        this.activeCard = activeCard;
    }
    
    private static BufferedImage importImg(){
        InputStream is = AppModel.class.getClassLoader().getResourceAsStream(Paths.get("res/tileset.png").toString());
        BufferedImage ss = null;

        try {
            ss = ImageIO.read(is);
        } catch (IOException e) {
            System.out.println("Error importing image");
            e.printStackTrace();
        }
        return ss;
    }

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        System.out.println(WIDTH);
        return WIDTH;
    }

    public double getFPS() {
        return FPS;
    }

    public void setFPS(double fPS) {
        FPS = fPS;
    }

    public double getUPS() {
        return UPS;
    }

    public void setUPS(double uPS) {
        UPS = uPS;
    }

    
}
