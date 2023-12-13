package view;

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


public class MapEditorView extends JPanel{
    MapEditorModel model = new MapEditorModel();

    MapEditorController controller;

    CustomButtonView switchToPlayManagerButton = new CustomButtonView("Play");
    JButton selectGrassButton;
    JButton selectPathButton;
    JButton selectFlowerButton;

    public MapEditorView(){
        this.controller = new MapEditorController(model, this);
        
        //FIXME : see the fixme in the mapeditormodel and use the mentioned list to dynamically display all the tile icons

        selectGrassButton = new JButton(model.getGrassIcon());
        selectFlowerButton = new JButton(model.getFlowerIcon());
        selectPathButton = new JButton(model.getPathIcon());
        this.setLayout(null);
        add(switchToPlayManagerButton);

        addActionListeners();

        add(selectGrassButton);
        add(selectPathButton);
        add(selectFlowerButton);

        switchToPlayManagerButton.setBounds(15,15,80,30);
        selectGrassButton.setBounds(150, 15, MapModel.UNIT_SIZE, MapModel.UNIT_SIZE);
        selectPathButton.setBounds(200, 15, MapModel.UNIT_SIZE, MapModel.UNIT_SIZE);
        selectFlowerButton.setBounds(250, 15, MapModel.UNIT_SIZE, MapModel.UNIT_SIZE);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, BottomSectionModel.SECTION_WIDTH*MapModel.UNIT_SIZE, BottomSectionModel.SECTION_HEIGHT*MapModel.UNIT_SIZE);
    }

        
    public CustomButtonView getSwitchToPlayManagerButton() {
        return switchToPlayManagerButton;
    }

    public void addActionListeners(){
        selectGrassButton.addActionListener(e -> controller.tileSelected(TileModel.GRASS.getId()));
        selectFlowerButton.addActionListener(e -> controller.tileSelected(TileModel.FLOWER.getId()));
        selectPathButton.addActionListener(e -> controller.tileSelected(TileModel.PATH.getId()));
    }

        public void setModel(MapEditorModel model) {
        this.model = model;
    }

        public void setController(MapEditorController controller) {
        this.controller = controller;
    }

}
