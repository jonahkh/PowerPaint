/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.Action;

/**
 * This class represents the actions for the rectangle tool.
 * 
 * @author Jonah Howard
 * @version 7 November 2015
 */
public final class RectangleAction extends AbstractTool implements Tool {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 2784159111198939204L;
    
    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;

    /**
     * Initializes a new rectangle tool.
     * 
     * @param thePanel the current Drawing Panel
     */
    public RectangleAction(final DrawingPanel thePanel) {
        super("Rectangle", false);
        putValue(Action.SELECTED_KEY, true);
        myPanel = thePanel;
    }

    /** {@inheritDoc}. */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(this);
    }
    
   /**
    * Draws a rectangle.
    * 
    * @param theInitialX the initial X coordinate
    * @param theInitialY the initial Y coordinate
    * @param theCurrentX the X coordinate that the mouse is currently on
    * @param theCurrentY the Y coordinate that the mouse is currently on
    * @return the rectangle based on the initial and current coordinates
    */
    @Override
    public Shape drawShape(final int theInitialX, final int theInitialY,
                          final int theCurrentX, final int theCurrentY) {
        int x1 = theInitialX;
        final int x2 = theCurrentX;
        int y1 = theInitialY;
        final int y2 = theCurrentY;
        int width = theCurrentX - theInitialX;
        int height = theCurrentY - theInitialY;
        // Check if user drags to the left of initial coordinates
        if (x1 > x2) {
            width = theInitialX - theCurrentX;
            x1 = x2;
        }
        if (y1 > y2) {
            height = theInitialY - theCurrentY;
            y1 = y2;
        }
        return new Rectangle2D.Double(x1, y1, width, height);
    }
}
