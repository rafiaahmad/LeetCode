class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // Build graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] t : times) {
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }

        // Distance array
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        // Min heap (distance, node)
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, K});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int node = curr[1];

            if (currDist > dist[node]) continue;

            // Relax neighbors
            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0];
                int weight = edge[1];

                if (dist[neighbor] > currDist + weight) {
                    dist[neighbor] = currDist + weight;
                    pq.offer(new int[]{dist[neighbor], neighbor});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}