class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int k =0;
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i =0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for( int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> q = new LinkedList();
        for ( int i =0 ; i < numCourses; i++) {
            if(indegree[i] == 0) {
                order[k++] = i;
                q.offer(i);
            }
        }
        int visitedNode = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            visitedNode++;
            for ( int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0 ) {
                    order[k++] = neighbour;
                    q.offer(neighbour);
                }
            }
        }
        return k == numCourses? order : new int[0];
        
    }
}
