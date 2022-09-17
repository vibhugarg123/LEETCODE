package TOP_450.TREE;

/*
        Problem-105: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
        Given two integer arrays preorder and inorder where
                preorder is the preorder traversal of a binary tree and
                inorder is the inorder traversal of the same tree, construct and return the binary tree.

        preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        1. In pre-order traversal, first element becomes root.
            - 3 becomes root
            - Let index idx denotes 3 in inorder array.
            - left child of 3 {0,idx-1}
            - right child of 3 {idx+1, inorder.length-1}


 */
public class BinaryTreeFromInorderAndPreOrder {

    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtils(preorder, inorder, 0, inorder.length - 1);
    }

    //find target in array A
    private int find(int[] A, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (A[i] == target) return i;
        }
        return -1;
    }

    private TreeNode buildTreeUtils(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        /* Pick current node from Preorder traversal using preIndex and increment preIndex */
        TreeNode temp = new TreeNode(preorder[preOrderIndex++]);

        /* If this node has no children then return */
        if (inStart == inEnd)
            return temp;

        /*Find the index of this node in Inorder traversal */
        int inIdx = find(inorder, inStart, inEnd, temp.val);

        /* Using index in Inorder traversal, construct left and right subtrees */
        temp.left = buildTreeUtils(preorder, inorder, inStart, inIdx - 1);
        temp.right = buildTreeUtils(preorder, inorder, inIdx + 1, inEnd);
        return temp;
    }

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        TreeNode root = new BinaryTreeFromInorderAndPreOrder().buildTree(preOrder, inOrder);
        root.preOrderTraversal(root);
    }
}