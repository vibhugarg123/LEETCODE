package TOP_450.SearchingSorting;

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

  public int[] getMinMax(int[] nums) {
    int i = 0;

     /* If array has an even number of elements then,
     initialize the first two elements as minimum and maximum */
    int max, min;
    if (nums.length % 2 == 0) {
      if (nums[0] >= nums[1]) {
        max = nums[0];
        min = nums[1];
      } else {
        max = nums[1];
        min = nums[0];
      }
      i = i + 2;
    } else {
            /* If array has odd number of elements then
               initialize the first element as minimum and maximum */
      max = min = nums[0];
      i = i + 1;
    }

    //Remaining elements,yet to be processed become even in number.
    for (; i <= nums.length - 2; i = i + 2) {
      // If i> i+1, i.e i is candidate for max, and i+1 for min
      if (nums[i] > nums[i + 1]) {
        if (nums[i] > max) {
          max = nums[i];
        }
        if (nums[i + 1] < min) {
          min = nums[i + 1];
        }
      } else {
        // If i< i+1, i.e i+1 is candidate for max, and i for min
        if (nums[i] < min) {
          min = nums[i];
        }
        if (nums[i + 1] > max) {
          max = nums[i + 1];
        }
      }
    }

    return new int[]{max, min};
  }

  // Divide and Conquer Based Approach
  public int[] getMinMaxDivideAndConquer(int[] nums, int l, int r) {
    // Base Case-1: when size=1
    if (l == r) {
      return new int[]{nums[l], nums[r]};
    }
    int min, max;
    // Base Case-1: when size=2
    if (l + 1 == r) {
      if (nums[l] < nums[r]) {
        min = nums[l];
        max = nums[r];
      } else {
        min = nums[r];
        max = nums[l];
      }
      return new int[]{max, min};
    }
    int mid = l + (r - l) / 2;
    int[] leftMinMax = getMinMaxDivideAndConquer(nums, l, mid);
    int[] rightMinMax = getMinMaxDivideAndConquer(nums, mid + 1, r);

    max = Math.max(leftMinMax[0], rightMinMax[0]);
    min = Math.min(leftMinMax[1], rightMinMax[1]);

    return new int[]{max, min};
  }


  public static void main(String[] args) {
    int[] nums = {1000, 11, 445, 1, 330, 3000};
    int[] res = new MinimumMaximumElementArrayMinimumNumberOfComparisons().getMinMax(nums);
    System.out.println(res[0] + " " + res[1]);

    int[] res2 = new MinimumMaximumElementArrayMinimumNumberOfComparisons().getMinMaxDivideAndConquer(nums, 0,
        nums.length - 1);
    System.out.println(res2[0] + " " + res2[1]);
  }
}