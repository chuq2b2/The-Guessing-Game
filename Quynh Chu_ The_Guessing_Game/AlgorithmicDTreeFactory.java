/**
 * @author Steven Bogaerts
 */

import java.util.LinkedList;
import java.util.Random;

public class AlgorithmicDTreeFactory {
    
    private int seed;
    private Random rng;
    private boolean chooseRandomly;
    
    public AlgorithmicDTreeFactory() {
        this.seed = 100;
        this.rng = new Random(seed);
        this.chooseRandomly = false;
    }
    
    public void setSeed(int seed) {
        this.seed = seed;
        this.rng = new Random(seed);
    }
    
    public void setChooseRandomly(boolean chooseRandomly) {
        this.chooseRandomly = chooseRandomly;
    }
    
    public DTreeNode build9PersonaTree() {
        LinkedList<Persona> personas = new LinkedList<Persona>();
        //                                              tie     armUp   clothes eating  horn    belt    walks   animal
        personas.add(new Persona(0, "Bear",             false,  false,  true,   false,  false,  false,  true,   true));
        personas.add(new Persona(1, "Tiger",            true,   false,  true,   false,  false,  true,   true,   true));
        personas.add(new Persona(2, "Unicorn",          false,  true,   false,  false,  true,   false,  true,   true));
        personas.add(new Persona(3, "Dog",              false,  false,  false,  false,  false,  false,  true,   true));
        personas.add(new Persona(4, "Fox",              true,   true,   true,   false,  false,  true,   true,   true));
        personas.add(new Persona(5, "Lion",             true,   true,   true,   false,  false,  false,  true,   true));
        personas.add(new Persona(6, "Panda",            false,  false,  false,  true,   false,  false,  true,   true));
        personas.add(new Persona(7, "Parrot",           false,  false,  false,  false,  false,  false,  false,  true));
        personas.add(new Persona(8, "Shark",            true,   true,   true,   false,  false,  true,   false,  true));
        
        return makeTree(personas);
    }
    
    private DTreeNode makeTree(LinkedList<Persona> personas) {
        LinkedList<String> attributes = new LinkedList<String>();
        attributes.add("tie");
        attributes.add("armup");
        attributes.add("clothes");
        attributes.add("eating");
        attributes.add("horn");
        attributes.add("belt");
        attributes.add("walks");
        attributes.add("animal");
        
        return makeTreeRec(personas, attributes);
    }
    
    private DTreeNode makeTreeRec(LinkedList<Persona> personas, LinkedList<String> attributes) {
        if (personas.size() == 0) {
            // throw new RuntimeException("Unknown node!");
            return new DTreeNode("unknown", true); // if we get to a leaf that doesn't correspond to any persona
        }
        //else if all the same class // should never happen, since each character name is different
        // else if A is empty // should never happen, since the dataset contains enough attributes to identify everyone
        else if (personas.size() == 1) {
            return new DTreeNode(personas.get(0).getName(), true);
        }
        else {
            String nextAttr = chooseNextAttribute(personas, attributes);
            attributes.remove(nextAttr);
            LinkedList<String> remAttributes1 = attributes;
            LinkedList<String> remAttributes2 = (LinkedList<String>) attributes.clone();
            
            LinkedList falsePersonas = new LinkedList<Persona>();
            LinkedList truePersonas = new LinkedList<Persona>();
            splitPersonas(personas, nextAttr, falsePersonas, truePersonas);
            
            DTreeNode root = new DTreeNode(nextAttr, false);
            root.setNodeForNo(makeTreeRec(falsePersonas, remAttributes1));
            root.setNodeForYes(makeTreeRec(truePersonas, remAttributes2));
            
            return root;
        }
    }
    
    private String chooseNextAttribute(LinkedList<Persona> personas, LinkedList<String> attributes) {
        if (chooseRandomly)
            return chooseRandomAttribute(personas, attributes);
        else
            return chooseBestAttribute(personas, attributes);
    }
    
    private String chooseRandomAttribute(LinkedList<Persona> personas, LinkedList<String> attributes) {
        int attrID = rng.nextInt(attributes.size());
        return attributes.get(attrID);
    }
    
    private String chooseBestAttribute(LinkedList<Persona> personas, LinkedList<String> attributes) {
        double allEnt = calcEntropy(personas);
        double currGain;
        
        String maxAttr = attributes.get(0);
        double maxGain = rateAttribute(personas, maxAttr, allEnt);
        
        // System.out.println("==============================");
        for(String currAttr: attributes) { // technically looks at element 0 again...
            currGain = rateAttribute(personas, currAttr, allEnt);
            // System.out.println(currAttr + " has gain: " + currGain);
            if (currGain > maxGain) {
                maxGain = currGain;
                maxAttr = currAttr;
            }
        }
        
        // System.out.println("Choose attr " + maxAttr);
        return maxAttr;
    }
    
    private double rateAttribute(LinkedList<Persona> personas, String attr, double allEnt) {
        // Instead of actual information gain, just look at proportions, choose the one with the most balanced proportion (closest to 1).

        LinkedList<Persona> falsePersonas = new LinkedList<Persona>();
        LinkedList<Persona> truePersonas = new LinkedList<Persona>();
        
        splitPersonas(personas, attr, falsePersonas, truePersonas);
        if ((falsePersonas.size() == 0) || (truePersonas.size() == 0))
            return 0;
        else
            return personas.size() - Math.abs(falsePersonas.size() - truePersonas.size());
    }
    
    private void splitPersonas(LinkedList<Persona> personas, String attr, LinkedList<Persona> falsePersonas, LinkedList<Persona> truePersonas) {
        boolean val;
        for(int i = 0; i < personas.size(); i++) {
            val = personas.get(i).getValue(attr);
            if (!val)
                falsePersonas.add(personas.get(i));
            else
                truePersonas.add(personas.get(i));
        }
    }
    
    private double calcEntropy(LinkedList<Persona> personas) {
        int n = personas.size();
        if (n == 0)
            return 0;
        else
            return n * ((-1.0 / n) * log2(1.0 / n));
    }
    
    private double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

}
