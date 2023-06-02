package TOP_450.PRIORITY_QUEUE;

import java.util.PriorityQueue;

/*
    Problem-23: Merge k Sorted Lists: https://leetcode.com/problems/merge-k-sorted-lists/
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

    Merge all the linked-lists into one sorted linked-list and return it.

    Example 1:

    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6

    Example 2:
    Input: lists = []
    Output: []

    Example 3:
    Input: lists = [[]]
    Output: []

    Solution: Use min-heap
    Time Complexity: Heap-size is K, hence every poll() means O(logk). For N extract Min, O(NlogK)
    Space Complexity: O(K) , k heads are added to min-heap.
 */
public class MergeKSortedLists23 {
    public static class ListNode {
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

        void print() {
            ListNode head = this;
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (o1, o2) -> Integer.compare(o1.val, o2.val));
        ListNode result = new ListNode();
        ListNode merged = result;

        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(listNode);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            merged.next = node;
            // Move result pointer
            merged = merged.next;

            if (node.next != null)
                pq.offer(node.next);

        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode merged = new MergeKSortedLists23().mergeKLists(new ListNode[]{list1, list2, list3});
        merged.print();
    }
}