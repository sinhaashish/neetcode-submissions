class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
          // First and last column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        // First and last row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) { 
            for (int j = 0; j < n; j++) { 
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }



        
    }

     public void dfs(char[][] edges, int i , int j ) {
        if ( i < 0 || i >= edges.length || j < 0 || j >= edges[0].length || edges[i][j] != 'O' ) {
             return;
        }
        edges[i][j] = 'T';
        dfs(edges, i+1, j);
        dfs(edges, i-1, j);
        dfs(edges, i, j+1);
        dfs(edges, i, j-1);
    }
}
