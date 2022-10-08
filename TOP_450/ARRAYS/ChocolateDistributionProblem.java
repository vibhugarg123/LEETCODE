package TOP_450.ARRAYS;

import java.util.Arrays;

/*
       Problem: Chocolate Distribution Problem
       https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0

       Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
       Each packet can have a variable number of chocolates. There are M students,
       the task is to distribute chocolate packets among M students such that :
            1. Each student gets exactly one packet.
            2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

        Example 1:

        Input:
            N = 8, M = 5
            A = {3, 4, 1, 9, 56, 7, 9, 12}
        Output: 6
        Explanation:
            The minimum difference between
            maximum chocolates and minimum chocolates
            is 9 - 3 = 6 by choosing following M packets :
            {3, 4, 9, 7, 9}.

        Example 2:
            Input:
                N = 7, M = 3
                A = {7, 3, 2, 4, 9, 12, 56}
            Output: 2
            Explanation:
                The minimum difference between
                maximum chocolates and minimum chocolates
                is 4 - 2 = 2 by choosing following M packets :
                {3, 2, 4}.

            Solution:
            The idea is based on the observation that to minimize the difference,
            we must choose consecutive elements from a sorted packet.
            We first sort the array arr[0..n-1],
            then find the subarray of size m with the minimum difference between the last and first elements.

            Time Complexity : O(nlogn)
            Space Complexity: O(1)
 */
public class ChocolateDistributionProblem {

    public long findMinDiff(int[] chocolates, int numberOfStudents) {
        Arrays.sort(chocolates);
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i <= chocolates.length - numberOfStudents; i++) {
            if (chocolates[i + numberOfStudents - 1] - chocolates[i] < diff) {
                diff = chocolates[i + numberOfStudents - 1] - chocolates[i];
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int numberOfStudents = 5;
        int[] chocolates = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(new ChocolateDistributionProblem().findMinDiff(chocolates, numberOfStudents));
    }
}