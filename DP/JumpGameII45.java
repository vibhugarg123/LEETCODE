package DP;
/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2

0->1=1
0->2=2
 */

class JumpGameII45 {
    public int jump(int[] nums) {
        //0 to N-1
        // minimum steps from 0 to k + minimum steps from k to N-1
        // Let dp[i] denotes the minimum number of jumps taken from 0 to index i
        // dp[0]=0
        // dp[1]=1
        // dp[2]= min(from 0 to 2 , 1 to 2) = min(0+1, 1+1)=1
        // dp[3]= 2
        // dp[4]=
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            //Let k be an intermediate point from 0 to i
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < i; k++) {
                if (k + nums[k] >= i) {
                    min = Math.min(min, dp[k] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        JumpGameII45 jumpGameII45 = new JumpGameII45();
        System.out.println(jumpGameII45.jump(nums));
    }
}