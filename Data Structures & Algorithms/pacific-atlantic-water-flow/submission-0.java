class Solution {

    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row
        for (int c = 0; c < cols; c++)
            dfs(0, c, heights, pacific);

        // Pacific: left column
        for (int r = 0; r < rows; r++)
            dfs(r, 0, heights, pacific);

        // Atlantic: bottom row
        for (int c = 0; c < cols; c++)
            dfs(rows - 1, c, heights, atlantic);

        // Atlantic: right column
        for (int r = 0; r < rows; r++)
            dfs(r, cols - 1, heights, atlantic);

        List<List<Integer>> ans = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    ans.add(Arrays.asList(r, c));
                }
            }
        }

        return ans;
    }

    int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    private void dfs(int r, int c,
                     int[][] heights,
                     boolean[][] visited) {

        visited[r][c] = true;

        for (int[] d : dirs) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                continue;

            if (visited[nr][nc])
                continue;

            // Reverse flow: only move to equal or higher height
            if (heights[nr][nc] < heights[r][c])
                continue;

            dfs(nr, nc, heights, visited);
        }
    }
}