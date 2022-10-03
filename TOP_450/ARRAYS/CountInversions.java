package TOP_450.ARRAYS;

/*
    Problem- https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

    Given an array of integers. Find the Inversion Count in the array.

        Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
        If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
        Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.


        Example 1:

        Input: N = 5, arr[] = {2, 4, 1, 3, 5}
        Output: 3
        Explanation: The sequence 2, 4, 1, 3, 5
        has three inversions (2, 1), (4, 1), (4, 3).
        Example 2:

        Input: N = 5
        arr[] = {2, 3, 4, 5, 6}
        Output: 0
        Explanation: As the sequence is already
        sorted so there is no inversion count.
        Example 3:

        Input: N = 3, arr[] = {10, 10, 10}
        Output: 0
        Explanation: As all the elements of array
        are same, so there is no inversion count.

        Solution: Merge sort
        Time  Complexity : O(nlog(n))
        Space Complexity: O(n)
 */
public class CountInversions {
    long inversionCount(long[] nums, long N) {
        return inversionCountUtils(nums, 0, nums.length - 1);
    }

    long inversionCountUtils(long[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            long L = inversionCountUtils(nums, start, mid);
            long R = inversionCountUtils(nums, mid + 1, end);
            return L + R + merge(nums, start, mid, end);
        }
        return 0;
    }

    long merge(long[] nums, int start, int mid, int end) {
        long inv = 0;

        long[] merged = new long[end - start + 1];

        int k = 0;
        int i = start, j = mid + 1;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                merged[k++] = nums[i++];
            } else {
                // if A[i]>A[j] and i<j
                // mid+1 represents starting point of right sub-array
                // If a[i] is greater than a[j], then there are (mid – i) inversions
                // because left and right sub-arrays are sorted,
                // so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
                inv += (mid + 1) - i;
                merged[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            merged[k++] = nums[i++];
        }
        while (j <= end) {
            merged[k++] = nums[j++];
        }

        k = 0;
        for (int x = start; x <= end; x++) {
            nums[x] = merged[k++];
        }

        return inv;
    }

    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5};
        System.out.println(new CountInversions().inversionCount(arr, arr.length - 1));
    }
}