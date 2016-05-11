package actions;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

/**
 * This class creates the action events for the Exit button in the menu. To exit the program
 * press CTRL + SHIFT + Q to quit.
 *
 * @author Jonah Howard
 * @version 11 November 2015
 */
public final class ExitAction extends AbstractPowerPaintAction {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -450620152500745345L;

    /** Represents the current JFrame. */
    private final JFrame myFrame;
    
    /**
     * Initialize a new exit action.
     * 
     * @param theFrame the current JFrame
     */
    public ExitAction(final JFrame theFrame) {
        super("Exit");
        myFrame = theFrame;
    }
    
    /** {@inheritDoc}. */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myFrame.dispose();
    }
}