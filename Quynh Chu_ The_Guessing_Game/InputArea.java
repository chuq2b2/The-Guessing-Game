/**
 * @author Steven Bogaerts
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class InputArea extends JPanel implements ActionListener {
    
    private JLabel questionLabel;
    private JButton yesButton;
    private JButton noButton;
    private DTreeNode currNode;
    
    public InputArea(int height) {
        int strutSize = (int) (0.4*height);
        
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        
        content.add(Box.createVerticalStrut(strutSize));
        
        ////////////////////////////////////////////////////////
        // The question
        questionLabel = new JLabel("Question here");
        content.add(questionLabel, BorderLayout.PAGE_START);
        
        ////////////////////////////////////////////////////////
        // Yes button
        yesButton = new JButton("Yes");
        yesButton.setActionCommand("Yes");
        yesButton.addActionListener(this);
        
        content.add(yesButton, BorderLayout.LINE_START);
        
        ////////////////////////////////////////////////////////
        // No button
        noButton = new JButton("No  ");
        noButton.setActionCommand("No");
        noButton.addActionListener(this);
        
        content.add(noButton, BorderLayout.PAGE_END);
        
        ////////////////////////////////////////////////////////
        // Remaining layout work
        content.add(Box.createVerticalStrut(strutSize));
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(Box.createHorizontalStrut(strutSize));
        this.add(content);
        this.add(Box.createHorizontalStrut(strutSize));
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Yes")) {
            // Yes button was hit
            // JOptionPane.showMessageDialog(this, "Yes was hit on question: " + questionLabel.getText());
            this.update(currNode.getNodeForYes());
        }
        else {
            // No button was hit
            // JOptionPane.showMessageDialog(this, "No was hit on question: " + questionLabel.getText());
            this.update(currNode.getNodeForNo());
        }
    }
    
    public void update(DTreeNode node) {
        this.currNode = node;
        questionLabel.setText(currNode.getText());
        
        if (currNode.getIsAnswer()) {
            yesButton.setVisible(false);
            noButton.setVisible(false);
        }
    }
    
}
