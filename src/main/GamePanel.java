package main;
import javax.swing.*;

import listener.GameKeyboardListener;
import listener.GameMouseListener;

import java.awt.*;
import java.awt.image.*;
import java.nio.file.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.*;
import java.util.*;
import model.Map;

public class GamePanel extends JPanel {
    private GameFrame game;

    public GamePanel(GameFrame game){
        super(new CardLayout());
        this.game = game;
        setPanelSize();
    }

    public void setPanelSize(){
        Dimension size = new Dimension(GameFrame.HEIGHT, GameFrame.WIDTH);

        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

    }

}
