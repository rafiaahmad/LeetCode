// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        // If source or destination is blocked
        if (A[0][0] == 0 || A[X][Y] == 0)
            return -1;

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        // {row, col, distance}
        queue.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (r == X && c == Y)
                return dist;

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < N && nc < M &&
                    A[nr][nc] == 1 && !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }
};