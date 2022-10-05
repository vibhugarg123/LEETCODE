package TOP_450.ARRAYS;

import java.util.Arrays;

/*
  Problem-189: Given an array, rotate the array to the right by k steps, where k is non-negative.
  Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105

    Solution: Observation
    If you rotate the array k times, last k elements come at the front of the array.

    Time Complexity :  O(N)
    Space Complexity:  O(1)

    Reverse array k times.
    - Reverse whole array [7,6,5,4,3,2,1]
    - Reverse array from start=0 to end= k-1 [5,6,7,4,3,2,1]
    - Reverse array from start=k to end=arr.length [5,6,7,1,2,3,4]

 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; //if k>=nums.length,  after length times rotation, the array becomes same.
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        RotateArray189 rotateArray189 = new RotateArray189();
        rotateArray189.rotate(nums, 3);
        Arrays.stream(nums).forEach(System.out::println);
    }
}