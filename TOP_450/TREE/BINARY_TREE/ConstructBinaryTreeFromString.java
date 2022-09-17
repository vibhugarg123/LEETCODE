package TOP_450.TREE.BINARY_TREE;

/*
   Problem- https://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/

   Construct a binary tree from a string consisting of parenthesis and integers.
   The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
   The integer represents the roots value and a pair of parenthesis contains a child binary tree with the same structure.
   Always start to construct the left child node of the parent first if it exists.

        Example 1:

        Input: "1(2)(3)"
        Output: 2 1 3
        Explanation:
                   1
                  / \
                 2   3
        Explanation: first pair of parenthesis contains
        left subtree and second one contains the right
        subtree. Inorder of above tree is "2 1 3".
        Example 2:

        Input: "4(2(3)(1))(6(5))"
        Output: 3 2 1 4 5 6
        Explanation:
                   4
                 /   \
                2     6
               / \   /
              3   1 5
 */
public class ConstructBinaryTreeFromString {

    int start = 0;

    private TreeNode getNewNode(String s) {
        boolean isNegative = false;
        // Condition to check for negative number
        if (s.charAt(start) == '-') {
            isNegative = true;
            start++;
        }

        // This loop basically construct the
        // number from the continuous digits
        int num = 0;
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            int digit = Character.getNumericValue(s.charAt(start));
            num = num * 10 + digit;
            start++;
        }

        // If string contains - minus sign
        // then append - to the number;
        if (isNegative)
            num = -num;
        return new TreeNode(num);
    }

    public TreeNode treeFromString(String s) {
        if (null == s || s.length() == 0 || start >= s.length()) {
            return null;
        }

        TreeNode node = getNewNode(s);
        if (start >= s.length()) {
            return node;
        }

        // Check for open bracket and add the data to the left subtree recursively
        if (s.charAt(start) == '(') {
            start++;
            node.left = treeFromString(s);
        }

        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }

        // Check for open bracket and add the data to the right subtree recursively
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.right = treeFromString(s);
        }

        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }
        return node;
    }

    public static void main(String[] args) {
        String s = "10(7(3(1(2))(6(5(4))))(9(8)))";
        ConstructBinaryTreeFromString constructBinaryTreeFromString = new ConstructBinaryTreeFromString();
        TreeNode root = constructBinaryTreeFromString.treeFromString(s);
        root.inorderTraversal(root);
    }
}