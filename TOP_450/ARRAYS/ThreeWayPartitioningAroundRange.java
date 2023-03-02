package TOP_450.ARRAYS;

import java.util.Arrays;

/*
    Problem: https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/

    Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts.

        All elements smaller than lowVal come first.
        All elements in range lowVal to highVal come next.
        All elements greater than highVal appear in the end.

    Solution: Dutch Flag Problem
 */

public class ThreeWayPartitioningAroundRange {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void threeWayPartition(int[] nums, int a, int b) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] < a) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] > b) {
                swap(nums, right, current);
                right--;
            } else {
                current++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4};
        new ThreeWayPartitioningAroundRange().threeWayPartition(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
    }
}