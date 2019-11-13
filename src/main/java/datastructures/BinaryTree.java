package datastructures;

public class BinaryTree {

    Node root;

    public void add(int value){
        root = insert(root, value);
    }

    private Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        if(value < node.value){
            node.left = insert(node.left, value);
        } else if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }

    class Node {
        Node left;
        Node right;
        int value;

        public Node(int value){
            this.value = value;
        }
    }

    public void print(){
        System.out.println("Print in order");
        printInOrder(root);
        System.out.println("Print pre order");
        printPreOrder(root);
        System.out.println("Print post order");
        printPostOrder(root);
    }

    private void printInOrder(Node node){
        if(node == null) return;
        printInOrder(node.left);
        System.out.println(node.value);
        printInOrder(node.right);
    }

    private void printPreOrder(Node node){
        if (node == null) return;
        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printPostOrder(Node node){
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(15);
        bt.add(1);
        bt.add(4);
        bt.add(16);
        bt.add(20);
        bt.add(3);
        bt.add(6);

        bt.print();
    }
}
