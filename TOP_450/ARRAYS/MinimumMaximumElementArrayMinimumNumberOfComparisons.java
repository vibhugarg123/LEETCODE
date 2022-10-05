package TOP_450.ARRAYS;

/*
    Problem: https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
    Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.

    Examples:

    Input: arr[] = {3, 5, 4, 1, 9}
    Output: Minimum element is: 1
            Maximum element is: 9

    Input: arr[] = {22, 14, 8, 17, 35, 3}
    Output:  Minimum element is: 3
             Maximum element is: 35

             If n is odd then initialize min and max as the first element.
             If n is even then initialize min and max as minimum and maximum of the first two elements respectively.
             For the rest of the elements, pick them in pairs and compare their
             maximum and minimum with max and min respectively.

     Time Complexity:
            If n is even: 1+ 3*(n-2+1)/2 = 1 + 3*(n-1)/2
            If n is odd: 3*(n-1)/2
 */
public class MinimumMaximumElementArrayMinimumNumberOfComparisons {
    static class Pair {
        int min;
        int max;

        Pair() {
        }
    }

    public Pair getMinMax(int[] nums) {
        Pair res = new Pair();
        int i = 0;

     /* If array has an even number of elements then,
     initialize the first two elements as minimum and maximum */
        if (nums.length % 2 == 0) {
            if (nums[0] >= nums[1]) {
                res.max = nums[0];
                res.min = nums[1];
            } else {
                res.max = nums[1];
                res.min = nums[0];
            }
            i = i + 2;
        } else {
            /* If array has odd number of elements then
               initialize the first element as minimum and maximum */
            res.max = res.min = nums[0];
            i = i + 1;
        }

        //Remaining elements,yet to be processed become even in number.
        for (; i < nums.length - 1; i = i + 2) {
            if (nums[i] > nums[i + 1]) {
                if (nums[i] > res.max) res.max = nums[i];
                if (nums[i + 1] < res.min) res.min = nums[i + 1];
            } else {
                if (nums[i] < res.min) res.min = nums[i];
                if (nums[i + 1] < res.max) res.max = nums[i + 1];
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1000, 11, 445, 1, 330, 3000};
        Pair res = new MinimumMaximumElementArrayMinimumNumberOfComparisons().getMinMax(nums);
        System.out.println(res.min + " " + res.max);
    }
}