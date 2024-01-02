package controller;

import model.gamelogic.BaseModel;

public class BaseController {
    

    public static void updateBaseCoords(int x, int y){
        BaseModel.setX(x);
        BaseModel.setY(y);
    }

    public static void initBase() {
        BaseModel.initBase();
    }

    
}
