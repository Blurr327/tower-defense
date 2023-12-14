package controller;

import model.GameModel;
import view.GameView;

public class GameController {
    private GameView view;

    public GameController(GameView view) {
        this.view = view;
    }

    public void switchToEdit() {
        GameModel.setGameMode(GameModel.EDIT);
        view.getBottomSectionView().updateCard();
    }

    public void switchToPlay() {
        GameModel.setGameMode(GameModel.PLAY);
        view.getBottomSectionView().updateCard();
    }

}
