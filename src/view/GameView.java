package view;

import java.awt.*;
import javax.swing.*;

import controller.GameController;
import controller.MapController;
import model.BottomSectionModel;
import model.MapModel;



public class GameView extends JPanel{
    private GameController gameController;
    protected MapView mapView = new MapView();
    protected CustomButtonView switchToMenuButton = new CustomButtonView("Menu");

    protected BottomSectionView bottomSectionView= new BottomSectionView(new BottomSectionModel());

    public GameView(){
        super();
        gameController = new GameController(this);

        this.setLayout(null);

        add(switchToMenuButton);
        add(mapView);
        add(bottomSectionView);
        
        addActionListeners();

        switchToMenuButton.setBounds(5, 5, 80, 30);
        bottomSectionView.setBounds(0, MapModel.HEIGHT*AppView.UNIT_SIZE, BottomSectionModel.SECTION_WIDTH*AppView.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*AppView.UNIT_SIZE);
        mapView.setBounds(0,0,MapModel.WIDTH*AppView.UNIT_SIZE, MapModel.HEIGHT*AppView.UNIT_SIZE);
    }


    public CustomButtonView getSwitchToMenuButton() {
        return switchToMenuButton;
    }
    
    public void addActionListeners(){
        bottomSectionView.getMapEditorView().getSwitchToPlayManagerButton().addActionListener(e -> gameController.switchToPlay());
        bottomSectionView.getPlayManagerView().getSwitchToEditButton().addActionListener(e -> gameController.switchToEdit());
    }

    public BottomSectionView getBottomSectionView() {
        return bottomSectionView;
    }

}
