package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.gamelogic.BaseModel;
import view.helperclasses.HealthBar;
import view.helperclasses.StringHelper;

public class BaseView {


    public static void renderBase(Graphics g, int x, int y){
        StringHelper.drawCenteredString(g, "X", x, y, AppView.UNIT_SIZE);
    }

    public static void renderBaseHealth(Graphics g, int x, int y){
        HealthBar.renderHealthBar(g, x, y, 100, 10, BaseModel.getHealth(), 100, "Base Health : ");
    }

}

