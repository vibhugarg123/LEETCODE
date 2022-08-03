package TOP_450.ARRAYS;

import java.util.Arrays;

/*
        Link: https://leetcode.com/problems/smallest-range-ii/
        Problem-910: You are given an integer array nums and an integer k.
            For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
            The score of nums is the difference between the maximum and minimum elements in nums.
            Return the minimum score of nums after changing the values at each index.

            Example 1:
            Input: nums = [1], k = 0
            Output: 0
            Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.

            Example 2:
            Input: nums = [0,10], k = 2
            Output: 6
            Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.

            Example 3:
            Input: nums = [1,3,6], k = 3
            Output: 3
            Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.

            Time Complexity: O(Nlog(N))
 */

public class SmallestRangeII910 {

    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        //Reduce diff, diff can be reduced when smaller tower height increases & higher tower height decreases
        int currentMinimumHeight = nums[0];
        int currentMaximumHeight = nums[nums.length - 1];
        int diff = currentMaximumHeight - currentMinimumHeight;

        for (int i = 0; i < nums.length - 1; i++) {
            // Find min & max using 2 elements at a time: first_elem at i & second_elem at i+1
            int first_elem = nums[i];
            int second_elem = nums[i + 1];

            int max = Math.max(currentMaximumHeight - k, first_elem + k); //Increase first element  by k to see if it yields a higher value
            int min = Math.min(currentMinimumHeight + k, second_elem - k);//Decrease second element by k to see if it yields a lower value

            diff = Math.min(diff, max - min);
        }

        return diff;
    }

    public static void main(String[] args) {
        SmallestRangeII910 smallestRangeII910 = new SmallestRangeII910();
        int[] nums = {1, 3, 6};

        System.out.println(smallestRangeII910.smallestRangeII(nums, 3));
    }
}