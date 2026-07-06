class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)  return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true; 
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

     public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) {
            return true;
        }
         if ( p == null || q == null) {
            return false;
        }
        return ((p.val == q.val) && isSameTree(p.left , q.left) 
        && isSameTree(p.right , q.right));
        
    }

    // public boolean isIdentical(TreeNode a, TreeNode b) {
    //     if (a == null && b == null)  return true;
    //     if (a != null && b != null) {
    //         return a.val == b.val &&
    //                isIdentical(a.left, b.left) &&
    //                isIdentical(a.right, b.right);
    //     }
    //     return false;
    // }
}