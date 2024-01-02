package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.MapEditorController;
import model.gamelogic.BottomSectionModel;
import model.gamelogic.GameModel;
import model.gamelogic.ShmucklesModel;
import model.map.MapEditorModel;
import model.map.MapModel;
import model.map.tiletypes.TileType;
import model.towers.TowerFactory;
import model.towers.TowerModel;
import model.map.tiletypes.TileTypeManagerModel;
import view.helperclasses.CustomButtonView;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Font;

import java.util.Iterator;


public class MapEditorView extends JPanel{

    private MapEditorModel model = new MapEditorModel();
    private MapEditorController controller;

    private CustomButtonView switchToPlayAndStartGameManagerButton = new CustomButtonView("Play");

    private CustomButtonView resumeButton = new CustomButtonView("Resume");


    // buttons used for switching to the spawn point editor and target point editor
    private CustomButtonView spawnPointEditorButton = new CustomButtonView("Spawn");
    private CustomButtonView targetPointEditorButton = new CustomButtonView("Target");


    public MapEditorView(){

        this.setLayout(null);

        // initializing controller

        this.controller = new MapEditorController(model, this);
        
        // initializing the tile buttons
        initTileButtons();

        initTowerButtons();


        // initializing and positioning switch to play manager button
        add(switchToPlayAndStartGameManagerButton);
        switchToPlayAndStartGameManagerButton.setBounds(15,15,90, 30);

        //initializing and positioning spawn point editor button
        add(spawnPointEditorButton);
        spawnPointEditorButton.setBounds(15, 50, 90, 30);

        //initializing and positioning target point editor button
        add(targetPointEditorButton);
        targetPointEditorButton.setBounds(15, 85, 90, 30);
        
        // add actions listenrs to the buttons
        addActionListeners();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void renderShmuckles(Graphics g){
        // draw shmuckles on bottom right corner of bottom section
        g.setColor(Color.black);
        g.setFont(new Font("Dialog", Font.PLAIN, 20));
        g.drawString("Shmuckles: " + ShmucklesModel.getShmuckles(), BottomSectionModel.SECTION_WIDTH*AppView.UNIT_SIZE - 200, BottomSectionModel.SECTION_HEIGHT*AppView.UNIT_SIZE - 15);
    }

    public void draw(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, BottomSectionModel.SECTION_WIDTH*AppView.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*AppView.UNIT_SIZE);
        renderShmuckles(g);
    }

        
    public CustomButtonView getSwitchToPlayManagerButton() {
        return switchToPlayAndStartGameManagerButton;
    }

    public void addActionListeners() {

        // add action listener to the spawn point editor button
        spawnPointEditorButton.addActionListener(e -> controller.spawnPointEditorButtonClicked());

        // add action listener to the target point editor button
        targetPointEditorButton.addActionListener(e -> controller.targetPointEditorButtonClicked());

    }

    public void setModel(MapEditorModel model) {
        this.model = model;
    }

    public void setController(MapEditorController controller) {
        this.controller = controller;
    }

    public void addResumeButton() {
        add(resumeButton);
        // position the resume button on the top right corner of the bottom sections
        resumeButton.setBounds(BottomSectionModel.SECTION_WIDTH*AppView.UNIT_SIZE - 90 -15, 15, 90, 30);
    }

    public void removeResumeButton() {
        remove(resumeButton);
    }

    public CustomButtonView getResumeButton() {
        return resumeButton;
    }

    public void initTileButtons() {
        Iterator<TileType> tileTypeIterator = TileTypeManagerModel.getTileTypesIterator();
        int i=0;
        while(tileTypeIterator.hasNext()) {
            TileType type = tileTypeIterator.next();
            JButton button = new JButton(TileView.getIcon(type));
            button.addActionListener(e -> controller.tileSelected(type));
            button.setBounds(100 + (i+1)*50, 15, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            this.add(button);
            i++;
        }
    }

    public void initTowerButtons(){
        Iterator<TowerModel> towerIterator = TowerFactory.getTowerIterator();
        int i=0;
        while(towerIterator.hasNext()) {
            TowerModel tower = towerIterator.next();
            JButton button = new JButton(TowerView.getIcon(tower));
            button.addActionListener(e -> controller.towerSelected(tower));
            button.setBounds(100 + (i+1)*50, 50, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            this.add(button);
            i++;
        }
    }
}
