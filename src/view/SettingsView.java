package view;

import java.awt.*;
import javax.swing.*;

import controller.AppController;
import controller.EnemyController;
import model.AppModel;
import model.gamelogic.BottomSectionModel;
import model.gamelogic.WaveModel;
import model.gamelogic.wavestates.MarathonWaveState;
import model.gamelogic.wavestates.NormalWaveState;
import view.helperclasses.CustomButtonView;


/*
 * this class is used to adjust the FPS, difficulty and sound settings
 */
public class SettingsView extends JPanel {
    // Even though we're in setting view, we're still using the App's controller since 
    // changing settings basically means changing the App's model
    private AppController controller;
    // changing the difficulty of the ennemies is the role of the setting
    // that's why i'll be using the Settings' view and not the EnemyView
    private EnemyController enemyController;
    private AppModel model;

    CustomButtonView switchToMenuButton = new CustomButtonView("Menu");

    // buttons to change the fluidity of the game
    CustomButtonView changeFPSTo30Button = new CustomButtonView("30 FPS");
    CustomButtonView changeFPSTo60Button = new CustomButtonView("60 FPS");
    CustomButtonView changeFPSTo120Button = new CustomButtonView("120 FPS");

    // buttons to change the tick rate of the game
    CustomButtonView changeTickRateTo32Button = new CustomButtonView("32 tickrate");
    CustomButtonView changeTickRateTo64Button = new CustomButtonView("64 tickrate");
    CustomButtonView changeTickRateTo128Button = new CustomButtonView("128 tickrate");

    // buttons to change the difficulty of the game
    CustomButtonView changeDifficultyToEasyButton = new CustomButtonView("Easy");
    CustomButtonView changeDifficultyToMediumButton = new CustomButtonView("Medium");
    CustomButtonView changeDifficultyToHardButton = new CustomButtonView("Hard");

    private static CustomButtonView switchToMarathonButton = new CustomButtonView("Marathon");
    private static CustomButtonView switchToNormalButton = new CustomButtonView("Normal");

    static {
        switchToMarathonButton.addActionListener(e -> WaveModel.setWaveModelState(new MarathonWaveState()));
        switchToNormalButton.addActionListener(e -> WaveModel.setWaveModelState(new NormalWaveState()));
    }

    Dimension buttonSize = new Dimension(120, 30); // Définir la taille préférée


    public SettingsView(){
        super(new BorderLayout());
    
        // Créer le JPanel pour le bouton "Menu"
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuPanel.add(switchToMenuButton);
        switchToMenuButton.setPreferredSize(buttonSize);
    
        // Créer le JPanel pour les autres boutons
        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

    
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonsPanel.add(changeFPSTo30Button, gbc);
        changeFPSTo30Button.setPreferredSize(buttonSize);
    
        gbc.gridx = 2;
        buttonsPanel.add(changeTickRateTo32Button, gbc);
        changeTickRateTo32Button.setPreferredSize(buttonSize);
    
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonsPanel.add(changeFPSTo60Button, gbc);
        changeFPSTo60Button.setPreferredSize(buttonSize);
    
        gbc.gridx = 2;
        buttonsPanel.add(changeTickRateTo64Button, gbc);
        changeTickRateTo64Button.setPreferredSize(buttonSize);
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonsPanel.add(changeFPSTo120Button, gbc);
        changeFPSTo120Button.setPreferredSize(buttonSize);
    
        gbc.gridx = 2;
        buttonsPanel.add(changeTickRateTo128Button, gbc);
        changeTickRateTo128Button.setPreferredSize(buttonSize);

        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonsPanel.add(changeDifficultyToEasyButton, gbc);
        changeDifficultyToEasyButton.setPreferredSize(buttonSize);

        gbc.gridx = 1;
        buttonsPanel.add(changeDifficultyToMediumButton, gbc);
        changeDifficultyToMediumButton.setPreferredSize(buttonSize);

        gbc.gridx = 2;
        buttonsPanel.add(changeDifficultyToHardButton, gbc);
        changeDifficultyToHardButton.setPreferredSize(buttonSize);

        // add marathon button neatly 
        gbc.gridx = 0;
        gbc.gridy = 4;
        buttonsPanel.add(switchToMarathonButton, gbc);
        switchToMarathonButton.setPreferredSize(buttonSize);

        // add normal button neatly
        gbc.gridx = 2;
        buttonsPanel.add(switchToNormalButton, gbc);
        switchToNormalButton.setPreferredSize(buttonSize);


    
        // Ajouter les JPanel à la SettingsView
        add(menuPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, AppView.WIDTH, AppView.HEIGHT);
    }
    
    public CustomButtonView getSwitchToMenuButton() {
        return switchToMenuButton;
    }

    public CustomButtonView getChangeFPSTo30Button() {
        return changeFPSTo30Button;
    }

    public CustomButtonView getChangeFPSTo60Button() {
        return changeFPSTo60Button;
    }

    public CustomButtonView getChangeFPSTo120Button() {
        return changeFPSTo120Button;
    }

    public CustomButtonView getChangeTickRateTo32Button() {
        return changeTickRateTo32Button;
    }

    public CustomButtonView getChangeTickRateTo64Button() {
        return changeTickRateTo64Button;
    }

    public CustomButtonView getChangeTickRateTo128Button() {
        return changeTickRateTo128Button;
    }

    public CustomButtonView getChangeDifficultyToEasyButton() {
        return changeDifficultyToEasyButton;
    }

    public CustomButtonView getChangeDifficultyToNormalButton() {
        return changeDifficultyToMediumButton;
    }

    public CustomButtonView getChangeDifficultyToHardButton() {
        return changeDifficultyToHardButton;
    }

    public CustomButtonView getSwitchToMarathonButton() {
        return switchToMarathonButton;
    }

    public CustomButtonView getSwitchToNormalButton() {
        return switchToNormalButton;
    }
}
