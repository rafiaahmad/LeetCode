class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {

        int n = arr.length;
        boolean[] visited = new boolean[n];
        long cost = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            List<Integer> cycle = new ArrayList<>();
            int curr = i;

            while (!visited[curr]) {
                visited[curr] = true;
                cycle.add(arr[curr]);
                curr = (curr + k) % n;
            }

            Collections.sort(cycle);
            int median = cycle.get(cycle.size() / 2);

            for (int val : cycle) {
                cost += Math.abs(val - median);
            }
        }

        return cost;
    }
}