class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return Arrays.asList(0);
        }

        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        // build graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> leaves = new LinkedList<>();

        // initial leaves
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.offer(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {

            int size = leaves.size();

            remainingNodes -= size;

            for (int i = 0; i < size; i++) {

                int leaf = leaves.poll();

                int neighbor =
                    graph.get(leaf).iterator().next();

                graph.get(neighbor).remove(leaf);

                if (graph.get(neighbor).size() == 1) {
                    leaves.offer(neighbor);
                }
            }
        }

        return new ArrayList<>(leaves);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna