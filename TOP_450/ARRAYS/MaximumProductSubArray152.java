package TOP_450.ARRAYS;

/*
        Problem-152: https://leetcode.com/problems/maximum-product-subarray/
        Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

        Example 1:

            Input: nums = [2,3,-2,4]
            Output: 6
            Explanation: [2,3] has the largest product 6.

        Example 2:

            Input: nums = [-2,0,-1]
            Output: 0
            Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

            Solution:
            The modified solution is also similar to the Largest Sum Contiguous Subarray problem which uses Kadane’s algorithm.
            For ease of understanding we are not using any flag like the previous solution.
            Here we use 3 variable called max_so_far, max_ending_here & min_ending_here.
            For every index the maximum number ending at that index will be the maximum(arr[i], max_ending_here * arr[i], min_ending_here[i]*arr[i]).
            Similarly the minimum number ending here will be the minimum of these 3. Thus, we get the final value for maximum product subarray.

            Time Complexity: O(n)
            Auxiliary Space: O(1)

           Eg: [-2,-1,-1]
            i=0
                maximum=-2
                minimum=-2
            i=1
                maximum= max(-1, -1*-2, -1*-2)=  2
                minimum= max(-1, -1*-2, -1*-2)= -1
            i=2
                maximum=max(-1,-1*2,-1*-2)=2
                minimum=-2

 */
public class MaximumProductSubArray152 {

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int maxProduct(int[] nums) {
        // max positive product ending at the current position
        int max_ending_here = nums[0];

        // min negative product ending at the current position
        int min_ending_here = nums[0];

        // Initialize overall max product
        int max_so_far = nums[0];

        // /* Traverse through the array.
        // the maximum product subarray ending at an index
        // will be the maximum of the element itself,
        // the product of element and max product ending previously
        // and the min product ending previously. */
        for (int i = 1; i < nums.length; i++) {
            //nums[i]=current element
            //nums[i]*max_ending_here denotes adding of current element to existing subarray
            //nums[i]*min_ending_here denotes if nums[i] is negative and min_ending_here is also negative, then product can be largest
            int temp = max(nums[i], nums[i] * max_ending_here, nums[i] * min_ending_here);

            min_ending_here = min(nums[i], nums[i] * max_ending_here, nums[i] * min_ending_here);

            max_ending_here = temp;
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(new MaximumProductSubArray152().maxProduct(nums));
    }
}