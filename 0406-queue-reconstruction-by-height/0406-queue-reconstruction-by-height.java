class Solution {
    public int[][] reconstructQueue(int[][] people) {

        // Step 1: sort
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // height desc
            return a[1] - b[1];                  // k asc
        });

        // Step 2: insert
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[people.length][]);
    }
}