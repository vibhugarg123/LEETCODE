package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
      Problem: https://leetcode.com/problems/search-in-a-binary-search-tree/

                4
              /  \
            2     7
          /  \
         1   3

        Input: root = [4,2,7,1,3], val = 2
        Output: [2,1,3]
 */
public class SearchInBST700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) return null;
        if (root.val == val) return root;
        if (val < root.val)
            return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        SearchInBST700 searchInBST700 = new SearchInBST700();
        TreeNode res = searchInBST700.searchBST(root, 2);
        res.preOrderTraversal(res);
    }
}
