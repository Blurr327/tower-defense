package controller;

import model.MapEditorModel;
import model.MapModel;
import view.MapView;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MapController implements MouseMotionListener, MouseListener {
    MapModel model;
    MapView view;

    public MapController(MapModel model, MapView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO: Implement mouseDragged method
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO: Implement mouseMoved method
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO: Implement mouseClicked method
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO: Implement mousePressed method
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO: Implement mouseReleased method
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO: Implement mouseEntered method
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO: Implement mouseExited method
    }
}
