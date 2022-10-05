package TOP_450.ARRAYS;

import java.util.HashMap;

/*
    Problem: https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1

    Example 1:

    Input:
    N = 4, K = 6
    arr[] = {1, 5, 7, 1}
    Output: 2
    Explanation:
        arr[0] + arr[1] = 1 + 5 = 6
        and arr[1] + arr[3] = 5 + 1 = 6.

    Example 2:

    Input:
    N = 4, K = 2
    arr[] = {1, 1, 1, 1}
    Output: 6
    Explanation:
        Each 1 will produce sum 2 with any 1.

    Solution:
    Given arr[] = {1, 5, 7, -1},
    sum = 6

        Store the frequency of every element:
        freq[arr[i]] = freq[arr[i]] + 1
        freq[1] : 1
        freq[5] : 1
        freq[7] : 1
        freq[-1] : 1

        Initialise a variable count with 0 to find the required count of pairs
        At index = 0: freq[sum – arr[0]] = freq[6 – 1] = freq[5] = 1
        count = 1
        At index = 1: freq[sum – arr[1]] = freq[6 – 5] = freq[1] = 1
        count = 2
        At index = 2: freq[sum – arr[2]] = freq[6 – 7] = freq[-1] = 1
        count = 3
        At index = 3: freq[sum – arr[3]] = freq[6 – (-1)] = freq[7] = 1
        count = 4
        The above also contains repeated pairs from front and last, i.e. pair (a, b) and (b, a) are
        considered as different pairs till now.
        Therefore, we will reduce the count by half to determine the count of unique pairs.
        count = count / 2 = 2
        Therefore, required Number of pairs with given sum = 2

        Time Complexity: O(n), to iterate over the array
        Auxiliary Space: O(n), to make a map of size n
 */
public class CountPairsWithGivenSum {
    int getPairsCount(int[] nums, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int counter = 0;
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int num : nums) {
            if (hm.containsKey(k - num)) {
                counter = counter + hm.get(k - num);
            }

            // if (num,num) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (k - num == num)
                counter--;
        }
        return counter / 2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        System.out.println(new CountPairsWithGivenSum().getPairsCount(nums, nums.length - 1, 2));
    }
}