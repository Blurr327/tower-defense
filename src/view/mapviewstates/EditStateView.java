package view.mapviewstates;

import java.awt.Graphics;

import view.helperclasses.MessagesView;
import view.mapviewstates.editingstateviews.EditingState;
import view.mapviewstates.editingstateviews.TileEditStateView;

public class EditStateView implements MapViewState{
    private static EditingState state = new TileEditStateView();
    private static final MessagesView forbiddenMapModificationInfo = new MessagesView("Can't modify map mid game");
    
    static {
        forbiddenMapModificationInfo.setAllowedToBeDrawn(false);
    }


    public static void setEditStateView(EditingState state){
        EditStateView.state = state;
    }


    @Override 
    public void renderState(Graphics g){
        if(forbiddenMapModificationInfo.allowedToBeDrawn()) forbiddenMapModificationInfo.drawDisappearingMessage(g);
        state.renderEditingState(g);
    }

    public static void allowForbiddenMapModificationInfoToBeDrawn() {
        forbiddenMapModificationInfo.setAllowedToBeDrawn(true);
    }
}
