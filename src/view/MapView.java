package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import controller.MapController;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;

import model.BaseModel;
import model.EnemyModel;
import model.GameModel;
import model.MapEditorModel;
import model.MapModel;
import model.TileType;
import model.WaveModel;


/*
 * this class is responsible for rendering the map and everything that happens in it (enemies, towers, projectiles, etc)
 */

public class MapView extends JPanel{
    private MapModel map;


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

        

        switch(GameModel.getGameMode()){
            case EDIT:
                renderEditorMap(g);
                break;
            case PLAY:
                renderPlayMap(g);
                break;
        }
    }

    public void renderMap(Graphics g){
        // drawing the map
        int u= AppView.UNIT_SIZE;
        for(int y=0;y<MapModel.HEIGHT;y++){
            for(int x=0;x<MapModel.WIDTH;x++){
                TileView.renderTile(g, x, y, MapModel.getTileIdAt(x, y));
            }
        }
    }

    public void renderEditorMap(Graphics g){

        int u= AppView.UNIT_SIZE;
        switch(MapEditorModel.getMapEditorMode()) {
            case TILE:
                if(MapEditorModel.isTileSelected()) {
                    TileView.renderTile(g, MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
                }
                break;
            case SPAWN:
                    // Draw the "S" on hover
                    StringHelper.drawCenteredString(g, "S", MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), u);

                    // Draw the "S" on the spawn tile
                    StringHelper.drawCenteredString(g, "S", EnemyModel.getSpawnTileX(), EnemyModel.getSpawnTileY(), u);
                break;
            case TARGET:

                    // Draw the "T" on hover
                    StringHelper.drawCenteredString(g, "X", MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), u);

                    BaseView.renderBase(g, BaseModel.getX(), BaseModel.getY());
                    break;
            case TOWER:

                break;
        }
    }

    public void renderPlayMap(Graphics g){

        for(int i=0;i<WaveModel.enemies.size();i++){
            EnemyView.renderEnemy(g, WaveModel.enemies.get(i));
            EnemyView.renderEnemyHealth(g, WaveModel.enemies.get(i));
        }

        BaseView.renderBase(g, BaseModel.getX(), BaseModel.getY());
        BaseView.renderBaseHealth(g, ((MapModel.WIDTH-1)*AppView.UNIT_SIZE)-75, 10);
        
    }

    public void setPanelSize(){
        Dimension size = new Dimension(MapModel.WIDTH*AppView.UNIT_SIZE, MapModel.HEIGHT*AppView.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

}
