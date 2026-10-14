
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // Base case
        if (root == null) {
            return null;
        }

        // First process left and right subtrees
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // If current node is now a leaf and matches target, delete it
        if (root.left == null && root.right == null
                && root.val == target) {
            return null;
        }

        return root;
    }
}
