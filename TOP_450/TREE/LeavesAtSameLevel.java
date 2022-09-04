package TOP_450.TREE;

/*
        Problem- https://www.geeksforgeeks.org/check-leaves-level/

        Given a Binary Tree, check if all leaves are at same level or not.

                          12
                        /    \
                      5       7
                    /          \
                   3            1
                  Leaves are at same level

                          12
                        /    \
                      5       7
                    /
                   3
                   Leaves are Not at same level


                          12
                        /
                      5
                    /   \
                   3     9
                  /      /
                 1      2
                 Leaves are at same level


       Solution: The idea is to first find the level of the leftmost leaf and store it in a variable leafLevel.
        Then compare level of all other leaves with leafLevel, if same, return true, else return false.

        Time Complexity: O(N)
        Space Complexity: O(N)

 */

public class LeavesAtSameLevel {
    int leafLevel;

    boolean check(TreeNode root) {
        return checkUtils(root, 0);
    }

    boolean checkUtils(TreeNode root, int level) {
        if (null == root) {
            return true;
        }
        if (null == root.left && null == root.right) {
            //Update leafLevel when you encounter leaf for the first time
            if (leafLevel == 0) {
                leafLevel = level;
            }
            // for other leaves, simply compare it with leafLevel.
            return level == leafLevel;
        }

        return checkUtils(root.left, level + 1) && checkUtils(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(15);

        System.out.println(new LeavesAtSameLevel().check(root));
    }
}