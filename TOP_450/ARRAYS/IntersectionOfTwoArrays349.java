package TOP_450.ARRAYS;

import java.util.*;
/*
        Link: https://leetcode.com/problems/intersection-of-two-arrays/
        Problem-349
        Given two integer arrays nums1 and nums2, return an array of their intersection.
        Each element in the result must be unique and you may return the result in any order.

        Example 1:

        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2]
        Example 2:

        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [9,4]
        Explanation: [4,9] is also accepted.
 */

public class IntersectionOfTwoSortedArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        int[] res = new int[nums1.length];

        int i = 0;

        for (int num : nums1) {
            map.putIfAbsent(num, true);
        }

        for (int num : nums2) {
            if (map.getOrDefault(num, false)) {
                res[i++] = num;
                map.put(num, false);
            }
        }

        // need to use Arrays.copyOf(), otherwise if the array is not filled, default value of integer i.e zero is appended
        return Arrays.copyOf(res, i);
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        IntersectionOfTwoSortedArrays349 intersectionOfTwoSortedArrays349 = new IntersectionOfTwoSortedArrays349();
        System.out.println(Arrays.toString(intersectionOfTwoSortedArrays349.intersection(nums1, nums2)));
    }
}