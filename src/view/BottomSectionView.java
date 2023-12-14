package view;

import java.awt.CardLayout;
import java.awt.Dimension;


import javax.swing.JPanel;

import controller.BottomSectionController;
import model.BottomSectionModel;
import model.MapModel;
import model.PlayManagerModel;

public class BottomSectionView extends JPanel {
    BottomSectionModel model;
    BottomSectionController controller;
    CardLayout cardLayout;
    MapEditorView mapEditorView = new MapEditorView();
    PlayManagerView playManagerView = new PlayManagerView(new PlayManagerModel());

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
        cardLayout.show(this, BottomSectionModel.getActiveCard());
    }

    public void setPanelSize(){
        Dimension size = new Dimension(BottomSectionModel.SECTION_WIDTH*MapModel.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*MapModel.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    public void updateCard(){
        cardLayout.show(this, BottomSectionModel.getActiveCard());
    }

    public MapEditorView getMapEditorView() {
        return mapEditorView;
    }

    public PlayManagerView getPlayManagerView() {
        return playManagerView;
    }



}
