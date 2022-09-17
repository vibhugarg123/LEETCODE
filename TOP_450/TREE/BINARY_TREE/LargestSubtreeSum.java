package TOP_450.TREE.BINARY_TREE;

/*
    Problem:
    You have been given a Binary Tree of integers. You are supposed to return the largest subtree sum in the given Binary Tree.
    Definition: The subtree sum of a node is defined as the sum of all the node values
               formed by the subtree rooted at that node (including the node itself).


                                        Input :   1
                                                /   \
                                               2      3
                                              / \    / \
                                             4   5  6   7
                                    Output : 28
                                    As all the tree elements are positive,
                                    the largest subtree sum is equal to
                                    sum of all tree elements.

                                    Input :       1
                                                /    \
                                              -2      3
                                              / \    /  \
                                             4   5  -6   2
                                    Output : 7
                                    Subtree with the largest sum is :  -2
                                                                      /  \
                                                                     4    5
                                    Also, entire tree sum is also 7.

                                    Time Complexity:  O(N)
                                    Space Complexity: O(N)

           Approach :
                Do post order traversal of the binary tree.
                At every node, find left subtree value and right subtree value recursively.
                The value of subtree rooted at current node is equal to sum of current node value, left node subtree sum and right node subtree sum.
                Compare current subtree sum with overall maximum subtree sum so far.
 */
public class LargestSubtreeSum {

    int max = Integer.MIN_VALUE;

    public int findLargestSubtreeSum(TreeNode root) {
        findLargestSubtreeSumUtils(root);
        return max;
    }

    public int findLargestSubtreeSumUtils(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            max = Math.max(max, root.val);
            return root.val;
        }
        int leftSum = findLargestSubtreeSumUtils(root.left);
        int rightSum = findLargestSubtreeSumUtils(root.right);

        max = Math.max(max, root.val + leftSum + rightSum);
        return root.val + leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);

        System.out.println(new LargestSubtreeSum().findLargestSubtreeSum(root));
    }
}