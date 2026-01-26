class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // Step 1: Create array of meetings
        int n =  start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        
        // Step 2: Sort by end time
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);
        
        // Step 3: Greedy selection
        int count = 1;                 // first meeting always selected
        int lastEnd = meetings[0][1];
        
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }
        
        return count;
    }
}
