package TOP_450.PRIORITY_QUEUE;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
  Problem- 215: Given an integer array nums and an integer k, return the kth largest element in the array.

  Note that it is the kth largest element in the sorted order, not the kth distinct element.

  Example 1:

  Input: nums = [3,2,1,5,6,4], k = 2
  Output: 5

  Example 2:

  Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
  Output: 4

  @link: https://leetcode.com/problems/kth-largest-element-in-an-array/
  Problem- 33: Anuj Bhaiya Course : https://www.youtube.com/watch?v=yAs3tONaf3s

  Concept: By default, Priority Queue is a min heap. You have to specify comparator for overriding this priority.

  Approach: If you sort the above elements, you have to return the kth element from end.
            i.e [1,2,2,3,3,4,5,5,6] k=4, 4th largest element= 4
            Observation: It means you are returning the minimum of last 4 elements of sorted array
                         i.e top element of min heap formed from last 4 elements.
            Solution:
            1. Construct priority queue (min heap for largest) of K size and adding first 3 elements [0 to K-1].
               Time Complexity : O(K log(K))
            2. Traverse from K to N-1 elements. If PQ[Top] < A[i], remove PQ[Top]. Insert A[i] in PQ.
               Time Complexity: (N-1-K+1)* O(log(K) + log(K)) ~ O(N-K)*log(k)
            3. Return PQ[top] : O(1)
            Total Time Complexity : O(k*log(k) + (n-k)*log(k))
                  Space Complexity: O(K)
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        //By default: it gives a min heap of size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        KthLargestElement kthLargestElement = new KthLargestElement();


        System.out.println(kthLargestElement.findKthLargest(nums, k));
    }
}
