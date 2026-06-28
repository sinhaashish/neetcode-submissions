class Solution {

    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Add all treasure cells
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                    continue;

                // Only process unvisited land
                if (grid[nr][nc] != Integer.MAX_VALUE)
                    continue;

                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}