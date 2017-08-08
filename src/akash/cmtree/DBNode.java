package akash.cmtree;

/**
 ** @author Akash
 *
 */
public class DBNode {

    private String nodeParent;
    private String nodeName;
    private String nodeValue;

    public DBNode(String nodeParent, String nodeName, String nodeValue) {
        this.nodeParent = nodeParent;
        this.nodeName = nodeName;
        this.nodeValue = nodeValue;
    }

    public String getNodeParent() {
        return nodeParent;
    }

    public void setNodeParent(String nodeParent) {
        this.nodeParent = nodeParent;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public String toString() {
        return this.nodeParent + "--" + nodeName + "--" + nodeValue;
    }

}
