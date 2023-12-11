package model;
import view.GamePanelContainer;

public class MapModel {
    public static final int UNIT_SIZE = 32;
    public static final int HEIGHT = 20;
    public static final int WIDTH = 20;
    private MapEditorModel mapEditorModel = new MapEditorModel();
    private final int[][] map;
    

    public MapModel(){
        this.map = new int[HEIGHT][WIDTH];
    }

    public int getTileIdAt(int x, int y){
        return map[y][x];
    }

    public void setTileIdAt(int x, int y, int id){
        map[y][x] = id;
    }

    public int getMapHeight(){
        return this.map.length;
    }

    public int getMapWidth(){
        return this.map[0].length;
    }

        public MapEditorModel getMapEditorModel() {
        return mapEditorModel;
    }
}

