package model.map;

public class SpawnState implements MapEditorState{
    

    @Override
    public void handleState() {
        if(MapEditorModel.selectedSpawnTileIsValid()) {
            System.out.println("Spawn tile valid");
            MapEditorModel.updateSpawnTileToSelectedTile();
        } else {
            System.out.println("The spawn must be on a path !");
        }
    }
}
