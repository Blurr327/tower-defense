package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import controller.MapController;

import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;

import model.enemies.EnemyModel;
import model.gamelogic.BaseModel;
import model.gamelogic.GameModel;
import model.gamelogic.WaveModel;
import model.map.MapEditorModel;
import model.map.MapModel;
import model.map.tiletypes.TileType;
import model.towers.TowerFactory;
import model.towers.TowerManagerModel;
import view.mapviewstates.EditStateView;
import view.mapviewstates.MapViewState;


/*
 * this class is responsible for rendering the map and everything that happens in it (enemies, towers, projectiles, etc)
 */

public class MapView extends JPanel{
    private MapModel map;
    private static MapViewState state = new EditStateView();


    public MapView(){
        map = new MapModel();
        setPanelSize();
        setFocusable(true);
        requestFocusInWindow();
        addMouseMotionListener(new MapController(new MapModel(), this));
        addMouseListener(new MapController(new MapModel(), this));
        
    }

    // This function is called 60 times per second because it is contained in the container panel that is repainted 60 times per second by the App Controller
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        renderMap(g);
        TowerView.renderTowers(g);
        state.renderState(g);
    }

    public void renderMap(Graphics g){
        // drawing the map
        int u= AppView.UNIT_SIZE;
        for(int y=0;y<MapModel.HEIGHT;y++){
            for(int x=0;x<MapModel.WIDTH;x++){
                TileView.renderTile(g, x, y, MapModel.getTileTypeAt(x, y));
            }
        }
    }

    public static void setMapViewState(MapViewState newState){
        state = newState;
    }

    public void setPanelSize(){
        Dimension size = new Dimension(MapModel.WIDTH*AppView.UNIT_SIZE, MapModel.HEIGHT*AppView.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }


}
