package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.Timer;

import model.map.MapModel;

public class MessagesView {

    private String message;
    private Timer messageTimer;
    final float[] alpha = {0.7f}; // Initial alpha value
    private boolean allowedToBeDrawn = true;
    private int[] delay = {15};

    public MessagesView(String message) {
        this.message = message;
    }

    public void drawMessage(Graphics g, float alpha) {
        // Create a Graphics2D object for more advanced rendering
        Graphics2D g2d = (Graphics2D) g.create();
    
        // Set rendering hints for better quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
        // Set the font for the text
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
    
        // Get the bounds of the text
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D textBounds = fontMetrics.getStringBounds(message, g2d);
    
        // Calculate the position to center the text within the rectangle
        int rectWidth = (int) textBounds.getWidth() + 10; // Add some padding
        int rectHeight = 50;
        int rectX = (MapModel.WIDTH * AppView.UNIT_SIZE - rectWidth) / 2; // Center horizontally
        int rectY = 32; // Center vertically
    
        
        g2d.setColor(new Color(128, 128, 128, (int) (alpha * 255)));
        // Draw the background rectangle
        g2d.fillRect(rectX, rectY, rectWidth, rectHeight);
        
        // Draw the text
        g2d.setColor(new Color(0, 0, 0, (int) (alpha * 255)));
        g2d.drawString(message, rectX + 5, rectY + (rectHeight - (int) textBounds.getHeight()) / 2 + fontMetrics.getAscent());
    
        // Set the color for the outline
        g2d.setColor(new Color(0, 0, 0, (int) (alpha * 255)));
    
        // Draw the border by drawing smaller rectangles around the original one
        int borderWidth = 2;
        for (int i = 0; i < borderWidth; i++) {
            g2d.drawRect(rectX + i, rectY + i, rectWidth - 2 * i - 1, rectHeight - 2 * i - 1);
        }
    
        // Dispose of the Graphics2D object to release resources
        g2d.dispose();
    }

    public void drawDisappearingMessage(Graphics g) {

        if(alpha[0] <= 0.0f){
            messageTimer.stop();
            allowedToBeDrawn = false;
            alpha[0] = 0.5f;
            return;
        }
        else if (messageTimer != null && messageTimer.isRunning()) {
            drawMessage(g, alpha[0]);
        }
        else {
            initMessageTimer();
        }
    }

    public void initMessageTimer(){
        messageTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delay[0] = Math.max(0, delay[0] - 1);
                System.out.println(delay[0]);
                if(delay[0] == 0) alpha[0] -= 0.05f; // Decrease alpha value by 0.05
            }
        });
        messageTimer.start();
    }

    public boolean allowedToBeDrawn() {
        return allowedToBeDrawn;
    }

    public void setAllowedToBeDrawn(boolean allowedToBeDrawn) {
        this.allowedToBeDrawn = allowedToBeDrawn;
    }

}
