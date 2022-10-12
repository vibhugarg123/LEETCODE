package TOP_450.ARRAYS;

import java.util.HashMap;

/*
    Problem-560: Subarray Sum Equals K
    https://leetcode.com/problems/subarray-sum-equals-k/

    Given an array of integers nums and an integer k, return the total number of sub-arrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.

    Example 1:
        Input: nums = [1,1,1], k = 2
        Output: 2

    Example 2:
        Input: nums = [1,2,3], k = 3
        Output: 2

        Solution:
        A0, A1, A2.............Ak, Ak+1, Ak+m,..........An
                                ......K......
        ...............currentSum............
        Suppose A0...AK+m denotes currentSum
        And AK....AK+m denotes desired sum

        Then, currentSum-K denotes the starting point of subarray that equals sum K.
        A0..........Oth index
        A0+A1.......1st index
        A0+A1+A2....2nd index


        This algorithm uses a mathematical trick.
        Note that Sum(i, j) = Sum(0,j) - Sum(0, i) for i < j.

        Now, we're looking for a contiguous array, such that Sum(i,j) = k where i < j.
        Putting the two together, you get Sum(0,j) - Sum(0,i) = k.
        Rewriting it, you have Sum(0,j) - k = S(0,i).

        As we iterate through and calculate Sum(0,j), we'll look for any signs of Sum(0,i)
        and increment our count by the number of times we have seen it.

        Time Complexity: O(N)
        Space Complexity:O(N)

 */
public class SubArraySumK560 {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store number of sub-arrays starting from index zero having particular value of sum.
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        //Note the reason why we put 0 in our map is to account for when we have a single element that is already equal to k.
        // Eg: [1], K=1
        // 1-1=0, it means start and end at same point, hence count for such subarray=1

        prevSum.put(0, 1);
        int res = 0;

        // Sum of elements so far.
        int currSum = 0;

        for (int num : nums) {

            // Add current element to sum so far.
            currSum += num;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(currSum - k))
                res += prevSum.get(currSum - k);

            // Add currSum value to count of
            // different values of sum.
            prevSum.put(currSum, prevSum.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new SubArraySumK560().subarraySum(nums, 3));
    }
}