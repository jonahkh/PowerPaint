/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JColorChooser;

/**
 * This class represents the ColorAction and stores information regarding the current color.
 * Displays a JColorChooser when the color menu option is selected and then updates the 
 * current color being drawn for the shapes on the Drawing Panel.
 * 
 * @author Jonah Howard
 * @version 7 November 2015
 */
public class ColorAction extends AbstractPowerPaintAction {

    /** A generated serialization ID. */
    private static final long serialVersionUID = -60639139951306285L;
    
    /** The default color. */
    private static final Color DEFAULT_COLOR = Color.BLACK;
    
    /** The current color for PowerPaint. */
    private Color myCurrentColor;
    
    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;
    
    /** 
     * Initializes a new ColorAction.
     * 
     * @param thePanel the current Drawing Panel
     */
    public ColorAction(final DrawingPanel thePanel) {
        super("Color...");
        // Default Color
        myCurrentColor = DEFAULT_COLOR;
        myPanel = thePanel;
    }

    /** {@inheritDoc}. */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        // Opens a color chooser dialog
        myCurrentColor = JColorChooser.showDialog(null, "Select Current Color",
                                                  myCurrentColor);
        // Change icon to the new color
        putValue(Action.SMALL_ICON, new ColorActionIcon(myCurrentColor));
        myPanel.setCurrentColor(myCurrentColor);
    }
}
