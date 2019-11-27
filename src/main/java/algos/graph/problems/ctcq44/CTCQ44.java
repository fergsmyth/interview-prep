package algos.graph.problems.ctcq44;

import algos.graph.problems.Tree;

public class CTCQ44 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(7);
        tree.insert(13);
        tree.insert(11);
        tree.insert(10);
        tree.checkBalance();
    }


}
