class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Time : O(n log n), Space : O(1)  -- Global Optimal Choice via earliest finish
        if (intervals.length == 0) return 0;

        // Step 1: Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int removals = 0;
        int prevEnd = intervals[0][1];

        // Step 2: Greedy selection
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // overlap → remove current interval
                removals++;
            } else {
                // no overlap → keep it
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}