class Solution {
    class Pair {
        TreeNode node;
        int maxSoFar;
        Pair(TreeNode node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }

    public int goodNodes(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, root.val));
        int count = 0;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int maxSoFar = curr.maxSoFar;
            if (node.val >= maxSoFar) {
                count++;
            }
            int newMax = Math.max(maxSoFar, node.val);
            if (node.left != null) {
                q.offer(new Pair(node.left, newMax));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, newMax));
            }
        }

        return count;
    }
}