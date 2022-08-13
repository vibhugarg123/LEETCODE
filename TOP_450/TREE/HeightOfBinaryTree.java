package TOP_450.TREE;
/*
   Given a binary tree, find its height.
   Link: https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/

Example 1:
                Input:
                     1
                    /  \
                   2    3
                Output: 2
                Example 2:

                Input:
                  2
                   \
                    1
                   /
                 3
                Output: 3

                Your Task:
                You don't need to read input or print anything. Your task is to complete the function height()
                which takes root node of the tree as input parameter and returns an
                integer denoting the height of the tree. If the tree is empty, return 0.

                Expected Time Complexity: O(N)
                Expected Auxiliary Space: O(N)

                Solution:
                  1. If the tree is empty, return 0.
                  2. Call the height of left subtree & call height of right subtree recursively.
                  3. Find max (height(root.left), height(root.right)) +1

 */
public class HeightOfBinaryTree {
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), (height(root.right))) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();
        System.out.println(heightOfBinaryTree.height(root));
    }
}
