package model.map;
import java.util.Random;
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
                    tiles[y][x] = new TileModel(x, y, TileType.GRASS);
                }
            }

            for(int x=0;x<WIDTH/2;x++){

                tiles[HEIGHT/2][x].setTileType(TileType.PATH);
            }
            for(int y=HEIGHT/4;y<=HEIGHT/2;y++){

                tiles[y][WIDTH/2].setTileType(TileType.PATH);
            }
            for(int x=WIDTH/2;x<WIDTH;x++){

                tiles[HEIGHT/4][x].setTileType(TileType.PATH);
            }

            for(int i=0;i<8;i++){
                generateFlower();
            }
    }

    public static int getTileIdAt(int x, int y){ 
        if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT)
            return -1;
        return tiles[y][x].getTileType().getId();
    }

    public static void setTileIdAt(int x, int y, int id){
        if(x<0 || x>=WIDTH || y<0 || y>=HEIGHT)
            return;
        tiles[y][x].setTileType(TileType.getTileById(id));
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
        while(tiles[y][x].getTileType() == TileType.PATH){
            x = r.nextInt(HEIGHT);
            y = r.nextInt(WIDTH);
        }
        tiles[y][x].setTileType(TileType.FLOWER);
    }

}

