/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

/**
 * This class is extended by all tools for the purpose of determining the default tool.
 *
 * @author Jonah Howard
 * @version 15 November 2015
 */
public abstract class AbstractTool extends AbstractPowerPaintAction implements Tool {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 1496237522988502655L;
    
    /** true if this tool is the default tool for the program. */
    private final boolean myDefaultButton;
    
    /**
     * Initializes a new AbstractTool.
     * 
     * @param theName the name of this tool
     * @param theDefaultButton true if this tool is the default tool for the program
     */
    public AbstractTool(final String theName, final boolean theDefaultButton) {
        super(theName);
        myDefaultButton = theDefaultButton;
    }

    /**
     * Returns true if this tool is the default tool.
     * 
     * @return true if this tool is the default tool
     */
    public boolean isDefaultButton() {
        return myDefaultButton;
    }
}
