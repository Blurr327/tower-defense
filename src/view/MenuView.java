package view;

import java.awt.*;
import javax.swing.*;

import model.AppModel;
import view.helperclasses.CustomButtonView;

/*
 * this class is the view for the menu
 *
 */
public class MenuView extends JPanel {
    CustomButtonView switchToGameButton = new CustomButtonView("Start");
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
