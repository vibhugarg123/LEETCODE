package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/*
        Problem: https://www.geeksforgeeks.org/replace-every-element-with-the-least-greater-element-on-its-right/

        Given an array of integers, replace every element with the least greater
        element on its right side in the array. If there are no greater elements on the right side, replace it with -1.

            Examples:

            Input: [8, 58, 71, 18, 31, 32, 63, 92,
                     43, 3, 91, 93, 25, 80, 28]
            Output: [18, 63, 80, 25, 32, 43, 80, 93,
                     80, 25, 93, -1, 28, -1, -1]

          Approach-1:
            1. Using BST. While inserting keep track of inorder-successor of each node. Insert elements in reverse order as we need just greater on the right side.
                Time Complexity: O(n*n): O(n) for insertion into BST if it's skewed tree.
            2. Using SET-
               If we traverse the array from backwards, we need  a data structure(ds) to support:
                    -  Insert an element into our ds in sorted order (so at any point of time the elements in our ds are sorted)
                    -  Finding the upper bound of the current element (upper bound will give just greater element from our ds if present)
                    -  Carefully observing at our requirements, a set is what comes in mind.
                         -   Why not multiset? Well we can use a multiset but there is no need to store an element more than once.

                Time and space complexity: We insert each element in our set and find upper bound for each element using a loop so its time complexity is O(n*log(n)).
                We are storing each element in our set so space complexity is O(n).
 */

public class ReplaceWithLeastGreaterElementOnRight {

    TreeNode succ;

    public ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        TreeNode root = null;
        ArrayList<Integer> intList = new ArrayList<>(arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            succ = null;
            // Insert current element into BST and
            // find its inorder successor
            root = insert(root, arr[i]);

            // Replace element by its inorder
            // successor in BST
            if (null != succ)
                arr[i] = succ.val;
            else
                arr[i] = -1;
            intList.add(0, arr[i]);
        }
        return intList;
    }

    public ArrayList<Integer> findLeastGreaterUsingSet(int n, int[] arr) {
        ArrayList<Integer> intList = new ArrayList<>(n);

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            treeSet.add(arr[i]);

            Integer it = treeSet.higher(arr[i]);

            if (null != it)
                arr[i] = it;
            else
                arr[i] = -1;
            intList.add(arr[i]);
        }
        Collections.reverse(intList);
        return intList;
    }

    TreeNode insert(TreeNode root, int element) {
        if (null == root) {
            return new TreeNode(element);
        }
        if (root.val > element) {
            succ = root;
            root.left = insert(root.left, element);
        } else {
            root.right = insert(root.right, element);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        //Using BST
        ArrayList<Integer> list = new ReplaceWithLeastGreaterElementOnRight().findLeastGreater(arr.length, arr);
        list.forEach(element -> {
            System.out.print(element + " ");
        });

        System.out.println();

        int[] arr2 = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        //Using TreeSet
        ArrayList<Integer> list2 = new ReplaceWithLeastGreaterElementOnRight().findLeastGreaterUsingSet(arr2.length, arr2);
        list2.forEach(element -> {
            System.out.print(element + " ");
        });

    }
}