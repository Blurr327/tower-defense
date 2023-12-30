package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class StringHelper {
    

    public static void drawCenteredString(Graphics g, String text, int tileX, int tileY, int unitSize) {
        // Set font and color   
        g.setFont(new Font("Dialong", Font.PLAIN, 20));
        g.setColor(Color.BLACK);

        // Calculate the center of the tile
        int centerX = tileX * unitSize + unitSize / 2;
        int centerY = tileY * unitSize + unitSize / 2;

        // Calculate the position to draw the string centered on the tile
        int x = centerX - g.getFontMetrics().stringWidth(text) / 2;
        int y = centerY + g.getFontMetrics().getHeight() / 4;  // Adjust vertical position for better centering

        // Set the alpha value for opacity (1.0f is fully opaque, 0.0f is fully transparent)
        float alpha = 0.4f;

        // Create an AlphaComposite instance with the specified alpha value
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

        // Save the current graphics state
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the composite for transparency
        g2d.setComposite(alphaComposite);

        // Draw the string
        g2d.drawString(text, x, y);

        // Dispose of the graphics context to release resources
        g2d.dispose();
    }
    
    public static Graphics2D getTrasnparentString(Graphics g, float alpha) {

        // Create an AlphaComposite instance with the specified alpha value
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

        // Save the current graphics state
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the composite for transparency
        g2d.setComposite(alphaComposite);

        return g2d;
    }

    public static void drawString(Graphics g, String text, int x, int y, int unitSize) {
        // Set font and color   
        g.setFont(new Font("Dialong", Font.PLAIN, 20));
        g.setColor(Color.BLACK);

        // Set the alpha value for opacity (1.0f is fully opaque, 0.0f is fully transparent)
        float alpha = 0.4f;

        // Create an AlphaComposite instance with the specified alpha value
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

        // Save the current graphics state
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the composite for transparency
        g2d.setComposite(alphaComposite);

        // Draw the string
        g2d.drawString(text, x, y);

        // Dispose of the graphics context to release resources
        g2d.dispose();
    }
}

