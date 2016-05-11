/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import java.awt.Shape;

import javax.swing.Action;

/**
 * A very trivial interface to represent the tools for PowerPaint.
 * 
 * @author Jonah Howard
 * @version 9 November 2015
 */
public interface Tool extends Action {
    
    /** Draws a shape based on the passed coordinates.
     *  
     * @param theInitialX the initial X coordinate
     * @param theInitialY the initial Y coordinate
     * @param theCurrentX the X coordinate that the mouse is currently on
     * @param theCurrentY the Y coordinate that the mouse is currently on 
     * @return the shape created based on the coordinates
     */
    Shape drawShape(int theInitialX, int theInitialY,
                          int theCurrentX, int theCurrentY);
}
