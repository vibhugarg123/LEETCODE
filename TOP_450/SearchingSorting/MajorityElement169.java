package TOP_450.SearchingSorting;

/*
    Problem-169: https://leetcode.com/problems/majority-element/description/
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times.
    You may assume that the majority element always exists in the array.

    Example 1:

    Input: nums = [3,2,3]
    Output: 3

    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    Solution: Moore Voting Algorithm
 */
public class MajorityElement169 {

  public int majorityElement(int[] nums) {
    int count = 1;
    int majorityElement = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        count = 1;
        majorityElement = nums[i];
      } else if (nums[i] == majorityElement) {
        count++;
      } else {
        count--;
      }
    }
    return majorityElement;
  }

  public static void main(String[] args) {
    int[] nums = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
    System.out.println(new MajorityElement169().majorityElement(nums));
  }
}
