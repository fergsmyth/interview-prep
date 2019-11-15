package algos.graph.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinDepthBSTInsert {

    private Node root;

    public static void main(String[] args) {
        MinDepthBSTInsert minDepthBSTInsert = new MinDepthBSTInsert();
        minDepthBSTInsert.insert(1);
        minDepthBSTInsert.insert(2);
        minDepthBSTInsert.insert(5);
        minDepthBSTInsert.insert(3);
        minDepthBSTInsert.insert(4);
        minDepthBSTInsert.insert(6);
        minDepthBSTInsert.insert(7);
        minDepthBSTInsert.printTreeBFS();
        minDepthBSTInsert.printTreeDFS();
    }

    public void printTreeBFS(){
        System.out.println("Printing BFS");
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.getValue());
            if (cur.getLeft() != null) queue.add(cur.getLeft());
            if (cur.getRight() != null) queue.add(cur.getRight());
        }
    }

    public void printTreeDFS(){
        System.out.println("Printing DFS");
        printDFS(root);
    }

    private void printDFS(Node cur) {
        if ( cur != null ){
            System.out.println(cur.getValue());
            printDFS(cur.getLeft());
            printDFS(cur.getRight());
        }
    }

    public void insert(int value){
        if(root == null) {
            root = new Node(value);
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.getLeft() == null){
                cur.setLeft(new Node(value));
                return;
            } else if (cur.getRight() == null){
                cur.setRight(new Node(value));
                return;
            } else {
                queue.add(cur.getLeft());
                queue.add(cur.getRight());
            }
        }
    }
}
