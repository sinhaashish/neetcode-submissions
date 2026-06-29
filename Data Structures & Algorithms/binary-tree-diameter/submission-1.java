class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if ( root == null) { return 0; }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(leftHeight +rightHeight  , Math.max(leftDiameter,rightDiameter ));
    }

    public int maxDepth(TreeNode root ) {
        return  root == null ? 0 : 
        1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
    }
}
