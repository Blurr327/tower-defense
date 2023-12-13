package view;

import java.awt.*;
import javax.swing.*;

public class SettingsView extends JPanel {
    CustomButtonView switchToMenuButton = new CustomButtonView("Menu");

    public SettingsView(){
        super(new FlowLayout());
        add(switchToMenuButton);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0,0,640,640);
    }
    
    public CustomButtonView getSwitchToMenuButton() {
        return switchToMenuButton;
    }

}
