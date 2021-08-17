/*
[Problem-238]
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? 
(The output array does not count as extra space for space complexity analysis.)
*/

/*
    Algorithm-1: With Space O(N)
    1. For each element in num array, calculate left product & right product in 2 arrays
       For example- [1,2,3,4]
       for 1, left[1]= 1
              right[1]= 2*3*4= 24
              output[1]= left[1]*right[1]=24
       leftArray = [1, 1, 2, 6]
       rightArray= [24,12, 4, 1]
       outputArray=[24,12,8,6]
       Time Complexity= O(N)+ O(N) + O(N)= O(N)
       Space Complexity= O(N)+ O(N)= O(N)

     Algorithm-2: Without Space
     1. Maintain leftArray in result array
     2. Take right variable & keep updating right & in-parallel calculating the output array value
      Time Complexity= O(N)+ O(N) = O(N)
      Space Complexity= O(1) //excluding the output array space
 */

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }
        int right = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                right = 1;
            } else {
                right = right * nums[i + 1];
            }
            result[i] = result[i] * right;
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] input = new int[]{1, 2, 3, 4};
        p.productExceptSelf(input);
    }
}