package LINKED_LIST;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printList() {
        ListNode p = this;
        while (null != p) {
            System.out.println(p.val + " ");
            p = p.next;
        }
    }
}