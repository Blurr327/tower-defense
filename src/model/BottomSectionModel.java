package model;

public class BottomSectionModel {
    public static final int SECTION_HEIGHT = 4;
    public static final int SECTION_WIDTH = MapModel.WIDTH;
    private static String activeCard = "edit";

    public BottomSectionModel() {
    }

    public static String getActiveCard() {
        return activeCard;
    }
    public void setActiveCard(String activeCard) {
        BottomSectionModel.activeCard = activeCard;
    }
}
