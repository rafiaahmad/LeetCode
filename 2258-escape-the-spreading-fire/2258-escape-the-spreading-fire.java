class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;

    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][] fireTime = computeFireTime(grid);

        int left = 0, right = m * n;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canReach(grid, fireTime, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (ans == m * n) return 1_000_000_000;
        return ans;
    }

    private int[][] computeFireTime(int[][] grid) {
        int[][] fireTime = new int[m][n];
        for (int[] row : fireTime)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                    grid[nx][ny] != 2 &&
                    fireTime[nx][ny] == Integer.MAX_VALUE) {

                    fireTime[nx][ny] = fireTime[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return fireTime;
    }

    private boolean canReach(int[][] grid, int[][] fireTime, int wait) {
        if (wait >= fireTime[0][0]) return false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(new int[]{0, 0, wait});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], time = cur[2];

            if (x == m - 1 && y == n - 1) {
                return time <= fireTime[x][y];
            }

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                int nt = time + 1;

                if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                    grid[nx][ny] != 2 &&
                    !visited[nx][ny] &&
                    nt < fireTime[nx][ny]) {

                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, nt});
                }
            }
        }
        return false;
    }
}