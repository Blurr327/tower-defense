package view;

import model.TileModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.ArrayList;

public class PlayView extends JPanel {
    MapView mapView;
    JButton switchToMenuButton = new JButton("Menu");
    private ArrayList<JLabel> tileLabels = new ArrayList<>();

    public PlayView(GameView gameView) {
        super(new BorderLayout());
        mapView = new MapView();

        // Create labels dynamically
        JPanel labelsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Add the "Menu" button to the bottom bar
        switchToMenuButton.addActionListener(e ->
                gameView.controller.switchTo("menu"));
        labelsPanel.add(switchToMenuButton);

        for (TileModel tileModel : TileModel.values()) {
            JLabel tileLabel = createTileLabel(tileModel);
            tileLabels.add(tileLabel);
            labelsPanel.add(tileLabel);
        }
        add(labelsPanel, BorderLayout.SOUTH);
    }

    private JLabel createTileLabel(TileModel tileModel) {
        BufferedImage image = tileModel.getSprite();
        ImageIcon icon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
    
        JLabel tileLabel = new JLabel(icon);
        tileLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add some padding
    
        tileLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Clicked: " + tileModel.getName());
                // Handle the click event, you can use tileModel.getId() or tileModel.getName() here (no need for it at the moment)
            }
    
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the background color when the mouse enters
                // It's thicc as hell but I don't know how to do it better
                tileLabel.setOpaque(true);
                tileLabel.setBackground(Color.DARK_GRAY);
            }
    
            @Override
            public void mouseExited(MouseEvent e) {
                // Reset the background color when the mouse exits
                tileLabel.setOpaque(false);
            }
        });
    
        return tileLabel;
    }
    

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        mapView.renderMap(g);
    }
}
