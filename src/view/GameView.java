package view;

import java.awt.*;
import javax.swing.*;

import controller.GameController;
import controller.MapController;
import controller.MapEditorController;
import model.gamelogic.BottomSectionModel;
import model.gamelogic.WaveModel;
import model.gamelogic.wavestates.NormalWaveState;
import model.map.MapModel;
import model.towers.*;
import view.helperclasses.CustomButtonView;

import java.awt.event.ActionEvent;

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
        Action BackToMenu = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate a click on the settings button
                getSwitchToMenuButton().doClick();
            }
        };
    
        // Add the key binding to the JPanel, we have to do it for every bind... but no choice I guess è_é
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('m'), "BackToMenu");
        this.getActionMap().put("BackToMenu", BackToMenu);
    }


    public CustomButtonView getSwitchToMenuButton() {
        return switchToMenuButton;
    }
    
    public void addActionListeners(){
        bottomSectionView.getMapEditorView().getSwitchToPlayManagerButton().addActionListener(e -> {
            ElGatoModel.resetCount();
            GoesBrrrrrrrModel.resetCount();
            SteveModel.resetCount();
            gameController.switchToPlayAndStartGame();
        });
        bottomSectionView.getPlayManagerView().getSwitchToEditButton().addActionListener(e -> gameController.switchToEdit());
        bottomSectionView.getMapEditorView().getResumeButton().addActionListener(e -> gameController.switchToPlay());
        // TODO: implement update enemies
        bottomSectionView.getMapEditorView().getUpgradeButton().addActionListener(e -> {
            TowerModel selectedTower = MapEditorController.getSelectedTower();
            if (selectedTower != null) {
                selectedTower.upgrade();
            }
        });
        bottomSectionView.getMapEditorView().getDowngradeButton().addActionListener(e -> {
            TowerModel selectedTower = MapEditorController.getSelectedTower();
            if (selectedTower != null) {
                selectedTower.downgrade();
            }
        });
        addKeyListener(gameController);
    }

    public BottomSectionView getBottomSectionView() {
        return bottomSectionView;
    }

        public MapView getMapView() {
        return mapView;
    }

    public void switchToEdit() {
         gameController.switchToEdit();
         if(WaveModel.getWaveModelState() instanceof NormalWaveState) bottomSectionView.getMapEditorView().disableTowerButtons();
            else bottomSectionView.getMapEditorView().enableTowerButtons();
    }

}
