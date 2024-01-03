package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JButton;

import model.gamelogic.BottomSectionModel;
import model.gamelogic.PlayManagerModel;
import model.map.MapModel;
import view.helperclasses.CustomButtonView;

/*
 * This class is responsible for displaying your current balance, the current wave, and the towers available to you
 */
public class PlayManagerView extends JPanel{
    PlayManagerModel model;
    CustomButtonView switchToEditAndEndGameButton = new CustomButtonView("Edit");

    public PlayManagerView(PlayManagerModel model){
        this.model = model;
        this.setLayout(null);
        add(switchToEditAndEndGameButton);
        switchToEditAndEndGameButton.setBounds(15,15,90,30);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, BottomSectionModel.SECTION_WIDTH*AppView.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*AppView.UNIT_SIZE);
    }

    public CustomButtonView getSwitchToEditButton() {
        return switchToEditAndEndGameButton;
    }

    public void disableSwitchToEditButton() {
        switchToEditAndEndGameButton.setEnabled(false);
    }

    public void enableSwitchToEditButton() {
        switchToEditAndEndGameButton.setEnabled(true);
    }

}
