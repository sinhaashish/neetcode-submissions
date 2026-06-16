class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int minutes =0;
        int m = grid.length;
        int n = grid[0].length;
        int fresh =0;
        // count frest oranges and populate the place for rotten oranges
        for ( int i =0 ; i < m ; i++) {
            for ( int j =0 ; j < n ; j++) {
                if ( grid[i][j] == 2 ) {
                    q.offer( new int[]{i,j});
                }
                if ( grid[i][j] == 1 ) {
                    fresh++;
                }
            }
        }
        if ( fresh ==0 ) { 
            return 0;
        }
        int[][] directions = new int[][]{{0,1}, {0, -1}, { 1,0} , { -1,0}};
        while(fresh >0 && !q.isEmpty()) {
            int size = q.size();
            for ( int i =0 ; i < size; i ++) {
                int[] current = q.poll();
                int row = current[0];
                int column = current[1];
                for ( int[] dir : directions) {
                    int r = row + dir[0];
                    int c = column + dir[1];
                    if ( r>=0 && r < grid.length && c>=0 && c < grid[0].length && grid[r][c] ==1) {
                        grid[r][c] =2;
                        q.offer(new int[]{ r,c});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
        
    }
}
