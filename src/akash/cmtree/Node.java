package akash.cmtree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Akash
 *
 */
public class Node {

    private String name;
    private List<Node> childList = new ArrayList<Node>();
    private Node parent;
    private String value;

    public Node() {

    }

    public Node(String name, String parent, String value) {
        this.name = name;

        this.value = value;
        if (parent != null)
            this.parent = new Node();
        this.parent.setName(parent);
        this.parent.getChildList().add(this);

    }

    public Node(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildList() {
        return childList;
    }

    public void setChildList(List<Node> childList) {
        this.childList = childList;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
