package view;

import java.awt.*;
import javax.swing.*;

public class SettingsView extends JPanel {
    AppView appView;
    public SettingsView(AppView appView){
        super(new FlowLayout());
        this.appView = appView;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0,0,640,640);
    }
    
}
