package model;

public class BottomSectionModel {
    public static final int SECTION_HEIGHT = 4;
    public static final int SECTION_WIDTH = AppModel.WIDTH;
    private String activeCard = "play";

    public BottomSectionModel() {
    }

    public String getActiveCard() {
        return activeCard;
    }
    public void setActiveCard(String activeCard) {
        this.activeCard = activeCard;
    }
}
