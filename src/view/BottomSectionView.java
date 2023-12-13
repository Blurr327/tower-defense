package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

import controller.BottomSectionController;
import controller.MapEditorController;
import model.BottomSectionModel;
import model.MapEditorModel;
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
        addActionListeners();
        initCardLayout();
        setPanelSize();
    }

    public void initCardLayout(){
        this.cardLayout = (CardLayout) this.getLayout();
        this.add(mapEditorView, "edit");
        this.add(playManagerView, "play");
        cardLayout.show(this, model.getActiveCard());
    }

    public void setPanelSize(){
        Dimension size = new Dimension(BottomSectionModel.SECTION_WIDTH*MapModel.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*MapModel.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    public void updateCard(){
        cardLayout.show(this, model.getActiveCard());
    }

    public void addActionListeners(){
        mapEditorView.getSwitchToPlayManagerButton().addActionListener(e -> controller.switchTo("play"));
        playManagerView.getSwitchToEditButton().addActionListener(e -> controller.switchTo("edit"));
    }

    


}
