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
        boolean isFound = new PathFinder().findNodeMatching("e", alphaGraph);
        System.out.println(isFound);
    }


    private boolean findNodeMatching(String nodeName, Graph graph){
        Queue<Node> queue = new ArrayDeque<>();
        Node root = graph.getNodes().get(0);
        root.setVisited(true);
        queue.add(root);
        while(!queue.isEmpty()){
            queue.stream().forEach(node -> System.out.print(node.getName()));
            System.out.println();
            Node r = queue.poll();
            if(r.getName().equalsIgnoreCase(nodeName)) {
                return true;
            }
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
        c.setAdjacent(new ArrayList<>(Arrays.asList(d, e, f)));
        d.setAdjacent(new ArrayList<>());
        e.setAdjacent(new ArrayList<>(Arrays.asList(d)));
        f.setAdjacent(new ArrayList<>());
        g.setAdjacent(new ArrayList<>(Arrays.asList(i, h)));
        h.setAdjacent(new ArrayList<>(Arrays.asList(j)));
        i.setAdjacent(new ArrayList<>());
        j.setAdjacent(new ArrayList<>(Arrays.asList(g)));
        return new Graph(Arrays.asList(a));
    }
}
