/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package view;

import actions.ColorAction;
import actions.ColorActionIcon;
import actions.DrawingPanel;
import actions.EllipseAction;
import actions.ExitAction;
import actions.FillBackground;
import actions.GridAction;
import actions.LineAction;
import actions.OpenAction;
import actions.PencilAction;
import actions.RectangleAction;
import actions.RedoAction;
import actions.ThicknessAction;
import actions.Tool;
import actions.UndoAction;
import actions.UndoAllAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * This class starts the GUI and sets up all of its components.
 * 
 * @author Jonah Howard
 * @version 9 November 2015
 */
public final class PowerPaintGUI {

    /** The current JFrame being used. */
    private final JFrame myFrame;
    
    /** Represents the drawing panel for the JFrame. */
    private DrawingPanel myPanel;
    
    /** Represents the menu bar. */
    private MenuBar myMenuBar;
    
    /** Represents the tool bar. */
    private ToolBar myToolBar;
    
    /** 
     * Initializes a new PowerPaintGUI and the JFrame.
     */
    public PowerPaintGUI() {
        myFrame = new JFrame("PowerPaint");
    }

    /**
     * Called by the main method. Starts the GUI and initializes the components.
     */
    private void start() {
        myFrame.setIconImage(new ImageIcon("./images/w.gif").getImage());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Toolkit kit = Toolkit.getDefaultToolkit();
        myPanel = new DrawingPanel();
        // Set location to center of monitor
        myFrame.setLocation(
                            (int) (kit.getScreenSize().getWidth() / 2
                            - ((int) myPanel.getPreferredSize().getWidth() / 2)),
                            (int) (kit.getScreenSize().getHeight() / 2
                            - ((int) myPanel.getPreferredSize().getHeight() / 2)));
        myMenuBar = new MenuBar();
        myToolBar = new ToolBar();
        setUpComponents();
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Sets up the JFrame by adding all of the components.
     */
    private void setUpComponents() {
        myFrame.setJMenuBar(myMenuBar.getMenuBar());
        myFrame.add(myToolBar, BorderLayout.SOUTH);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myPanel.setLayout(new BorderLayout());
        fillFileMenu();
        fillOptionsMenu();
        fillToolsMenu();
    }

    /**
     * Initializes and fills the file menu items to the file menu and add 
     * corresponding accelerators.
     */
    private void fillFileMenu() {
        final UndoAllAction undoAll = new UndoAllAction(myPanel);
        final ExitAction exit = new ExitAction(myFrame);
        final UndoAction undo = new UndoAction(myPanel);
        final RedoAction redo = new RedoAction(myPanel);
        final OpenAction open = new OpenAction();
        exit.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X); 
        undo.putValue(Action.SMALL_ICON, new ImageIcon("./images/undoicon.png"));
        redo.putValue(Action.SMALL_ICON, new ImageIcon("./images/redoicon.png"));
        // Set accelerators
        exit.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift Q"));
        undo.putValue(Action.ACCELERATOR_KEY,
                      KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        redo.putValue(Action.ACCELERATOR_KEY,
                      KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
        open.putValue(Action.ACCELERATOR_KEY, 
                      KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        undoAll.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control shift Z"));
        // Add property change listeners
        undo.addPropertyChangeListener(myPanel);
        myPanel.addPropertyChangeListener(undo);
        myPanel.addPropertyChangeListener(redo);
        myPanel.addPropertyChangeListener(undoAll);
        open.addPropertyChangeListener(myPanel);
        myMenuBar.createFileMenu(undoAll, exit, redo, undo, open);
    }

    /**
     * Fills the Options menu option and initializes all of the options and their respective
     * listeners.
     */
    private void fillOptionsMenu() {
        final GridAction grid = new GridAction(myPanel);
        final ColorAction colorAction = new ColorAction(myPanel);
        final FillBackground fillBackground = new FillBackground(myPanel);
        final ThicknessAction thicknessAction = new ThicknessAction(myPanel);
        colorAction.putValue(Action.SMALL_ICON, new ColorActionIcon(Color.BLACK));
        // Add property change listeners
        colorAction.addPropertyChangeListener(myPanel);
        myMenuBar.createOptionsMenu(thicknessAction, grid, colorAction, fillBackground);
    }
    
    /**
     * Fills the Tools menu and tool bar as well as initialize all of the tools.
     */
    private void fillToolsMenu() {
        final PencilAction pencil = new PencilAction(myPanel);
        final LineAction line = new LineAction(myPanel);
        final EllipseAction ellipse = new EllipseAction(myPanel);
        final RectangleAction rectangle = new RectangleAction(myPanel);
        // Set property change listeners
        pencil.addPropertyChangeListener(myPanel);
        line.addPropertyChangeListener(myPanel);
        ellipse.addPropertyChangeListener(myPanel);
        rectangle.addPropertyChangeListener(myPanel);
        final Tool[] tools = {pencil, line, ellipse, rectangle};
        for (final Tool tool: tools) {
            tool.putValue(Action.SMALL_ICON, new ImageIcon("./images/" 
                            + tool.toString() + "_bw.gif"));
            myMenuBar.createToolsMenuButtons(tool);
            myToolBar.createToolBarButton(tool);
        }
    }

    /**
     * Main method, starts the program.
     * 
     * @param theArgs Command line parameter (ignored)
     */
    public static void main(final String... theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI().start();
            }
        });
    }
}
