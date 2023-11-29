package helper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import listener.*;
import main.*;

public class ListenerInitializer {
    private final GameFrame gameFrame;
    private final GameKeyboardListener keyListener;
    private final GameMouseListener mouseListener;

    public ListenerInitializer(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.keyListener = new GameKeyboardListener(gameFrame);
        this.mouseListener = new GameMouseListener();
    }

    public void initListeners(JPanel panel) {
        panel.addMouseListener(mouseListener);
        panel.addMouseMotionListener(mouseListener);
        panel.addKeyListener(keyListener);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

}
