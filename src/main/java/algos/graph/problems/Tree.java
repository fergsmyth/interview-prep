package algos.graph.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Tree {

    Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else if (node.value > value) {
            node.left = insert(node.left, value);
        } else if (node.value < value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public static Tree createMinimalTree(int[] values){
        Tree tree = new Tree();
        tree.insertMidpoint(values,0, values.length - 1, tree);
        return tree;
    }

    private void insertMidpoint(int[] values, int start, int end, Tree tree) {
        if (start > end) return;
        int midpoint = (end + start) / 2;
        int value = values[midpoint];
        tree.insert(value);
        insertMidpoint(values, start, midpoint - 1, tree);
        insertMidpoint(values, midpoint + 1, end, tree);
    }

    public void printTree(){
        System.out.println("Printing DFS");
        printDFS(root);
    }

    private void printDFS(Node node){
        if(node != null) {
            System.out.println(node.getValue());
            printDFS(node.getLeft());
            printDFS(node.getRight());
        }
    }

    public Map<Integer, LinkedList<Node>> getDepthLists(){
        Map<Integer, LinkedList<Node>> depthMapList = new HashMap<>();
        listDepthDFS(1, root, depthMapList);
        return depthMapList;
    }

    private void listDepthDFS(int counter, Node node, Map<Integer, LinkedList<Node>> map){
        if(node == null) return;
        LinkedList<Node> nodes = map.get(counter);
        if(nodes != null){
            nodes.add(node);
        } else {
            LinkedList depthList = new LinkedList();
            depthList.add(node);
            map.put(counter, depthList);
        }
        counter++;
        listDepthDFS(counter, node.left, map);
        listDepthDFS(counter, node.right, map);
    }

}