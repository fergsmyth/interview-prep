package algos.graph.problems;

import algos.graph.Graph;
import algos.graph.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class PathFinder {

    public static void main(String[] args) {
        Graph alphaGraph = createDirectedGraph();
        boolean isFound = new PathFinder().findNodeMatchingBFS(alphaGraph.getStart(), alphaGraph.getEnd());
        System.out.println(isFound);
    }


    // Find if end node can be reached from start node
    private boolean findNodeMatchingBFS(Node start, Node end){
        Queue<Node> queue = new ArrayDeque<>();
        start.setVisited(true);
        queue.add(start);
        while(!queue.isEmpty()){
            Node r = queue.poll();
            System.out.println(r.getName());
            if(r.equals(end)) return true;
            for (Node child : r.getAdjacent()){
                if (child.getVisited()) continue;
                child.setVisited(true);
                queue.add(child);
            }
        }
        return false;
    }

    public static Graph createDirectedGraph() {

        Node j = new Node("j");
        Node i = new Node("i");
        Node h = new Node("h");
        Node g = new Node("g");
        Node f = new Node("f");
        Node e = new Node("e");
        Node d = new Node("d");
        Node c = new Node("c");
        Node b = new Node("b");
        Node a = new Node("a");

        a.setAdjacent(new ArrayList<>(Arrays.asList(b, g)));
        b.setAdjacent(new ArrayList<>(Arrays.asList(c)));
        c.setAdjacent(new ArrayList<>(Arrays.asList(e, f)));
        d.setAdjacent(new ArrayList<>(Arrays.asList(c)));
        e.setAdjacent(new ArrayList<>(Arrays.asList(d)));
        f.setAdjacent(new ArrayList<>(Arrays.asList(e)));
        g.setAdjacent(new ArrayList<>(Arrays.asList(i, h)));
        h.setAdjacent(new ArrayList<>(Arrays.asList(j)));
        i.setAdjacent(new ArrayList<>());
        j.setAdjacent(new ArrayList<>(Arrays.asList(g)));
        Graph graph = new Graph(Arrays.asList(a));
        graph.setStart(e);
        graph.setEnd(f);
        return graph;
    }
}
