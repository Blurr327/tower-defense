package view;
import javax.swing.*;

import main.Game;

import java.awt.*;

public class GamePanelContainer extends JPanel {
    private AppView appView;

    public GamePanelContainer(AppView appView){
        super(new CardLayout());
        this.appView = appView;
        setPanelSize();
    }

    public void setPanelSize(){
        Dimension size = new Dimension(appView.model.getWIDTH(), appView.model.getHEIGHT());
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

}
