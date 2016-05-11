/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class represents the Undo All action. Clears the panel of all drawn shapes.
 * It does not reset the background color.
 *
 * @author Jonah Howard
 * @version 10 November 2015
 */
public final class UndoAllAction extends AbstractPowerPaintAction 
                                 implements PropertyChangeListener {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 8975159206920409820L;

    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;
    
    /**
     * Initializes a new Undo All action. 
     * 
     * @param thePanel the current Drawing Panel
     */
    public UndoAllAction(final DrawingPanel thePanel) {
        super("Undo All Changes");
        setEnabled(false);
        myPanel = thePanel;
    }
    
    /** {@inheritDoc}. */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("enable undo all".equals(theEvent.getPropertyName())) {
            setEnabled((boolean) theEvent.getNewValue());
        }
    }

    /** {@inheritDoc}. */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.undoAll();
        setEnabled(false);
    }
}
