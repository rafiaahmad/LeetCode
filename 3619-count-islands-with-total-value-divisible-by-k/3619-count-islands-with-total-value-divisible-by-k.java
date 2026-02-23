class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int sum = dfs(grid, i, j);
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 ||
            i >= grid.length || j >= grid[0].length ||
            grid[i][j] == 0) {
            return 0;
        }

        int val = grid[i][j];
        grid[i][j] = 0; // mark visited

        val += dfs(grid, i + 1, j);
        val += dfs(grid, i - 1, j);
        val += dfs(grid, i, j + 1);
        val += dfs(grid, i, j - 1);

        return val;
    }
}