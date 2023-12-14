package model;

public class BottomSectionModel {
    public static final int SECTION_HEIGHT = 4;
    public static final int SECTION_WIDTH = MapModel.WIDTH;

    public BottomSectionModel() {
    }

    public static String getActiveCard() {
        switch(GameModel.getGameMode()){
            case EDIT:
                return "edit";
            case PLAY:
                return "play";
            default:
                return "edit";
        }
    }

}
