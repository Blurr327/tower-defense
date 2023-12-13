package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JButton;

import model.BottomSectionModel;
import model.MapModel;
import model.PlayManagerModel;

public class PlayManagerView extends JPanel{
    PlayManagerModel model;
    CustomButtonView switchToEditButton = new CustomButtonView("Edit");

    public PlayManagerView(PlayManagerModel model){
        this.model = model;
        this.setLayout(null);
        add(switchToEditButton);
        switchToEditButton.setOpaque(false);
        switchToEditButton.setContentAreaFilled(false);
        switchToEditButton.setBounds(15,15,80,30);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, BottomSectionModel.SECTION_WIDTH*MapModel.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*MapModel.UNIT_SIZE);
    }

    public CustomButtonView getSwitchToEditButton() {
        return switchToEditButton;
    }

}
