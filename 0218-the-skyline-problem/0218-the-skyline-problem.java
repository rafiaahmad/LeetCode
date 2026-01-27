class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            // start event -> height positive
            events.add(new int[]{b[0], -b[2]});
            // end event -> height positive again but 0 indicates remove
            events.add(new int[]{b[1], b[2]});
        }

        // sort: x ascending, starts before ends, higher start first, lower end first
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prevMax = 0;

        for (int[] event : events) {
            int x = event[0], h = event[1];
            if (h < 0) {
                // start of building: add height
                pq.add(-h);
            } else {
                // end of building: remove height
                pq.remove(h);
            }
            int currentMax = pq.peek();
            if (currentMax != prevMax) {
                List<Integer> point = new ArrayList<>();
                point.add(x);
                point.add(currentMax);
                answer.add(point);
                prevMax = currentMax;
            }
        }
        return answer;
    }
}