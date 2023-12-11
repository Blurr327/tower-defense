package controller;

import model.BottomSectionModel;
import view.BottomSectionView;

public class BottomSectionController {
    BottomSectionView view;
    BottomSectionModel model;

    public BottomSectionController(BottomSectionView view, BottomSectionModel model) {
        this.view = view;
        this.model = model;
    }

    public void switchTo(String s){
        model.setActiveCard(s);
        view.updateCard();
    }
    
}
