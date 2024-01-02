package view;

import java.awt.Graphics;

public class EditStateView implements MapViewState{
    private static EditingState state = new TileEditStateView();


    public static void setEditStateView(EditingState state){
        EditStateView.state = state;
    }


    @Override 
    public void renderState(Graphics g){
        state.renderEditingState(g);
    }
}
