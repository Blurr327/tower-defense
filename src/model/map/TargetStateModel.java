package model.map;

public class TargetStateModel implements MapEditorState{
    

    @Override
    public void handleState() {
        if(MapEditorModel.selectedTargetTileIsValid()) {
            MapEditorModel.updateTargetTileToSelectedTile();
        } else {
            System.out.println("The target must be on a path !");
        }
    }
}
