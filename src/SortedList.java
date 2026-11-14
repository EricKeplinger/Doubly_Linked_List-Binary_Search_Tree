
class Node {
    int val;
    Node next, prev;

    Node(int val) {
        this.val = val;
    }
}

public class SortedList {
    private Node head = null; // pointer to the head of the list
    private Node tail = null; // pointer to the tail of the list

    public void insert(int val) {
        // TODO adapt the code to insert in a doubly linked list

        Node p = head, prev = null;

        // find the position to insert the new node
        while (p != null && p.val < val) {
            prev = p;
            p = p.next;
        }

        // at this point, prev is the last node with value less than val (or null if val is the smallest)
        Node n = new Node(val);
        n.next = p;
        if (prev == null) { // inserting at the head
            head = n;
            n.prev = prev;
        } else{
            prev.next = n;
            n.prev = prev;
        }

        if(p != null){ // inserting after prev
            p.prev = n;
        }

        // update tail if empty list or inserted at the end
        if (tail == null || p == null) {
            tail = n;
        }
    }

    public String toStringReversed() {
        // TODO implement this method for a doubly linked list

        return toStringReversed(tail);
    }

    private String toStringReversed(Node p){
        if(p == null){
            return "";
        } else{
            return p.val + " " + toStringReversed(p.prev);
        }

    }
}