package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
  Problem- https://practice.geeksforgeeks.org/problems/median-of-bst/1
  Given a Binary Search Tree of size N, find the Median of its Node values.

        Example 1:

        Input:
               6
             /   \
           3      8
         /  \    /  \
        1    4  7    9
        Output: 6
        Explanation: Inorder of Given BST will be:
        1, 3, 4, 6, 7, 8, 9. So, here median will 6.

        Example 2:

        Input:
               6
             /   \
           3      8
         /   \    /
        1    4   7
        Output: 5
        Explanation:Inorder of Given BST will be:
        1, 3, 4, 6, 7, 8. So, here median will
        (4 + 6)/2 = 10/2 = 5.
 */
public class MedianOfBST {
    int index = 0;
    TreeNode prev;

    public float findMedian(TreeNode root) {
        int numberOfNodes = countNodes(root);
        int K = (int) (Math.floor(numberOfNodes / 2.0) + 1);
        prev = null;
        TreeNode med = findMedianUtils(root, K);
        return (numberOfNodes & 1) == 1 ? med.val : (float) ((med.val + prev.val) / 2.0);
    }

    private TreeNode findMedianUtils(TreeNode root, int K) {
        if (null == root) return null;
        TreeNode left = findMedianUtils(root.left, K);
        if (null != left) return left;
        index++;
        if (index == K) {
            return root;
        }
        prev = root;
        return findMedianUtils(root.right, K);
    }

    private int countNodes(TreeNode root) {
        if (null == root) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(new MedianOfBST().findMedian(root));
    }
}