package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

/*
        Problem: https://leetcode.com/problems/delete-node-in-a-bst/

        Case-1: When node is a leaf node, do nothing
                    5
                  /  \
                 4    6

        Case-2-a) : When node's leaf child is null, delete 4 i. the new root would be 4's right
                    6       6
                  /        /
                4         5
                 \
                 5
         Case-2-b) : When node's right child is null, delete 6 i.e the new root would be 6's left
                    6        4
                  /           \
                4              5
                 \
                 5
          Case-3: when both left child & right child is not null, delete 3
                      5
                   /   \
                  3     6
               /   \     \
              2     4     7

                Inorder: 2 3 4 5 6 7
                New Inorder: 2 4 5 6 7

                Replace 3 with next inorder successor, which is minimum value in right subtree of 3
                      5
                   /   \
                  4     6
               /   \     \
              2     4     7
              Now delete the inorder successor i.e 4 from right subtree recursively.
                      5
                   /   \
                  4     6
               /         \
              2           7

              Time Complexity:
              The worst case time complexity of delete operation is O(h) where h is the height of the Binary Search Tree.
              In worst case, we may have to travel from the root to the deepest leaf node.
              The height of a skewed tree may become n and the time complexity of delete operation may become O(n)
 */

public class DeletionOfNodeBST450 {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) return root;
        if (key < root.val) {
            //Deletion of key from root's left subtree, will result in new root.left
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            //Deletion of key from root's right subtree, will result in new root.right
            root.right = deleteNode(root.right, key);
        } else {
            //Case-1: When node to be deleted is leaf or the left child is null
            if (null == root.left)
                return root.right;
                //Case-2: When node to be deleted right child is null
            else if (null == root.right)
                return root.left;
            // Case-3: When neither left child is null nor right child is null
            // Update current node data with the inorder successor of current node i.e, minimum in right subtree of current node
            root.val = TreeMinimum(root.right);
            // Delete the minimum node from right subtree
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int TreeMinimum(TreeNode root) {
        int minV = root.val;
        while (null != root.left) {
            minV = root.left.val;
            root = root.left;
        }
        return minV;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        DeletionOfNodeBST450 deletionOfNodeBST450 = new DeletionOfNodeBST450();
        System.out.println("Inorder Traversal Before deleting leaf");
        root.inorderTraversal(root);
        root = deletionOfNodeBST450.deleteNode(root, 4);
        System.out.println("Inorder Traversal After deleting leaf");
        root.inorderTraversal(root);
    }
}