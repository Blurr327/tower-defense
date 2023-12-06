package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.imageio.ImageIO;


public class GameModel {
    private int UNIT_SIZE = 32;
    private int HEIGHT = MapModel.WIDTH*UNIT_SIZE;
    private int WIDTH = MapModel.HEIGHT*UNIT_SIZE;
    private BufferedImage spriteSheet = importImg();
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
        InputStream is = GameModel.class.getClassLoader().getResourceAsStream(Paths.get("res/tileset.png").toString());
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

    public int getUNIT_SIZE() {
        return UNIT_SIZE;
    }

    public void setUNIT_SIZE(int uNIT_SIZE) {
        UNIT_SIZE = uNIT_SIZE;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int hEIGHT) {
        HEIGHT = hEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int wIDTH) {
        WIDTH = wIDTH;
    }

    public void setSpriteSheet(BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
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
