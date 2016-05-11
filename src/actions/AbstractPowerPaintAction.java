/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * The purpose of this class is to set the mnemonics for all of the buttons and to provide a 
 * customized toString() method.
 * 
 * @author Jonah Howard
 * @version 9 November 2015
 *
 */
public abstract class AbstractPowerPaintAction extends AbstractAction {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = 4479306340464719551L;
    
    /** The name of this action. */
    private final String myAction;
    
    /**
     * Initializes a new AbstractPowerPaintAction.
     * 
     * @param theAction the name of the action being initialized
     */
    public AbstractPowerPaintAction(final String theAction) {
        super(theAction);
        myAction = theAction;
        putValue(Action.MNEMONIC_KEY, (int) myAction.charAt(0));
    }
    
    /** {@inheritDoc}. */
    @Override
    public String toString() {
        return myAction;
    }
    
    /**
     * Sets the mnemonic for this tool.
     */
    public void createMnemonic() {
        putValue(Action.MNEMONIC_KEY, (int) myAction.charAt(0));
    }
}
