/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class represents the undo button in the file menu. Undo is disabled unless there are
 * shapes on the drawing panel. Pressing the undo button will remove the most recent shape.
 * Press CTRL + SHIFT + Z to undo all.
 *
 * @author Jonah Howard
 * @version 15 November 2015
 */
public final class UndoAction extends AbstractPowerPaintAction 
                              implements PropertyChangeListener {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 647939540844275889L;

    /** Represents the current Drawing Panel. */
    private final DrawingPanel myPanel;
    
    /**
     * Initializes the undo button.
     * 
     * @param thePanel the current Drawing Panel
     */
    public UndoAction(final DrawingPanel thePanel) {
        super("Undo");
        setEnabled(false);
        myPanel = thePanel;
    }

    /** {@inheritDoc}. */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.undo();
    }

    /** {@inheritDoc}. */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("enable undo".equals(theEvent.getPropertyName())) {
            setEnabled((boolean) theEvent.getNewValue());
        }
    }
}