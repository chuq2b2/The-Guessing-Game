/**
 * @author Steven Bogaerts (starter code)
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HardcodedDTreeFactory {

    public static void main(String[] args) {
        HardcodedDTreeFactory factory = new HardcodedDTreeFactory();
        
        System.out.println("--------------------------");
        DTreeNode tree2 = factory.hardcode2PersonaTree();
        System.out.println("2-persona tree:\n" + tree2);
        
        System.out.println("--------------------------");
        DTreeNode tree4 = factory.hardcode4PersonaTree();
        System.out.println("4-persona tree:\n" + tree4);
        
        System.out.println("--------------------------");
        DTreeNode tree9 = factory.hardcode9PersonaTree();
        System.out.println("9-persona tree:\n" + tree9);
    }
    
    public DTreeNode hardcode2PersonaTree() {
    
        DTreeNode tie = new DTreeNode("tie", false);
        DTreeNode bear = new DTreeNode("Bear", true);
        DTreeNode tiger = new DTreeNode("Tiger", true);
        tie.setNodeForNo(bear);
        tie.setNodeForYes(tiger);
        
        return tie;
    }
    
    public DTreeNode hardcode4PersonaTree(){
        DTreeNode clothes = new DTreeNode("Clothes", false);
        DTreeNode armUp = new DTreeNode("ArmUp", false);
        DTreeNode tie = new DTreeNode("Tie", false);
        
        DTreeNode dog = new DTreeNode("Dog", true);
        DTreeNode unicorn = new DTreeNode("Unicorn", true);
        DTreeNode bear = new DTreeNode("Bear", true);
        DTreeNode tiger = new DTreeNode("Tiger", true);
        
        clothes.setNodeForNo(armUp);
        clothes.setNodeForYes(tie);
        armUp.setNodeForNo(dog);
        armUp.setNodeForYes(unicorn);
        tie.setNodeForNo(bear);
        tie.setNodeForYes(tiger);
        return clothes;
    }
    public DTreeNode hardcode9PersonaTree(){
        DTreeNode belt = new DTreeNode("Belt", false);
        DTreeNode clothes = new DTreeNode("Clothes", false);
        DTreeNode armUp = new DTreeNode("ArmUp", false);
        DTreeNode tie1 = new DTreeNode("Tie", false);
        DTreeNode tie2 = new DTreeNode("Tie", false);
        DTreeNode eating = new DTreeNode("Eating", false);
        DTreeNode walks1 = new DTreeNode("Walks", false);
        DTreeNode walks2 = new DTreeNode("Walks", false);
        
        DTreeNode dog = new DTreeNode("Dog", true);
        DTreeNode unicorn = new DTreeNode("Unicorn", true);
        DTreeNode bear = new DTreeNode("Bear", true);
        DTreeNode tiger = new DTreeNode("Tiger", true);
        DTreeNode parrot = new DTreeNode("Parrot", true);
        DTreeNode panda = new DTreeNode("Panda", true);
        DTreeNode lion = new DTreeNode("Lion", true);
        DTreeNode shark = new DTreeNode("Shark", true);
        DTreeNode fox = new DTreeNode("Fox", true);
        armUp.setNodeForNo(clothes);
        armUp.setNodeForYes(belt);
        clothes.setNodeForNo(eating);
        clothes.setNodeForYes(tie1);
        belt.setNodeForNo(tie2);
        belt.setNodeForYes(walks1);
        eating.setNodeForNo(walks2);
        eating.setNodeForYes(panda);
        walks2.setNodeForNo(parrot);
        walks2.setNodeForYes(dog);
        tie1.setNodeForNo(bear);
        tie1.setNodeForYes(tiger);
        tie2.setNodeForNo(unicorn);
        tie2.setNodeForYes(lion);
        walks1.setNodeForNo(shark);
        walks1.setNodeForYes(fox);
        return armUp;
    }

    /*
     When you print your hardcoded trees, you should get:
     
        --------------------------
        2-persona tree:
        tie?
        No tie:
            Bear
        Yes tie:
            Tiger
        --------------------------
        4-persona tree:
        clothes?
        No clothes: 
            armUp?
            No armUp:
                Dog
            Yes armUp:
                Unicorn
        Yes clothes:
            tie?
            No tie:
                Bear
            Yes tie:
                Tiger
        --------------------------
        9-persona tree:
        armUp?
        No armUp:
            clothes?
            No clothes:
                eating?
                No eating:
                    walks?
                    No walks:
                        Parrot
                    Yes walks:
                        Dog
                Yes eating:
                    Panda
            Yes clothes:
                tie?
                No tie:
                    Bear
                Yes tie:
                    Tiger
        Yes armUp:
            belt?
            No belt:
                tie?
                No tie:
                    Unicorn
                Yes tie:
                    Lion
            Yes belt:
                walks?
                No walks:
                    Shark
                Yes walks:
                    Fox
     */
    
}
