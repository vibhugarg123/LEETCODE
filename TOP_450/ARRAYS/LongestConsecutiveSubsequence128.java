package TOP_450.ARRAYS;

import java.util.HashSet;

/*
    Problem-128: Longest Consecutive Sequence- https://leetcode.com/problems/longest-consecutive-sequence/
    Note: Consecutive numbers can be in any order.

    Example 1:
        Input: nums = [100,4,200,1,3,2]
        Output: 4
         Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Example 2:
        Input: nums = [0,3,7,2,5,8,4,6,0,1]
        Output: 9

    Solution:
        - Create an empty hash.
        - Insert all array elements to hash.
        - Do the following for every element arr[i]
            - Check if this element is the starting point of a subsequence. To check this, simply look for arr[i] – 1 in the hash,
              if not found, then this is the first element of a subsequence.
                - If this element is the first element, then count the number of elements in the consecutive starting with this element.
                Iterate from arr[i] + 1 till the last element that can be found.
                - If the count is more than the previous longest subsequence found, then update this.

     Time complexity: O(N), Only one traversal is needed and the time complexity is O(n)
                            under the assumption that hash insert and search takes O(1) time.

     Auxiliary space: O(N), To store every element in the hashmap O(n) space is needed.
 */
public class LongestConsecutiveSubsequence128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }

        int maxLength = 0;
        for (int num : nums) {
            // if current element is the starting
            // element of a sequence i.e, nums[i]-1 is not present in set
            if (!hs.contains(num - 1)) {
                int j = num;
                // Eg: if 3 is the current element, search for 4, 5, 6, 7...
                // Suppose it stops at 8 i.e 8 not found
                // length= 8-3=5 i.e 3,4,5,6,7
                while (hs.contains(j)) {
                    j++;
                }
                if (maxLength < j - num) {
                    maxLength = j - num;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new LongestConsecutiveSubsequence128().longestConsecutive(nums));
    }
}