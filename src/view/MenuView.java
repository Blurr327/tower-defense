package view;

import java.awt.*;
import javax.swing.*;

import model.AppModel;
import view.helperclasses.CustomButtonView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

/*
 * this class is the view for the menu
 *
 */
public class MenuView extends JPanel {
    CustomButtonView switchToGameButton = new CustomButtonView("Play");
    CustomButtonView switchToSettingsButton = new CustomButtonView("Settings");
    CustomButtonView quitButton = new CustomButtonView("Quit");

    public MenuView(){
        this.setLayout(null);
        add(switchToGameButton);
        add(switchToSettingsButton);
        add(quitButton);
        quitButton.addActionListener( e -> {
            System.out.println("Goodbye ! :(");
            System.exit(0);
        });
        // variables for correctly positioning the buttons
        int spacing = 30;
        int button_height = 30;
        int button_width = 100;
        // positioning the buttons
        switchToGameButton.setBounds((AppView.WIDTH/2)-(button_width/2)
        , (AppView.HEIGHT/2)-(button_height/2) - spacing - button_height
        , button_width, button_height
        );
        switchToSettingsButton.setBounds((AppView.WIDTH/2)-(button_width/2)
        , (AppView.HEIGHT/2)-(button_height/2)
        ,button_width, button_height
        );
        quitButton.setBounds((AppView.WIDTH/2)-(button_width/2)
        , (AppView.HEIGHT/2)-(button_height/2) + spacing + button_height
        , button_width, button_height
        );
        Action goToSettings = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate a click on the settings button
                getSwitchToSettingsButton().doClick();
                System.out.println("You are in the settings, to go back, press m.");
                System.out.println("You can press on f/t to change the FPS/tickrate !");
                System.out.println("You can press on t to change the difficulty of the game !");
            }
        };
    
        // Add the key binding to the JPanel, we have to do it for every bind... but no choice I guess è_é
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "goToSettings");
        this.getActionMap().put("goToSettings", goToSettings);

        Action goToPlay = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate a click on the settings button
                getSwitchToGameButton().doClick();
                System.out.println("You are in the game, here's the keybinding : ");
                System.out.println("v, b, n for the tile, w, x, c for the tower, you can upgrade/downgrade with u/i");
            }
        };
    
        // Add the key binding to the JPanel, we have to do it for every bind... but no choice I guess è_é
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('p'), "goToPlay");
        this.getActionMap().put("goToPlay", goToPlay);

        Action goQuit = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate a click on the settings button
                System.out.println("Goodbye ! :(");
                System.exit(0);
            }
        };
    
        // Add the key binding to the JPanel, we have to do it for every bind... but no choice I guess è_é
        this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke('q'), "goQuit");
        this.getActionMap().put("goQuit", goQuit);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0,0,AppView.WIDTH,AppView.HEIGHT);
    }

        public CustomButtonView getSwitchToGameButton() {
        return switchToGameButton;
    }

        public CustomButtonView getSwitchToSettingsButton() {
        return switchToSettingsButton;
    }
}
