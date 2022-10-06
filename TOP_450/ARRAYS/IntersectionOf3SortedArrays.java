package TOP_450.ARRAYS;

import java.util.ArrayList;

/*
    Problem: Common Elements- https://practice.geeksforgeeks.org/problems/common-elements1132/1
    Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
    Note: can you take care of the duplicates without using any additional Data Structure?

    Example 1:

    Input:
    n1 = 6; A = {1, 5, 10, 20, 40, 80}
    n2 = 5; B = {6, 7, 20, 80, 100}
    n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}

    Output: 20 80
    Explanation: 20 and 80 are the only
    common elements in A, B and C

    Solution:
    1. If current element A[i]=B[j]=C[k] , add it to result.
        i++, j++, k++
    2. If A[i]<B[j], i needs to be incremented, inorder A can reach B
        i++;
    3. If B[j]<C[k], j needs to be incremented, inorder B can reach C
        j++;
    4. Else k++; Since k needs to be incremented inorder to reach A or B.

    5. Handle Duplicate Stuff by keeping track of previous elements.

    Time Complexity:  O(n1+n2+n3)
    Space Complexity: O(1)
 */
public class IntersectionOf3SortedArrays {
    ArrayList<Integer> commonElements(int[] A, int[] B, int[] C) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length && k < C.length) {
            if (A[i] == B[j] && B[j] == C[k]) {
                res.add(A[i]);
                i++;
                j++;
                k++;
            } else if (A[i] < B[j]) {
                i++;
            } else if (B[j] < C[k]) {
                j++;
            } else {
                k++;
            }

            if (i - 1 >= 0) {
                int prev_A = A[i - 1];
                while (i < A.length && A[i] == prev_A) i++;
            }

            if (j - 1 >= 0) {
                int prev_B = B[j - 1];
                while (j < B.length && B[j] == prev_B) j++;
            }

            if (k - 1 >= 0) {
                int prev_C = C[k - 1];
                while (k < C.length && C[k] == prev_C) k++;
            }

        }

        // No common elements found
        if (res.size() == 0) {
            res.add(-1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 10, 20, 40, 80};
        int[] B = {6, 7, 20, 80, 100};
        int[] C = {3, 4, 15, 20, 30, 70, 80, 120};

        ArrayList<Integer> res = new IntersectionOf3SortedArrays().commonElements(A, B, C);
        res.forEach(num -> {
            System.out.println(num + " ");
        });
    }
}