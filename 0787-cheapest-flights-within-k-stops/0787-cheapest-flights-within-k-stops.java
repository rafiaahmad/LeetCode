class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 0x3f3f3f3f;
        
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        
        // Perform k+1 iterations
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n);
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (dist[u] != INF && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }
        
        return dist[dst] == INF ? -1 : dist[dst];
    }
}