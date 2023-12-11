package view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import controller.BottomSectionController;
import model.BottomSectionModel;
import model.MapEditorModel;
import model.MapModel;
import model.PlayManagerModel;

public class BottomSectionView extends JPanel {
    BottomSectionModel model;
    BottomSectionController controller;
    CardLayout cardLayout;

    public BottomSectionView(BottomSectionModel model){
        super(new CardLayout());
        this.model = model;
        this.controller = new BottomSectionController(this, model);
        initCardLayout();
        setPanelSize();
    }

    public void initCardLayout(){
        this.cardLayout = (CardLayout) this.getLayout();
        this.add(new MapEditorView(new MapEditorModel()), "edit");
        this.add(new PlayManagerView(new PlayManagerModel()), "play");
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

}
