package TOP_450.ARRAYS;/*
[Problem-167]: https://leetcode.com/problems/two-sum/
Two Sum II - Input array is sorted
Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
*/

class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }else if (numbers[i]+numbers[j]<target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }
    public static void main(String[]args) {
        TwoSumII twoSumII=new TwoSumII();
        int[] arr = twoSumII.twoSum(new int[]{2,7,11,15},9);
        for (int i:arr){
            System.out.println(i);
        }
    }
}