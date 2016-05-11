/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;

import javax.swing.Action;

/**
 * This class represents the line tool.
 * 
 * @author Jonah Howard
 * @version 7 November 2015
 */
public final class LineAction extends AbstractTool implements Tool {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = 6298396962008673211L;
    
    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;
    
    /** 
     * Initializes a new line tool.
     * 
     * @param thePanel the current Drawing Panel
     */
    public LineAction(final DrawingPanel thePanel) {
        super("Line", false);
        putValue(Action.SELECTED_KEY, true);
        myPanel = thePanel;
    }
    
    /** {@inheritDoc}. */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(this);
    }
    
    /**
     * Draws a line from the initial coordinates to the current coordinates.
     * 
     * @param theInitialX the initial X coordinate
     * @param theInitialY the initial Y coordinate
     * @param theCurrentX the X coordinate that the mouse is currently on
     * @param theCurrentY the Y coordinate that the mouse is currently on
     * @return a line based on the passed coordinates
     */
    public Shape drawShape(final int theInitialX, final int theInitialY,
                          final int theCurrentX, final int theCurrentY) {
        return new Line2D.Double(theInitialX, theInitialY, theCurrentX, theCurrentY);
    }
}