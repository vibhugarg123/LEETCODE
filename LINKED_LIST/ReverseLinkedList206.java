package LINKED_LIST;


/*
[Problem-206]
Given the head of a singly linked list, reverse the list, and return the reversed list.
  1->2->3->4->5

  Condition-1: Empty list, return empty list
  Condition-2: Single node, return that single node
  Condition-3: Two nodes
    1->2

    1<-2
    prev=null
    current=1
    temp=2

    1->next=prev(null)
    previous=current(1)
    current=next (i.e Process 2)

    return previous is the new head;
 */
class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /* head temp newHead
        1->rev(2->3)
        temp=2
        head=1
        newHead=3

    <-null<-1<-2<-3 (head)
     */
    public ListNode recursiveReverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        //Reverse the remaining part of linked list
        ListNode newHead = recursiveReverse(head.next);
        //Save the joining link b/w head & new head
        ListNode temp = head.next;

        //joining link next is now pointing to current head
        temp.next = head;
        //head next is now pointing to null
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode reversedList = reverseLinkedList206.reverseList(head);
        reversedList.printList();

//        ListNode recursiveReversedList = reverseLinkedList206.recursiveReverse(head);
//        recursiveReversedList.printList();
    }
}
