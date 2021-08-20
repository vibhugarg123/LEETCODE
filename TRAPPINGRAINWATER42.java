/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */

/*
Algorithm:
    Logic: Water is stored where
    1. Find maximum height of bar from the left end upto an index i in the array \text{left\_max}left_max.
    2. Find maximum height of bar from the right end upto an index i in the array \text{right\_max}right_max.
    3. Iterate over the height array and update ans:
        - Add {Math.min(left[i], right[i]) - height[i]} to ans;

        Time complexity: O(n)
        Space complexity: O(n)
 */
class TrappingRainWater42 {
    public int trap(int[] height) {
        int water = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int left_max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > left_max) {
                left_max = height[i];
            }
            left[i] = left_max;
        }
        int right_max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > right_max) {
                right_max = height[i];
            }
            right[i] = right_max;
        }

        for (int i = 0; i < height.length; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater42 trappingRainWater42 = new TrappingRainWater42();
        System.out.println(trappingRainWater42.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}