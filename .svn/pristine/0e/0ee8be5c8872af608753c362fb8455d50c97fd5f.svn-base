/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.Path2D;

import javax.swing.Action;

/**
 * This class represents a pencil tool.
 * 
 * @author Jonah Howard
 * @version 9 November 2015
 */
public final class PencilAction extends AbstractTool implements Tool {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -4536767261208964397L;
    
    /** The current path for the pencil. */
    private final Path2D.Double myPath;
    
    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;
    
    /** Tracks if the initial X coordinate has changed. */
    private int myPrevX;
    
    /** Tracks if the initial Y coordinate has changed. */
    private int myPrevY;
    
    /**
     * Initializes a new Pencil tool.
     * 
     * @param thePanel the current Drawing Panel
     */
    public PencilAction(final DrawingPanel thePanel) {
        super("Pencil", true);
        putValue(Action.SELECTED_KEY, true);
        myPath = new Path2D.Double();
        myPanel = thePanel;
    }

    /** {@inheritDoc}. */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setCurrentTool(this);
    }

    /**
     * Draws the Pencil tool. A path is drawn from the initial coordinates to the current
     * coordinates.
     * 
     * @param theInitialX the initial X coordinate
     * @param theInitialY the initial Y coordinate
     * @param theCurrentX the X coordinate that the mouse is currently on
     * @param theCurrentY the Y coordinate that the mouse is currently on
     * @return the created path based on the initial and current coordinates
     */
    @Override
    public Shape drawShape(final int theInitialX, final int theInitialY,
                           final int theCurrentX, final int theCurrentY) {
        if (myPrevX != theInitialX && myPrevY != theInitialY) {
            myPath.reset();
        }
        if (myPath.getCurrentPoint() == null) {
            myPath.moveTo(theInitialX, theInitialY);
            myPrevX = theInitialX;
            myPrevY = theInitialY;
        } else {
            myPath.quadTo(myPath.getCurrentPoint().getX(), myPath.getCurrentPoint().getY(),
                         (double) theCurrentX, (double) theCurrentY);
            myPath.moveTo(theCurrentX, theCurrentY);
        }
        return (Path2D.Double) myPath.clone();
    }
}
