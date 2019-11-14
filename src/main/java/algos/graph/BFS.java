package algos.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    public void searchGraph(Graph graph){
        System.out.println("Breadth First Search");
        Queue<Node> bfsQueue = new ArrayDeque<>();
        Node root = graph.nodes.get(0);
        root.visited = true;
        bfsQueue.add(root);
        while(!bfsQueue.isEmpty()){
            Node r = bfsQueue.poll();
            System.out.println(r.name);
            for (Node n : r.adjacent) {
                if (!n.visited){
                    n.visited = true;
                    bfsQueue.add(n);
                }
            }
        }
    }

}
