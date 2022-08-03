package TOP_450.ARRAYS;

/*
    Link: https://leetcode.com/problems/smallest-range-i/
    Problem- 450: You are given an integer array nums and an integer k.
        In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k].
        You can apply this operation at most once for each index i.
        The score of nums is the difference between the maximum and minimum elements in nums.
        Return the minimum score of nums after applying the mentioned operation at most once for each index in it.

        Example 1:
        Input: nums = [1], k = 0
        Output: 0
        Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.

        Example 2:
        Input: nums = [0,10], k = 2
        Output: 6
        Range of nums[i]= {nums[i]-x,nums[i]+x}
        Array range: [{-2,2},{8,10}]

        Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.

        Example 3:
        Input: nums = [1,3,6], k = 3
        Range of nums[i]= {nums[i]-x,nums[i]+x}
        Array range: [{-2,4},{0,6},{3,9}]
        Output: 0
        Explanation: Change nums to be [4, 4, 4]. The score is max(nums) - min(nums) = 4 - 4 = 0.


        Solution:
        1. minimum score can be 0
        2. Find minimum element in array.
        3. Find maximum element in array.
        4. Diff is minimum when we subtract K from max & add K to min.

        Time Complexity:  O(N)
        Space Complexity: O(1)

 */
class SmallestRangeI908 {
    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int diff = (max - k) - (min + k);
        return diff < 0 ? 0 : diff;
    }

    public static void main(String[] args) {
        SmallestRangeI908 smallestRangeI908 = new SmallestRangeI908();
        int[] nums = {1, 3, 6};
        System.out.println(smallestRangeI908.smallestRangeI(nums, 3));
    }
}