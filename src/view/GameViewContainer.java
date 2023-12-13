package view;

import java.awt.*;
import javax.swing.*;

import controller.MapController;
import model.BottomSectionModel;
import model.MapModel;



public class GameViewContainer extends JPanel{
    //FIXME: create gameview model that stores the current gamemode. Create a game controller that changes the gamemode upon clicking.
    // change the bottomsection class so that it always displays the current gamemode, which it has no control over
    // the bottom section class will only update the card on the bottomsectionview when the button is clicked, no more
    // make the changes necessary in Map as well : delete the mapMode variable and use the gamemode variable to display the map depending on the gameMode
    protected MapView mapView = new MapView();
    protected CustomButtonView switchToMenuButton = new CustomButtonView("Menu");

    protected BottomSectionView bottomSectionView= new BottomSectionView(new BottomSectionModel());

    public GameViewContainer(){
        super();
        this.setLayout(null);
        add(switchToMenuButton);
        add(mapView);
        add(bottomSectionView);
        switchToMenuButton.setBounds(5, 5, 80, 30);
        switchToMenuButton.setOpaque(false);
        switchToMenuButton.setContentAreaFilled(false);
        bottomSectionView.setBounds(0, MapModel.HEIGHT*MapModel.UNIT_SIZE, BottomSectionModel.SECTION_WIDTH*MapModel.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*MapModel.UNIT_SIZE);
        mapView.setBounds(0,0,MapModel.WIDTH*MapModel.UNIT_SIZE, MapModel.HEIGHT*MapModel.UNIT_SIZE);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g) {
        mapView.renderMap(g);
    }

    public CustomButtonView getSwitchToMenuButton() {
        return switchToMenuButton;
    }
    
}
