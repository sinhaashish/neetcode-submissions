class Solution {
    public List<List<String>> solveNQueens(int n) {
        int board[][] = new int[n][n];
        List<List<String>> result = new ArrayList<List<String>> ();
        populateBoard(board,0, new HashSet(), new HashSet(), new HashSet(),result);
        return result;
    }

    public void populateBoard(int[][] board, int i , HashSet<Integer> diag1 , HashSet<Integer> diag2 , HashSet<Integer> column , List<List<String>> result ) {
            
            if ( i == board.length) {
                List<String> row  = new ArrayList<>();
                
                for ( int k =0 ; k < board.length ; k++) {
                    StringBuilder sb = new StringBuilder();
                    for ( int l =0 ; l < board.length ; l++) {
                        if(board[k][l] == 1) {
                            sb.append('Q');
                        } else {
                            sb.append('.');
                        }
                    }
                    row.add(sb.toString());
                }
                result.add(row);
                return ;
                
            }
            for( int j =0 ; j <board.length ; j++) {
                if ( !diag1.contains(i+j) &&  !diag2.contains(j-i) && !column.contains(j)) {
                    board[i][j] = 1;
                    diag1.add(i+j);
                    diag2.add(j-i);
                    column.add(j);
                    populateBoard(board, i+1, diag1, diag2, column, result);
                    diag1.remove(i+j);
                    diag2.remove(j-i);
                    column.remove(j); 
                    board[i][j]= 0;
                }
            }
        }
    }

