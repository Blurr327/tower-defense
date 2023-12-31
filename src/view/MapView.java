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
import model.map.TileType;
import model.towers.TowerFactory;
import model.towers.TowerManagerModel;


/*
 * this class is responsible for rendering the map and everything that happens in it (enemies, towers, projectiles, etc)
 */

public class MapView extends JPanel{
    private MapModel map;

    private static final MessagesView spawnEditInfo = new MessagesView("Click on a tile to set it as the spawn point");
    private static final MessagesView targetEditInfo = new MessagesView("Click on a tile to set it as the target point");
    private static final MessagesView pauseMessage = new MessagesView("Pressing escape will pause/unpause the game");
    private static final MessagesView tileEditInfo = new MessagesView("Select a tile from the bottom section and click on a tile to change it");
    private static final MessagesView towerEditInfo = new MessagesView("Select a tower from the bottom section and click on a tile to place it");
    private static final MessagesView towerRemovalInfo = new MessagesView("Right click on a tower to remove it");
    private static final MessagesView forbiddenMapModificationInfo = new MessagesView("Can't modify map mid game");

    static {
        forbiddenMapModificationInfo.setAllowedToBeDrawn(false);
    }

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
                if(pauseMessage.allowedToBeDrawn()) pauseMessage.drawDisappearingMessage(g);
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
        renderTowers(g);
        switch(MapEditorModel.getMapEditorMode()) {
            case TILE:
                if(tileEditInfo.allowedToBeDrawn()) tileEditInfo.drawDisappearingMessage(g);
                if(forbiddenMapModificationInfo.allowedToBeDrawn()) forbiddenMapModificationInfo.drawDisappearingMessage(g);
                if(MapEditorModel.isTileSelected()) {
                    TileView.renderTile(g, MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), MapEditorModel.getSelectedTileId());
                }
                break;
            case SPAWN:
                    if(spawnEditInfo.allowedToBeDrawn()) spawnEditInfo.drawDisappearingMessage(g);
                    // Draw the "S" on hover
                    StringHelper.drawCenteredString(g, "S", MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), u);

                    // Draw the "S" on the spawn tile
                    StringHelper.drawCenteredString(g, "S", EnemyModel.getSpawnTileX(), EnemyModel.getSpawnTileY(), u);
                break;
            case TARGET:
                    if(targetEditInfo.allowedToBeDrawn()) targetEditInfo.drawDisappearingMessage(g);
                    // Draw the "T" on hover
                    StringHelper.drawCenteredString(g, "X", MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), u);

                    BaseView.renderBase(g, BaseModel.getX(), BaseModel.getY());
                    break;
            case TOWER:
                    if(towerEditInfo.allowedToBeDrawn()) towerEditInfo.drawDisappearingMessage(g);
                    if(MapEditorModel.getSelectedTower()!=null)
                        TowerView.renderTowerAt(g, MapEditorModel.getSelectedTower(), MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY());
                    break;

        }
    }

    public void renderPlayMap(Graphics g){

        renderTowers(g);

        for(int i=0;i<WaveModel.enemies.size();i++){
            EnemyView.renderEnemy(g, WaveModel.enemies.get(i));
            EnemyView.renderEnemyHealth(g, WaveModel.enemies.get(i));
        }

        BaseView.renderBase(g, BaseModel.getX(), BaseModel.getY());
        BaseView.renderBaseHealth(g, ((MapModel.WIDTH-1)*AppView.UNIT_SIZE)-75, 10);
        
        renderProjectiles(g);
    }

    public void renderTowers(Graphics g){
        for(int i=0;i<TowerManagerModel.getNumberOfTowers();i++){
            if(towerRemovalInfo.allowedToBeDrawn()) towerRemovalInfo.drawDisappearingMessage(g);
            TowerView.renderTower(g, TowerManagerModel.getTowerByIndex(i));
        }
    }

    public void renderProjectiles(Graphics g){
        for(int i=0;i<TowerManagerModel.getNumberOfTowers();i++){
            TowerView.renderProjectilesOf(g, TowerManagerModel.getTowerByIndex(i));
        }
    }

    public void setPanelSize(){
        Dimension size = new Dimension(MapModel.WIDTH*AppView.UNIT_SIZE, MapModel.HEIGHT*AppView.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    public static void showForbiddenMessage(){
        forbiddenMapModificationInfo.setAllowedToBeDrawn(true);
    }

}
