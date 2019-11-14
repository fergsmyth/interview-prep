package algos.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    List<Node> nodes;
    private Node start;
    private Node end;

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public static void main(String[] args) {

        Graph directedGraphForDFS = createDirectedGraph();
        new DFS().searchGraph(directedGraphForDFS);

        Graph directedGraphForBFS = createDirectedGraph();
        new BFS().searchGraph(directedGraphForBFS);

    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public static Graph createDirectedGraph() {
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
