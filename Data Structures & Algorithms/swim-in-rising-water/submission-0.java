class Solution {

    class Cell {
        int row;
        int col;
        int time;

        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<Cell> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);

        boolean[][] visited = new boolean[n][n];

        pq.offer(new Cell(0, 0, grid[0][0]));

        int[][] dir = {
                {1,0},{-1,0},{0,1},{0,-1}
        };

        while (!pq.isEmpty()) {

            Cell current = pq.poll();

            int r = current.row;
            int c = current.col;

            if (visited[r][c])
                continue;

            visited[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return current.time;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;

                if (visited[nr][nc])
                    continue;

                int newTime = Math.max(current.time,
                                       grid[nr][nc]);

                pq.offer(new Cell(nr, nc, newTime));
            }
        }

        return -1;
    }
}