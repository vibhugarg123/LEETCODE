package TOP_450.ARRAYS;

/*
    Problem-287: https://leetcode.com/problems/find-the-duplicate-number/
    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

    There is only and only one number that is repeated  in nums, rest all are unique, return this repeated number.

    You must solve the problem without modifying the array nums and uses only constant extra space.

    Example 1:
        Input: nums = [1,3,4,2,2]
        Output: 2

    Example 2:
        Input: nums = [3,1,3,4,2]
        Output: 3

     Example 3:
        Input: nums = [2,2,2,2,2]
        Output: 2

    Solution: The problem gets reduced to Given a linked list, return the node where the cycle begins.
        1. This is a linked list cycle detection problem.
        2. Floyd's cycle detection problem to know beginning of cycle.

        Complexity Analysis:
            Time Complexity:  O(n)
            Space Complexity: O(1)
 */
public class FindDuplicateNumber287 {
    public int findDuplicate(int[] nums) {

        int tortoise = nums[0];
        int hare = nums[0];
        // Find the intersection point of the two runners.
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);


        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 1, 3, 1, 5};
        System.out.println(new FindDuplicateNumber287().findDuplicate(nums));
    }
}