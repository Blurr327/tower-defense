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

import model.GameModel;
import model.MapEditorModel;
import model.MapModel;
import model.TileModel;
import model.enemies.MrBlobModel;

/*
 * this class is responsible for rendering the map and everything that happens in it (enemies, towers, projectiles, etc)
 */

public class MapView extends JPanel{
    private MapModel map;
    // temporary code to test enemy movement
    public static MrBlobModel blob;

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
                g.drawImage(TileView.getSpriteById(MapModel.getTileIdAt(x, y)),x*u, y*u, null);
            }
        }
    }

    public void renderEditorMap(Graphics g){

        int u= AppView.UNIT_SIZE;
        switch(MapEditorModel.getMapEditorMode()) {
            case TILE:
                if(MapEditorModel.isTileSelected()) 
                    g.drawImage(TileView.getSpriteById(MapEditorModel.getSelectedTileId()), MapEditorModel.getTileToModX()*u, MapEditorModel.getTileToModY()*u, null);
                break;
            case SPAWN:
                    // Draw the "S" on hover
                    drawCenteredString(g, "S", MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), u);

                    // Draw the "S" on the spawn tile
                    drawCenteredString(g, "S", MapEditorModel.getSpawnTileX(), MapEditorModel.getSpawnTileY(), u);
                break;
            case TARGET:

                    // Draw the "T" on hover
                    drawCenteredString(g, "X", MapEditorModel.getTileToModX(), MapEditorModel.getTileToModY(), u);

                    // Draw the "T" on target tile
                    drawCenteredString(g, "X", MapEditorModel.getTargetTileX(), MapEditorModel.getTargetTileY(), u);
                break;
        }
    }

    public void renderPlayMap(Graphics g){
        // temporary code to test enemy movement
        int u= AppView.UNIT_SIZE;
        EnemyView blobView = new EnemyView(blob);  
        g.drawImage(blobView.getSprite(), (int) (blob.getX()*u), (int) (blob.getY()*u), null);
        
    }

    public void setPanelSize(){
        Dimension size = new Dimension(MapModel.WIDTH*AppView.UNIT_SIZE, MapModel.HEIGHT*AppView.UNIT_SIZE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }


    private void drawCenteredString(Graphics g, String text, int tileX, int tileY, int unitSize) {
        // Set font and color   
        g.setFont(new Font("Dialong", Font.PLAIN, 20));
        g.setColor(Color.BLACK);

        // Calculate the center of the tile
        int centerX = tileX * unitSize + unitSize / 2;
        int centerY = tileY * unitSize + unitSize / 2;

        // Calculate the position to draw the string centered on the tile
        int x = centerX - g.getFontMetrics().stringWidth(text) / 2;
        int y = centerY + g.getFontMetrics().getHeight() / 4;  // Adjust vertical position for better centering

        // Set the alpha value for opacity (1.0f is fully opaque, 0.0f is fully transparent)
        float alpha = 0.4f;

        // Create an AlphaComposite instance with the specified alpha value
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

        // Save the current graphics state
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the composite for transparency
        g2d.setComposite(alphaComposite);

        // Draw the string
        g2d.drawString(text, x, y);

        // Dispose of the graphics context to release resources
        g2d.dispose();
    }
}