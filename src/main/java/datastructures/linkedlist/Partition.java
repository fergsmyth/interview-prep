package datastructures.linkedlist;

public class Partition {

    private Node head;

    public static void main(String[] args) {
//        new Partition().partitionAround(int x);
    }

    public Node partitionAround(int pivot){
        Node cur = head;
        Node after = null;
        Node before = null;
        while (cur != null){
            if(cur.data < pivot){
                if(before != null){
                    before.next = cur;
                    before = before.next;
                } else {
                    before = cur;
                }
                cur = cur.next;
            } else {
                if(after != null){
                    Node temp = cur.next;
                    cur.next = after.next;
                    after.next = cur;
                    cur = temp;
                } else {
                    after = cur;
                }
            }
            cur = cur.next;
        }

        if(before == null){
            return after;
        } else {
//            before.next = pivotNode;
        }
        return null;
    }

    class Node {
        public Node next;
        public int data;

        public void setNext(Node next) {
            this.next = next;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
