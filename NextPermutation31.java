import java.util.Arrays;

/*
Terminology-
LDS- Longest Decreasing Subsequence

Brute Force:
1. Time Complexity: - O(N !) [to generate all permutations] +
                      O(N!logN!) [sort the permutations] +
                      O(N!) [look for desired permutation]
                      =N(!logN!)
                      OR
                      O(N!) If the permutations are generated in sorted-order.
   Space Complexity:-O(N!) for storing N! permutations.

Single-Pass Approach-
Time Complexity: O(N)
Space Complexity: O(1)
*/
class NextPermutation31 {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int j = -1;
        //Find the element which is just smaller than its previous element,
        // element just before LDS.
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //j= element just before LDS
                /*
                  For eg- [6,2,1,5,4,3,0]
                  [5,4,3,0] is the LDS
                  Element just before LDS is 1 i.e j=2
                 */
                j = i - 1;
                break;
            }
        }
        if (j == -1) {
            Arrays.sort(nums);
            return;
        }

        //Find the element just greater then j i.e element
        // just greater than the element before LDS.
        int next = j + 1;
        for (int i = j + 1; i <= nums.length - 1; i++) {
            if (nums[i] > nums[j] && nums[i] < nums[next]) {
                next = i;
            }
        }
        //swap nums[j] (element just before LDS) & nums[next] (element just greater than LDS)
        swap(nums, j, next);

        //After j, we have the new LDS. Sort the new LDS , to generate least possible value.
        //You can reverse from j+1 to end of array to optimise instead of sorting.
        Arrays.sort(nums, j + 1, nums.length);
    }

    public static void main(String[] args) {
        NextPermutation31 nextPermutation31 = new NextPermutation31();
        nextPermutation31.nextPermutation(new int[]{6, 2, 1, 5, 4, 3, 0});
    }
}
