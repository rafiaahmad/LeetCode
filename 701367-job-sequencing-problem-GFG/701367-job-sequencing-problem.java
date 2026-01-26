class Solution {

    // DSU find
    private int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        // Step 1: store jobs as (profit, deadline)
        int[][] jobs = new int[n][2];
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // Step 2: sort by profit descending
        Arrays.sort(jobs, (a, b) -> b[0] - a[0]);

        // Step 3: initialize DSU
        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalProfit = 0;

        // Step 4: schedule jobs
        for (int i = 0; i < n; i++) {
            int availableSlot = find(jobs[i][1], parent);

            if (availableSlot > 0) {
                count++;
                totalProfit += jobs[i][0];

                // mark slot as occupied
                parent[availableSlot] = availableSlot - 1;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(totalProfit);
        return result;
    }
}
