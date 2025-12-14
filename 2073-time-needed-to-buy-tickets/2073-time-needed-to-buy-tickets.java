class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();

        // Push (index, ticketsNeeded)
        for (int i = 0; i < tickets.length; i++) {
            q.add(new int[]{i, tickets[i]});
        }

        int time = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();  // take from queue
            time++;

            cur[1]--;  // buy 1 ticket

            // If k finishes now -> return time
            if (cur[0] == k && cur[1] == 0) {
                return time;
            }

            // If still needs tickets, put back in queue
            if (cur[1] > 0) {
                q.add(cur);
            }
        }

        return time;
    }
}