package view;
import javax.swing.*;

import main.Game;

import java.awt.*;

public class GamePanelContainer extends JPanel {
    private GameView gameView;

    public GamePanelContainer(GameView gameView){
        super(new CardLayout());
        this.gameView = gameView;
        setPanelSize();
    }

    public void setPanelSize(){
        Dimension size = new Dimension(gameView.model.getHEIGHT(), gameView.model.getWIDTH());
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

}
