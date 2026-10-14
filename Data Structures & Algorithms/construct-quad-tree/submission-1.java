
class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    private Node build(int[][] grid, int row, int col, int size) {
        // Check whether this square contains the same values
        boolean same = true;
        int value = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != value) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }
        // If all values are identical, create a leaf node
        if (same) {
            return new Node(value == 1, true);
        }
        int half = size / 2;
        // Divide into four quadrants
        Node topLeft = build(grid, row, col, half);
        Node topRight = build(grid, row, col + half, half);
        Node bottomLeft = build(grid, row + half, col, half);
        Node bottomRight = build(grid, row + half, col + half, half);

        // Create an internal node with four children
        Node root = new Node(true, false);
        root.topLeft = topLeft;
        root.topRight = topRight;
        root.bottomLeft = bottomLeft;
        root.bottomRight = bottomRight;

        return root;
    }
}
