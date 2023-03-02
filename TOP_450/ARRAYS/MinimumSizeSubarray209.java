package TOP_450.ARRAYS;

/*
    Problem-209:
    Given an array of positive integers nums and a positive integer target, return the minimal length of a
    subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

        Example 1:

        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal length under the problem constraint.

        Example 2:

        Input: target = 4, nums = [1,4,4]
        Output: 1

        Example 3:

        Input: target = 11, nums = [1,1,1,1,1,1,1,1]
        Output: 0

         Array: [2,3,1,2,4,3]
         Target: 7

         Complexity analysis:

            Time complexity: O(n)
            Space complexity: O(1)

    window size=1, [2] :        start=0, end=0 sum<7  ; len=-1
    window size=2, [2,3]:       start=0, end=1 sum<7  ; len=-1
    window size=3, [2,3,1]:     start=0, end=2 sum<7  ; len=-1
    window size=4, [2,3,1,2]:   start=0, end=3 sum>=7 ; len=4

    Since len=4, we want to decrease the window size; To decrease, move start of window to 1
    start=1 ; end=3 sum<7, window size=3
    As window size is less but the sum is not greater than equal to target, keep adding element
    start=1; end=4 sum=10 >7, but window size=4
    Again decrease window size; To decrease, move start of window to 2
    start=2; end=4, window size=3
    sum=7 which is equal to 7, hence update len=3
    Try to decrease window size further, move start of window to 3
    start=3, end=4, window size=2
    sum=6 <7, hence increase window
    start=3, end=5, sum=9 >7, len=3
    Decrease window size, start=4, end=5, window size=2
    sum=7=7, len=2
    Try to decrease window size further, move start=5, end=5, window length=1
    sum=3<7, ignore
    Try to increase window: start=5, end=6
    start>end stop.

    Ans=2

 */
public class MinimumSizeSubarray209 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int startCurrentWindow = 0;
        int sumCurrentWindow = 0;

        for (int endCurrentWindow = 0; endCurrentWindow < nums.length; endCurrentWindow++) {
            // Keep increasing window size
            sumCurrentWindow += nums[endCurrentWindow];

            // If the sumCurrentWindow is greater than equal to target, find minLength
            // and try to reduce window size
            while (sumCurrentWindow >= target) {
                minLength = Math.min(minLength, endCurrentWindow - startCurrentWindow + 1);
                // Reduce the sumCurrentWindow to reduce window size
                sumCurrentWindow -= nums[startCurrentWindow];
                // Reduce window size by sliding one to the right
                startCurrentWindow++;
            }
        }
        return (minLength != Integer.MAX_VALUE) ? minLength : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(new MinimumSizeSubarray209().minSubArrayLen(target, nums));
    }
}
