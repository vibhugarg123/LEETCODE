package TOP_450.SearchingSorting;

/*
    Problem: GFG
    Find a Fixed Point (Value equal to index) in a given array
    Given an array of n distinct integers sorted in ascending order,
    write a function that returns a Fixed Point in the array,
    if there is any Fixed Point present in array, else returns -1.
    Fixed Point in an array is an index i such that arr[i] = i.
    Note that integers in array can be negative.

    Input: arr[] = {-10, -5, 0, 3, 7}
    Output: 3  // arr[3] == 3

    Input: arr[] = {0, 2, 5, 8, 17}
    Output: 0  // arr[0] == 0

    Input: arr[] = {-10, -5, 3, 4, 7, 9}
    Output: -1  // No Fixed Point

    Solution: Binary Search O(logn)
 */
public class FixedPointDistinctSortedArray {

  private int binarySearch(int[] nums, int start, int end) {
    if (start > end) {
      return -1;
    }
    int mid = start + (end - start) / 2;
    if (mid == nums[mid]) {
      return mid;
    } else if (mid < nums[mid]) {
      return binarySearch(nums, start, mid - 1);
    } else {
      return binarySearch(nums, mid + 1, end);
    }
  }

  public int fixedPoint(int[] nums) {
    return binarySearch(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    FixedPointDistinctSortedArray fixedPointDistinctSortedArray = new FixedPointDistinctSortedArray();
    int[] nums = {-10, -1, 0, 3, 10, 11, 30, 50, 100};
    System.out.println("fixed point " + fixedPointDistinctSortedArray.fixedPoint(nums));
  }
}
