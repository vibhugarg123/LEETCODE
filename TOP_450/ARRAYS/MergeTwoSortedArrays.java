package TOP_450.ARRAYS;

import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/merge-sorted-array/
    Problem-88 :
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
    To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

    Example 1:
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.


    Example 3:
    Input: nums1 = [1,2,5,8,0,0,0], m = 4, nums2 = [2,3,7], n = 3
    Output: [1,2,2,3,5,7,8]

    Solution:
    1. Compare highest elements of first & second element , keep placing it at the back of the first array.
    Time  Complexity: O(m+n)
    Space Complexity: O(1)

 */
class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int current = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[current--] = nums2[j];
                j--;
            } else {
                nums1[current--] = nums1[i];
                i--;
            }
        }

        while (i >= 0) {
            nums1[current--] = nums1[i];
            i--;
        }
        while (j >= 0) {
            nums1[current--] = nums2[j];
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5, 8, 0, 0, 0};
        int[] nums2 = {2, 3, 7};
        int m = 4;
        int n = 3;

        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        mergeTwoSortedArrays.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}