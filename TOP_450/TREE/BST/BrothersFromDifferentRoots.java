package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
       Problem: https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1
       Given two BSTs containing N1 and N2 distinct nodes respectively and given a value x.
       Your task is to complete the function countPairs(),
       that returns the count of all pairs from both the BSTs whose sum is equal to x.

        Example 1:

            Input:

            BST1:
                   5
                 /   \
                3     7
               / \   / \
              2   4 6   8

            BST2:
                   10
                 /    \
                6      15
               / \    /  \
              3   8  11   18

            x = 16
            Output:
            3

            Explanation:
            The pairs are: (5, 11), (6, 10) and (8, 8)
 */
public class BrothersFromDifferentRoots {

    int countPairs;

    public int countPairs(TreeNode root1, TreeNode root2, int x) {
        if (null == root1 || null == root2) return 0;

        countPairs = 0;
        countPairsUtils(root1, root2, x);
        return countPairs;
    }

    private boolean search(TreeNode root, int x) {
        if (null == root) return false;
        if (root.val == x) return true;
        if (x > root.val)
            return search(root.right, x);
        return search(root.left, x);
    }

    public void countPairsUtils(TreeNode root1, TreeNode root2, int x) {
        if (null == root1) return;
        countPairsUtils(root1.left, root2, x);
        if (search(root2, x - root1.val)) {
            countPairs++;
            System.out.println(root1.val + " " + (x - root1.val));
        }
        countPairsUtils(root1.right, root2, x);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(1);

        System.out.println(new BrothersFromDifferentRoots().countPairs(root1, root2, 4));
    }
}