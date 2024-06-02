package TOP_450.SearchingSorting;

/*
    Problem-33: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    There is an integer array nums sorted in ascending order (with distinct values).
    Prior to being passed to your function, nums is possibly rotated
    at an unknown pivot index k (1 <= k < nums.length) such that the
    resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    Given the array nums after the possible rotation and an integer target,
    return the index of target if it is in nums, or -1 if it is not in nums.
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    Example 2:

    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
    Example 3:

    Input: nums = [1], target = 0
    Output: -1
 */
public class SearchInRotatedSortedArray33 {

  private int binarySearch(int[] nums, int start, int end, int target) {
    if (start > end) {
      return -1;
    }
    int mid = start + (end - start) / 2;
    if (nums[mid] == target) {
      return mid;
    }
    // It states that [start....mid] is sorted
    if (nums[start] <= nums[mid]) {
      // check whether target lies between [start...mid]
      if (nums[start] <= target && target <= nums[mid]) {
        return binarySearch(nums, start, mid - 1, target);
      } else {
        return binarySearch(nums, mid + 1, end, target);
      }
    }
    // Guarantee- If the left part of the middle element is not sorted, it is certain that the right part is sorted
    // It states that [mid....end] is sorted
    else {
      // check whether target lies between [mid...end]
      if (nums[mid] <= target && target <= nums[end]) {
        return binarySearch(nums, mid + 1, end, target);
      } else {
        return binarySearch(nums, start, mid - 1, target);
      }
    }
  }

  public int search(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  public static void main(String[] args) {
    SearchInRotatedSortedArray33 searchInRotatedSortedArray33 = new SearchInRotatedSortedArray33();
    int[] nums = {7, 8, 9, 1, 2, 3, 4, 5, 6};
    int target = 1;
    System.out.println(searchInRotatedSortedArray33.search(nums, target));
  }
}
