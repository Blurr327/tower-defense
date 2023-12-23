package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.imageio.ImageIO;


public class AppModel {
    public enum AppMode{
        MENU, SETTINGS, GAME;
    }
    private static AppMode appMode = AppMode.MENU;
    private static double UPS = 60; // updates per second

    public static AppMode getAppMode() {
        return appMode;
    }

    public static void setAppMode(AppMode appMode) {
        AppModel.appMode = appMode;
    }
    
    public static double getUPS() {
        return UPS;
    }

    public static void setUPS(double uPS) {
        UPS = uPS;
    }

    
}
