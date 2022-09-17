package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*      Problem: https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
        Given a Binary search tree. Your task is to complete the function which will
        return the Kth largest element without doing any modification in Binary Search Tree.

        Example 1:
        Input:
              4
            /   \
           2     9
        k = 2
        Output: 4

        To find the Kth largest element in a Binary search tree,
        the simplest logic is to do reverse inorder traversal and while doing reverse inorder traversal simply keep a count of number of Nodes visited.
         When the count becomes equal to k, we stop the traversal and print the data.
         It uses the fact that reverse inorder traversal will give us a list sorted in descending order.
 */
public class KthLargestElementBST {

    int counter = 0;

    public int kthLargest(TreeNode root, int K) {
        if (null == root) return -1;

        int x = kthLargest(root.right, K);
        if (x != -1) return x;
        counter++;
        if (counter == K) return root.val;
        return kthLargest(root.left, K);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(new KthLargestElementBST().kthLargest(root, 1));
    }
}