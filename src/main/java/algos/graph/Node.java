package algos.graph;

import java.util.List;

public class Node {
    String name;
    List<Node> adjacent;
    Boolean visited = false;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getAdjacent() {
        return adjacent;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public void setAdjacent(List<Node> adjacent) {
        this.adjacent = adjacent;
    }
}
