package TOP_450.TREE;

/*
    Problem- https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1

    Example 1:

        Input:
                     10
                  /      \
                -2        6
               /   \     /  \
             8     -4   7    5

        Output:
                    20
                  /    \
                4        12
               /  \     /  \
             0     0   0    0

        Explanation:

                   (4-2+12+6)
                  /           \
              (8-4)          (7+5)
               /   \         /  \
              0     0       0    0
        Expected Time Complexity: O(N)
        Expected Auxiliary Space: O(height of tree)

 */
public class ConvertToSumTree {

    public void toSumTree(TreeNode root) {
        toSumTreeUtils(root);
    }

    private int toSumTreeUtils(TreeNode root) {
        if (null == root) return 0;
        if (null == root.left && null == root.right) {
            int temp = root.val;
            root.val = 0;
            return temp;
        }
        int lSum = toSumTreeUtils(root.left);
        int rSum = toSumTreeUtils(root.right);

        int temp = root.val;
        root.val = lSum + rSum;
        return temp + lSum + rSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        ConvertToSumTree convertToSumTree = new ConvertToSumTree();
        convertToSumTree.toSumTree(root);
        root.inorderTraversal(root);
    }
}