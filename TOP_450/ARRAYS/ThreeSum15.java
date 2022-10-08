package TOP_450.ARRAYS;

import java.util.*;

/*
    Problem-15: https://leetcode.com/problems/3sum/
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
        such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        Notice that the solution set must not contain duplicate triplets.

        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]

        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.

        Example 2:

        Input: nums = [0,1,1]
        Output: []

        Explanation: The only possible triplet does not sum up to 0.

        Example 3:

        Input: nums = [0,0,0]
        Output: [[0,0,0]]
        Explanation: The only possible triplet sums up to 0.

        Solution:
        1. Sort the array- O(n * log(n))
        2. Fix ith position of the array and find twoSumSorted from i+1 to length of array while skipping duplicates.

        Time Complexity: O(n*log(n)) + n*n
        Space Complexity: O(1)
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                List<List<Integer>> tmp = twoSumSorted(i + 1, nums, -nums[i]);

                if (tmp.size() > 0) {
                    res.addAll(tmp);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSumSorted(int start, int[] nums, int k) {
        int a = nums[start - 1];

        List<List<Integer>> res = new ArrayList<>();
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] < k) {
                start++;
            } else if (nums[start] + nums[end] > k) {
                end--;
            } else {
                List<Integer> subList = new ArrayList<>();
                subList.add(a);
                subList.add(nums[start]);
                subList.add(nums[end]);
                res.add(subList);

                while (start < end && nums[start + 1] == nums[start]) start++;

                while (start < end && nums[end - 1] == nums[end]) end--;

                start++;
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ThreeSum15().threeSum(nums);
        res.forEach(System.out::println);
    }
}