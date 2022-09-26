package TOP_450.TREE.BST;

/*
    Problem: https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1
    Given an array arr[ ] of size N consisting of distinct integers, write a program that returns 1
    if given array can represent preorder traversal of a possible BST, else returns 0.

        Example 1:

        Input:
        N = 3
        arr = {2, 4, 3}
        Output: 1
        Explanation: Given arr[] can represent preorder traversal of following BST:
                       2
                        \
                         4
                        /
                       3

         Solution:
         We will recursively visit all nodes, but we will not build the nodes.
         In the end, if the complete array is not traversed, then that means that array can not represent the preorder traversal of any binary tree.

         Time complexity: O(N)
         Auxiliary Space: O(height of the possible binary tree)
 */
public class CheckGivenArrayRepresentsPreOrderOfBST {
    int index;

    int canRepresentBST(int[] arr, int N) {
        index = 0;
        canRepresentBSTUtils(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return index == N ? 1 : 0;
    }

    void canRepresentBSTUtils(int[] arr, int min, int max) {
        if (index >= arr.length) return;
        if (arr[index] >= min && arr[index] <= max) {
            int rootData = arr[index];
            index++;
            canRepresentBSTUtils(arr, min, rootData);
            canRepresentBSTUtils(arr, rootData, max);
        }
    }

    public static void main(String[] args) {
        int[] preorder1 = {2, 4, 3};
        /*
                2
                \
                 4
                /
               3
        */
        if (new CheckGivenArrayRepresentsPreOrderOfBST().canRepresentBST(preorder1, preorder1.length) == 1)
            System.out.print("preorder1 can represent BST");
        else
            System.out.print("preorder1 can not represent BST  :(");
    }
}