package TOP_450.SearchingSorting;

/*
Problem-34: Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Solution: Modified Binary Search
 */
public class FirstAndLastPositionOfElementSortedArray34 {

  // leftBias=[True/False], if false, res is rightBiased
  private int binarySearch(int[] nums, int start, int end, int target, boolean leftBias) {
    if (start > end) {
      return -1;
    }
    int mid = start + ((end - start) / 2);
    if (nums[mid] == target) {
      if (leftBias) {
        if (mid - 1 < 0 || nums[mid - 1] != target) {
          return mid;
        } else {
          return binarySearch(nums, start, mid - 1, target, leftBias);
        }
      } else {
        if (mid + 1 >= nums.length || nums[mid + 1] != target) {
          return mid;
        } else {
          return binarySearch(nums, mid + 1, end, target, leftBias);
        }
      }
    } else if (nums[mid] > target) {
      return binarySearch(nums, start, mid - 1, target, leftBias);
    } else {
      return binarySearch(nums, mid + 1, end, target, leftBias);
    }
  }

  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = binarySearch(nums, 0, nums.length - 1, target, true);
    result[1] = binarySearch(nums, 0, nums.length - 1, target, false);
    return result;
  }

  public static void main(String[] args) {
    FirstAndLastPositionOfElementSortedArray34 firstAndLastPositionOfElementSortedArray34 =
        new FirstAndLastPositionOfElementSortedArray34();
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    int[] result = firstAndLastPositionOfElementSortedArray34.searchRange(nums, target);
    for (int x : result) {
      System.out.println(x + " ");
    }
  }
}
