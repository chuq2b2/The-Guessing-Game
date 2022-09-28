/**
 * @author Steven Bogaerts (starter code)
 */

public class DTreeNode {

    private String text;
    private boolean isAnswer;
    private DTreeNode nodeForNo;
    private DTreeNode nodeForYes;
    public DTreeNode(String text, boolean isAnswer, DTreeNode nodeForNo, DTreeNode nodeForYes)
    {
        this.text = text;
        this.isAnswer = isAnswer;
        this.nodeForNo = nodeForNo;
        this.nodeForYes = nodeForYes;
    }
    public DTreeNode(String text, boolean isAnswer)
    {
        this.text = text;
        this.isAnswer = isAnswer;
        nodeForNo = null;
        nodeForYes = null;
    }
    public String getText()
    {
        return text;
    }
    public boolean getIsAnswer()
    {
        return isAnswer;
    }
    public DTreeNode getNodeForNo()
    {
        return nodeForNo;
    }
    public DTreeNode getNodeForYes()
    {
        return nodeForYes;
    }
    public void setNodeForNo(DTreeNode newNodeForNo)
    {
        nodeForNo = newNodeForNo;
    }
    public void setNodeForYes(DTreeNode newNodeForYes)
    {
        nodeForYes = newNodeForYes;
    }
    
    public double getAverageNumQuestions() {
        return getSumNumQuestions(0) / 9.0; // Assumes there are 9 personas
    }

    private int getSumNumQuestions(int numSoFar) {
        if (text.equals("unknown"))
            return 0;
        else if (isAnswer)
            return numSoFar;
        else
            return nodeForNo.getSumNumQuestions(numSoFar+1) + nodeForYes.getSumNumQuestions(numSoFar+1);
    }

    public String toString() {
        return toStringRec(0);
    }

    protected String toStringRec(int level) {
        String indent = new String(new char[level]).replace("\0", "    "); // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java
        if (isAnswer)
            return indent + text;
        else {
            return indent + text + "?" + "\n" + indent + "No " + text + ":\n" + nodeForNo.toStringRec(level+1) 
            + "\n" + indent + "Yes " + text + ":\n" + nodeForYes.toStringRec(level+1);
        }
    }
}
