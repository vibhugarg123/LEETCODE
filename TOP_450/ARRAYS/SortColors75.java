package TOP_450.ARRAYS;

/*
[Problem-75] : https://leetcode.com/problems/sort-colors/
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.

    Example 1:

    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    Example 2:

    Input: nums = [2,0,1]
    Output: [0,1,2]
    Example 3:

    Input: nums = [0]
    Output: [0]
    Example 4:

    Input: nums = [1]
    Output: [1]

    Algorithm- Dutch Flag Problem
    Time Complexity: O(N)
    Space Complexity: O(1)

    0.....left,mid....high.....N-1
    1. Assume 3 pointers [left, mid, right]
        - left will always track of "0".
        - right will always track of "2".
        - mid is the current element to be processed, which will check whether to swap it to the left or right or keep it as it.
 */
class SortColours75 {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, current = 0;
        //traversing the whole array from 0 to N-1
        while (current <= right) {
            switch (nums[current]) {
                case 0:
                    swap(nums, left, current);
                    left++;
                    current++;
                    break;
                case 2:
                    //move the current element i.e 2 to right, but right may be 0 or 1 or 2 which needs to processed again
                    // when it moves to current, hence no current ++.
                    swap(nums, right, current);
                    right--;
                    break;
                case 1:
                    // since 1 is the current element, it's already in right place i.e in the mid
                    current++;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SortColours75 sc = new SortColours75();
        int[] nums = new int[]{1, 2, 0};
        sc.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}