package TOP_450.ARRAYS;

/*
        Problem-53: https://leetcode.com/problems/maximum-subarray/

        Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

        A subarray is a contiguous part of an array.

        Example 1:

        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
        Example 2:

        Input: nums = [1]
        Output: 1
        Example 3:

        Input: nums = [5,4,-1,7,8]
        Output: 23

        Kadane’s Algorithm:
        The idea of Kadane’s algorithm is to maintain a variable max_ending_here that stores the maximum sum contiguous subarray ending
        at current index and a variable max_so_far stores the maximum sum of contiguous subarray found so far,
        Everytime there is a positive-sum value in max_ending_here compare it with max_so_far and update max_so_far if it is greater than max_so_far.

        Time Complexity:  O(N)
        Space Complexity: O(1)
 */
public class MaximumSubarrayContiguous53 {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int num : nums) {
            //Either add current element to existing subarray or start a new subarray
            max_ending_here = Math.max(num, max_ending_here + num);

            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarrayContiguous53().maxSubArray(nums));
    }
}