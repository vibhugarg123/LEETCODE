package TOP_450.TREE;


import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
        Problem- https://www.geeksforgeeks.org/minimum-swap-required-convert-binary-tree-binary-search-tree

        Given the array representation of Complete Binary Tree i.e,
        if index i is the parent, index 2*i + 1 is the left child and index 2*i + 2 is the right child.
        The task is to find the minimum number of swap required to convert it into Binary Search Tree.

        Input : arr[] = { 5, 6, 7, 8, 9, 10, 11 }
        Output : 3
        Binary tree of the given array:
                        5
                      /  \
                     6   7
                   /  \ /  \
                 8    9 10 11

                 Solution:
                 1. Store inorder traversal of the given tree in array as inorder traversal of BST results in sorted array.
                 2. Number of comparisons to from x1 to x2 state is the answer= x1[8,6,9,5,10,7,11] -> x2[5,6,7,8,9,10,11]
                            Here, the problem became minimum number of swaps required to sort the array.
                Time Complexity: O(nlogn)
                Auxiliary Space: O(n) because it is using extra space for array
 */
public class MinimumSwapsRequiredToConvertBinaryTreeIntoBST {

    public int minSwaps(int n, int[] A) {
        // Store inorder traversal of the tree represented using array
        // left child = 2*i+1;
        // right child= 2*i+2;
        List<Integer> list = new ArrayList<>();
        inorderTraversal(A, list, 0);

        // Return minimum number of Swaps to sort an array
        return minSwapsToSortAnArray(list.stream()
                .mapToInt(Integer::intValue)
                .toArray());
    }

    private void inorderTraversal(int[] A, List<Integer> list, int index) {
        if (index >= A.length) return;
        inorderTraversal(A, list, 2 * index + 1);
        list.add(A[index]);
        inorderTraversal(A, list, 2 * index + 2);
    }


    public int minSwapsToSortAnArray(int[] A) {
        List<Pair<Integer, Integer>> pairList = new ArrayList<>();
        //Storing Pairs of elements with indices
        // Eg: A[] = { 8, 6, 9, 5, 10, 7, 11 }
        // Eg: Pairs={{8,0},
        //            {6,1},
        //            {9,2},
        //            {5,3},
        //            {10,4},
        //            {7,5},
        //            {11,6}}
        for (int i = 0; i < A.length; i++) {
            pairList.add(new Pair<>(A[i], i));
        }

        // sorting pairs of elements with indices by elements value
        // Eg: Pairs={{5,3}
        //            {6,1},
        //            {7,5},
        //            {8,0},
        //            {9,2},
        //            {10,4},
        //            {11,6}}
        pairList.sort(Comparator.comparing(o -> o.fst));

        int numberOfSwaps = 0;
        for (int i = 0; i < pairList.size(); i++) {
            Pair<Integer, Integer> temp = pairList.get(i);
            // It means you are at correct index i.e element a
            if (temp.snd == i) continue;
            //Find the correct index
            numberOfSwaps++;
            Collections.swap(pairList, i, temp.snd);
        }
        return numberOfSwaps;
    }

    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 9, 10, 11};
        int n = A.length;

        System.out.println(new MinimumSwapsRequiredToConvertBinaryTreeIntoBST().minSwaps(n, A));
    }
}