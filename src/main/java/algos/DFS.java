package algos;

public class DFS {

    public void searchGraph(Graph graph){
        graph.nodes.stream().forEach(this::search);
    }

    private void search(Node node){
        if(node.visited) return;
        node.visited = true;
        System.out.println(node.name);
        node.adjacent.stream().forEach(this::search);
    }

}
