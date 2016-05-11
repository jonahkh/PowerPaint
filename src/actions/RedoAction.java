/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.event.ActionEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class represents the redo button in the file menu. Enabled after the user has 
 * selected the undo menu option and is disabled if there are no more shapes to redraw.
 * Redo is disabled if the user chooses to undo all. Press CTRL + Y to redo.
 *
 * @author Jonah Howard
 * @version 15 November 2015
 */
public final class RedoAction extends AbstractPowerPaintAction 
                              implements PropertyChangeListener {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 4713457149042276298L;

    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;
    /**
     * Initializes the redo button.
     * 
     * @param thePanel the current Drawing Panel
     */
    public RedoAction(final DrawingPanel thePanel) {
        super("Redo");
        setEnabled(false);
        myPanel = thePanel;
    }

    /** {@inheritDoc}. */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.redo();
    }

    /** {@inheritDoc}. */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("enable redo".equals(theEvent.getPropertyName())) {
            setEnabled((boolean) theEvent.getNewValue());
        }
    }
}
