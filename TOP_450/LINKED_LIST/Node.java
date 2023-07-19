package TOP_450.LINKED_LIST;

public class Node {
    int val;
    Node next;

    Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    void print() {
        Node head = this;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
