package model;
import java.util.Random;

import view.AppContainer;

public class MapModel {
    public static final int HEIGHT = 20;
    public static final int WIDTH = 20;
    private static final int[][] map = new int[HEIGHT][WIDTH];
    
    // generating default map
    static {
            for(int x=0;x<WIDTH/2;x++){
                map[HEIGHT/2][x] = 2;
            }
            for(int y=HEIGHT/4;y<=HEIGHT/2;y++){
                map[y][WIDTH/2] = 2;
            }
            for(int x=WIDTH/2;x<WIDTH;x++){
                map[HEIGHT/4][x] = 2;
            }

            for(int i=0;i<8;i++){
                generateFlower();
            }
    }

    public static int getTileIdAt(int x, int y){ 
        return map[y][x];
    }

    public static void setTileIdAt(int x, int y, int id){
        map[y][x] = id;
    }

    public static void generateFlower() {
        Random r = new Random();
        int x = r.nextInt(HEIGHT);
        int y = r.nextInt(WIDTH);
        while(map[x][y] == 2){
            x = r.nextInt(HEIGHT);
            y = r.nextInt(WIDTH);
        }
        map[x][y] = 1;
    }

}

