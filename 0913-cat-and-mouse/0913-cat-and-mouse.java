class Solution {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] dp = new int[n][n][2];
        int[][][] degree = new int[n][n][2];

        // Build base outdegrees
        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][0] = graph[m].length; // mouse moves
                degree[m][c][1] = graph[c].length;
                // cat can't move to hole
                for (int nei : graph[c]) {
                    if (nei == 0) degree[m][c][1]--;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        // Mouse wins when mouse is at hole
        for (int c = 0; c < n; c++) {
            for (int t = 0; t < 2; t++) {
                dp[0][c][t] = 1;
                q.add(new int[]{0, c, t});
            }
        }

        // Cat wins when cat catches mouse
        for (int i = 1; i < n; i++) {
            for (int t = 0; t < 2; t++) {
                dp[i][i][t] = 2;
                q.add(new int[]{i, i, t});
            }
        }

        // Reverse BFS
        while (!q.isEmpty()) {
            int[] state = q.poll();
            int mPos = state[0], cPos = state[1], turn = state[2];
            int result = dp[mPos][cPos][turn];

            for (int[] prev : getParents(graph, mPos, cPos, turn)) {
                int pm = prev[0], pc = prev[1], pt = prev[2];

                // If this parent state is unknown
                if (dp[pm][pc][pt] == 0) {
                    // If current result is beneficial to the player whose turn it was in parent
                    if (result == (pt == 0 ? 1 : 2)) {
                        dp[pm][pc][pt] = result;
                        q.add(new int[]{pm, pc, pt});
                    } else {
                        // decrement degree, if all children are opponent wins
                        if (--degree[pm][pc][pt] == 0) {
                            dp[pm][pc][pt] = (pt == 0 ? 2 : 1);
                            q.add(new int[]{pm, pc, pt});
                        }
                    }
                }
            }
        }

        return dp[1][2][0];
    }

    private List<int[]> getParents(int[][] graph, int m, int c, int turn) {
        List<int[]> parents = new ArrayList<>();
        if (turn == 0) {
            // current was mouse's turn, so previous was cat's turn
            for (int pcPrev : graph[c]) {
                if (pcPrev == 0) continue; // cat can't have been at hole
                parents.add(new int[]{m, pcPrev, 1});
            }
        } else {
            // current was cat's turn, so previous was mouse's turn
            for (int pmPrev : graph[m]) {
                parents.add(new int[]{pmPrev, c, 0});
            }
        }
        return parents;
    }
}