/**
 * @author Steven Bogaerts
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Driver extends JFrame {
    
    // public static final int NUM_IMAGES = 9; // 2, 4, or 9

    public static final int CHAR_DISPLAY_DIM = 500; // width and height of character display area
    
    public static void playWithVeryGoodTree() {
        Driver d = new Driver();
        InputArea inputArea = d.setUpGUI(9);
        d.playWithVeryGoodTree(inputArea);
    }
    
    public static void playWithHardcodedTree(int numPersonas) {
        if (!((numPersonas == 2) || (numPersonas == 4) || (numPersonas == 9))) {
            JOptionPane.showMessageDialog(new JFrame(), "numPersonas must be 2, 4, or 9, but you entered " + numPersonas + ".");
            System.exit(-1);
        }
        
        Driver d = new Driver();
        InputArea inputArea = d.setUpGUI(numPersonas);
        d.playWithHardcodedTree(inputArea, numPersonas);
    }
    
    private InputArea setUpGUI(int numImages) {
        setLayout(new GridLayout(1, 2));
        
        ////////////////////////////////////////////////////////////
        // Set up character display
        setSize(CHAR_DISPLAY_DIM * 2, CHAR_DISPLAY_DIM);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PersonaDisplay personaDisplay = new PersonaDisplay(CHAR_DISPLAY_DIM, numImages);
        add(personaDisplay);
        
        ////////////////////////////////////////////////////////////
        // Set up input area
        InputArea inputArea = new InputArea(CHAR_DISPLAY_DIM);
        add(inputArea);
        
        return inputArea;
    }
    
    private void playWithHardcodedTree(InputArea inputArea, int numImages) {
        setVisible(true);
        
        HardcodedDTreeFactory factory = new HardcodedDTreeFactory();
        DTreeNode root = makeTree(factory, numImages);
        
        System.out.println(root);
        inputArea.update(root);
    }
    
    private DTreeNode makeTree(HardcodedDTreeFactory factory, int numPersonas) {
        if (numPersonas == 9)
            return factory.hardcode9PersonaTree();
        else if (numPersonas == 4)
            return factory.hardcode4PersonaTree();
        else if (numPersonas == 2)
            return factory.hardcode2PersonaTree();
        
        return null;
    }
    
    private void playWithVeryGoodTree(InputArea inputArea) {
        setVisible(true);
        
        AlgorithmicDTreeFactory factory = new AlgorithmicDTreeFactory();
        factory.setChooseRandomly(false);
        DTreeNode root = factory.build9PersonaTree();
        
        System.out.println(root);
        System.out.println("Average number of questions: " + root.getAverageNumQuestions());
        inputArea.update(root);
    }
    
}
