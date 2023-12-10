package view;

import model.TileModel;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class PlayView extends JPanel {
    MapView mapView;
    JButton switchToMenuButton = new JButton("Menu");
    private ArrayList<JButton> tileButtons = new ArrayList<>();

    public PlayView(GameView gameView) {
        super(new BorderLayout());
        mapView = new MapView();
        switchToMenuButton.addActionListener(e ->
                gameView.controller.switchTo("menu"));
        add(switchToMenuButton, BorderLayout.NORTH);

        // Create buttons dynamically
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (TileModel tileModel : TileModel.values()) {
            JButton tileButton = createTileButton(tileModel);
            tileButtons.add(tileButton);
            buttonsPanel.add(tileButton);
        }
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private JButton createTileButton(TileModel tileModel) {
        JButton tileButton = new JButton(tileModel.getName());
        tileButton.addActionListener(e -> {
            System.out.println("Button Clicked: " + tileModel.getName());
        });
        return tileButton;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        mapView.renderMap(g);
    }
}
