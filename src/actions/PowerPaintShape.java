/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.Color;
import java.awt.Shape;

/**
 * This class represents each shape that is drawn on the drawing panel. The shape's color,
 * thickness, and type are saved.
 *
 * @author Jonah Howard
 * @version 9 November 2015
 */
public class PowerPaintShape {

    /** The color of this shape. */
    private final Color myColor;
    
    /** The thickness of this shape. */
    private final int myThickness;
    
    /** The current shape. */
    private final Shape myShape;

    /**
     * Initializes a new PowerPaintShape.
     * 
     * @param theShape the current shape
     * @param theThickness the current thickness
     * @param theColor the current color
     */
    public PowerPaintShape(final Shape theShape, final int theThickness,
                           final Color theColor) {
        myColor = theColor;
        myThickness = theThickness;
        myShape = theShape;
    }
    
    /**
     * returns this shape.
     * 
     * @return this shape
     */
    protected Shape getShape() {
        return myShape;
    }
    
    /**
     * returns the thickness.
     * 
     * @return the thickness
     */
    protected int getThickness() {
        return myThickness;
    }
    
    /**
     * returns the color.
     * 
     * @return the color
     */
    protected Color getColor() {
        return myColor;
    }    
}
