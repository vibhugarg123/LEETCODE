package TOP_450.LINKED_LIST;

/*
    Problem- https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLL21 {
    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node mergedList = new Node();
        Node head = mergedList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }

            head = head.next;
        }
        if (list1 != null) head.next = list1;
        if (list2 != null) head.next = list2;
        return mergedList.next;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node merged_list = new MergeTwoSortedLL21().mergeTwoLists(list1, list2);
        merged_list.print();

    }
}