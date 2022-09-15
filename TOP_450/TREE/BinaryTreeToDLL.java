package TOP_450.TREE;

/*
    Problem- https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
        Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
        The left pointer  = previous pointer
            right pointer = next pointer
        The order of nodes in DLL must be the same as in Inorder for the given Binary Tree.
        The first node of Inorder traversal (LNR) must be the head node of the DLL.

        Input:
               10
              /   \
             20   30
           /   \
          40   60

        Output:
        40 20 60 10 30
        30 10 60 20 40
        Explanation:  DLL would be
        40<=>20<=>60<=>10<=>30.

        Solution:
        The idea is to do in order traversal of the binary tree.
            - While doing inorder traversal, keep track of the previously visited node in a variable, say prev.
            - For every visited node, make it right to the prev and left of this node as prev.
            - Return head node.


         Dry-Run:
            10
           /
         20

         1. While doing inorder, we reach to 20
            At 20, prev=null, hence make 20 as head.
                   prev=20; i.e prev becomes current node
         2. Go back to 10
            At 10, since prev!=null i.e prev=20
            prev->right=current or root 20->right=10
            root->left=prev.  10->left=20
            previous becomes 10 now.
 */
public class BinaryTreeToDLL {

    TreeNode head;
    TreeNode prev;

    TreeNode bToDLL(TreeNode root) {
        bToDLLUtils(root);
        return head;
    }

    void bToDLLUtils(TreeNode root) {
        if (null == root) return;
        bToDLLUtils(root.left);

        //Only head can have prev=null
        if (null == prev) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        bToDLLUtils(root.right);
    }

    private void printDLL(TreeNode root) {
        TreeNode temp = root;
        while (null != temp) {
            System.out.print(temp.val + " ");
            temp = temp.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);

        BinaryTreeToDLL binaryTreeToDLL = new BinaryTreeToDLL();
        binaryTreeToDLL.printDLL(binaryTreeToDLL.bToDLL(root));
    }
}