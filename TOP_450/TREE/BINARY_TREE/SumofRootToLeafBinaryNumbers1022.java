package TOP_450.TREE.BINARY_TREE;
/*
You are given the root of a binary tree where each node has a value 0 or 1.
Each root-to-leaf path represents a binary number starting with the most significant bit.
For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.

Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 */


import TOP_450.TREE.TreeNode;

class SumOfRootToLeafBinaryNumbers1022 {
    private int sumRootToLeafUtils(TreeNode root, String s) {
        if (null == root) {
            return 0;
        }

        //leaf node
        if (root.left == null && root.right == null) {
            s += Integer.toString(root.val);
            System.out.println(s);
            return Integer.parseInt(s, 2);
        }

        s += Integer.toString(root.val);

        return sumRootToLeafUtils(root.left, s) + sumRootToLeafUtils(root.right, s);
    }

    public int sumRootToLeaf(TreeNode root) {
        String s = "";
        return sumRootToLeafUtils(root, s);
    }

    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers1022 sumOfRootToLeafBinaryNumbers1022 = new SumOfRootToLeafBinaryNumbers1022();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sumOfRootToLeafBinaryNumbers1022.sumRootToLeaf(root));
    }
}