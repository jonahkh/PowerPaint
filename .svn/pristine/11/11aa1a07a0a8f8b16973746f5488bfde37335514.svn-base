/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * This class creates the action event for the Color button in the menu.
 *
 * @author Jonah Howard
 * @version 14 November 2015
 */
public class ColorActionIcon implements Icon {
    
    /** The size of this icon. */
    private static final Dimension ICON_SIZE = new Dimension(20, 20);
    
    /** The current color being used. */
    private final Color myCurrentColor;
    
    /**
     * Initializes a new ColorActionIcon.
     * 
     * @param theColor the color being considered
     */
    public ColorActionIcon(final Color theColor) {
        super();
        myCurrentColor = theColor;
    }
    
    /**
     * returns the height of the icon.
     * 
     * @return the height of the icon
     */
    @Override
    public int getIconHeight() {
        return (int) ICON_SIZE.getHeight();
    }

    /**
     * returns the width of the icon.
     * 
     * @return the width of the icon
     */
    @Override
    public int getIconWidth() {
        return (int) ICON_SIZE.getHeight();
    }

    /** {@inheritDoc}. */
    @Override
    public void paintIcon(final Component theComponent, final Graphics theGraphics, 
                          final int theX, final int theY) {
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setColor(myCurrentColor);
        // Draw the icon based on the passed coordinates and current color
        g2d.fillRect(theX, theY, (int) ICON_SIZE.getWidth(), (int) ICON_SIZE.getHeight());
    }
}