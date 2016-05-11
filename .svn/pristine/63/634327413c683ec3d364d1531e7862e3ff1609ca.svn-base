/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.Action;

/**
 * This class represents the ellipse tool.
 * 
 * @author Jonah Howard
 * @version 7 November 2015
 */
public final class EllipseAction extends AbstractTool implements Tool {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -6609192105020138902L;
    
    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;
    /**
     * Initializes a new Ellipse Tool.
     * 
     * @param thePanel the current Drawing Panel
     */
    public EllipseAction(final DrawingPanel thePanel) {
        super("Ellipse", false);
        putValue(Action.SELECTED_KEY, true);
        myPanel = thePanel;
    }
    
    /**
     * Creates an ellipse shape.
     *  
     * @param theInitialX the initial X coordinate
     * @param theInitialY the initial Y coordinate
     * @param theCurrentX the X coordinate that the mouse is currently on
     * @param theCurrentY the Y coordinate that the mouse is currently on
     * @return the created ellipse based on the initial and current coordinates
     */
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
        return new Ellipse2D.Double(x1, y1, width, height);
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(this);
    }
}

