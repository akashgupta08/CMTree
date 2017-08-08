package akash.cmtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Tree testing
 * 
 * @author Akash
 *
 */
public class CMTree {

    static List<DBNode> dbVo = new ArrayList<DBNode>();
    static Map<String, Node> tree = new HashMap<String, Node>();

    public static void init() {

        dbVo.add(new DBNode("shobit", "kanika", "kanika_value"));
        dbVo.add(new DBNode("naveen", "ish", "ish_value"));
        dbVo.add(new DBNode("kanika", "raman", "raman_value"));
        dbVo.add(new DBNode("shobit", "tarun", "tarun_value"));
        dbVo.add(new DBNode("naveen", "laxman", "laxman_value"));
        dbVo.add(new DBNode(null, "chander", "c_value"));
        dbVo.add(new DBNode("chander", "shobit", "shobit_value"));
        dbVo.add(new DBNode("chander", "naveen", "naveen_value"));
        System.out.println(dbVo);
    }

    public static Map<String, Node> parseVO(List<DBNode> vo) {
        Node tNode, tNodeSelf;
        Set<String> keySet;
        for (DBNode dNode : vo) {
            keySet = tree.keySet();
            if (!keySet.isEmpty()) {
                if (keySet.contains(dNode.getNodeParent())) {
                    tNode = tree.get(dNode.getNodeParent());
                } else {
                    tNode = new Node();
                    tNode.setName(dNode.getNodeParent());
                    // dNode.getNodeName(),dNode.getNodeValue(),dNode.getNodeParent());
                }
                // creating new Self Node
                if (keySet.contains(dNode.getNodeName())) {
                    tNodeSelf = tree.get(dNode.getNodeName());
                } else {
                    tNodeSelf = new Node();
                    tNodeSelf.setName(dNode.getNodeName());
                    tNodeSelf.setValue(dNode.getNodeValue());
                }
                // geting existing parent Node

                tNodeSelf.setParent(tNode);
                // add current node to parent child list.
                tNode.getChildList().add(tNodeSelf);
                // tree.put(dNode.getNodeParent(), tNode);
                tree.put(dNode.getNodeName(), tNodeSelf);

                //
                // tree.put(tNode.getName(),tNode);
                if (dNode.getNodeParent() == null) {
                    tree.put(null, tNodeSelf.getParent());
                } else {
                    tree.put(tNodeSelf.getParent().getName(), tNodeSelf.getParent());
                }

            } else {
                tNodeSelf = new Node();
                tNodeSelf.setName(dNode.getNodeName());
                tNodeSelf.setValue(dNode.getNodeValue());

                tNode = new Node();
                tNode.setName(dNode.getNodeParent());
                tNode.getChildList().add(tNodeSelf);

                tNodeSelf.setParent(tNode);

                // dNode.getNodeName(),
                // dNode.getNodeValue(),dNode.getNodeParent());
                tree.put(tNodeSelf.getName(), tNodeSelf);
                tree.put(tNodeSelf.getParent().getName(), tNodeSelf.getParent());

            }

        }
        return tree;
    }

    public static void childTraverse(List<Node> childList) {
        System.out.println("");
        for (int j = 0; j < childList.size(); j++) {
            Node node = childList.get(j);
            System.out.print("       ");
            System.out.print(node.getName());
            childTraverse(node.getChildList());
            System.out.println("");
        }
    }

    public static void traverse(Map<String, Node> map, String root) {

        System.out.print(root + "-->");
        Node node = map.get(root);
        if (node.getChildList() != null)
            childTraverse(node.getChildList());

    }

    public static void main(String... strings) {
        init();
        tree = parseVO(dbVo);
        System.out.println(tree);
        traverse(tree, "chander");

    }
}
