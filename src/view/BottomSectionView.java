package view;

import java.awt.CardLayout;
import java.awt.Dimension;


import javax.swing.JPanel;

import controller.BottomSectionController;
import model.BottomSectionModel;
import model.GameModel;
import model.MapModel;
import model.PlayManagerModel;

public class BottomSectionView extends JPanel {
    private BottomSectionModel model;
    private BottomSectionController controller;
    
    private CardLayout cardLayout; // card layout for switching between map editor and play manager

    private MapEditorView mapEditorView = new MapEditorView();
    private PlayManagerView playManagerView = new PlayManagerView(new PlayManagerModel());

    public BottomSectionView(BottomSectionModel model){
        super(new CardLayout());
        this.model = model;

        this.controller = new BottomSectionController(this, model);
        initCardLayout();
        setPanelSize();
    }

    public void initCardLayout(){
        this.cardLayout = (CardLayout) this.getLayout();
        this.add(mapEditorView, "edit");
        this.add(playManagerView, "play");
        cardLayout.show(this, getActiveCard());
    }

    public void setPanelSize(){
        Dimension size = new Dimension(BottomSectionModel.SECTION_WIDTH*AppView.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*AppView.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    public void updateCard(){
        cardLayout.show(this, getActiveCard());
    }

    public MapEditorView getMapEditorView() {
        return mapEditorView;
    }

    public PlayManagerView getPlayManagerView() {
        return playManagerView;
    }

    public String getActiveCard() {
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
