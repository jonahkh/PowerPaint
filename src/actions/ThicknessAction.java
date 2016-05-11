/*
 * TCSS 305 
 * Assignment 5 - PowerPaint
 */

package actions;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class represents the Thickness menu option.
 * 
 * @author Jonah Howard
 * @version 7 November 2015
 */
public final class ThicknessAction {
    
    /** The default thickness. */
    private static final int DEFAULT_THICKNESS = 1;
    
    /** The minor tick spacing. */
    private static final int MINOR_TICK_SPACING = 1;
    
    /** the major tick spacing. */
    private static final int MAJOR_TICK_SPACING = 5;
    
    /** The maximum thickness. */
    private static final int MAXIMUM_THICKNESS = 20;
    
    /** The minimum Thickness. */
    private static final int MINIMUM_THICKNESS = 0;
    
    /** The spacing length. */
    private static final int SPACING_LENGTH = 5;
    
    /** The JSlider for the Thickness sub menu. */
    private final JSlider mySlider;
    
    /** The current Drawing Panel. */
    private final DrawingPanel myPanel;
    
    /**
     * Initializes the Thickness menu option.
     * 
     * @param thePanel the current Drawing Panel
     */
    public ThicknessAction(final DrawingPanel thePanel) {
        mySlider = new JSlider(MINIMUM_THICKNESS, MAXIMUM_THICKNESS, SPACING_LENGTH);
        myPanel = thePanel;
    }
    
    /** 
     * Returns the current JSlider.
     * 
     * @return the current JSlider. 
     */
    public JSlider getSlider() {
        mySlider.setMinorTickSpacing(MINOR_TICK_SPACING);
        mySlider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        mySlider.setPaintLabels(true);
        mySlider.setPaintTicks(true);
        mySlider.setValue(DEFAULT_THICKNESS);
        mySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                myPanel.setThickness(mySlider.getValue());
            }
        });
        return mySlider;
    }
}
