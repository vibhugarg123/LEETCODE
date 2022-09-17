package TOP_450.TREE.BINARY_TREE;


/*      Problem: https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
        Write a function that returns true if the given Binary Tree is SumTree else false.
        A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present
        in its left subtree and right subtree. An empty tree is SumTree and the sum of an empty tree can be considered as 0.
        A leaf node is also considered as SumTree.

        Following is an example of SumTree.

                  26
                /   \
              10     3
            /    \     \
          4      6      3

          Output: true

          Time  Complexity: O(N)
          Space Complexity: O(N)
 */

public class SumTree {
    boolean x = true;

    boolean isSumTree(TreeNode root) {
        isSumTreeUtils(root);
        return x;
    }

    int isSumTreeUtils(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return root.val;
        }

        int leftSum = isSumTreeUtils(root.left);
        int rightSum = isSumTreeUtils(root.right);

        x = x && (root.val == leftSum + rightSum);
        return root.val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(110);
        root.left = new TreeNode(30);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(20);
        root.right.right = new TreeNode(10);
        System.out.println(new SumTree().isSumTree(root));
    }
}