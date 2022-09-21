package TOP_450.TREE.BST;

/*
       Problem: https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
       Given a Binary Tree, write a function to populate next pointer for all nodes.
       The next pointer for every node should be set to point to inorder successor.

            Example 1:

            Input:
                       10
                   /  \
                  8    12
                 /
                3

            Output: 3->8 8->10 10->12 12->-1
            Explanation: The inorder of the above tree is :
            3 8 10 12. So the next pointer of node 3 is
            pointing to 8 , next pointer of 8 is pointing
            to 10 and so on.And next pointer of 12 is
            pointing to -1 as there is no inorder successor
            of 12.
 */

class Node {
    int data;
    Node left, right, next;

    public Node(int data) {
        this.data = data;
    }
}

public class InorderSuccessorOfAllNodes {

    Node prev = null;

    public void populateNext(Node root) {
        if (null == root) return;

        populateNext(root.left);

        if (null != prev) prev.next = root;

        prev = root;
        populateNext(root.right);
    }

    private void printInorderNext(Node root) {
        if (null == root) return;
        printInorderNext(root.left);
        System.out.println(root.data + " " + (root.next == null ? null : root.next.data));
        printInorderNext(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);

        InorderSuccessorOfAllNodes inorderSuccessorOfAllNodes = new InorderSuccessorOfAllNodes();
        inorderSuccessorOfAllNodes.populateNext(root);
        inorderSuccessorOfAllNodes.printInorderNext(root);
    }
}