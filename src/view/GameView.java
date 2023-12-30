package view;

import java.awt.*;
import javax.swing.*;

import controller.GameController;
import controller.MapController;
import model.gamelogic.BottomSectionModel;
import model.map.MapModel;


/*
 * This class is the container containing the bottom section and the map
 * it is responsible for poitioning them correctly and displaying components linked to the game as a whole
 */
public class GameView extends JPanel{
    private GameController gameController;
    private MapView mapView = new MapView();

    private CustomButtonView switchToMenuButton = new CustomButtonView("Menu");

    private BottomSectionView bottomSectionView= new BottomSectionView(new BottomSectionModel());

    public GameView(){
        super();
        gameController = new GameController(this);

        this.setLayout(null);

        add(switchToMenuButton);
        add(mapView);
        add(bottomSectionView);
        
        setFocusable(true);
        requestFocusInWindow();
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
        addKeyListener(gameController);
    }

    public BottomSectionView getBottomSectionView() {
        return bottomSectionView;
    }

        public MapView getMapView() {
        return mapView;
    }
}
