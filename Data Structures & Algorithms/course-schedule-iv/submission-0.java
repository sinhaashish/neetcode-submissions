class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] pre = new boolean[numCourses][numCourses];

        // Step 1: Mark direct prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            pre[a][b] = true;
        }

        // Step 2: Find indirect prerequisites
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (pre[i][k] && pre[k][j]) {
                        pre[i][j] = true;
                    }
                }
            }
        }

        // Step 3: Answer each query
        List<Boolean> answer = new ArrayList<Boolean>();

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            answer.add(pre[u][v]);
        }

        return answer;
    }
}