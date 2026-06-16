class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count =0;
        int m = grid.length;
        int n = grid[0].length;
        int area = 0;
        for ( int i =0; i < m ; i++) {
            for ( int j =0 ;j < n ; j++) {
                if (grid[i][j]== 1) {
                    area = Math.max( area, DFS(grid,i,j));
                }
            }
        }
        return area;
        
    }

    public int DFS(int[][] grid, int i, int j) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int res = 1;
        //mark it as visited 
        grid[i][j] = 0;
        res += DFS(grid, i + 1, j)
                + DFS(grid, i - 1, j)
                + DFS(grid, i, j + 1)
                + DFS(grid, i, j - 1);
        return res;
    }
}
