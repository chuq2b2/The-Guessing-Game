/**
 * @author Steven Bogaerts
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.JOptionPane;

public class PersonaDisplay extends JPanel {

    private JLabel[][] imageJLabels;
    
    /**
     * Sets up the imagePanel and adds images to it.
     * panelDim is the length and width.
     */
    public PersonaDisplay(int panelDim, int numImages) {
        int gridNumRows = 0;
        int gridNumCols = 0;
        int imageDim = 0;
        
        // If NUM_IMAGES is a perfect square, display in a square
        double root = Math.sqrt(numImages);
        if (Math.floor(root) == root) {
            gridNumRows = (int) root;
            gridNumCols = (int) root;
            imageDim = panelDim / gridNumCols;
        }
        else if (numImages == 2) {
            gridNumRows = 2;
            gridNumCols = 1;
            imageDim = panelDim / gridNumCols / 2; // /2 so images aren't too wide
        }
        else {
            JOptionPane.showMessageDialog(this, "Unsupported number of images: " + numImages);
            System.exit(-1);
        }
        
        imageJLabels = new JLabel[gridNumRows][gridNumCols];
        this.setLayout(new GridLayout(gridNumRows, gridNumCols));
        int row, col;
        for(int i = 0; i < numImages; i++) {
            row = i / gridNumCols;
            col = i % gridNumCols;
            imageJLabels[row][col] = getImageLabel(i, imageDim);
            this.add(imageJLabels[row][col]);
        }
    }
    
    /**
     * Fetches the image and handles resizing based on imageDim.
     * Assumes the image is basically a square.
     */
    private JLabel getImageLabel(int id, int imageDim) {
        String num = id < 10 ? "0" + id : "" + id;
        
        // Some code from https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/f" + num + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Image resizedImage = img.getScaledInstance(imageDim, imageDim, Image.SCALE_SMOOTH);
        
        JLabel label = new JLabel(new ImageIcon(resizedImage));
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        return label;
    }
    
    public void hideImage(int row, int col) {
        imageJLabels[row][col].setVisible(false);
    }
    
}