package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.MapEditorController;
import model.gamelogic.BottomSectionModel;
import model.gamelogic.GameModel;
import model.map.MapEditorModel;
import model.map.MapModel;
import model.map.TileType;
import model.towers.TowerFactory;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Font;


public class MapEditorView extends JPanel{

    private MapEditorModel model = new MapEditorModel();
    private MapEditorController controller;

    private CustomButtonView switchToPlayAndStartGameManagerButton = new CustomButtonView("Play");

    private CustomButtonView resumeButton = new CustomButtonView("Resume");
    
    // array list containing all of the tile buttons which are going to be displayed on the bottom section
    private ArrayList<JButton> tileButtons = new ArrayList<JButton>();

    private ArrayList<JButton> towerButtons = new ArrayList<JButton>();

    // array containing all of the icons for the tower buttons
    private static final ImageIcon[] towerIconArray;


    // this is the array containing all of the icons for the tile buttons
    private static final ImageIcon[] tileIconArray;

    // buttons used for switching to the spawn point editor and target point editor
    private CustomButtonView spawnPointEditorButton = new CustomButtonView("Spawn");
    private CustomButtonView targetPointEditorButton = new CustomButtonView("Target");

    // initializing the icon array
    static {
        tileIconArray = new ImageIcon[TileType.values().length];
        for(TileType tile : TileType.values()) {
            tileIconArray[tile.getId()] = new ImageIcon(TileView.getSpriteById(tile.getId()));
        }

        towerIconArray = new ImageIcon[TowerFactory.getNumberOfTowers()];
        for(int i = 0; i < towerIconArray.length;i++){
            towerIconArray[i] = new ImageIcon(TowerView.getSprite(TowerFactory.getTowerByIndex(i)));
        }
    }


    public MapEditorView(){

        this.setLayout(null);

        // initializing controller

        this.controller = new MapEditorController(model, this);
        
        // initializing the tile buttons
        for(int i = 0; i < tileIconArray.length;i++){
            tileButtons.add(new JButton(tileIconArray[i]));
        }

        for (int i = 0; i < towerIconArray.length; i++) {
            towerButtons.add(new JButton(towerIconArray[i]));
        }

        // initializing and positioning switch to play manager button
        add(switchToPlayAndStartGameManagerButton);
        switchToPlayAndStartGameManagerButton.setBounds(15,15,90, 30);

        //initializing and positioning spawn point editor button
        add(spawnPointEditorButton);
        spawnPointEditorButton.setBounds(15, 50, 90, 30);

        //initializing and positioning target point editor button
        add(targetPointEditorButton);
        targetPointEditorButton.setBounds(15, 85, 90, 30);

        
        // positioning the tile buttons and adding them to the panel
        for(int i = 0; i < tileButtons.size();i++){
            tileButtons.get(i).setBounds(100 + (i+1)*50, 15, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            add(tileButtons.get(i));
        }

        for (int i = 0; i < towerButtons.size(); i++) {
            towerButtons.get(i).setBounds(100 + (i + 1) * 50, 50, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            add(towerButtons.get(i));
        }
        
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
        g.drawString("Shmuckles: " + GameModel.getShmuckles(), BottomSectionModel.SECTION_WIDTH*AppView.UNIT_SIZE - 200, BottomSectionModel.SECTION_HEIGHT*AppView.UNIT_SIZE - 15);
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

        // add action listeners to the tile buttons
        for (int i = 0; i < tileButtons.size(); i++) {
            final int index = i; // Create a final copy of the variable i
            tileButtons.get(i).addActionListener(e -> controller.tileSelected(index));
        }

        for (int i = 0; i < towerButtons.size(); i++) {
            final int index = i; // Create a final copy of the variable i
            towerButtons.get(i).addActionListener(e -> controller.towerSelected(TowerFactory.getTowerByIndex(index)));
        }

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

}
