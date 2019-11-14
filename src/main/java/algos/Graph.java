package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Graph {

    List<Node> nodes;

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public static void main(String[] args) {
        Graph directedGraph = createDirectedGraph();

        new DFS().searchGraph(directedGraph);
//        new BFS().searchGraph(graph);
    }

    private static Graph createDirectedGraph() {
        Node node5 = new Node("5");
        Node node4 = new Node("4");
        Node node3 = new Node("3");
        Node node2 = new Node("2");
        Node node1 = new Node("1");
        Node node0 = new Node("0");
        node0.setAdjacent(new ArrayList<>(Arrays.asList(node1, node4, node5)));
        node1.setAdjacent(new ArrayList<>(Arrays.asList(node3, node4)));
        node2.setAdjacent(new ArrayList<>(Arrays.asList(node1)));
        node3.setAdjacent(new ArrayList<>(Arrays.asList(node2, node4)));
        node4.setAdjacent(new ArrayList<>());
        node5.setAdjacent(new ArrayList<>());
        return new Graph(Arrays.asList(node0));
    }

}
