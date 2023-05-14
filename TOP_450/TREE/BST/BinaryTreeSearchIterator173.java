package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

import java.util.Stack;

/*
        Problem-173: https://leetcode.com/problems/binary-search-tree-iterator/description/
 */
public class BinaryTreeSearchIterator173 {
    Stack<TreeNode> st = new Stack<>();

    public BinaryTreeSearchIterator173(TreeNode root) {
        store(root);
    }

    public void store(TreeNode root) {
        if (null == root) return;
        store(root.right);
        st.push(root);
        store(root.left);
    }

    public int next() {
        if (!st.isEmpty()) {
            return st.pop().val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BinaryTreeSearchIterator173 binaryTreeSearchIterator173 = new BinaryTreeSearchIterator173(root);
        System.out.println(binaryTreeSearchIterator173.next());     // return 3
        System.out.println(binaryTreeSearchIterator173.next());    // return 7
        System.out.println(binaryTreeSearchIterator173.hasNext()); // return True
        System.out.println(binaryTreeSearchIterator173.next());    // return 9
        System.out.println(binaryTreeSearchIterator173.hasNext()); // return True
        System.out.println(binaryTreeSearchIterator173.next());    // return 15
        System.out.println(binaryTreeSearchIterator173.hasNext()); // return True
        System.out.println(binaryTreeSearchIterator173.next());    // return 20
        System.out.println(binaryTreeSearchIterator173.hasNext()); // return False
    }
}