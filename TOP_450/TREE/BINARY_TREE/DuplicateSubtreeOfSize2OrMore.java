package TOP_450.TREE.BINARY_TREE;

import TOP_450.TREE.TreeNode;

import java.util.HashMap;

/*
        Problem- https://www.geeksforgeeks.org/check-binary-tree-contains-duplicate-subtrees-size-2/

        Given a Binary Tree, check whether the Binary tree contains a duplicate subtree of size 2 or more.
        Note : Two same leaf nodes are not considered as subtree size of a leaf node is one.

        Input :  Binary Tree
                       A
                     /    \
                   B        C
                 /   \       \
                D     E       B
                             /  \
                            D    E
        Output : Yes
 */
public class DuplicateSubtreeOfSize2OrMore {

    int isDup = 0;

    public int dupSub(TreeNode root) {
        HashMap<String, Integer> hm = new HashMap<>();

        dupSubUtils(root, hm);
        return isDup;
    }

    private String dupSubUtils(TreeNode root, HashMap<String, Integer> hm) {
        if (null == root) {
            return "#";
        }

        String subTree = root.val + "." + dupSubUtils(root.left, hm) + "." + dupSubUtils(root.right, hm);
        hm.put(subTree, hm.getOrDefault(subTree, 0) + 1);

        // serialization of leaf node : root.val + "." + "#" + "." + "#"
        if (!subTree.equals(root.val + "." + "#" + "." + "#") && hm.get(subTree) >= 2) {
            isDup = 1;
        }

        return subTree;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(3);

        System.out.println(new DuplicateSubtreeOfSize2OrMore().dupSub(root));
    }
}