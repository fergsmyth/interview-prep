package algos;

import java.util.List;

public class Node {
    String name;
    List<Node> adjacent;
    Boolean visited = false;

    public Node(String name) {
        this.name = name;
    }

    public void setAdjacent(List<Node> adjacent) {
        this.adjacent = adjacent;
    }
}
