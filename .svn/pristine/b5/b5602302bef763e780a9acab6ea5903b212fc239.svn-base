/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * This class creates the drawing panel that all of the shapes will be drawn on. Shapes are
 * only drawn if the current thickness is greater than one.
 * 
 * @author Jonah Howard
 * @version 7 November 2015
 */
public final class DrawingPanel extends JPanel implements PropertyChangeListener {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 6952941747989916966L;

    /** The preferred size of the drawing panel. */
    private static final Dimension DEFAULT_SIZE = new Dimension(400, 200);
    
    /** Refers to the undo property change event name. */
    private static final String UNDO_EVENT = "enable undo";
    
    /** Refers to the redo property change event name. */
    private static final String REDO_EVENT = "enable redo";
    
    /** The default color. */
    private static final Color DEFAULT_COLOR = Color.BLACK;
    
    /** The default Background color. */
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    
    /** Refers to the undo all property change event. */
    private static final String UNDO_ALL_EVENT = "enable undo all";

    /** The initial X coordinate of the mouse when pressed. */
    private int myInitialX;

    /** The initial Y coordinate of the mouse when pressed. */
    private int myInitialY;

    /** The current X coordinate of the mouse. */
    private int myCurrentX;

    /** The current Y coordinate of the mouse. */
    private int myCurrentY;

    /** Tracks if the mouse is being dragged. */
    private boolean myIsDragged;

    /** The current tool being used. */
    private Tool myCurrentTool;
    
    /** A list containing all of the states of the drawing panel. */
    private final List<PowerPaintShape> myShapes;
    
    /** Holds the shapes that have been created for the undo button. */
    private final Deque<PowerPaintShape> myUndoStack;

    /** Holds the shapes that have been deleted from the undo button. */
    private final Deque<PowerPaintShape> myRedoStack;
    
    /** Set the current thickness. */
    private int myCurrentThickness;
    
    /** Set the current color. */
    private Color myCurrentColor;
    

    /**
     * Initializes the drawing panel, the mouse listener, and the tools.
     */
    public DrawingPanel() {
        super();
        myShapes = new ArrayList<PowerPaintShape>();
        myIsDragged = false;
        myCurrentThickness = 1; // Default thickness
        myCurrentColor = DEFAULT_COLOR;
        myUndoStack = new ArrayDeque<PowerPaintShape>();
        myRedoStack = new ArrayDeque<PowerPaintShape>();
        setUpComponents();
    }
    
    /**
     * Sets up the JPanel and the MouseAdapter.
     */
    private void setUpComponents() {
        addPropertyChangeListener(this);
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        setPreferredSize(DEFAULT_SIZE);
        setSize(DEFAULT_SIZE);
        setBackground(DEFAULT_BACKGROUND_COLOR);
        final MouseAdapter listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
    
    /** {@inheritDoc}. */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("color".equals(theEvent.getPropertyName())) {
            myCurrentColor = (Color) theEvent.getNewValue();
        } else if ("open image".equals(theEvent.getPropertyName())) {
            add((JLabel) theEvent.getNewValue());
            validate();
        }
        repaint();
    }
    
    /**
     * Sets the current thickness to the passed value.
     * 
     * @param theThickness the new thickness
     */
    protected void setThickness(final int theThickness) {
        myCurrentThickness = theThickness;
    }
    
    /**
     * Sets the current tool to the passed tool. 
     * 
     * @param theTool the current tool
     */
    protected void setCurrentTool(final Tool theTool) {
        myCurrentTool = theTool;
    }
    
    /**
     * Fills the background to the current color.
     */
    protected void fillBackground() {
        setBackground(myCurrentColor);
    }
    
    /**
     * Set the current color to the passed color.
     * 
     * @param theColor the current color
     */
    protected void setCurrentColor(final Color theColor) {
        myCurrentColor = theColor;
    }
    
    /**
     * Removes all shapes from the drawing panel and disables the undo and redo menu options.
     */
    protected void undoAll() {
        myShapes.clear();
        myUndoStack.clear();
        myRedoStack.clear();
        firePropertyChange(UNDO_EVENT, null, false);
        firePropertyChange(REDO_EVENT, null, false);
    }
    
    /**
     * Removes the most recently drawn shape.
     */
    protected void undo() {
        // Enable redo menu option if necessary
        if (myRedoStack.isEmpty()) {
            firePropertyChange(REDO_EVENT, null, true);
        }
        myRedoStack.push(myUndoStack.pop());
        myShapes.remove(myShapes.size() - 1);
        // Disable undo menu option if necessary 
        if (myUndoStack.isEmpty()) {
            firePropertyChange(UNDO_EVENT, null, false);
            firePropertyChange(UNDO_ALL_EVENT, null, false);
        }
        repaint();
    }
    
    /**
     * Redraws the most recently removed shape.
     */
    protected void redo() {
        myShapes.add(myRedoStack.peek());
        // Enable undo menu option if necessary
        if (myUndoStack.isEmpty()) {
            firePropertyChange(UNDO_EVENT, null, true);
            firePropertyChange(UNDO_ALL_EVENT, null, true);
        }
        myUndoStack.push(myRedoStack.pop());
        // Disable redo menu option if necessary
        if (myRedoStack.isEmpty()) {
            firePropertyChange(REDO_EVENT, null, false);
        }
        repaint();
    }
    
    /** {@inheritDoc} */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
        // Redraw all previous shapes
        for (final PowerPaintShape shape : myShapes) {
            g2d.setStroke(new BasicStroke(shape.getThickness(),
                                          BasicStroke.CAP_ROUND,
                                          BasicStroke.JOIN_ROUND));
            g2d.setColor(shape.getColor());
            g2d.draw(shape.getShape());
        }
        // Draw the current shape being drawn/dragged
        if (myIsDragged && myCurrentThickness > 0) {
            g2d.setStroke(new BasicStroke(myCurrentThickness,
                                          BasicStroke.CAP_ROUND,
                                          BasicStroke.JOIN_ROUND));
            g2d.setColor(myCurrentColor);
            g2d.draw(myCurrentTool.drawShape(myInitialX, myInitialY, 
                                                    myCurrentX, myCurrentY));
        }
    }

    /** {@inheritDoc}. */
    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            // Initialize coordinates to the current mouse location
            myInitialX = theEvent.getX();
            myInitialY = theEvent.getY();
            myCurrentX = theEvent.getX();
            myCurrentY = theEvent.getY();
        }

        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            // Update current coordinates to the current mouse location
            myCurrentX = theEvent.getX();
            myCurrentY = theEvent.getY();
            myIsDragged = true;
            repaint();
        }

        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            myCurrentY = theEvent.getY();
            myCurrentX = theEvent.getX();
            // Only save shapes with thickness > 0
            if (myCurrentThickness > 0) {
                final PowerPaintShape shape = new PowerPaintShape(myCurrentTool.drawShape(
                                                            myInitialX, myInitialY, 
                                                            myCurrentX, myCurrentY),
                                                            myCurrentThickness,
                                                            myCurrentColor);
                myShapes.add(shape);
                // Update undo stack
                if (myUndoStack.isEmpty()) {
                    firePropertyChange(UNDO_EVENT, null, true);
                    firePropertyChange(UNDO_ALL_EVENT, null, true);
                }
                myUndoStack.push(shape);
                // Update redo stack
                if (!myRedoStack.isEmpty()) {
                    myRedoStack.clear();
                    firePropertyChange(REDO_EVENT, null, false);
                }
                firePropertyChange("enable save", false, true);
            }
            repaint();
            myIsDragged = false;
        }
    }
}
