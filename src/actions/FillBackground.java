/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.event.ActionEvent;

/**
 * This class creates the action listener for the fill background option. When pressed, 
 * the background is set to the current color. Note that filling the background is final
 * and cannot be undone.
 *
 * @author Jonah Howard
 * @version 15 November 2015
 */
public final class FillBackground extends AbstractPowerPaintAction {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 453572604679506097L;
    
    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;

    /**
     * Initializes a new FIllBackground.
     * 
     * @param thePanel the current Drawing Panel
     */
    public FillBackground(final DrawingPanel thePanel) {
        super("Fill Background");
        myPanel = thePanel;
    }

    /**
     * Sets the background to the current color.
     * 
     * @param theEvent represents when an action is performed on the fill bucket button
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.fillBackground();
    }
}
