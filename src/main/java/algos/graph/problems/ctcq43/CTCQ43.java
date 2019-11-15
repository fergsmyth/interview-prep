package algos.graph.problems.ctcq43;

import algos.graph.problems.Node;
import algos.graph.problems.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CTCQ43 {
    public static void main(String[] args) {
        Map<Integer, LinkedList<Node>> map = new HashMap<>();
        Tree minimalTree = Tree.createMinimalTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        minimalTree.getDepthLists().values();
        for (LinkedList<Node> depthList : minimalTree.getDepthLists().values()) {
            System.out.println("Depth List");
            for (Node node : depthList){
                System.out.println(node.getValue());
            }
        }
    }
}
