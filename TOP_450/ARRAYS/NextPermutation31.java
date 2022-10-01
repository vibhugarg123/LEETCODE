package TOP_450.ARRAYS;

/*
    Problem-31: https://leetcode.com/problems/next-permutation/

    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are all the permutations of arr:
    [1,2,3], [1,3,2],
    [2, 1, 3], [2, 3, 1],
    [3,1,2], [3,2,1].
    The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
    More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
    then the next permutation of that array is the permutation that follows it in the sorted container.
    If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].

    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
    Given an array of integers nums, find the next permutation of nums.

    The replacement must be in place and use only constant extra memory.
    Example 1:

    Input: nums = [1,2,3]
    Output: [1,3,2]
    Example 2:

    Input: nums = [3,2,1]
    Output: [1,2,3]
    Example 3:

    Input: nums = [1,1,5]
    Output: [1,5,1]

    Case-1: In descending order, no next larger permutation is possible.
            For example, no next permutation is possible for the following array:
            [9, 5, 4, 3, 1]

      1,5,8,4,7,6,5,3,1
      1. Find the first decreasing element.
         1->3->5->6-7 increasing, from 7 to 4 decreasing. j=3
      2. Find number just larger than 4 i.e 5 at index i=6
      3. Swap i and j
        1,5,8,5,7,6,4,3,1
      4. Reverse from j+1 i.e 4 to nums.length()-1
 */
public class NextPermutation31 {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        //1. Find first decreasing element from end of array
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            //2. find element just greater than element at ith index
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 3. swap element at i and j
            swap(nums, i, j);
        }

        //4. Reverse the array from i+1 till length of array
        reverse(nums, i + 1, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        NextPermutation31 nextPermutation31 = new NextPermutation31();
        nextPermutation31.nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}