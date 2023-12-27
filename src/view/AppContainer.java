package view;
import javax.swing.*;

import controller.MapController;
import main.Game;
import model.MapModel;

import java.awt.*;

public class AppContainer extends JPanel {
    private GameView gameView;

    public AppContainer(int width, int height, GameView gameView){
        super(new CardLayout());
        
        this.gameView = gameView;
        add(gameView);
        setPanelSize(width , height);
    }

    public void setPanelSize(int width, int height){
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    public void updateGameViewCards() {
        gameView.getBottomSectionView().updateCard();
    }

    public GameView getGameView() {
        return gameView;
    }

}

