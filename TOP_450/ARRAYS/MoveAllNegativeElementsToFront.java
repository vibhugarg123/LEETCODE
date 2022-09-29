package TOP_450.ARRAYS;

/*
        Problem: https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/


        Efficient Approach 1:
        The idea is to simply apply the partition process of quicksort.

        Time complexity: O(N)
        Auxiliary Space: O(1)

        eg:  {-3, 3, -2, 2}
        pivot=0, i=-1 , elements on the left side of pivot<0, elements on right side of pivot >0
        Whatever elements on right side of pivot as j increases are less than 0, move them to left using i
        Here i denotes the next positive element to get swapped.

        - j=0: A[j]<0 true, i=0, swap A[i],A[j] i.e A[0], A[0] {-3,3,-2,2}
        - j=1: A[j]<0                                          {-3,3,-2,2}
        - j=2: A[j]<0 true, i=1, swap A[i],A[j] i.e A[1], A[2] {-3,-2,3,2}
        - j=3: A[j]<0

 */
public class MoveAllNegativeElementsToFront {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void segregateElements(int arr[], int n) {
        int pivot = 0;
        int i = -1;
        for (int j = 0; j <= arr.length - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-3, 3, -2, 2};
        new MoveAllNegativeElementsToFront().segregateElements(arr, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
