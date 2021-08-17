package MODIFIED_BINARY_SEARCH;

/*
[Problem-33]
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

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


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
 */
class SearchInRotatedSortedArray {

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        //To avoid integer overflow
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        //Check if the first half is sorted i.e first element in the subpart is <= middle element
        if (nums[start] <= nums[mid]) {
            // If the target element lies between start & mid
            if (target >= nums[start] && target < nums[mid]) {
                return binarySearch(nums, target, start, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, end);
            }
        }
        //Guarantee- If the left part of the middle element is not sorted, it is sure that the right part is sorted
        else {
            // If the target element lies between mid & high
            if (target > nums[mid] && target <= nums[end]) {
                return binarySearch(nums, target, mid + 1, end);
            } else {
                return binarySearch(nums, target, start, end - 1);
            }
        }
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return binarySearch(nums, target, start, end);
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}