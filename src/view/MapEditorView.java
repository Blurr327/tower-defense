package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.MapEditorController;
import model.BottomSectionModel;
import model.MapEditorModel;
import model.MapModel;
import model.TileModel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;


public class MapEditorView extends JPanel{
    MapEditorModel model = new MapEditorModel();

    MapEditorController controller;

    CustomButtonView switchToPlayManagerButton = new CustomButtonView("Play");
    
    ArrayList<JButton> tileButtons = new ArrayList<JButton>();
    private static final ImageIcon[] iconArray;

    static {
        iconArray = new ImageIcon[TileModel.values().length];
        for(TileModel tile : TileModel.values()) {
            iconArray[tile.getId()] = new ImageIcon(TileView.getSpriteById(tile.getId()));
        }
    }


    public MapEditorView(){

        this.setLayout(null);

        // initializing controller

        this.controller = new MapEditorController(model, this);
        
        // initializing the tile buttons
        for(int i = 0; i < iconArray.length;i++){
            tileButtons.add(new JButton(iconArray[i]));
        }

        // initializing switch to play manager button
        add(switchToPlayManagerButton);
        switchToPlayManagerButton.setBounds(15,15,80,30);
        addActionListeners();
        
        // positioning the tile buttons and adding them to the panel
        for(int i = 0; i < tileButtons.size();i++){
            tileButtons.get(i).setBounds(100 + (i+1)*50, 15, AppView.UNIT_SIZE, AppView.UNIT_SIZE);
            add(tileButtons.get(i));
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, BottomSectionModel.SECTION_WIDTH*AppView.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*AppView.UNIT_SIZE);
    }

        
    public CustomButtonView getSwitchToPlayManagerButton() {
        return switchToPlayManagerButton;
    }

    public void addActionListeners() {
        for (int i = 0; i < tileButtons.size(); i++) {
            final int index = i; // Create a final copy of the variable i
            tileButtons.get(i).addActionListener(e -> controller.tileSelected(index));
        }
    }

    public void setModel(MapEditorModel model) {
        this.model = model;
    }

        public void setController(MapEditorController controller) {
        this.controller = controller;
    }

}
