/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package view;

import actions.AboutAction;
import actions.AbstractTool;
import actions.ColorAction;
import actions.ExitAction;
import actions.FillBackground;
import actions.GridAction;
import actions.OpenAction;
import actions.RedoAction;
import actions.ThicknessAction;
import actions.Tool;
import actions.UndoAction;
import actions.UndoAllAction;

import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

/**
 * This class creates the menu bar and adds all of its components.
 * 
 * @author Jonah Howard
 * @version 5 November 2015
 *
 */
public final class MenuBar {

    /** The current menu bar. */
    private final JMenuBar myMenuBar;
    
    /** The current button group. */
    private final ButtonGroup myGroup;
    
    /** The menu for the tools. */
    private final JMenu myToolsMenu;
    
    /** The menu for the options. */
    private final JMenu myOptionsMenu;
    
    /** The menu for the file options. */
    private final JMenu myFileMenu;
    
    /**
     * Initializes a new MenuBar.
     */
    public MenuBar() {
        myMenuBar = new JMenuBar();
        myToolsMenu = new JMenu("Tools");
        myOptionsMenu = new JMenu("Options");
        myFileMenu = new JMenu("File");
        myGroup = new ButtonGroup();
        createMenuBar();
    }
    
    /**
     * Returns the menu bar.
     * 
     * @return the menu bar
     */
    protected JMenuBar getMenuBar() {
        return myMenuBar;
    }
    
    /** Adds all of the components to the menu bar. */
    private void createMenuBar() {
        myToolsMenu.setMnemonic(KeyEvent.VK_T);
        myOptionsMenu.setMnemonic(KeyEvent.VK_O);
        myMenuBar.add(myFileMenu);
        myMenuBar.add(myOptionsMenu);
        myMenuBar.add(myToolsMenu);
        myMenuBar.add(createHelpMenu());
    }
    
    /**
     * Creates the file menu.
     * 
     * @param theUndoAllAction represents the undo all action
     * @param theExitAction represents the exit action
     * @param theRedoAction represents the redo action
     * @param theUndoAction represents the undo action
     * @param theOpenAction represents the open action
     */
    protected void createFileMenu(final UndoAllAction theUndoAllAction,
                               final ExitAction theExitAction,
                               final RedoAction theRedoAction,
                               final UndoAction theUndoAction,
                               final OpenAction theOpenAction) {
        myFileMenu.setMnemonic(KeyEvent.VK_F);
        myFileMenu.add(theUndoAllAction);
        myFileMenu.addSeparator();
        myFileMenu.add(theUndoAction);
        myFileMenu.add(theRedoAction);
        myFileMenu.addSeparator();
        myFileMenu.add(theOpenAction);
        myFileMenu.addSeparator();
        myFileMenu.add(theExitAction);
    }
    
    /** 
     * Creates the options menu.
     * 
     * @param theThicknessAction the thickness action listener
     * @param theGridAction the grid action listener
     * @param theColorAction the color listener
     * @param theFillBackgroundAction the fill background listener
     */
    protected void createOptionsMenu(final ThicknessAction theThicknessAction,
                                    final GridAction theGridAction,
                                    final ColorAction theColorAction,
                                    final FillBackground theFillBackgroundAction) {
        myOptionsMenu.setMnemonic(KeyEvent.VK_O);
        final JCheckBoxMenuItem grid = new JCheckBoxMenuItem("Grid");
        final JMenu submenu = new JMenu("Thickness");
        submenu.setMnemonic(KeyEvent.VK_T);
        submenu.add(theThicknessAction.getSlider());
        grid.addActionListener(theGridAction);
        grid.setMnemonic(KeyEvent.VK_G);
        // Add all components
        myOptionsMenu.add(grid);
        myOptionsMenu.add(theFillBackgroundAction);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(submenu);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(theColorAction);
    }
    
    /**
     * Creates the help menu.
     * 
     * @return the help menu
     */
    private JMenu createHelpMenu() {
        final JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.add(new AboutAction());
        return helpMenu;
    }
    
    /** 
     * Adds all of the tools to the tools menu.
     * 
     * @param theTool the current tool being attached to a button
     */
    protected void createToolsMenuButtons(final Tool theTool) {
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theTool);
        if (((AbstractTool) theTool).isDefaultButton()) {
            createdButton.doClick();
        }
        myGroup.add(createdButton);
        myToolsMenu.add(createdButton);
    }
}