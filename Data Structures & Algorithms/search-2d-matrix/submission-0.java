class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows * cols - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;

            int i = m / cols;
            int j = m % cols;

            if (target > matrix[i][j]) {
                l = m + 1;
            } else if (target < matrix[i][j]) {
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}