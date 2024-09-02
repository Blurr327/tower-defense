package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JButton;

import model.gamelogic.BottomSectionModel;
import model.gamelogic.PlayManagerModel;
import model.map.MapModel;
import view.helperclasses.CustomButtonView;

import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

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

        Action StartEditing = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate a click on the settings button
                getSwitchToEditButton().doClick();
                System.out.println("(With a pressed key)");
            }
        };
    
        // Add the key binding to the JPanel, we have to do it for every bind... but no choice I guess è_é
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('e'), "StartEditing");
        this.getActionMap().put("StartEditing", StartEditing);
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
