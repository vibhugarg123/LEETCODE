package TOP_450.ARRAYS;

import java.util.PriorityQueue;

/*
    Problem-215: https://leetcode.com/problems/kth-largest-element-in-an-array/

         Given an integer array nums and an integer k, return the kth largest element in the array.

         Note that it is the kth largest element in the sorted order, not the kth distinct element.

        You must solve it in O(n) time complexity.

        Example 1:

        Input: nums = [3,2,1,5,6,4], k = 2
        Output: 5
        Example 2:

        Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        Output: 4

        Space Complexity: O(K)
        Time Complexity: O(K + (N-K) * Log K)
 */
public class KthLargestElement215 {
    public int findKthLargest(int[] nums, int k) {
        // Construct min heap of size k
        // Construct min heap in such a way that only k elements are present at the end after traversing array.
        // If min heap is of size k, then kth largest would be the first element in min heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        int i = 0;
        for (i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // In the last, first k largest elements are present inside heap.
        for (i = k; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new KthLargestElement215().findKthLargest(nums, k));
    }
}