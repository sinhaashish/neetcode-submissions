/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
             return new ArrayList<Integer>() ;
        }
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            System.out.println(" size" + size);
            for (int i = 0 ; i < size; i++) {
                TreeNode temp = q.poll();
                if ( i == size-1) {
                    result.add(temp.val);
                }
                if (temp.left != null){
                    q.offer(temp.left);
                }
                if (temp.right != null){
                    q.offer(temp.right);
                }

            }
        }
        return result;
    }
}
