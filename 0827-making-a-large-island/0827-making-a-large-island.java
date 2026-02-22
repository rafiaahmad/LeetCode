class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2; 
        Map<Integer, Integer> sizeMap = new HashMap<>();
        
        int maxSize = 0;

        // Step 1: Label each island with a unique ID and record its size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    sizeMap.put(islandId, size);
                    maxSize = Math.max(maxSize, size);
                    islandId++;
                }
            }
        }

        // Step 2: Try flipping each 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    if (i > 0 && grid[i - 1][j] > 1) neighbors.add(grid[i - 1][j]);
                    if (i < n - 1 && grid[i + 1][j] > 1) neighbors.add(grid[i + 1][j]);
                    if (j > 0 && grid[i][j - 1] > 1) neighbors.add(grid[i][j - 1]);
                    if (j < n - 1 && grid[i][j + 1] > 1) neighbors.add(grid[i][j + 1]);

                    int newSize = 1; // flipping this 0
                    for (int id : neighbors) {
                        newSize += sizeMap.getOrDefault(id, 0);
                    }
                    maxSize = Math.max(maxSize, newSize);
                }
            }
        }

        // Edge case: grid all 1s
        if (maxSize == 0) return n * n;
        return maxSize;
    }

    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        int size = 1;
        size += dfs(grid, i - 1, j, id);
        size += dfs(grid, i + 1, j, id);
        size += dfs(grid, i, j - 1, id);
        size += dfs(grid, i, j + 1, id);
        return size;
    }
}