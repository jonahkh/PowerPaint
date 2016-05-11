/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package view;

import actions.AbstractTool;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * This class creates the Tool Bar and fills its components.
 * 
 * @author Jonah Howard
 * @version 10 November 2015
 *
 */
public final class ToolBar extends JToolBar {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 7280568427508955229L;
    
    /** Represents the group of buttons. */
    private final ButtonGroup myGroup;
    
    /**
     * Initializes the Tool Bar.
     */
    public ToolBar() {
        super();
        myGroup = new ButtonGroup();
    }

    /**
     * Creates the tool bar buttons.
     * 
     * @param theAction The current action to attach to a button
     */
    protected void createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        myGroup.add(toggleButton);
        add(toggleButton);
        // Check for the default button
        if (((AbstractTool) theAction).isDefaultButton()) {
            toggleButton.doClick();
            toggleButton.setEnabled(true);
        }
    }
}
