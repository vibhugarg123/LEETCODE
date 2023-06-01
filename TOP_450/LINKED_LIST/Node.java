package TOP_450.LINKED_LIST;

public class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    void print() {
        Node head = this;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
