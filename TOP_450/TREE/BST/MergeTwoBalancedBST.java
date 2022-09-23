package TOP_450.TREE.BST;

import TOP_450.TREE.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
        Problem: https://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/

        1. Do inorder traversal of the first tree and store the traversal in one temp array arr1[]. This step takes O(m) time.
        2. Do inorder traversal of the second tree and store the traversal in another temp array arr2[]. This step takes O(n) time.
        3. The arrays created in steps 1 and 2 are sorted arrays. Merge the two sorted arrays into one array of size m + n. This step takes O(m+n) time.
        4. Construct a balanced tree from the merged array. This step takes O(m+n) time.

        The time complexity of this method is O(m+n). This method takes O(m+n) time even if the input BSTs are not balanced.

        Inplace Approach:

        We can use a Doubly Linked List to merge trees in place. Following are the steps.

        1. Convert the given two Binary Search Trees into a doubly linked list in place.
        2. Merge the two sorted Linked Lists.
        3. Build a Balanced Binary Search Tree from the merged list created in step 2.
          The time complexity of this method is also O(m+n) and this method does conversion in place.
 */
public class MergeTwoBalancedBST {
    public TreeNode merge(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        storeInorder(root1, l1);
        storeInorder(root2, l2);

        List<Integer> l3 = mergeLists(l1, l2);

        return balanceBSTUtils(l3, 0, l3.size() - 1);
    }

    private TreeNode balanceBSTUtils(List<Integer> inorder, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;

        TreeNode temp = new TreeNode(inorder.get(mid));

        temp.left = balanceBSTUtils(inorder, start, mid - 1);
        temp.right = balanceBSTUtils(inorder, mid + 1, end);
        return temp;
    }

    private void storeInorder(TreeNode root, List<Integer> inorder) {
        if (null == root) return;
        storeInorder(root.left, inorder);
        inorder.add(root.val);
        storeInorder(root.right, inorder);
    }

    private List<Integer> mergeLists(List<Integer> l1, List<Integer> l2) {
        if (l1.isEmpty())
            return l2;
        if (l2.isEmpty())
            return l1;

        List<Integer> l3 = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                l3.add(l1.get(i++));
            } else {
                l3.add(l2.get(j++));
            }
        }
        while (i < l1.size()) {
            l3.add(l1.get(i++));
        }
        while (j < l2.size()) {
            l3.add(l2.get(j++));
        }
        return l3;
    }

    public static void main(String[] args) {
         /* Creating following tree as First balanced BST
                100
                / \
              50 300
            / \
           20 70
        */
        TreeNode root1 = new TreeNode(100);
        root1.left = new TreeNode(50);
        root1.right = new TreeNode(300);
        root1.left.left = new TreeNode(20);
        root1.left.right = new TreeNode(70);

        /* Creating following tree as second balanced BST
                80
                / \
              40 120
        */

        TreeNode root2 = new TreeNode(80);
        root2.left = new TreeNode(40);
        root2.right = new TreeNode(120);

        MergeTwoBalancedBST mergeTwoBalancedBST = new MergeTwoBalancedBST();
        TreeNode merged = mergeTwoBalancedBST.merge(root1, root2);
        merged.inorderTraversal(merged);
    }
}