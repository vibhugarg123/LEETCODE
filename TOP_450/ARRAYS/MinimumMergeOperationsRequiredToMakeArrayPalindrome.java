package TOP_450.ARRAYS;

/*
    Problem: https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
    Given an array of positive integers. We need to make the given array a ‘Palindrome’.
    The only allowed operation is "merging" (of two adjacent elements). Merging two adjacent elements means replacing them with their sum.
    The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.

    Example :

    Input : arr[] = {15, 4, 15}
    Output : 0
    Array is already a palindrome. So we
    do not need any merge operation.

    Input : arr[] = {1, 4, 5, 1}
    Output : 1
    We can make given array palindrome with
    minimum one merging (merging 4 and 5 to
    make 9)

    Input : arr[] = {11, 14, 15, 99}
    Output : 3
    We need to merge all elements to make
    a palindrome.
    The expected time complexity is O(n).

    Solution: (Using 2-pointer approach)
    - We start i from 0 and j from n-1.
    - If arr[i] == arr[j], then there is no need to do any merging operations at index i or index j.
    - Else, we need to do merging operations. Following cases arise.
        - For the case when arr[i] < arr[j], update arr[i+1] = arr[i+1] + arr[i]. Our answer in this case will be 1 + f(i+1, j).
        - If arr[i] > arr[j], then we should do merging operation at index j. We merge index j-1 and j, and update arr[j-1] = arr[j-1] + arr[j].
         Our answer in this case will be 1 + f(i, j-1).

         Time Complexity: O(n)
         Auxiliary Space: O(1)

        Example:
        [1,11,14,15,99,1]
        - i=0, elem=1
          j=5, elem=1
          elem at i=0 and j=5 are same.
          mergeOperations=0
       - i=1, elem=11
         j=4, elem=99
         elem at i=1 i.e 11<99
         try to club elements from left side, so that it might be equal to elem on right side.
         i=2, arr[2]=arr[2]+arr[1]=25
         [1,11,25,15,99,1]
         mergeOperations=1
      -  i=2, j=4
         elem at index 2 i.e 25<99
         try to club elements from left side, so that it might be equal to elem on right side.
         i=3, arr[3]=arr[3]+arr[2]=15+25=40
         [1,11,25,40,99,1]
         mergeOperations=2
      -  i=3, j=4
         40<99
         arr[4]=arr[4]+arr[3]
         arr[4]=99+40= 139
         [1,11,25,40,139,1]
         mergeOperations=3
      - i=4, j=4 stop

      Number of merge operations minimum=3
 */
public class MinimumMergeOperationsRequiredToMakeArrayPalindrome {

    int MinimumOperations(int[] nums) {
        int i = 0, j = nums.length - 1;
        int counter = 0;

        while (i < j) {

            if (nums[i] == nums[j]) {
                i++;
                j--;
            } else if (nums[i] < nums[j]) {
                i++;
                nums[i] = nums[i] + nums[i - 1];
                counter++;
            } else {
                j--;
                nums[j] = nums[j] + nums[j + 1];
                counter++;
            }

        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {1, 11, 25, 40, 139, 1};

        System.out.println(new MinimumMergeOperationsRequiredToMakeArrayPalindrome().MinimumOperations(nums));
    }
}