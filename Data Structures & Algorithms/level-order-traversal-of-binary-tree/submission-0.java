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
    public List<List<Integer>> levelOrder(TreeNode root) {

         if (root == null) {
             return new ArrayList(new ArrayList<Integer>()) ;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<Integer>();
            for (int i = 0 ; i < size; i++) {
                TreeNode temp = q.poll();
                row.add(temp.val);
                if (temp.left != null){
                    q.offer(temp.left);
                }
                if (temp.right != null){
                    q.offer(temp.right);
                }

            }
            result.add(row);
        }
        return result;
        
    }
}
