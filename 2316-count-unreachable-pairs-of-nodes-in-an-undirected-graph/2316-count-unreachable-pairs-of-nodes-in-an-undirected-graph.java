class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        long result = 0;
        long remaining = n;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long size = dfs(graph, visited, i);
                result += size * (remaining - size);
                remaining -= size;
            }
        }

        return result;
    }

    private long dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        long size = 1;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(graph, visited, neighbor);
            }
        }
        return size;
    }
}