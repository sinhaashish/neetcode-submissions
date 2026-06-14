class Solution {
    public boolean isValidSudoku(char[][] board) {
        for( int i =0 ; i < 9 ; i++) {
            for( int j =0 ; j < 9 ; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    board[i][j] ='.';
                    if (!isValid(board, i, j , ch)){
                        return false;
                    }
                    board[i][j] =ch;
                    
                }
            
            }
        }
        return true;   
    }

    public boolean isValid(char[][] board, int row , int col , char ch) {
        for (  int k =0 ; k < 9 ; k++) {
            if (board[row][k] == ch) {
                return false;
            }
            if (board[k][col] == ch) {
                return false;
            }
            if (board[3*(row/3)+k/3][3*(col/3)+k%3] == ch) {
                return false;
            }
            
        }
        return true;
    }
}
