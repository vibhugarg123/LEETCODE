/*Problem-160
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


It is guaranteed that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.
listA = [4,1,8,4,5]
listB = [5,6,1,8,4,5]
len(A)=5
len(B)=6
Diff= 1, move pointer of B, one step ahead 
head A, head B
4        6 (moved one step further from 5)
1        1
8        8
headA=headB, return
*/
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
//
//public class Solution {
//    private int calculateLength(ListNode head){
//        ListNode p=head;
//        int length=0;
//        while(null!=p){
//            length++;
//            p=p.next;
//        }
//        return length;
//    }
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int lenA=calculateLength(headA);
//        int lenB=calculateLength(headB);
//        if (lenA==0 || lenB==0){
//            return null;
//        }
//        ListNode p,q;
//        int diff;
//        if(lenA>lenB){
//            p=headA;
//            q=headB;
//            diff=lenA-lenB;
//        }else{
//            p=headB;
//            q=headA;
//            diff=lenB-lenA;
//        }
//        for(int i=1;i<=diff;i++){
//            p=p.next;
//        }
//        while(p!=q){
//            p=p.next;
//            q=q.next;
//        }
//        return p;
//    }
//}
