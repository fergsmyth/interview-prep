package algos.graph.problems.ctcq42;

public class CTCQ42 {

    public static void main(String[] args) {
        int[] valuesToInsert = {1,2,3,4,5,6,7,8,9,10};
        Tree mininalTree = Tree.createMininalTree(valuesToInsert);
        mininalTree.printTree();
    }

}
