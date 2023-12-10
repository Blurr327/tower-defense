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
        System.out.println(gameView.model.getActiveCard());
        Dimension size;
        if (gameView.model.getActiveCard().equals("custom")){
            size = new Dimension (gameView.model.getHEIGHT(), gameView.model.getWIDTH() + 100);
        } else {
            size = new Dimension (gameView.model.getHEIGHT(), gameView.model.getWIDTH() + 100);
        }
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        System.out.println("Panel size :"  + size);
        System.out.println("Real size :"  + getSize());
        revalidate();
        repaint();
    }

}
