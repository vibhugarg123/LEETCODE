package TOP_450.GREEDY;

/*
    Link: https://leetcode.com/problems/jump-game-ii/
    Problem-45:
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.
    You can assume that you can always reach the last index.

    Example 1:
        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

        Solution:
            start_index=0
            Make sure you make single jump from one level/range i.e [start, current_end].
            i=0 [0,2]
            i=1 [1,4]
            i=2 [2,3]
            i=3 [3,4]
            i=4: destination.

    Example 2:
        Input: nums = [2,3,0,1,4]
        Output: 2
 */
class JumpGameII {
    public int jump(int[] nums) {
        int count = 0;
        int possibleMax = 0;
        int currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            possibleMax = Math.max(possibleMax, nums[i] + i);

            //other level starts
            if (i == currentEnd) {
                count++;
                //this level completes at possibleMax
                currentEnd = possibleMax;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(nums));
    }
}