package model.map;
import java.util.Random;

import model.map.tiletypes.FlowerTileType;
import model.map.tiletypes.GrassTileType;
import model.map.tiletypes.PathTileType;
import model.map.tiletypes.TileType;

import java.util.ArrayList;
import view.AppContainer;

public class MapModel {
    public static final int HEIGHT = 20;
    public static final int WIDTH = 20;
    private static final TileModel[][] tiles = new TileModel[HEIGHT][WIDTH];

    // generating default map
    static {

            for(int y=0;y<HEIGHT;y++){
                for(int x=0;x<WIDTH;x++){
                    tiles[y][x] = new TileModel(x, y, new GrassTileType());
                }
            }

            for(int x=0;x<WIDTH/2;x++){

                tiles[HEIGHT/2][x].setTileType(new PathTileType());
            }
            for(int y=HEIGHT/4;y<=HEIGHT/2;y++){

                tiles[y][WIDTH/2].setTileType(new PathTileType());
            }
            for(int x=WIDTH/2;x<WIDTH;x++){

                tiles[HEIGHT/4][x].setTileType(new PathTileType());
            }

            for(int i=0;i<8;i++){
                generateFlower();
            }
    }

    public static TileType getTileTypeAt(int x, int y){ 
        if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT)
            return null;
        return tiles[y][x].getTileType();
    }

    public static void setTileTypeAt(int x, int y, TileType type){
        if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT)
            return;
        tiles[y][x].setTileType(type);
    }

    public static TileModel getTileAt(int x, int y){
        if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT)
            return null;
        return tiles[y][x];
    }

    public static void setTileAt(int x, int y, TileModel tile){
        if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT)
            return;
        tiles[y][x] = tile;
    }

    public static void iniTiles(){
        for(int y=0;y<HEIGHT;y++){
            for(int x=0;x<WIDTH;x++){
                tiles[y][x].setMapComponentOnTile(null);
            }
        }
    }
    
    public static void generateFlower() {
        Random r = new Random();
        int x = r.nextInt(HEIGHT);
        int y = r.nextInt(WIDTH);
        while(tiles[y][x].getTileType() instanceof PathTileType){
            x = r.nextInt(HEIGHT);
            y = r.nextInt(WIDTH);
        }
        tiles[y][x].setTileType(new FlowerTileType());
    }

}

