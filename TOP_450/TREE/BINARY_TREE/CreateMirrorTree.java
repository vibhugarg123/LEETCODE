package TOP_450.TREE.BINARY_TREE;

/*
 Problem: https://www.geeksforgeeks.org/create-a-mirror-tree-from-the-given-binary-tree/
 Given a binary tree, the task is to create a new binary tree which is a mirror image of the given binary tree.

        Examples:

        Input:
                5
               / \
              3   6
             / \
            2   4
        Output:
        Inorder of original tree: 2 3 4 5 6
        Inorder of mirror tree: 6 5 4 3 2
        Mirror tree will be:
          5
         / \
        6   3
           / \
          4   2

        Input:
                2
               / \
              1   8
             /     \
            12      9
        Output:
        Inorder of original tree: 12 1 2 8 9
        Inorder of mirror tree: 9 8 2 1 12

 Solution: In order to change the original tree in its mirror tree,
           then we simply swap the left and right link of each node. If the node is leaf node then do nothing.
           Use post-order traversal.
 */
public class CreateMirrorTree {
    public void createMirror(TreeNode root) {
        if (null == root) {
            return;
        }
        //Traverse post-order
        createMirror(root.left);
        createMirror(root.right);

        //Swap left & right link
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        System.out.println("Original Level Order Traversal");
        root.inorderTraversal(root);

        CreateMirrorTree createMirrorTree = new CreateMirrorTree();
        createMirrorTree.createMirror(root);
        System.out.println("\nMirror Level Order Traversal");
        root.inorderTraversal(root);
    }
}
