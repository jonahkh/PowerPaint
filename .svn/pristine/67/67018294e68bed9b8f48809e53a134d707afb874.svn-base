/*
 * TCSS 305 
 * Assignment 4 - SnapShop
 */

package actions;

import image.PixelImage;

import java.awt.event.ActionEvent;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This class creates the action event for the open file menu option. An open dialog is shown
 * when the user selects the open option in the file menu. Press CTRL + O to open the open 
 * dialog. Note that the image is layered on top of all shapes.
 *
 * @author Jonah Howard
 * @version 15 November 2015
 */
public final class OpenAction extends AbstractPowerPaintAction {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -8943208499272078651L;
    
    /** The current file chooser for the drawing panel. */
    private final JFileChooser myFileChooser;
    
    /** The icon representing the image. */
    private final JLabel myImageLabel;
    
    /**
     * Initializes a new open action.
     */
    public OpenAction() {
        super("Open...");
        myFileChooser = new JFileChooser("./");
        myImageLabel = new JLabel(); 
    }
    
    /** {@inheritDoc}. */
    // Opens a file chooser and loads the drawing panel with the selected image
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        if (myFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                myImageLabel.setOpaque(false);
                final PixelImage image = PixelImage.load(myFileChooser.getSelectedFile());
                myImageLabel.setIcon(new ImageIcon(image));
                firePropertyChange("open image", null, myImageLabel);
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(null,
                                              "The selected file does not contain an image!",
                                              "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
