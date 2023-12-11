package view;

import java.awt.*;
import javax.swing.*;

import model.BottomSectionModel;
import model.MapModel;



public class GameViewContainer extends JPanel{
    protected AppView appView;
    protected MapView mapView = new MapView();
    protected JButton switchToMenuButton = new JButton("Menu");
    protected BottomSectionView bottomSectionView= new BottomSectionView(new BottomSectionModel());

    public GameViewContainer(AppView appView){
        super();
        this.appView = appView;
        this.setLayout(null);
        switchToMenuButton.addActionListener(e -> 
            appView.controller.switchTo("menu"));
        add(mapView);
        add(switchToMenuButton);
        add(bottomSectionView);
        switchToMenuButton.setBounds(5, 5, 80, 30);
        switchToMenuButton.setOpaque(false);
        switchToMenuButton.setContentAreaFilled(false);
        bottomSectionView.setBounds(0, MapModel.HEIGHT*MapModel.UNIT_SIZE, BottomSectionModel.SECTION_WIDTH*MapModel.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*MapModel.UNIT_SIZE);

        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g) {
        mapView.renderMap(g);
    }

    
}
